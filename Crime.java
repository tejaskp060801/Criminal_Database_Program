import java.util.ArrayList;
import java.util.UUID;

public class Crime {
    protected UUID casenumber; 
    protected String title; 
    protected boolean isSolved; 
    protected ArrayList<Person> people; 
    protected ArrayList<TypeOfCrime> typeOfCrime;  
    protected String location; 
    protected String date;
    protected ArrayList<Evidence> evidence; 
    protected ArrayList<LawEnforcementUser> workingoncase; 
    protected String crimedescription; 

public Crime(UUID id, String title, boolean isSolved, ArrayList<TypeOfCrime> felonyType, ArrayList<Person> people, String location, String date, ArrayList<Evidence> evidenceList, ArrayList<LawEnforcementUser> officers, String description) {
    this.setID(id);
    this.title = title; 
    this.people = people; 
    this.crimedescription = description; 
    this.date = date; 
    this.evidence = evidenceList;
    this.isSolved = isSolved; 
    this.location = location; 
    this.typeOfCrime = felonyType; 
    this.workingoncase = officers; 
    }
    
    //im not sure if this method is needed bc you remove the crime through the CrimeList class
    //like in the Person class there is no removePerson; you can only remove through PersonList
    //there is already a deleteCrime method in CrimeList
    public void removeCrime(Crime crime) {

    }

    public void setID(UUID id) {
        if (id == null) {
            casenumber = UUID.randomUUID();
        } else {
            casenumber = id;
        }
    }
   
    public boolean isSolved() {
        return this.isSolved;
    }

    public String getTitle() {
        return this.title; 
    }

    public String getLocation() {
        return this.location;
    }

    public ArrayList<Person> getPOIArray() {
         ArrayList<Person> people = new ArrayList<Person>();
        return people; 

    }

    public static ArrayList<Criminal> getCriminalArray() {
         ArrayList<Criminal> criminalswoo = new ArrayList<Criminal>();
         return criminalswoo;
    }

    public ArrayList<LawEnforcementUser> getWorkingOnCaseArrayList() {
        return this.workingoncase;
    }

    public ArrayList<Person> getPeople() {
        return this.people;
    }

    public ArrayList<Evidence> getEvidence() {
        return this.evidence;
    }

    public String getCrimeDescription() {
        return this.crimedescription; 
    }

    public String getDate() {
        return this.date; 
    }

    public ArrayList<TypeOfCrime> getTypeOfCrime() {
        return this.typeOfCrime; 
    }

    //i dont these two are neccessary because the person class doesnt have one like this either
    //sort of confused with what information

    public void addInformation() {  

       
    }

    public void editInformation(){ 
        
    }

    public String toString() { 
        return "\n----------\n" + "Case Number: " + this.casenumber +"\nTitle "
        + this.title  + "\nSolved or Unsolved: " + this.isSolved +
        "\nPeople" + this.people + " \nType of Crime" + this.typeOfCrime+ " Location\n" +
        this.location + "\nDate: " + this.date + "\nEvidence: " + this.evidence + 
        "\nLaw Enforcement User Working On Case: " + this.workingoncase +
        "\nDescription of Crime: " + this.crimedescription + "\n----------\n"; 
    }

    public UUID getcasenumber() {
        return this.casenumber;
    }
}