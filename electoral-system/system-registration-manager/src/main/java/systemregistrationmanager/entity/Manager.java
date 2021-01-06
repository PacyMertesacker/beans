package systemregistrationmanager.entity;

import lombok.Setter;
import lombok.Getter;

import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table
public class Manager {
    @NonNull
    @Id
    @PrimaryKey
    @Setter @Getter
    private String id;

    @NonNull
    @Column
    @Setter @Getter
    private String name;

    public Manager(@JsonProperty("id") String id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return String.format("{ id = %1$s \n name = %2$s }", id, name);
    }
}
