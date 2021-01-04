package candidate.controller;

import core.entity.Candidate;
import core.exception.ApiRequestException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/candidate")
public class CandidateController {

    public static final Candidate[] candidates = {
            new Candidate("Vin Diesel with hair", "TheFamily", "Blah Blah Blah TheFamily Blah Blah Blah"),
            new Candidate("Vin Diesel", "FastAndFurious", "waddyamean"),
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
