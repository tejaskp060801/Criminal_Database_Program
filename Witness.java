import java.util.UUID;
import java.util.ArrayList;

public class Witness extends PersonOfInterest {
    public boolean willTestify;

    public Witness(String firstName, String lastName, int age, String gender, String race,
        UUID id,String address, String profession, double height, double weight,
        String skinColor, String natHair, String unNatHair, String clothing,
        boolean hasTattoo, String tatDescription, double shoeSize, boolean isUSCitizen,
        String crimeOrg, ArrayList<UUID> crimes, ArrayList<UUID> relations, String statement,
        boolean willTestify){
        super(firstName, lastName, age, gender, race, id, address, profession, height,
            weight, skinColor, natHair, unNatHair, clothing, hasTattoo, tatDescription,
            shoeSize, isUSCitizen, crimeOrg, crimes, relations, statement);
        this.setWillTestify(willTestify);  
        this.personType = "Witness";
    }
    public boolean getWillTestify(){
        return willTestify; 
    }
    public void setWillTestify(boolean willTestify){
        this.willTestify = willTestify; 
    }
    public String toString(){
        return super.toString() + "\nThe witness " + this.willTestify +" testify";
    }
    
}
