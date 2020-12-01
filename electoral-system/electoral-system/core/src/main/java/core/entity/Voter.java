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
    private String address;
    @Column
    private Boolean hasVoted;

    public Voter(@JsonProperty("name") String name, @JsonProperty("region") String region,
    @JsonProperty("address") String address,@JsonProperty("hasVoted") Boolean hasVoted){
        this.name = name;
        this.region = region;
        this.region = region;
        this.hasVoted = hasVoted;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }

    public Boolean getHasVoted(){
        return hasVoted;
    }

    public void setHasVoted(@NonNull Boolean hasVoted){
        this.hasVoted = hasVoted;
    }

    @Override
    public String toString() {
        return String.format("{ id = %1$s \n name = %2$s \n region = %3$s \n address = %4$s}", getId(),
                getName(), getRegion(), getAddress());
    }
}