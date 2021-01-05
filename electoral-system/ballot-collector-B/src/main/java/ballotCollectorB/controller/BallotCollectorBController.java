package ballotCollectorB.controller;

import java.util.HashMap;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import core.entity.Voter;

@RestController
@RequestMapping("/ballotcollectorB")
public class BallotCollectorBController {
    @Autowired
    RestTemplate restTemplate;

    HashMap<String,Integer> voteMap = new HashMap<>();
    ArrayList<String> candidates = new ArrayList<>();

    @PostMapping("/voter")
    public void addVote(@RequestBody Voter voter) {
        // only count vote if it is valid
        if(candidates.contains(voter.getVotedFor())) {
            // only count votes for current region
            if(voter.getRegion().equals("B")) {
                Integer numVotes = voteMap.get(voter.getVotedFor());
                if (numVotes == null) {
                    numVotes = 0;
                }

                voteMap.put(voter.getVotedFor(), ++numVotes);
            }
        }
    }

    @PostMapping()
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
