package informationhub.controller;

import core.entity.Candidate;
import core.entity.Votes;
import informationhub.entity.Forum;
import informationhub.entity.CandidateRegistration;
import informationhub.repository.InformationHubRepo;
import informationhub.repository.CandidateRegistrationRepo;

import java.sql.Timestamp;
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
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class InformationHubService{
    @Autowired InformationHubRepo informationHubRepo;
    @Autowired CandidateRegistrationRepo candidateRegistrationRepo;

    static int candidateId = 0;

    // Post a message in the forum
    @PostMapping("/forum")
    public ResponseEntity<Forum> postMessage(@RequestBody Forum forum){
        try{
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            //messageId++;
            //forum.setMessageDetails(messageId, timestamp);
            Forum messageInRepo = informationHubRepo.save(forum);
            return new ResponseEntity<>(messageInRepo, HttpStatus.CREATED);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    // Check if a candidate is registered
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

    // Register a candidate
    @PostMapping("/forum/candidates/register")
    public ResponseEntity<CandidateRegistration> registerCandidate(@RequestBody Candidate candidate){
        try{
            CandidateRegistration candidateRegistration = convertToCandidateRegistration(candidate);
            Optional<CandidateRegistration> candidateReg = candidateRegistrationRepo.findById(candidateRegistration.getId());
            if (!candidateReg.isPresent()) {
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

    // Get a list of all candidates currently registered in Candidate class:
    @RequestMapping(value="/forum/candidates", method=RequestMethod.GET)
    public void getCandidates(){
        try{
            RestTemplate restTemplate = new RestTemplate();
            List<CandidateRegistration> candidateRegistrationList = new ArrayList<>();
            Candidate[] candidates = restTemplate.getForObject("http://localhost:8083/candidate/name", Candidate[].class);
            if (candidates.length > 0){
                for(Candidate c : candidates){
                    candidateRegistrationList.add(convertToCandidateRegistration(c));
                }
                candidateRegistrationRepo.saveAll(candidateRegistrationList);
            }
            else{
                System.out.println("There are no candidates registered.");
            }
        }
        catch(Exception e){
            e.printStackTrace();
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
        candidateId++;
        return new CandidateRegistration(candidateId,c.getName(),c.getParty(),c.getBio());
    }

    public static void displayCandidate(CandidateRegistration cr) {
		System.out.println("|=================================================================================================================");
		System.out.println("|                                                                                                               ");
		System.out.println(
				"| Name: \n|\t" + String.format("%1$-31s", cr.getName()) + "\n" +
				"| Party: \n|\t" + String.format("%1$-31s", cr.getParty()) + "\n" +
				"| Manifesto: \n|\t" + String.format("%1$-31s", cr.getManifesto())+" ");
		System.out.println("|                                                                                                               ");
		System.out.println("|=================================================================================================================");
	}

}