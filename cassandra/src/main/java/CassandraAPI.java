import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Row;

import com.datastax.driver.core.exceptions.AlreadyExistsException;

public class CassandraAPI{
    String serverIp = "127.0.0.1";
    String keyspace = "system";

     cluster = Cluster.builder()
        .addContactPoints(serverIp)
        .build();

    session = cluster.connect("system");

    public void insertRow(){

    }

    public void updateRow(){

    }

    public void deleteRow(){

    }
}