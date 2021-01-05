package informationhub.controller;

import core.entity.Candidate;
import core.entity.Votes;
import informationhub.entity.CandidateRegistration;
import informationhub.repository.InformationHubRepo;
import informationhub.repository.CandidateRegistrationRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class InformationHubService{
    @Autowired InformationHubRepo informationHubRepo;
    @Autowired CandidateRegistrationRepo candidateRegistrationRepo;

    static int candidateId = 0;

    // Post a message in the forum
    @PostMapping("/forum/results")
    public void viewFinal(@RequestBody List<Votes> votes){
        try{
            Collections.sort(votes,
            Comparator.comparingInt(Votes::getNumOfVotes).reversed());
            Votes winner = votes.remove(0);
            System.out.println("|=================================================================================================================");
            System.out.println("|\t\t\tElection Results");
            System.out.println("|=================================================================================================================");
            System.out.println("|                                                                                                               ");
            System.out.println("|\t\t\tCandidate "+winner.getCandidate()+" has won the election with "+winner.getNumOfVotes());
            System.out.println("|=================================================================================================================");
            for (Votes v : votes){
                System.out.println("| Candidate "+v.getCandidate()+" next with "+v.getNumOfVotes()+".");
            } 
            System.out.println("|=================================================================================================================");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    // Check if a candidate is registered already
    @PostMapping("/forum/candidates/{id}")
    public ResponseEntity<String> checkCandidate(@PathVariable int id){
        try{
            Optional<CandidateRegistration> candidate = candidateRegistrationRepo.findById(id);

            if (candidate.isPresent()) {
                return new ResponseEntity<>(candidate.get().getName() +" is already registered.", HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>("This candidate does not exist yet, register them?", HttpStatus.CREATED);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Register a candidate from Candidate Class
    @PostMapping("/forum/candidates/register")
    public ResponseEntity<CandidateRegistration> registerCandidate(@RequestBody Candidate candidate){
        try{
            CandidateRegistration candidateRegistration = convertToCandidateRegistration(candidate);
            Optional<CandidateRegistration> candidateAlreadyExists = candidateRegistrationRepo.findByNameAndParty(candidateRegistration.getName(), candidateRegistration.getParty());
            if (!candidateAlreadyExists.isPresent()) {
                candidateId++;
                CandidateRegistration candidateInRepo = candidateRegistrationRepo.save(candidateRegistration);
                return new ResponseEntity<>(candidateInRepo, HttpStatus.CREATED);            
            }
            else {
                return new ResponseEntity<>(null, HttpStatus.CREATED);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Print the candidates from Cassandra:
    @RequestMapping(value="/forum/candidates/view", method=RequestMethod.GET)
    public void viewCandidates(){
        try{
            List<CandidateRegistration> candidates = candidateRegistrationRepo.findAll();
            Collections.sort(candidates);
            System.out.println("|=================================================================================================================");
            System.out.println("|\t\t\tCandidate Information");
            for (CandidateRegistration c : candidates){
                displayCandidate(c);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public CandidateRegistration convertToCandidateRegistration(Candidate c){
        return new CandidateRegistration(candidateId,c.getName(),c.getParty(),c.getBio());
    }

    public static void displayCandidate(CandidateRegistration cr) {
		System.out.println("|=================================================================================================================");
		System.out.println("|                                                                                                               ");
		System.out.println(
                "| Party: \n|\t" + String.format("%1$-31s", cr.getParty()) + "\n" +
				"| Name: \n|\t" + String.format("%1$-31s", cr.getName()) + "\n" +
				"| Manifesto: \n|\t" + String.format("%1$-31s", cr.getManifesto())+" ");
		System.out.println("|                                                                                                               ");
		System.out.println("|=================================================================================================================");
    }
    
}