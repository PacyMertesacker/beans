package candidate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import core.entity.Candidate;

@SpringBootApplication
@EnableEurekaClient
public class CandidateApplication {
    public static void main(String[] args) {
        SpringApplication.run(CandidateApplication.class, args);
    }
}
