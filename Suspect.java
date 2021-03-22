import java.util.UUID;

public class Suspect extends PersonOfInterest {

    public Suspect(String firstName, String lastName, int age, String gender, String race, UUID id,String address, String profession, double height, double weight, String skinColor, String natHair, String unNatHair, String clothing, boolean hasTattoo, String tatDescription, double shoeSize, boolean isUSCitizen, String crimeOrg){
         super(firstName, lastName, age, gender, race, id, address, profession, height, weight, skinColor, natHair, unNatHair, clothing, hasTattoo, tatDescription, shoeSize, isUSCitizen, crimeOrg);
    }

    public String toString(){
        return super.toString();
    }
    
}
