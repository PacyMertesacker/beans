package ballotCollector.controller;

import java.util.HashMap;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import core.entity.Voter;
import core.entity.Candidate;

@RestController
@RequestMapping("/ballotcollector")
public class BallotCollectorController {
    HashMap<String,Integer> voteMap = new HashMap<>();
    ArrayList<Candidate> candidates = new ArrayList<>();

    @PostMapping("/voter")
    public void addVote(@RequestBody Voter voter) {
        // only count vote if it is valid
        if(candidates.contains(voter.getVotedFor()) {
            // only count votes for current region
            if(voter.getRegion().equals("A")) {
                Integer numVotes = voteMap.get(voter.getVotedFor());
                if (numVotes == null) {
                    numVotes = 0;
                }

                voteMap.put(voter.getVotedFor(), ++numVotes);
                System.out.println(regionMap.toString());
            }
        }
    }

  /*  public Integer test(String candidate, String region){
        HashMap<String, Integer> currRegionMap = regionMap.get(region);
        Integer numVotes = currRegionMap.get(candidate); 
        
        return numVotes;
    } */

    @PostMapping("/candidate")
    public void addCandidate(@RequestBody Candidate candidate) {
        this.candidates.add(candidate);
        System.out.println(candidate.toString());
    }

    @GetMapping("/test")
    public ResponseEntity<Integer> test1(){
        Integer votes = test("Vin Diesel", "A");
        return new ResponseEntity<>(votes, HttpStatus.CREATED);
    }
}
