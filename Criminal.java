import java.util.ArrayList;

public class Criminal extends Person {
    private boolean isInJail; 
    private boolean Deceased; 
    private ArrayList<Crime> crimes; 
    private ArrayList<FamilyMember> family; 
    private ArrayList<Associate> associates; 
    @Override
    public void addToDataBase(Person p) {
        
    }
    public Criminal() {
        super(); 
        this.isInJail = isInJail; 
        this.Deceased = Deceased; 
        this.crimes = crimes; 
        this.family = family; 
        this.associates = associates; 
        
    }
    public void addFamilyMember(FamilyMember fm) {
        
    }
    public void addAssociate(Associate assoc) {
        
    }
    public void addCrime(Crime crime) {
        
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
    public String toString() {
        return ""; 
    }
    
}
