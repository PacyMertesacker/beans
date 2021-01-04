package core.entity;

public class Voter{
  
    private int id;
  
    private String name;

    private String votedFor;

    private String region;

    public Voter( int id, String name, String votedFor, String region){
        this.id= id;
        this.name = name;
        this.votedFor = votedFor;
        this.region = region;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getVotedFor() {
        return votedFor;
    }

    public void setVotedFor(String votedFor) {
        this.votedFor = votedFor;
    }
}
