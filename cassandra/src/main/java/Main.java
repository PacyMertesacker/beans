import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Row;

import com.datastax.driver.core.exceptions.AlreadyExistsException;

public class Main {
    public static void main(String[] args) {
        try {
            String serverIp = "127.0.0.1";
            String keyspace = "system";

            Cluster cluster = Cluster.builder()
                .addContactPoints(serverIp)
                .build();

            Session session = cluster.connect();

            String exampkeyspace = "exampkeyspace";
            String statement = "CREATE KEYSPACE "+ exampkeyspace +" WITH replication = {'class':'SimpleStrategy','replication_factor':1}";

            try {
                session.execute(statement);
            } catch (AlreadyExistsException ex) {
                if (!ex.getMessage().equals("Keyspace " + exampkeyspace + " already exists")) {
                    ex.printStackTrace();
                }
            }

            keyspace = "exampkeyspace";

            cluster = Cluster.builder()
                .addContactPoints(serverIp)
                .build();

            session = cluster.connect("system");

            statement = "CREATE TABLE users (" + 
                      " username varchar PRIMARY KEY," + 
                      " password varchar " + 
                      ");";
            try {
                session.execute(statement);
            } catch (AlreadyExistsException ex) {
                if (!ex.getMessage().equals("Table exampkeyspace.users already exists")) {
                    ex.printStackTrace();
                }
            }

            String cqlStatementC = "INSERT INTO exampkeyspace.users (username, password) " + 
                      "VALUES ('Serenity', 'fa3dfQefx')";

            String cqlStatementU = "UPDATE exampkeyspace.users " +
                      "SET password = 'zzaEcvAf32hla'," +
                      "WHERE username = 'Serenity';";

            String cqlStatementD = "DELETE FROM exampkeyspace.users " + 
                      "WHERE username = 'Serenity';";

            session.execute(cqlStatementC);

            String cqlStatement = "SELECT * FROM exampkeyspace.users";
            
            for (Row row : session.execute(cqlStatement)) {
                System.out.println(row.toString());
            }

            session.execute(cqlStatementD);

            statement = "DROP TABLE exampkeyspace.users";
            session.execute(statement);

            statement = "DROP KEYSPACE exampkeyspace";
            session.execute(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}