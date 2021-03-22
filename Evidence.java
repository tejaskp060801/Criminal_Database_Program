import java.util.UUID;

public class Evidence {
    public String description;
    public UUID evidenceId;
    public Evidence evidenceType;

    public String toString(){
        return "Evidence description: " + this.description + "\nEvidence ID: " + this.evidenceId;
    }

    public String getDescription(){
        return this.description;
    }

    public UUID getID(){
        return this.evidenceId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setID(UUID id) {
        this.evidenceId = id;
    }
    
}
