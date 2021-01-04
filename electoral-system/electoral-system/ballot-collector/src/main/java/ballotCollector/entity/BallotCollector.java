package ballotCollector.entity;

import java.util.HashMap;
import lombok.NonNull;
import core.entity.Candidate;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table
public class BallotCollector {
    @NonNull
    @Id
    @PrimaryKey
    private String id;

    @NonNull
    @Column
    private String region;

    @Column
    private HashMap<Candidate,String> votesMap;

    public BallotCollector(@JsonProperty("id") String id, @JsonProperty("region") String region, @JsonProperty("votesMap") HashMap<Candidate,String> votesMap) {
        this.id = id;
        this.region = region;
        this.votesMap = votesMap;
    }

    public String getId() {
        return id;
    }

    public String getRegion() {
        return region;
    }

	public HashMap<Candidate, String> getVotesMap() {
		return votesMap;
	}

    public void setId(@NonNull String id) {
        this.id = id;
    }

	public void setRegion(@NonNull String region) {
		this.region = region;
    }
    
    public void setVotesMap(@NonNull HashMap<Candidate, String> votesMap) {
		this.votesMap = votesMap;
    }	
}
