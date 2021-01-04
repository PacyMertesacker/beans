package informationhub.entity;

import lombok.Setter;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.HashMap;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import com.fasterxml.jackson.annotation.JsonProperty;


@Table
public class CandidateRegistration implements Comparable<CandidateRegistration>{
    @NonNull
    @Id
    @PrimaryKey
    @Setter @Getter
    private int id;

    @NonNull
    @Column
    @Setter @Getter
    private String name;

    @NonNull
    @Column
    @Setter @Getter
    private String party;

    @NonNull
    @Column
    @Setter @Getter
    private String manifesto;

    public CandidateRegistration(@JsonProperty("id") int id, @JsonProperty("name") String name, 
    @JsonProperty("party") String party, @JsonProperty("manifesto") String manifesto) {
        this.id = id;
        this.name = name;
        this.party = party;
        this.manifesto = manifesto;
    }

    // Used for sorting candidates by party.
    @Override public int compareTo(CandidateRegistration cr) { 
        if (this.getParty() == null || cr.getParty() == null) { 
          return 0; 
        } 
        return this.getParty().compareTo(cr.getParty());
      }

    public String toString() {
        return String.format("{ id = %1$s \n name = %2$s \n party = %3$s \n manifesto = %4$s}", id, name, party, manifesto);
    }
}
