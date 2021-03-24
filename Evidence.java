import java.util.UUID;

public class Evidence {
    public String description;
    public UUID evidenceID;
    public String evidenceType;

    public Evidence(String description, UUID id, String evidencetype) {
        this.setDescription(description);;
        if (evidenceID == null) {
            this.evidenceID = UUID.randomUUID();
        } else {
            this.setID(id);
        }
        this.setEvidenceType(evidenceType);
    }

    public String toString(){
        return "Evidence description: " + this.description + "\nEvidence ID: " + this.evidenceID;
    }

    public String getDescription(){
        return this.description;
    }

    public UUID getID(){
        return this.evidenceID;
    }

    public String getEvidenceType() {
        return this.evidenceType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setID(UUID id) {
        this.evidenceID = id;
    }
    public void setEvidenceType(String evidenceType){
        this.evidenceType = evidenceType; 
    }
}