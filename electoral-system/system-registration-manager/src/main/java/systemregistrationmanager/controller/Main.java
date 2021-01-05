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
import java.util.HashMap;

@RestController
@RequestMapping("/SysRegMan")
public class Main {
    @Autowired 
    SystemRegistrationManagerRepo repo;

    // TODO store in Cassandra
    HashMap<String, HashMap<String, Integer>> regionalBallots = new HashMap<>();

    @PostMapping()
    public void addBallots(@RequestBody HashMap<String, HashMap<String, Integer>> regionalBallot) {
        this.regionalBallots = regionalBallot;
        System.out.println(regionalBallot.toString());
    }

    @PostMapping("/managers")
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
        try {    
            Manager managerInRepo = repo.save(manager);
            return new ResponseEntity<>(managerInRepo, HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(new Manager("1", "Murph"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/managers/{id}", method = RequestMethod.GET)
    public ResponseEntity<Manager> getManager(@PathVariable("id") String id) {
        Optional<Manager> manager = repo.findById(id);

        if (manager.isPresent()) {
            return new ResponseEntity<>(manager.get(), HttpStatus.CREATED);
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}