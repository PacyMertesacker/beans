package Entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
public class Candidate {
    @PrimaryKey private final UUID id;
    @Column
    // name never changes
    private final String name;
    @Column
    // party and bio can be edited with a patch or put request
    private String party;
    @Column
    private String bio;

    public Candidate(UUID id, String name, String party, String bio) {
        this.id = id;
        this.name = name;
        this.party = party;
        this.bio = bio;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
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
