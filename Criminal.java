import java.util.ArrayList;
import java.util.UUID;

public class Criminal extends Person {
    private boolean isInJail; 
    private boolean Deceased; 
    private ArrayList<Crime> crimes; 
    private ArrayList<FamilyMember> family; 
    private ArrayList<Associate> associates; 
    public Criminal(String firstName, String lastName, int age, String gender, String race, UUID id, String address,
    String profession, double height, double weight, String skinCol, String natHairCol, String unNatHairCol,
    String clothing, boolean hasTattoo, String tatDesc, double shoeSize, boolean isUsCitizen,
    String org, boolean isInJail, boolean Deceased, ArrayList<Crime> crimes, ArrayList<FamilyMember> fm, ArrayList<Associate> assoc) {
        super(firstName, lastName, age, gender, race, id, address, profession, height, weight, skinCol, natHairCol, unNatHairCol, clothing, hasTattoo, tatDesc, shoeSize, isUsCitizen, org); 
        this.setisInJail(isInJail); 
        this.setDeceased(Deceased);;
        this.setCrimes(crimes); 
        this.setFamilyMembers(fm); 
        this.setAssociates(assoc);; 
        
    }
    public boolean getIsInJail() {
        return isInJail; 
    }
    public boolean getDeceased() {
        return Deceased; 
    }
    public void addFamilyMember(FamilyMember fm) {
        family.add(fm);  
    }
    public void addAssociate(Associate assoc) {
        associates.add(assoc); 
    }
    public void addCrime(Crime crime) {
        crimes.add(crime); 
    }
    public ArrayList<Crime> getCrimes() {
        return crimes; 
    }
    public ArrayList<FamilyMember> getFamily() {
        return family; 
    }
    public ArrayList<Associate> getAssociates() {
        return associates; 
    }
    public void setisInJail(boolean isInJail){
        this.isInJail = isInJail; 
    }
    public void setDeceased(boolean Deceased){
        this.Deceased = Deceased; 
    }
    public void setCrimes(ArrayList<Crime> crimes) {
        this.crimes = crimes; 
    }
    public void setFamilyMembers(ArrayList<FamilyMember> fm) {
        this.family = fm; 
    }
    public void setAssociates(ArrayList<Associate> assoc) {
        this.associates = assoc; 
    }
    public String toString() {
        return super.toString() + this.Deceased + this.associates + this.crimes + this.family + this.isInJail; 
    }
    
}
