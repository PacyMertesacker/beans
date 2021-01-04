package candidate.controller;

import core.entity.Candidate;
import core.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    public static final Candidate[] candidates = {
            new Candidate("Sean Ennis O'Toole", "PartyA", "Blah Blah Blah PartyA Blah Blah Blah"),
            new Candidate("Adam Shorten", "The Adam Party", "Will strengthen the Adam population"),
            new Candidate("Luke Murphy", "PartyB", "Blah Blah Blah PartyB Blah Blah Blah"),
            new Candidate("Adam Waldron", "The Adam Party", "Will encourage cat owners to consider the name Adam for their pets"),
            new Candidate("Ronan Kelly", "PartyC", "Blah Blah Blah PartyC Blah Blah Blah")
    };

    @GetMapping("/name/{name}")
    public Candidate getCandidateByName(@PathVariable("name") String name){
        for (Candidate candidate : candidates)
            if (candidate.getName().equals(name))
                return candidate;
        throw new ApiRequestException("No candidate by this name");
    }

    @GetMapping("/name")
    public Candidate[] getAllCandidate(@PathVariable("name") String name){
        return candidates;
    }
}
