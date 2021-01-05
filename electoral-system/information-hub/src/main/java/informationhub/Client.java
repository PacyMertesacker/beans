package informationhub;

import informationhub.entity.CandidateRegistration;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;


public class Client{
    public static void main(String[] args){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CandidateRegistration[]> cr = restTemplate.getForEntity("http://localhost:8050/forum/candidates", CandidateRegistration[].class);
        CandidateRegistration[] candidates = cr.getBody();
        for(CandidateRegistration c : cr.getBody()){
            displayProfile(c);
        }
    }

    public static void displayProfile(CandidateRegistration cr) {
		System.out.println("|=================================================================================================================|");
		System.out.println("|                                     |                                     |                                     |");
		System.out.println(
                "| ID: " + String.format("%1$-29s", cr.getId()) +
				"| Name: " + String.format("%1$-29s", cr.getName()) + 
				" | Party: " + String.format("%1$-27s", cr.getParty()) +
				" | Manifesto: " + String.format("%1$-30s", cr.getManifesto())+" |");
		System.out.println("|                                     |                                     |                                     |");
		System.out.println("|=================================================================================================================|");
	}
}