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

import java.util.HashMap;

@RestController
@RequestMapping("/voter")
public class VoterController {
    int numThreads = 2;

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

    @PostMapping("/test")
    public void test(){

        for (Voter voter : voters) {
            HttpEntity<Voter> request = new HttpEntity<>(voter);
            String host = "http://localhost:8083/ballotcollector/voter";
            restTemplate.postForObject(host, request, Voter.class);
        }

        // for (int i = 0;i < numThreads;i++) {
        //     final int index = i;
        //     System.out.println(index);
        //     new Thread(() -> sendVotes(index)).start();
        // }

        // new Thread(() -> sendVotes("A")).start();
        // new Thread(() -> sendVotes("B")).start();

        try {
            Thread.sleep(2000);
        } catch (Exception ex) {

        }

        restTemplate.getForObject("http://localhost:8085/SysRegMan/results", Integer.class);

        // for(Voter voter : voters){
        //     HttpEntity<Voter> request = new HttpEntity<>(voter);
        //     String host = "";
        //     if(voter.getRegion() == "A"){
        //         host = "http://localhost:8081/ballotcollectorA/voter";
        //     }
        //     else if(voter.getRegion() == "B"){
        //         host = "http://localhost:8084/ballotcollectorB/voter";
        //     }
        //     restTemplate.postForObject(host, request, Voter.class);
        // }
        // restTemplate.getForObject("http://localhost:8081/ballotcollectorA", HashMap.class);
        // restTemplate.getForObject("http://localhost:8084/ballotcollectorB", HashMap.class);
    }

    private void sendVotes(int index) {
        int unit = voters.length / numThreads;

        int secStart, secEnd;

        secStart = index * unit;
        secEnd = secStart + unit;

        if (index == numThreads - 1) {
            secEnd = voters.length;
        }

        for (int i = secStart;i < secEnd;i++) {
            HttpEntity<Voter> request = new HttpEntity<>(voters[i]);
            String host = "http://localhost:8083/ballotcollector/voter";
            restTemplate.postForObject(host, request, Voter.class);
        }
    }

