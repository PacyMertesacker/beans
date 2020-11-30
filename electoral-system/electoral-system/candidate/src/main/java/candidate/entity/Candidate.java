package candidate.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.lang.NonNull;

@Table
public class Candidate {
    @Id
    @NonNull
    @PrimaryKey
    private String id;
    @NonNull
    @Column
    // name never changes
    private String name;
    @Column
    // party and bio can be edited with a patch or put request
    private String party;
    @Column
    private String bio;

    public Candidate(@JsonProperty("name") String name, @JsonProperty("party") String party,
                     @JsonProperty("bio") String bio) {
        this.name = name;
        this.party = party;
        this.bio = bio;
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

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return String.format("{ id = %1$s \n name = %2$s \n party = %3$s \n bio = %4$s}", getId().toString(),
                getName(), getParty(), getBio());
    }
}
