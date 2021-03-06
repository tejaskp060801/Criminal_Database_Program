import java.util.UUID;
import java.util.ArrayList;

public class Suspect extends PersonOfInterest {
    protected boolean willTestify;

    public Suspect(String firstName, String lastName, int age, String gender, String race,
        UUID id,String address, String profession, double height, double weight,
        String skinColor, String natHair, String unNatHair, String clothing,
        boolean hasTattoo, String tatDescription, double shoeSize, boolean isUSCitizen,
        String crimeOrg, ArrayList<UUID> crimes, ArrayList<UUID> relations, String statement, 
        boolean willTestify){
         super(firstName, lastName, age, gender, race, id, address, profession,
            height, weight, skinColor, natHair, unNatHair, clothing,
            hasTattoo, tatDescription, shoeSize, isUSCitizen, crimeOrg,
            crimes, relations, statement);
        this.willTestify = willTestify;
        this.personType = "Suspect";
    }

    public String toString(){
        return super.toString() + "\nWill Testify: " + this.willTestify;
    }

    public boolean getWillTestify() {
        return this.willTestify;
    }
    
}
