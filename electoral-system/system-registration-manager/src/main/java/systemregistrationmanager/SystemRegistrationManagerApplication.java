package systemregistrationmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class SystemRegistrationManagerApplication {

	public static void main(String[] args) {
//		new RestTemplate().getForObject("http://localhost:8083/voter/test", Integer.class);

		SpringApplication.run(SystemRegistrationManagerApplication.class, args);
	}

}