import java.util.UUID;

public class Victim extends PersonOfInterest {
    public boolean willTestify;

    public Victim(String firstName, String lastName, int age, String gender, String race, UUID id,String address, String profession, double height, double weight, String skinColor, String natHair, String unNatHair, String clothing, boolean hasTattoo, String tatDescription, double shoeSize, boolean isUSCitizen, String crimeOrg, boolean willTestify){
        super(firstName, lastName, age, gender, race, id ,address, profession, height, weight, skinColor, natHair, unNatHair, clothing, hasTattoo, tatDescription, shoeSize, isUSCitizen, crimeOrg); 
        this.setWillTestify(willTestify);
    }
    public boolean getWillTestify(){
        return willTestify; 
    }
    public void setWillTestify(boolean willTestify){
        this.willTestify = willTestify; 
    }
    public String toString(){
        return super.toString() + this.willTestify;
    }
}
