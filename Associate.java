import java.util.UUID;

public class Associate extends Person{
    private String relationship;
    private UUID relationshipID;


    public Associate(String firstName, String lastName, int age, String gender, String race, UUID id, String address,
    String profession, double height, double weight, String skinCol, String natHairCol, String unNatHairCol,
    String clothing, boolean hasTattoo, String tatDesc, double shoeSize, boolean isUsCitizen,
    String org, String relationship, UUID relationshipID) {
        super(firstName, lastName, age, gender, race, id, address, profession, height, weight, skinCol, natHairCol, unNatHairCol, clothing, hasTattoo, tatDesc, shoeSize, isUsCitizen, org); 
        this.setRelationship(relationship);
        this.setRelationshipID(relationshipID);
        this.personType = "Associate";
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
        this.relationshipID = relationshipID; 
    }
    public String toString(){
        return super.toString() 
        + "\n the relationship between criminal and associate is " + this.relationship 
        + "\n the Relationship ID is "  + this.relationshipID;
    }


}
