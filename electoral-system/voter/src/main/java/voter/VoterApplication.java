package voter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import core.entity.Voter;

@SpringBootApplication
@EnableEurekaClient
public class VoterApplication {

	public static void main(String[] args) {
	
		SpringApplication.run(VoterApplication.class, args);
	}

	@Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
	// public static final Voter[] voters = {
	// 		new Voter("Luke Kelly", "Vin Diesel with hair", "D"),
	// 		new Voter("Adam Shorten", "Vin Diesel", "B"),
	// 		new Voter("Adam O Toole", "Vin Diesel with hair", "A"),
	// 		new Voter("Adam Kelly", "Vin Diesel with hair", "A"),
	// 		new Voter("Luke Murphy", "Vin Diesel", "A"),
	// 		new Voter("Adam Shorten", "Vin Diesel", "D"),
	// 		new Voter("Ronan O Toole", "Vin Diesel with hair", "B"),
	// 		new Voter("Sean Waldron", "Vin Diesel with hair", "B"),
	// 		new Voter("Luke Shorten", "Vin Diesel with hair", "B"),
	// 		new Voter("Ronan Murphy", "Vin Diesel with hair", "B"),
	// 		new Voter("Ronan Shorten", "Vin Diesel", "B"),
	// 		new Voter("Adam Shorten", "Vin Diesel", "B"),
	// 		new Voter("Luke O Toole", "Vin Diesel", "D"),
	// 		new Voter("Adam Shorten", "Vin Diesel with hair", "C"),
	// 		new Voter("Ronan Murphy", "Vin Diesel with hair", "D"),
	// 		new Voter("Adam Waldron", "Vin Diesel", "C"),
	// 		new Voter("Adam Murphy", "Vin Diesel", "B"),
	// 		new Voter("Luke Shorten", "Vin Diesel with hair", "A"),
	// 		new Voter("Ronan Waldron", "Vin Diesel with hair", "A"),
	// 		new Voter("Sean Waldron", "Vin Diesel with hair", "A"),
	// 		new Voter("Adam Shorten", "Vin Diesel with hair", "D"),
	// 		new Voter("Adam O Toole", "Vin Diesel with hair", "D"),
	// 		new Voter("Sean Murphy", "Vin Diesel with hair", "D"),
	// 		new Voter("Luke Kelly", "Vin Diesel", "B"),
	// 		new Voter("Adam Murphy", "Vin Diesel", "C"),
	// 		new Voter("Adam Waldron", "Vin Diesel with hair", "C"),
	// 		new Voter("Adam Kelly", "Vin Diesel with hair", "A"),
	// 		new Voter("Ronan Murphy", "Vin Diesel", "B"),
	// 		new Voter("Sean Shorten", "Vin Diesel with hair", "B"),
	// 		new Voter("Luke O Toole", "Vin Diesel", "B"),
	// 		new Voter("Adam Murphy", "Vin Diesel with hair", "C"),
	// 		new Voter("Sean Shorten", "Vin Diesel with hair", "D"),
	// 		new Voter("Luke Murphy", "Vin Diesel", "C"),
	// 		new Voter("Adam Waldron", "Vin Diesel", "D"),
	// 		new Voter("Luke O Toole", "Vin Diesel", "B"),
	// 		new Voter("Adam Waldron", "Vin Diesel", "D"),
	// 		new Voter("Adam Waldron", "Vin Diesel with hair", "D"),
	// 		new Voter("Luke Murphy", "Vin Diesel with hair", "C"),
	// 		new Voter("Adam Murphy", "Vin Diesel with hair", "C"),
	// 		new Voter("Luke Waldron", "Vin Diesel with hair", "C"),
	// 		new Voter("Ronan Waldron", "Vin Diesel with hair", "B"),
	// 		new Voter("Adam Kelly", "Vin Diesel", "A"),
	// 		new Voter("Adam Kelly", "Vin Diesel with hair", "B"),
	// 		new Voter("Ronan Murphy", "Vin Diesel", "D"),
	// 		new Voter("Sean Kelly", "Vin Diesel with hair", "C"),
	// 		new Voter("Ronan Murphy", "Vin Diesel with hair", "C"),
	// 		new Voter("Luke Waldron", "Vin Diesel", "D"),
	// 		new Voter("Luke Kelly", "Vin Diesel with hair", "B"),
	// 		new Voter("Adam Shorten", "Vin Diesel", "D"),
	// 		new Voter("Luke Murphy", "Vin Diesel with hair", "D"),
	// 		new Voter("Adam Murphy", "Vin Diesel", "D"),
	// 		new Voter("Adam O Toole", "Vin Diesel with hair", "D"),
	// 		new Voter("Adam Waldron", "Vin Diesel with hair", "B"),
	// 		new Voter("Luke O Toole", "Vin Diesel", "B"),
	// 		new Voter("Adam Murphy", "Vin Diesel with hair", "C"),
	// 		new Voter("Luke Murphy", "Vin Diesel", "A"),
	// 		new Voter("Luke Murphy", "Vin Diesel with hair", "C"),
	// 		new Voter("Sean O Toole", "Vin Diesel", "A"),
	// 		new Voter("Luke Shorten", "Vin Diesel with hair", "C"),
	// 		new Voter("Ronan O Toole", "Vin Diesel", "C"),
	// 		new Voter("Adam Murphy", "Vin Diesel", "B"),
	// 		new Voter("Sean Kelly", "Vin Diesel", "B"),
	// 		new Voter("Adam Shorten", "Vin Diesel", "D"),
	// 		new Voter("Luke Murphy", "Vin Diesel with hair", "A"),
	// 		new Voter("Ronan Shorten", "Vin Diesel", "B"),
	// 		new Voter("Sean Kelly", "Vin Diesel", "B"),
	// 		new Voter("Sean O Toole", "Vin Diesel with hair", "D"),
	// 		new Voter("Sean O Toole", "Vin Diesel", "D"),
	// 		new Voter("Adam Kelly", "Vin Diesel with hair", "D"),
	// 		new Voter("Adam Kelly", "Vin Diesel with hair", "A"),
	// 		new Voter("Luke Murphy", "Vin Diesel with hair", "A"),
	// 		new Voter("Sean Kelly", "Vin Diesel with hair", "C"),
	// 		new Voter("Adam Waldron", "Vin Diesel", "A"),
	// 		new Voter("Sean Shorten", "Vin Diesel", "A"),
	// 		new Voter("Adam Murphy", "Vin Diesel with hair", "A"),
	// 		new Voter("Ronan Murphy", "Vin Diesel with hair", "B"),
	// 		new Voter("Adam Waldron", "Vin Diesel", "B"),
	// 		new Voter("Adam Shorten", "Vin Diesel", "C"),
	// 		new Voter("Sean O Toole", "Vin Diesel with hair", "A"),
	// 		new Voter("Adam O Toole", "Vin Diesel", "A"),
	// 		new Voter("Ronan Waldron", "Vin Diesel with hair", "C"),
	// 		new Voter("Adam Kelly", "Vin Diesel with hair", "B"),
	// 		new Voter("Adam Shorten", "Vin Diesel", "B"),
	// 		new Voter("Adam Murphy", "Vin Diesel with hair", "B"),
	// 		new Voter("Adam Murphy", "Vin Diesel with hair", "C"),
	// 		new Voter("Ronan O Toole", "Vin Diesel", "D"),
	// 		new Voter("Luke Kelly", "Vin Diesel", "C"),
	// 		new Voter("Sean Murphy", "Vin Diesel", "D"),
	// 		new Voter("Sean Kelly", "Vin Diesel", "B"),
	// 		new Voter("Adam Shorten", "Vin Diesel with hair", "D"),
	// 		new Voter("Luke Kelly", "Vin Diesel", "A"),
	// 		new Voter("Adam Waldron", "Vin Diesel", "B"),
	// 		new Voter("Adam Waldron", "Vin Diesel", "C"),
	// 		new Voter("Adam Waldron", "Vin Diesel", "D"),
	// 		new Voter("Adam Murphy", "Vin Diesel", "C"),
	// 		new Voter("Adam Kelly", "Vin Diesel with hair", "C"),
	// 		new Voter("Adam Waldron", "Vin Diesel", "D"),
	// 		new Voter("Luke Kelly", "Vin Diesel with hair", "A"),
	// 		new Voter("Adam Shorten", "Vin Diesel", "B"),
	// 		new Voter("Adam Kelly", "Vin Diesel with hair", "D")
	// };
}
