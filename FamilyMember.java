
import java.util.UUID;

public class FamilyMember extends Person{
    private String relationship;
    private UUID relationshipID;

    public FamilyMember(String firstName, String lastName, int age, String gender, String race, UUID id, String address,
    String profession, double height, double weight, String skinCol, String natHairCol, String unNatHairCol,
    String clothing, boolean hasTattoo, String tatDesc, double shoeSize, boolean isUsCitizen,
    String org, String relationship, UUID relationshipID) {
        super(firstName, lastName, age, gender, race, id, address, profession, height, weight, skinCol, natHairCol, unNatHairCol, clothing, hasTattoo, tatDesc, shoeSize, isUsCitizen, org); 
        this.setRelationship(relationship);
        this.setRelationshipID(relationshipID);
    }
    public String getRelationship() {
        return relationship; 
    }
    public UUID getRelationshipID(){
        return relationshipID; 
    }
    public void setRelationship(String relationship){
        this.relationship = relationship; 
    }
    public void setRelationshipID(UUID relationshipID){
        this.relationshipID = id; 
    }
    public String toString() {
        return super.toString()+ this.relationship + this.relationshipID;
    }
}