package voter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
	@LoadBalanced
	@Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
