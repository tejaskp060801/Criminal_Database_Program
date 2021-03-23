import java.util.ArrayList;
import java.util.UUID;

public class Crime {
    protected UUID casenumber; 
    protected String title; 
    protected boolean isSolved; 
    protected ArrayList<Person> people; //array
    protected ArrayList<TypeOfCrime> typeOfCrime;  //array
    protected String location; 
    protected String date;
    protected ArrayList<Evidence> evidence; //array
    protected ArrayList<LawEnforcementUser> workingoncase; //array
    protected String crimedescription; 

    public Crime(String title, boolean isSolved, ArrayList<TypeOfFelony> felonyType, ArrayList<Person> people, String location, String date, ArrayList<Evidence> evidenceList, ArrayList<String> officers, String description) {
        casenumber = UUID.randomUUID(); 
        this.title = title; 
        this.people = people; 
        this.crimeDescription = description; 
        this.date = date; 
        this.evidence = evidence; 
        this.isSolved = isSolved; 
        this.location = location; 
        this.typeOfCrime = typeOfCrime; 
        this.workingOnCase = officers; 
    }
    

    public void deleteCrime(Crime crime) {
        
    }
    public void crimeSolved() {
        
    }
    public String getTitle(String title) {
        return title; 
    }
    public ArrayList<Person> getPOIArray() {
         ArrayList<Person> people = new ArrayList<Person>();
        return people; 

    }
    public static ArrayList<Criminal> getCriminalArray() {
         ArrayList<Criminal> criminalswoo = new ArrayList<Criminal>();
         return criminalswoo;
    }
    public ArrayList<UUID> getWorkingOnCaseArrayList() {
        ArrayList<UUID> workingOnCase= new ArrayList<UUID>();
        return workingOnCase; 
    }
    public String getCrimeDescription() {
        return crimeDescription; 
    }
    public String getDate() {
        return date; 
    }
    public ArrayList<TypeOfCrime> getTypeOfCrime() {
        ArrayList<TypeOfCrime> typeOfCrimes = new ArrayList<TypeOfCrime>();
        return typeOfCrime; 
    }
    /* do these bottom methods mean add information into like which specific attribute
    *
    *
    */
    public void addInformation() { //i dont understand this method 

    }
    public void editInformation(){ //i dont understand this one either
        
    }
    public String toString() { //this one
        return "\n----------\n" + "Case Number: " + this.caseNumber +"\nTitle "
        + this.title  + "\nSolved or Unsolved: " + this.isSolved +
        "\nPeople" + this.People + " \nType of Crime" + this.typeOfCrime+ " Location\n" +
        this.location + "\nDate: " + this.date + "\nEvidence: " + this.evidence + 
        "\nLaw Enforcement User Working On Case: " + this.workingOnCase +
        "\nDescription of Crime: " + this.crimeDescription + "\n----------\n"; 
    }

    public UUID getcasenumber() {
        return this.casenumber;
    }
}
