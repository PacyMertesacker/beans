package informationhub.controller;

import informationhub.entity.Forum;
import informationhub.repository.InformationHubRepo;

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
    @Autowired
    InformationHubRepo informationHubRepo;

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


}