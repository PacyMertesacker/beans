package systemregistrationmanager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import core.entity.Votes;
import systemregistrationmanager.repository.SystemRegistrationManagerRepo;

@RestController
public class SystemRegistrationManagerController {
    @Autowired 
    SystemRegistrationManagerRepo repo;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/SysRegMan/results")
    public void printResults() {
        String[] candidates = {"Vin Diesel", "Vin Diesel with hair"};

        List<String> results = new ArrayList<>();

        int maxNumOfVotes = 0;

        for (String candidate : candidates) {
            Optional<List<Votes>> votesData = repo.findByCandidate(candidate);

            List<Votes> votes = votesData.get();

            int numOfVotes = 0;

            for (Votes vote : votes) {
                numOfVotes += vote.getNumOfVotes();
            }

            System.out.println(candidate + " : " + numOfVotes);
            if (numOfVotes > maxNumOfVotes) {
                results.add(0, candidate + "," + numOfVotes); 
                maxNumOfVotes = numOfVotes;   
            } else {
                results.add(candidate + "," + numOfVotes);
            }
        }
        restTemplate.postForObject("http://information-hub/forum/results", results, List.class); 
    }
}