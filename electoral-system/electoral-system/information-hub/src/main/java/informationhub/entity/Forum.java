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

//import java.util.Comparable;

@Table
public class Forum implements Comparable<Forum>{
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
    private String message;

    @NonNull
    @Column
    @Setter @Getter
    private Timestamp messageTimestamp;

    public Forum(@JsonProperty("name") String name, 
    @JsonProperty("message") String message) {
        this.name = name;
        this.message = message;
    }

    public void setMessageDetails(int id, Timestamp messageTimestamp){
        this.id = id;
        this.messageTimestamp = messageTimestamp;
    }

    // Used for sorting messages in correct order of time.
    @Override public int compareTo(Forum f) { 
        if (this.getMessageTimestamp() == null || f.getMessageTimestamp() == null) { 
          return 0; 
        } 
        return this.getMessageTimestamp().compareTo(f.getMessageTimestamp());
      }

    public String toString() {
        return String.format("{ id = %1$s \n name = %2$s \n message = %3$s \n timestamp = %4$s}", id, name, message, messageTimestamp);
    }
}
