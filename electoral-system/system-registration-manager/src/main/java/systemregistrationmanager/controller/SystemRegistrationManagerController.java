package systemregistrationmanager.controller;

import systemregistrationmanager.entity.Manager;
import systemregistrationmanager.repository.SystemRegistrationManagerRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import core.entity.Votes;

@RestController
public class SystemRegistrationManagerController {
    @Autowired 
    SystemRegistrationManagerRepo repo;

    // @PostMapping("/managers")
    // public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
    //     try {    
    //         Manager managerInRepo = repo.save(manager);
    //         return new ResponseEntity<>(managerInRepo, HttpStatus.CREATED);
    //     } catch (Exception ex) {
    //         ex.printStackTrace();
    //         return new ResponseEntity<>(new Manager("1", "Murph"), HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
        String[] candidates = {"Vin Diesel", "Vin Diesel with hair"};

        for (String candidate : candidates) {
            Optional<List<Votes>> votesData = repo.findByCandidate(candidate);

            List<Votes> votes = votesData.get();

            int numOfVotes = 0;

            for (Votes vote : votes) {
                numOfVotes += vote.getNumOfVotes();
            }
            System.out.println(candidate + " : " + numOfVotes);
        }
    }

    @GetMapping("/SysRegMan/results")
    public void printResults() {
        String[] candidates = {"Vin Diesel", "Vin Diesel with hair"};

        List<String> results = new ArrayList<>();

        for (String candidate : candidates) {
            Optional<List<Votes>> votesData = repo.findByCandidate(candidate);

            List<Votes> votes = votesData.get();

            int numOfVotes = 0;

            for (Votes vote : votes) {
                numOfVotes += vote.getNumOfVotes();
            }
            System.out.println(candidate + " : " + numOfVotes);
            results.add(candidate + " : " + numOfVotes);
        }
        
    }
}