package informationhub.entity;

import lombok.Setter;
import lombok.Getter;

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

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getParty() {
      return party;
    }

    public void setParty(String party) {
      this.party = party;
    }

    public String getManifesto() {
      return manifesto;
    }

    public void setManifesto(String manifesto) {
      this.manifesto = manifesto;
    }
}
