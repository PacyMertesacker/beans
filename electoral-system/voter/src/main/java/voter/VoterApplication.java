package voter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VoterApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoterApplication.class, args);
	}

}
