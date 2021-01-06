package informationhub.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import core.entity.Candidate;
import informationhub.entity.CandidateRegistration;
import informationhub.repository.CandidateRegistrationRepo;
import informationhub.repository.InformationHubRepo;


@RestController
public class InformationHubService{
    @Autowired InformationHubRepo informationHubRepo;
    @Autowired CandidateRegistrationRepo candidateRegistrationRepo;

    static int candidateId = 0;

    // Post a message in the forum
    @PostMapping("/forum/results")
    public void viewFinal(@RequestBody List<String> results){
        
        String[] result = results.remove(0).split(",");

        try{
            System.out.println("|=================================================================================================================");
            System.out.println("|\t\t\tElection Results");
            System.out.println("|=================================================================================================================");
            System.out.println("|                                                                                                               ");
            System.out.println("|\t\t\tCandidate "+ result[0] +" has won the election with "+ result[1] +" Votes");
            System.out.println("|=================================================================================================================");
            for (String s : results){
                result = s.split(",");
                System.out.println("| Candidate "+ result[0] +" next with "+ result[1] +".");
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