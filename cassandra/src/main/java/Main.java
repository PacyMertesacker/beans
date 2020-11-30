import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Row;

import com.datastax.driver.core.exceptions.AlreadyExistsException;

public class Main {
    // Static session so it is accessible by the CRUD methods:
    private static Session session;

    public static void main(String[] args) {
        try {
            String serverIp = "127.0.0.1";
            String keyspace = "system";
            String exampkeyspace = "exampkeyspace"; //Keyspace is a data container, similar to a database in a RDBMS. A keyspace is an outermost object that determines how data replicates on nodes.

            // Create Cassandra cluster:
            Cluster cluster = Cluster.builder()
                .addContactPoints(serverIp)
                .build();

            session = cluster.connect();
            String statement = "CREATE KEYSPACE "+ exampkeyspace +" WITH replication = {'class':'SimpleStrategy','replication_factor':1}";

            try {
                session.execute(statement);
            } catch (AlreadyExistsException ex) {
                if (!ex.getMessage().equals("Keyspace " + exampkeyspace + " already exists")) {
                    ex.printStackTrace();
                }
            }

            cluster = Cluster.builder()
                .addContactPoints(serverIp)
                .build();

            session = cluster.connect("system");

            statement = "CREATE TABLE users (" + 
                      " username varchar PRIMARY KEY," + 
                      " password varchar " + 
                      ");";
            try {
                session.execute("USE " + exampkeyspace);
                session.execute(statement);
            } catch (AlreadyExistsException ex) {
                if (!ex.getMessage().equals("Table exampkeyspace.users already exists")) {
                    ex.printStackTrace();
                }
            }

            String cqlStatementU = "UPDATE exampkeyspace.users " +
                      "SET password = 'zzaEcvAf32hla'," +
                      "WHERE username = 'Serenity';";

            String cqlStatement = "SELECT * FROM exampkeyspace.users";
            System.out.println(session.execute(cqlStatement).one());
            
            for (String row: users){
                String[] user = row.split(",");
                insertUser(user[0],user[1]);
            }

            for (Row row : session.execute(cqlStatement)) {
                System.out.println(row.toString());
            }

            session.execute(cqlStatementU);

            statement = "DROP TABLE exampkeyspace.users";
            session.execute(statement);

            statement = "DROP KEYSPACE exampkeyspace";
            session.execute(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void insertUser(String user, String password){
        session.execute("INSERT INTO exampkeyspace.users (username, password) " + 
        " VALUES ('" + user + "', '" + password + "')");
    }

    public static void deleteUser(String user){
        session.execute("DELETE FROM exampkeyspace.users " + 
                      "WHERE username = '" + user + "';");
    }


    /**
    Test Data
     */
    private static final String [] users = {
        new String("Adam,Password1"),
        new String("Beth,Password2"),
        new String("Carl,Password3"),
        new String("Daniel,Password4"),
        new String("Edith,Password5")
    };
}