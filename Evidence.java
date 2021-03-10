import java.util.UUID;

public class Evidence {
    public String description;
    public UUID evidenceId;
    public Evidence evidenceType;

    public String toString(){
        return "";
    }

    public String getDescription(){
        return "";
    }

    public UUID getID(){
        UUID uuid = UUID.randomUUID();
        return uuid;
    }

    
}
