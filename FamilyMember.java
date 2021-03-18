
import java.util.UUID;

public class FamilyMember extends Person{
    private String relationship;
    private UUID relationshipID;

    public FamilyMember() {
        this.relationship = relationship; 
        this.relationshipID = relationshipID; 
    }
    public String toString() {
        return super.toString()+ this.relationship + this.relationshipID;
    }
}