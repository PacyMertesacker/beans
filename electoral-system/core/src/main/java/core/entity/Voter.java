package core.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.lang.NonNull;

@Table
public class Voter{
    @Id
    @PrimaryKey
    private String id;
    @NonNull
    @Column
    // name never changes
    private String name;
    @Column
    private String region;
   
    @Column
    private String votedFor;

    public Voter(@JsonProperty("name") String name, @JsonProperty("region") String region,
   @JsonProperty("votedFor")String votedFor){
        this.name = name;
        this.votedFor = votedFor;
        this.region = region;
    }
    
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(@NonNull String region) {
        this.region = region;
    }

    public String getVotedFor() {
        return votedFor;
    }

    public void setVotedFor(@NonNull String votedFor) {
        this.votedFor = votedFor;
    }
}
