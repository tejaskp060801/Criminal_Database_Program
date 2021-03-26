import java.util.ArrayList;
import java.util.UUID;

public class Criminal extends Person {
    private boolean isInJail; 
    private boolean Deceased; 
    private ArrayList<UUID> crimes; 
    private ArrayList<UUID> family; 
    private ArrayList<UUID> associates; 
    public Criminal(String firstName, String lastName, int age, String gender, String race, UUID id, String address,
    String profession, double height, double weight, String skinCol, String natHairCol, String unNatHairCol,
    String clothing, boolean hasTattoo, String tatDesc, double shoeSize, boolean isUsCitizen,
    String org, boolean isInJail, boolean Deceased, ArrayList<UUID> crimes, ArrayList<UUID> fm, ArrayList<UUID> assoc) {
        super(firstName, lastName, age, gender, race, id, address, profession, height, weight, skinCol, natHairCol, unNatHairCol, clothing, hasTattoo, tatDesc, shoeSize, isUsCitizen, org); 
        this.setisInJail(isInJail); 
        this.setDeceased(Deceased);;
        this.setCrimes(crimes); 
        this.setFamilyMembers(fm); 
        this.setAssociates(assoc);; 
        this.personType = "Criminal";
    }
    public boolean getIsInJail() {
        return isInJail; 
    }
    public boolean getDeceased() {
        return Deceased; 
    }
    public void addFamilyMember(FamilyMember fm) {
        UUID temp = fm.getPersonID();
        family.add(temp);  
    }
    public void addAssociate(Associate assoc) {
        UUID temp = assoc.getPersonID();
        associates.add(temp); 
    }
    public void addCrime(Crime crime) {
        UUID temp = crime.getcasenumber();
        crimes.add(temp);
    }
    public ArrayList<UUID> getCrimes() {
        return crimes; 
    }
    public ArrayList<UUID> getFamily() {
        return family; 
    }
    public ArrayList<UUID> getAssociates() {
        return associates; 
    }
    public void setisInJail(boolean isInJail){
        this.isInJail = isInJail; 
    }
    public void setDeceased(boolean Deceased){
        this.Deceased = Deceased; 
    }
    public void setCrimes(ArrayList<UUID> crimes) {
        this.crimes = crimes; 
    }
    public void setFamilyMembers(ArrayList<UUID> fm) {
        this.family = fm; 
    }
    public void setAssociates(ArrayList<UUID> assoc) {
        this.associates = assoc; 
    }
    public String toString() {
        String crimeStr = "";
        for(UUID c : crimes) {
            crimeStr += "\n" + "\t" + c.toString();
        }

        String assStr = "";
        for(UUID a : assoc) {
            assStr += "\n" + "\t" + a.toString();
        }

        String famStr = "";
        for(UUID f : fm) {
            famStr += "\n" + "\t" + f.toString();
        }

        return super.toString() 
        + "\n Is this person Deceased? " +this.Deceased 
        + "\n The assosciates associated with this criminal are " + assStr
        + "\n The crimes this person has commited are " + crimeStr 
        + "\n The family members associated with this criminal are " + famStr 
        + "\n Is this person in Jail? " + this.isInJail; 
    }
    
}
