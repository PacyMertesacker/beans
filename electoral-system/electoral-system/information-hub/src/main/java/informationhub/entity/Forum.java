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
public class Forum {
    //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    @NonNull
    @Id
    @PrimaryKey
    @Setter @Getter
    private String id;

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

    public Forum(@JsonProperty("id") String id, @JsonProperty("name") String name, 
    @JsonProperty("message") String message) {
        this.id = id;
        this.name = name;
        this.message = message;
    }

    public String toString() {
        return String.format("{ id = %1$s \n name = %2$s \n message = %3$s \n timestamp = %4$s}", id, name, message, messageTimestamp);
    }
}
