package voter.service;

import entity.Voter;
import voter.repository.VoterRepo;
import exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
public class VoterService {
    @Autowired VoterRepo voterRepo;

    public Voter addVoter(Voter voter) {
        if((!voterRepo.existsByAddress(voter.getAddress())&& !voterRepo.existsByName(voter.getName())))
            return voterRepo.save(voter);
        else
            throw new ApiRequestException("This Voter already exists in the database");
    }

    public Voter findVoterByID(String id) {
        return voterRepo.findById(id).orElseThrow(() ->
                new ApiRequestException("Cannot find Voter with this ID"));
    }

    public Voter findVoterByName(String name) {
        return voterRepo.findByName(name).orElseThrow(() ->
                new ApiRequestException("Cannot find Voter with this ID"));
    }

    public Voter replaceVoterByID(String id, Voter voter) {
        voterRepo.findById(id).orElseThrow(() ->
                new ApiRequestException("Cannot find member with this ID"));
        voter.setId(id);
        voterRepo.save(voter);

        return voter;
    }

    public List<Voter> findAllVoters() {
        return voterRepo.findAll();
    }

    public Voter removeVoterByID(String id) {
        Voter voter = findVoterByID(id);
        voterRepo.deleteById(id);
        return voter;
    }

    public Voter removeVoterByName(String name) {
        Voter voter = findVoterByName(name);
        voterRepo.deleteByName(name);
        return voter;
    }

    public void removeAllVoters() {
        voterRepo.deleteAll();
    }

    public Voter updateHasVoted(String id, Voter voter){
        voterRepo.findById(id).orElseThrow(() ->
        new ApiRequestException("Cannot find member with this ID"));
        voter.setHasVoted(true);
        return voter;

    }
    
}
