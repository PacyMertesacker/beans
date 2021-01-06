package ballotCollector.controller;

import java.util.HashMap;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import core.entity.Voter;
import core.entity.Votes;
import ballotCollector.repository.BallotCollectorRepo;

@RestController
@RequestMapping("/ballotcollector")
public class BallotCollectorController {
    @Autowired 
    BallotCollectorRepo repo;

    HashMap<String,HashMap<String,Integer>> regionMap = new HashMap<>();
    ArrayList<String> candidates = new ArrayList<String>();

    int votesId = 0;

    @PostMapping("/voter")
    public void addVote(@RequestBody Voter voter) {
        //if (candidates.contains(voter.getVotedFor())) {
            Optional<Votes> votesData = repo.findByCandidateAndRegion(voter.getVotedFor(), voter.getRegion());
            Votes votes;
            if (votesData.isPresent()) {
                votes = votesData.get();
                votes.setNumOfVotes( votes.getNumOfVotes() + 1);
            } else {
                votes = new Votes(votesId++, voter.getVotedFor(), voter.getRegion(), 1);
            }
            repo.save(votes);
        //} 
    }

    public Integer test(String candidate, String region){        
        Optional<Votes> votesData = repo.findByCandidateAndRegion(candidate, region);
        if (votesData.isPresent()) {
            return votesData.get().getNumOfVotes();
        }

        return -1;
    }

    @PostMapping("/candidate")
    public void addCandidate(@RequestBody String candidate) {
        this.candidates.add(String.valueOf(candidate));
        System.out.println(candidate.toString());
    }

    @GetMapping("/test")
    public ResponseEntity<Integer> test1(){
        Integer votes = test("Vin Diesel", "A");
        return new ResponseEntity<>(votes, HttpStatus.CREATED);
    }
}
