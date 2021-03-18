import java.util.UUID;

public class Associate extends Person{
    private String relationship;
    private UUID relationshipID;


    public Associate() {
        this.relationship = relationship;
        this.relationshipID = relationshipID; 
    }
    public String toString(){
        return super.toString() + this.relationship + this.relationshipID;
    }


}
