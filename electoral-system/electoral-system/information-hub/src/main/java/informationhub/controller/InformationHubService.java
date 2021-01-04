package informationhub.controller;

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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class InformationHubService{
    @Autowired InformationHubRepo informationHubRepo;
    @Autowired CandidateRegistrationRepo candidateRegistrationRepo;

    static int messageId = 0;

    // Post a message in the forum
    @PostMapping("/forum")
    public ResponseEntity<Forum> postMessage(@RequestBody Forum forum){
        try{
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            messageId++;
            forum.setMessageDetails(messageId, timestamp);
            Forum messageInRepo = informationHubRepo.save(forum);
            return new ResponseEntity<>(messageInRepo, HttpStatus.CREATED);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all messages in the forum
    @RequestMapping(value="/forum/view", method=RequestMethod.GET)
    public ResponseEntity<List<Forum>> viewForum(){
        try{
            List<Forum> forum = informationHubRepo.findAll();
            Collections.sort(forum);
            if (!forum.isEmpty()){
                return new ResponseEntity<>(forum, HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Check if a candidate is registered
    @PostMapping("/forum/candidate/{id}")
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
    @PostMapping("/forum/candidate/register")
    public ResponseEntity<CandidateRegistration> registerCandidate(@RequestBody CandidateRegistration candidateRegistration){
        try{
            Optional<CandidateRegistration> candidate = candidateRegistrationRepo.findById(candidateRegistration.getId());
            if (!candidate.isPresent()) {
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

    // Return a list of all candidates currently registered:
    @RequestMapping(value="/forum/candidates", method=RequestMethod.GET)
    public ResponseEntity<List<CandidateRegistration>> getCandidates(){
        try{
            List<CandidateRegistration> candidateRegistration = candidateRegistrationRepo.findAll();
            Collections.sort(candidateRegistration);
            if (!candidateRegistration.isEmpty()){
                return new ResponseEntity<>(candidateRegistration, HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}