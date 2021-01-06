package core.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.lang.NonNull;
import lombok.Setter;
import lombok.Getter;

@Table
public class Votes{
    @NonNull
    @PrimaryKey
    @Column
    @Setter @Getter
    private int id;

    @NonNull
    @Column
    @Setter @Getter
    private String candidate;
    
    @NonNull
    @Column
    @Setter @Getter
    private String region;

    @NonNull
    @Column
   // @Setter @Getter
    private int numOfVotes;

    public Votes(@JsonProperty("id") int id, @JsonProperty("candidate") String candidate, @JsonProperty("region") String region, @JsonProperty("numOfVotes") int numOfVotes){
        this.id = id;
        this.candidate = candidate;
        this.region = region;
        this.numOfVotes = numOfVotes;
    }

    public int getNumOfVotes() {
        return numOfVotes;
    }

    public void setNumOfVotes(int numOfVotes) {
        this.numOfVotes = numOfVotes;
    }

}
