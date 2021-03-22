import java.util.UUID;

public class Suspect extends PersonOfInterest {

    public Suspect(String firstName, String lastName, int age, String gender, String race, UUID id,String address, String profession, double height, double weight, String skinColor, String natHair, String unNatHair, String clothing, boolean hasTattoo, String tatDescription, double shoeSize, boolean isUSCitizen, String crimeOrg, boolean willTestify){
         super(crimeOrg, crimeOrg, age, crimeOrg, crimeOrg, id, crimeOrg, crimeOrg, shoeSize, shoeSize, crimeOrg, crimeOrg, crimeOrg, crimeOrg, willTestify, crimeOrg, shoeSize, willTestify, crimeOrg);
    }

    public String toString(){
        return super.toString();
    }
    
}
