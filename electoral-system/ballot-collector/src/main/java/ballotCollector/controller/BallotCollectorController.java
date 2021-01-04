package ballotCollector.controller;

import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import core.entity.Voter;

@RestController
@RequestMapping("/ballotcollector")
public class BallotCollectorController {
    HashMap<String,HashMap<String,Integer>> regionMap = new HashMap<>();

    @PostMapping("/voter")
    public void addVote(@RequestBody Voter voter) {
        HashMap<String, Integer> currRegionMap = regionMap.get(voter.getRegion());
        if(currRegionMap == null){
            currRegionMap = new HashMap<String,Integer>(); 
        }

        Integer numVotes = currRegionMap.get(voter.getVotedFor()); 
        if(numVotes == null){
            numVotes = 0;
        }

        currRegionMap.put(voter.getVotedFor(), ++numVotes);
        regionMap.put(voter.getRegion(), currRegionMap);
        System.out.println(regionMap.toString());
    }

    public Integer test(String candidate, String region){
        HashMap<String, Integer> currRegionMap = regionMap.get(region);
        Integer numVotes = currRegionMap.get(candidate); 
        
        return numVotes;
    }

    @GetMapping("/test")
    public ResponseEntity<Integer> test1(){
        Integer votes = test("Vin Diesel", "A");
        return new ResponseEntity<>(votes, HttpStatus.CREATED);
    }
}