    public static final Voter[] voters = {
        new Voter("Luke Kelly", "Vin Diesel with hair", "A"),
        new Voter("Adam Shorten", "Vin Diesel", "B"),
        new Voter("Adam O Toole", "Vin Diesel with hair", "A"),
        new Voter("Adam Kelly", "Vin Diesel with hair", "A"),
        new Voter("Luke Murphy", "Vin Diesel", "A"),
        new Voter("Adam Shorten", "Vin Diesel", "A"),
        new Voter("Ronan O Toole", "Vin Diesel with hair", "B"),
        new Voter("Sean Waldron", "Vin Diesel with hair", "B"),
        new Voter("Luke Shorten", "Vin Diesel with hair", "B"),
        new Voter("Ronan Murphy", "Vin Diesel with hair", "B"),
        new Voter("Ronan Shorten", "Vin Diesel", "B"),
        new Voter("Adam Shorten", "Vin Diesel", "B"),
        new Voter("Luke O Toole", "Vin Diesel", "A"),
        new Voter("Adam Shorten", "Vin Diesel with hair", "A"),
        new Voter("Ronan Murphy", "Vin Diesel with hair", "A"),
        new Voter("Adam Waldron", "Vin Diesel", "B"),
        new Voter("Adam Murphy", "Vin Diesel", "B"),
        new Voter("Luke Shorten", "Vin Diesel with hair", "A"),
        new Voter("Ronan Waldron", "Vin Diesel with hair", "A"),
        new Voter("Sean Waldron", "Vin Diesel with hair", "A"),
        new Voter("Adam Shorten", "Vin Diesel with hair", "A"),
        new Voter("Adam O Toole", "Vin Diesel with hair", "A"),
        new Voter("Sean Murphy", "Vin Diesel with hair", "A"),
        new Voter("Luke Kelly", "Vin Diesel", "B"),
        new Voter("Adam Murphy", "Vin Diesel", "B"),
        new Voter("Adam Waldron", "Vin Diesel with hair", "B"),
        new Voter("Adam Kelly", "Vin Diesel with hair", "A"),
        new Voter("Ronan Murphy", "Vin Diesel", "B"),
        new Voter("Sean Shorten", "Vin Diesel with hair", "B"),
        new Voter("Luke O Toole", "Vin Diesel", "B"),
        new Voter("Adam Murphy", "Vin Diesel with hair", "B"),
        new Voter("Sean Shorten", "Vin Diesel with hair", "A"),
        new Voter("Luke Murphy", "Vin Diesel", "B"),
        new Voter("Adam Waldron", "Vin Diesel", "A"),
        new Voter("Luke O Toole", "Vin Diesel", "B"),
        new Voter("Adam Waldron", "Vin Diesel", "A"),
        new Voter("Adam Waldron", "Vin Diesel with hair", "A"),
        new Voter("Luke Murphy", "Vin Diesel with hair", "B"),
        new Voter("Adam Murphy", "Vin Diesel with hair", "B"),
        new Voter("Luke Waldron", "Vin Diesel with hair", "B"),
        new Voter("Ronan Waldron", "Vin Diesel with hair", "B"),
        new Voter("Adam Kelly", "Vin Diesel", "A"),
        new Voter("Adam Kelly", "Vin Diesel with hair", "B"),
        new Voter("Ronan Murphy", "Vin Diesel", "A"),
        new Voter("Sean Kelly", "Vin Diesel with hair", "B"),
        new Voter("Ronan Murphy", "Vin Diesel with hair", "B"),
        new Voter("Luke Waldron", "Vin Diesel", "A"),
        new Voter("Luke Kelly", "Vin Diesel with hair", "B"),
        new Voter("Adam Shorten", "Vin Diesel", "A"),
        new Voter("Luke Murphy", "Vin Diesel with hair", "A"),
        new Voter("Adam Murphy", "Vin Diesel", "A"),
        new Voter("Adam O Toole", "Vin Diesel with hair", "A"),
        new Voter("Adam Waldron", "Vin Diesel with hair", "B"),
        new Voter("Luke O Toole", "Vin Diesel", "B"),
        new Voter("Adam Murphy", "Vin Diesel with hair", "B"),
        new Voter("Luke Murphy", "Vin Diesel", "A"),
        new Voter("Luke Murphy", "Vin Diesel with hair", "B"),
        new Voter("Sean O Toole", "Vin Diesel", "A"),
        new Voter("Luke Shorten", "Vin Diesel with hair", "B"),
        new Voter("Ronan O Toole", "Vin Diesel", "B"),
        new Voter("Adam Murphy", "Vin Diesel", "B"),
        new Voter("Sean Kelly", "Vin Diesel", "B"),
        new Voter("Adam Shorten", "Vin Diesel", "A"),
        new Voter("Luke Murphy", "Vin Diesel with hair", "A"),
        new Voter("Ronan Shorten", "Vin Diesel", "B"),
        new Voter("Sean Kelly", "Vin Diesel", "B"),
        new Voter("Sean O Toole", "Vin Diesel with hair", "A"),
        new Voter("Sean O Toole", "Vin Diesel", "A"),
        new Voter("Adam Kelly", "Vin Diesel with hair", "A"),
        new Voter("Adam Kelly", "Vin Diesel with hair", "A"),
        new Voter("Luke Murphy", "Vin Diesel with hair", "A"),
        new Voter("Sean Kelly", "Vin Diesel with hair", "B"),
        new Voter("Adam Waldron", "Vin Diesel", "A"),
        new Voter("Sean Shorten", "Vin Diesel", "A"),
        new Voter("Adam Murphy", "Vin Diesel with hair", "A"),
        new Voter("Ronan Murphy", "Vin Diesel with hair", "B"),
        new Voter("Adam Waldron", "Vin Diesel", "B"),
        new Voter("Adam Shorten", "Vin Diesel", "B"),
        new Voter("Sean O Toole", "Vin Diesel with hair", "A"),
        new Voter("Adam O Toole", "Vin Diesel", "A"),
        new Voter("Ronan Waldron", "Vin Diesel with hair", "B"),
        new Voter("Adam Kelly", "Vin Diesel with hair", "B"),
        new Voter("Adam Shorten", "Vin Diesel", "B"),
        new Voter("Adam Murphy", "Vin Diesel with hair", "B"),
        new Voter("Adam Murphy", "Vin Diesel with hair", "B"),
        new Voter("Ronan O Toole", "Vin Diesel", "A"),
        new Voter("Luke Kelly", "Vin Diesel", "B"),
        new Voter("Sean Murphy", "Vin Diesel", "A"),
        new Voter("Sean Kelly", "Vin Diesel", "B"),
        new Voter("Adam Shorten", "Vin Diesel with hair", "A"),
        new Voter("Luke Kelly", "Vin Diesel", "A"),
        new Voter("Adam Waldron", "Vin Diesel", "B"),
        new Voter("Adam Waldron", "Vin Diesel", "B"),
        new Voter("Adam Waldron", "Vin Diesel", "A"),
        new Voter("Adam Murphy", "Vin Diesel", "B"),
        new Voter("Adam Kelly", "Vin Diesel with hair", "B"),
        new Voter("Adam Waldron", "Vin Diesel", "A"),
        new Voter("Luke Kelly", "Vin Diesel with hair", "A"),
        new Voter("Adam Shorten", "Vin Diesel", "B"),
        new Voter("Adam Kelly", "Vin Diesel with hair", "A")
    };
}
