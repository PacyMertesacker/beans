
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import core.entity.Voter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VoterApplication {
        public static void main(String[] args) {
            RestTemplate restTemplate = new RestTemplate();
            for(int i=0;i<voters.length;i++){
                HttpEntity<Voter> request = new HttpEntity<>(voters[i]);
                //restTemplate.postForObject("http://192.168.99.100:8083/applications", request, Voter.class);
            }
        } 

    public static final Voter[] voters = {
        new Voter(0, "Luke Kelly", "Vin Diesel with hair", "D"),
        new Voter(1, "Adam Shorten", "Vin Diesel", "B"),
        new Voter(2, "Adam O Toole", "Vin Diesel with hair", "A"),
        new Voter(3, "Adam Kelly", "Vin Diesel with hair", "A"),
        new Voter(4, "Luke Murphy", "Vin Diesel", "A"),
        new Voter(5, "Adam Shorten", "Vin Diesel", "D"),
        new Voter(6, "Ronan O Toole", "Vin Diesel with hair", "B"),
        new Voter(7, "Sean Waldron", "Vin Diesel with hair", "B"),
        new Voter(8, "Luke Shorten", "Vin Diesel with hair", "B"),
        new Voter(9, "Ronan Murphy", "Vin Diesel with hair", "B"),
        new Voter(10, "Ronan Shorten", "Vin Diesel", "B"),
        new Voter(11, "Adam Shorten", "Vin Diesel", "B"),
        new Voter(12, "Luke O Toole", "Vin Diesel", "D"),
        new Voter(13, "Adam Shorten", "Vin Diesel with hair", "C"),
        new Voter(14, "Ronan Murphy", "Vin Diesel with hair", "D"),
        new Voter(15, "Adam Waldron", "Vin Diesel", "C"),
        new Voter(16, "Adam Murphy", "Vin Diesel", "B"),
        new Voter(17, "Luke Shorten", "Vin Diesel with hair", "A"),
        new Voter(18, "Ronan Waldron", "Vin Diesel with hair", "A"),
        new Voter(19, "Sean Waldron", "Vin Diesel with hair", "A"),
        new Voter(20, "Adam Shorten", "Vin Diesel with hair", "D"),
        new Voter(21, "Adam O Toole", "Vin Diesel with hair", "D"),
        new Voter(22, "Sean Murphy", "Vin Diesel with hair", "D"),
        new Voter(23, "Luke Kelly", "Vin Diesel", "B"),
        new Voter(24, "Adam Murphy", "Vin Diesel", "C"),
        new Voter(25, "Adam Waldron", "Vin Diesel with hair", "C"),
        new Voter(26, "Adam Kelly", "Vin Diesel with hair", "A"),
        new Voter(27, "Ronan Murphy", "Vin Diesel", "B"),
        new Voter(28, "Sean Shorten", "Vin Diesel with hair", "B"),
        new Voter(29, "Luke O Toole", "Vin Diesel", "B"),
        new Voter(30, "Adam Murphy", "Vin Diesel with hair", "C"),
        new Voter(31, "Sean Shorten", "Vin Diesel with hair", "D"),
        new Voter(32, "Luke Murphy", "Vin Diesel", "C"),
        new Voter(33, "Adam Waldron", "Vin Diesel", "D"),
        new Voter(34, "Luke O Toole", "Vin Diesel", "B"),
        new Voter(35, "Adam Waldron", "Vin Diesel", "D"),
        new Voter(36, "Adam Waldron", "Vin Diesel with hair", "D"),
        new Voter(37, "Luke Murphy", "Vin Diesel with hair", "C"),
        new Voter(38, "Adam Murphy", "Vin Diesel with hair", "C"),
        new Voter(39, "Luke Waldron", "Vin Diesel with hair", "C"),
        new Voter(40, "Ronan Waldron", "Vin Diesel with hair", "B"),
        new Voter(41, "Adam Kelly", "Vin Diesel", "A"),
        new Voter(42, "Adam Kelly", "Vin Diesel with hair", "B"),
        new Voter(43, "Ronan Murphy", "Vin Diesel", "D"),
        new Voter(44, "Sean Kelly", "Vin Diesel with hair", "C"),
        new Voter(45, "Ronan Murphy", "Vin Diesel with hair", "C"),
        new Voter(46, "Luke Waldron", "Vin Diesel", "D"),
        new Voter(47, "Luke Kelly", "Vin Diesel with hair", "B"),
        new Voter(48, "Adam Shorten", "Vin Diesel", "D"),
        new Voter(49, "Luke Murphy", "Vin Diesel with hair", "D"),
        new Voter(50, "Adam Murphy", "Vin Diesel", "D"),
        new Voter(51, "Adam O Toole", "Vin Diesel with hair", "D"),
        new Voter(52, "Adam Waldron", "Vin Diesel with hair", "B"),
        new Voter(53, "Luke O Toole", "Vin Diesel", "B"),
        new Voter(54, "Adam Murphy", "Vin Diesel with hair", "C"),
        new Voter(55, "Luke Murphy", "Vin Diesel", "A"),
        new Voter(56, "Luke Murphy", "Vin Diesel with hair", "C"),
        new Voter(57, "Sean O Toole", "Vin Diesel", "A"),
        new Voter(58, "Luke Shorten", "Vin Diesel with hair", "C"),
        new Voter(59, "Ronan O Toole", "Vin Diesel", "C"),
        new Voter(60, "Adam Murphy", "Vin Diesel", "B"),
        new Voter(61, "Sean Kelly", "Vin Diesel", "B"),
        new Voter(62, "Adam Shorten", "Vin Diesel", "D"),
        new Voter(63, "Luke Murphy", "Vin Diesel with hair", "A"),
        new Voter(64, "Ronan Shorten", "Vin Diesel", "B"),
        new Voter(65, "Sean Kelly", "Vin Diesel", "B"),
        new Voter(66, "Sean O Toole", "Vin Diesel with hair", "D"),
        new Voter(67, "Sean O Toole", "Vin Diesel", "D"),
        new Voter(68, "Adam Kelly", "Vin Diesel with hair", "D"),
        new Voter(69, "Adam Kelly", "Vin Diesel with hair", "A"),
        new Voter(70, "Luke Murphy", "Vin Diesel with hair", "A"),
        new Voter(71, "Sean Kelly", "Vin Diesel with hair", "C"),
        new Voter(72, "Adam Waldron", "Vin Diesel", "A"),
        new Voter(73, "Sean Shorten", "Vin Diesel", "A"),
        new Voter(74, "Adam Murphy", "Vin Diesel with hair", "A"),
        new Voter(75, "Ronan Murphy", "Vin Diesel with hair", "B"),
        new Voter(76, "Adam Waldron", "Vin Diesel", "B"),
        new Voter(77, "Adam Shorten", "Vin Diesel", "C"),
        new Voter(78, "Sean O Toole", "Vin Diesel with hair", "A"),
        new Voter(79, "Adam O Toole", "Vin Diesel", "A"),
        new Voter(80, "Ronan Waldron", "Vin Diesel with hair", "C"),
        new Voter(81, "Adam Kelly", "Vin Diesel with hair", "B"),
        new Voter(82, "Adam Shorten", "Vin Diesel", "B"),
        new Voter(83, "Adam Murphy", "Vin Diesel with hair", "B"),
        new Voter(84, "Adam Murphy", "Vin Diesel with hair", "C"),
        new Voter(85, "Ronan O Toole", "Vin Diesel", "D"),
        new Voter(86, "Luke Kelly", "Vin Diesel", "C"),
        new Voter(87, "Sean Murphy", "Vin Diesel", "D"),
        new Voter(88, "Sean Kelly", "Vin Diesel", "B"),
        new Voter(89, "Adam Shorten", "Vin Diesel with hair", "D"),
        new Voter(90, "Luke Kelly", "Vin Diesel", "A"),
        new Voter(91, "Adam Waldron", "Vin Diesel", "B"),
        new Voter(92, "Adam Waldron", "Vin Diesel", "C"),
        new Voter(93, "Adam Waldron", "Vin Diesel", "D"),
        new Voter(94, "Adam Murphy", "Vin Diesel", "C"),
        new Voter(95, "Adam Kelly", "Vin Diesel with hair", "C"),
        new Voter(96, "Adam Waldron", "Vin Diesel", "D"),
        new Voter(97, "Luke Kelly", "Vin Diesel with hair", "A"),
        new Voter(98, "Adam Shorten", "Vin Diesel", "B"),
        new Voter(99, "Adam Kelly", "Vin Diesel with hair", "D"),            
    };
}
