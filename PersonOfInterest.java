import java.util.ArrayList;
import java.util.UUID;

public abstract class PersonOfInterest extends Person{
    protected ArrayList<UUID> crimes;
    protected ArrayList<UUID> relations;
    protected String statement;

    public PersonOfInterest(String firstName, String lastName, int age, String gender,
        String race, UUID id,String address, String profession, double height,
        double weight, String skinColor, String natHair, String unNatHair,
        String clothing, boolean hasTattoo, String tatDescription, double shoeSize,
        boolean isUSCitizen, String crimeOrg, ArrayList<UUID> crimes, ArrayList<UUID> relations,
        String statement) {
        super(firstName, lastName, age, gender, race, id, address, profession,
            height, weight, skinColor, natHair, unNatHair, clothing, hasTattoo,
            tatDescription, shoeSize, isUSCitizen, crimeOrg);
        this.crimes = crimes;
        this.relations = relations;
        this.statement = statement;
    }
    public ArrayList<UUID> getCrimes() {
        return this.crimes;
    }
    
    public ArrayList<UUID> getRelations() {
        return this.relations;
    }
    
    public String getStatement() {
        return this.statement; 
    }
    public String toString(){
        return super.toString()+ 
        "\n The crimes this person is involved in is " + this.crimes 
        + "\n The relations this person has are " + this.relations
        + "\n the statement this person has to make is " + this.statement;
    }

     
}
