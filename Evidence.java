import java.util.UUID;

public class Evidence {
    public String description;
    public UUID evidenceID;
    public String evidenceType;

    public Evidence(String description, UUID evidenceID, String evidencetype) {
        this.description = description;
        if (evidenceID == null) {
            this.evidenceID = UUID.randomUUID();
        } else {
            this.evidenceID = evidenceID;
        }
        this.evidenceType = evidencetype;
    }

    public String toString(){
        return "Evidence description: " + this.description + "\nEvidence ID: " + this.evidenceId;
    }

    public String getDescription(){
        return this.description;
    }

    public UUID getID(){
        return this.evidenceID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setID(UUID id) {
        this.evidenceID = id;
    }
    
}
