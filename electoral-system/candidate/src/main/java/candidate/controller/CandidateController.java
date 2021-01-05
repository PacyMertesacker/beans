package candidate.controller;

import core.entity.Candidate;
import core.exception.ApiRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    RestTemplate restTemplate;

    public static final Candidate[] candidates = {
            new Candidate("Vin Diesel with hair", "TheFamily", "Blah Blah Blah TheFamily Blah Blah Blah"),
            new Candidate("Vin Diesel", "FastAndFurious", "waddyamean"),
    };

    // Register a candidate in the CandidateRegistration table from either local data or a RequestBody
    @PostMapping("/register")
    public void storeCandidate(@RequestBody Candidate candidate){
        try{
            if (candidates.length > 0) {
                for (Candidate c : candidates){
                    HttpEntity<Candidate> candidateHttp = new HttpEntity<>(c);
                    restTemplate.postForEntity("http://localhost:8050/forum/candidates/register", candidateHttp, Candidate.class);
                }
            }
            else {
                HttpEntity<Candidate> candidateHttp = new HttpEntity<>(candidate);
                restTemplate.postForEntity("http://localhost:8050/forum/candidates/register", candidateHttp, Candidate.class);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("/name/{name}")
    public Candidate getCandidateByName(@PathVariable("name") String name){
        for (Candidate candidate : candidates){
            if (candidate.getName().equals(name))
                return candidate;
        }
        throw new ApiRequestException("No candidate by this name");
    }

    @GetMapping("/name")
    public Candidate[] getAllCandidate(){
        return candidates;
    }

    @PostMapping()
    public void test() {
        for(Candidate candidate : candidates) {
            HttpEntity<String> request = new HttpEntity<>(candidate.getName());
            restTemplate.postForObject("http://localhost:8083/ballotcollector/candidate", request, String.class);
        }
    }
}