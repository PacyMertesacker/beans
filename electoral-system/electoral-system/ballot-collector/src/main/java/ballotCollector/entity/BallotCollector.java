package ballotCollector.entity;

import java.util.HashMap;
import candidate.entity.Candidate;
import lombok.NonNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;


@Table
public class BallotCollector {
    @NonNull
    @Id
    private String id;

    @NonNull
    @Column
    private String region;

    @Column
    private HashMap<Candidate,Integer> votesMap;

    public BallotCollector(String id, String region) {
        this.id = id;
        this.region = region;
    }

    public String getId() {
        return id;
    }

    public String getRegion() {
        return region;
    }

	public HashMap<Candidate, Integer> getVotesMap() {
		return votesMap;
	}

    public void setId(String id) {
        this.id = id;
    }

	public void setRegion(String region) {
		this.region = region;
    }
    
    public void setVotesMap(HashMap<Candidate, Integer> votesMap) {
		this.votesMap = votesMap;
    }	

    public String toString() {
        return String.format("{ id = %1$s \n region = %2$s }", getId(),getRegion() );
    }
}
