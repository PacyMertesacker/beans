package ballotCollectorB.controller;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ballotCollectorB.repository.BallotCollectorRepo;
import core.entity.Voter;
import core.entity.Votes;

@RestController
@RequestMapping("/ballotcollectorB")
public class BallotCollectorBController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BallotCollectorRepo repo;

    int votesId = 0;

    HashMap<String,Integer> voteMap = new HashMap<>();
    ArrayList<String> candidates = new ArrayList<>();

    @PostMapping("/voter")
    public void addVote(@RequestBody Voter voter) {
        // only count votes for current region
        // if(voter.getRegion().equals("B")) {
        //     Integer numVotes = voteMap.get(voter.getVotedFor());
        //     if (numVotes == null) {
        //         numVotes = 0;
        //     }

        //     voteMap.put(voter.getVotedFor(), ++numVotes);
        //     System.out.println(voteMap.toString());
        // }

        if (!voter.getRegion().equals("B")) {
            System.out.println("Not region B");
            return;
        }

        Optional<Votes> votesData = repo.findByCandidateAndRegion(voter.getVotedFor(), voter.getRegion());
        Votes votes;
        if (votesData.isPresent()) {
            votes = votesData.get();
            votes.setNumOfVotes( votes.getNumOfVotes() + 1);
        } else {
            votes = new Votes(votesId++, voter.getVotedFor(), voter.getRegion(), 1);
        }

        repo.save(votes);
    }

    @GetMapping()
    public void postToSysRegMan(){
        HashMap<String,HashMap<String, Integer>> regionalBallots = new HashMap<>();
        regionalBallots.put("B", voteMap);
        HttpEntity<HashMap<String,HashMap<String, Integer>>> request =
                new HttpEntity<>(regionalBallots);
        restTemplate.postForObject("http://localhost:8085/SysRegMan", request, HashMap.class);
    }

  /*  public Integer test(String candidate, String region){
        HashMap<String, Integer> currRegionMap = regionMap.get(region);
        Integer numVotes = currRegionMap.get(candidate); 
        
        return numVotes;
    } */

    @PostMapping("/candidate")
    public void addCandidate(@RequestBody String candidate) {
        this.candidates.add(candidate);
        System.out.println(candidate.toString());
    }

    // @GetMapping("/test")
    // public ResponseEntity<Integer> test1(){
    //     Integer votes = test("Vin Diesel", "A");
    //     return new ResponseEntity<>(votes, HttpStatus.CREATED);
    // }
}
