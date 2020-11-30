package voter.controller;

import voter.entity.Voter;
import voter.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voter")
public class VoterController {

    @Autowired VoterService voterService;

    @PostMapping
    public Voter postVoter(@RequestBody Voter voter) {
        return voterService.addVoter(voter);
    }

    @GetMapping
    public List<Voter> getAllVoters(){
        return voterService.findAllVoters();
    }

    @GetMapping("/id/{id}")
    public Voter getVoterByID(@PathVariable("id") String id){
        return voterService.findVoterByID(id);
    }

    @GetMapping("/name/")
    public Voter getVoterByName(@PathVariable("name") String name){
        return voterService.findVoterByName(name);
    }

    @PutMapping("/id/{id}")
    public Voter putVoterByID(@PathVariable("id") String id, @RequestBody Voter Voter) {
        return voterService.replaceVoterByID(id, Voter);
    }

    @DeleteMapping
    public void deleteAllVoters() {
        voterService.removeAllVoters();
    }

    @DeleteMapping("/id/{id}")
    public Voter deleteVoterByID(@PathVariable("id") String id) {
        return voterService.removeVoterByID(id);
    }

    @DeleteMapping("/name/{name}")
    public Voter deleteVoterByName(@PathVariable("name") String name) {
        return voterService.removeVoterByName(name);
    }
    
}
