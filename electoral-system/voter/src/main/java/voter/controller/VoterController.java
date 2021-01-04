package voter.controller;

import core.entity.Voter;
import core.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/voter")
public class VoterController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/name/{name}")
    public Voter getVoterByName(@PathVariable("name") String name){
        for(Voter voter: voters)
            if(voter.getName().equals(name))
                return voter;
        throw new ApiRequestException("No Voters found");
    }

    @GetMapping("/name")
    public Voter[] getAllVotersByName(@PathVariable("name") String name){
        return voters;
    }

    @PostMapping()
    public void test(){
        for(Voter voter : voters){
            HttpEntity<Voter> request = new HttpEntity<>(voter);
            restTemplate.postForObject("http://localhost:8081/ballotcollector/voter", request, Voter.class);
        }
    }

    public static final Voter[] voters = {
        new Voter("Luke Kelly", "Vin Diesel with hair", "D"),
        new Voter("Adam Shorten", "Vin Diesel", "B"),
        new Voter("Adam O Toole", "Vin Diesel with hair", "A"),
        new Voter("Adam Kelly", "Vin Diesel with hair", "A"),
        new Voter("Luke Murphy", "Vin Diesel", "A"),
        new Voter("Adam Shorten", "Vin Diesel", "D"),
        new Voter("Ronan O Toole", "Vin Diesel with hair", "B"),
        new Voter("Sean Waldron", "Vin Diesel with hair", "B"),
        new Voter("Luke Shorten", "Vin Diesel with hair", "B"),
        new Voter("Ronan Murphy", "Vin Diesel with hair", "B"),
        new Voter("Ronan Shorten", "Vin Diesel", "B"),
        new Voter("Adam Shorten", "Vin Diesel", "B"),
        new Voter("Luke O Toole", "Vin Diesel", "D"),
        new Voter("Adam Shorten", "Vin Diesel with hair", "C"),
        new Voter("Ronan Murphy", "Vin Diesel with hair", "D"),
        new Voter("Adam Waldron", "Vin Diesel", "C"),
        new Voter("Adam Murphy", "Vin Diesel", "B"),
        new Voter("Luke Shorten", "Vin Diesel with hair", "A"),
        new Voter("Ronan Waldron", "Vin Diesel with hair", "A"),
        new Voter("Sean Waldron", "Vin Diesel with hair", "A"),
        new Voter("Adam Shorten", "Vin Diesel with hair", "D"),
        new Voter("Adam O Toole", "Vin Diesel with hair", "D"),
        new Voter("Sean Murphy", "Vin Diesel with hair", "D"),
        new Voter("Luke Kelly", "Vin Diesel", "B"),
        new Voter("Adam Murphy", "Vin Diesel", "C"),
        new Voter("Adam Waldron", "Vin Diesel with hair", "C"),
        new Voter("Adam Kelly", "Vin Diesel with hair", "A"),
        new Voter("Ronan Murphy", "Vin Diesel", "B"),
        new Voter("Sean Shorten", "Vin Diesel with hair", "B"),
        new Voter("Luke O Toole", "Vin Diesel", "B"),
        new Voter("Adam Murphy", "Vin Diesel with hair", "C"),
        new Voter("Sean Shorten", "Vin Diesel with hair", "D"),
        new Voter("Luke Murphy", "Vin Diesel", "C"),
        new Voter("Adam Waldron", "Vin Diesel", "D"),
        new Voter("Luke O Toole", "Vin Diesel", "B"),
        new Voter("Adam Waldron", "Vin Diesel", "D"),
        new Voter("Adam Waldron", "Vin Diesel with hair", "D"),
        new Voter("Luke Murphy", "Vin Diesel with hair", "C"),
        new Voter("Adam Murphy", "Vin Diesel with hair", "C"),
        new Voter("Luke Waldron", "Vin Diesel with hair", "C"),
        new Voter("Ronan Waldron", "Vin Diesel with hair", "B"),
        new Voter("Adam Kelly", "Vin Diesel", "A"),
        new Voter("Adam Kelly", "Vin Diesel with hair", "B"),
        new Voter("Ronan Murphy", "Vin Diesel", "D"),
        new Voter("Sean Kelly", "Vin Diesel with hair", "C"),
        new Voter("Ronan Murphy", "Vin Diesel with hair", "C"),
        new Voter("Luke Waldron", "Vin Diesel", "D"),
        new Voter("Luke Kelly", "Vin Diesel with hair", "B"),
        new Voter("Adam Shorten", "Vin Diesel", "D"),
        new Voter("Luke Murphy", "Vin Diesel with hair", "D"),
        new Voter("Adam Murphy", "Vin Diesel", "D"),
        new Voter("Adam O Toole", "Vin Diesel with hair", "D"),
        new Voter("Adam Waldron", "Vin Diesel with hair", "B"),
        new Voter("Luke O Toole", "Vin Diesel", "B"),
        new Voter("Adam Murphy", "Vin Diesel with hair", "C"),
        new Voter("Luke Murphy", "Vin Diesel", "A"),
        new Voter("Luke Murphy", "Vin Diesel with hair", "C"),
        new Voter("Sean O Toole", "Vin Diesel", "A"),
        new Voter("Luke Shorten", "Vin Diesel with hair", "C"),
        new Voter("Ronan O Toole", "Vin Diesel", "C"),
        new Voter("Adam Murphy", "Vin Diesel", "B"),
        new Voter("Sean Kelly", "Vin Diesel", "B"),
        new Voter("Adam Shorten", "Vin Diesel", "D"),
        new Voter("Luke Murphy", "Vin Diesel with hair", "A"),
        new Voter("Ronan Shorten", "Vin Diesel", "B"),
        new Voter("Sean Kelly", "Vin Diesel", "B"),
        new Voter("Sean O Toole", "Vin Diesel with hair", "D"),
        new Voter("Sean O Toole", "Vin Diesel", "D"),
        new Voter("Adam Kelly", "Vin Diesel with hair", "D"),
        new Voter("Adam Kelly", "Vin Diesel with hair", "A"),
        new Voter("Luke Murphy", "Vin Diesel with hair", "A"),
        new Voter("Sean Kelly", "Vin Diesel with hair", "C"),
        new Voter("Adam Waldron", "Vin Diesel", "A"),
        new Voter("Sean Shorten", "Vin Diesel", "A"),
        new Voter("Adam Murphy", "Vin Diesel with hair", "A"),
        new Voter("Ronan Murphy", "Vin Diesel with hair", "B"),
        new Voter("Adam Waldron", "Vin Diesel", "B"),
        new Voter("Adam Shorten", "Vin Diesel", "C"),
        new Voter("Sean O Toole", "Vin Diesel with hair", "A"),
        new Voter("Adam O Toole", "Vin Diesel", "A"),
        new Voter("Ronan Waldron", "Vin Diesel with hair", "C"),
        new Voter("Adam Kelly", "Vin Diesel with hair", "B"),
        new Voter("Adam Shorten", "Vin Diesel", "B"),
        new Voter("Adam Murphy", "Vin Diesel with hair", "B"),
        new Voter("Adam Murphy", "Vin Diesel with hair", "C"),
        new Voter("Ronan O Toole", "Vin Diesel", "D"),
        new Voter("Luke Kelly", "Vin Diesel", "C"),
        new Voter("Sean Murphy", "Vin Diesel", "D"),
        new Voter("Sean Kelly", "Vin Diesel", "B"),
        new Voter("Adam Shorten", "Vin Diesel with hair", "D"),
        new Voter("Luke Kelly", "Vin Diesel", "A"),
        new Voter("Adam Waldron", "Vin Diesel", "B"),
        new Voter("Adam Waldron", "Vin Diesel", "C"),
        new Voter("Adam Waldron", "Vin Diesel", "D"),
        new Voter("Adam Murphy", "Vin Diesel", "C"),
        new Voter("Adam Kelly", "Vin Diesel with hair", "C"),
        new Voter("Adam Waldron", "Vin Diesel", "D"),
        new Voter("Luke Kelly", "Vin Diesel with hair", "A"),
        new Voter("Adam Shorten", "Vin Diesel", "B"),
        new Voter("Adam Kelly", "Vin Diesel with hair", "D")
    };
}
