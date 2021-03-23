import java.util.ArrayList;
import java.util.UUID;

public class Crime {
    protected UUID casenumber; 
    protected String title; 
    protected boolean isSolved; 
    protected ArrayList<Person> people; //array
    protected ArrayList<TypeOfCrime> typeofcrime;  //array
    protected String location; 
    protected String date;
    protected ArrayList<Evidence> evidence; //array
    protected ArrayList<LawEnforcementUser> workingoncase; //array
    protected String crimedescription; 

    public Crime() {
        this.casenumber = null; 
        this.title = null; 
        this.people = null; 
        this.crimedescription = null; 
        this.date = null; 
        this.evidence = null; 
        this.isSolved = false; 
        this.location = null; 
        this.typeofcrime = null; 
        this.workingoncase = null; 
    }
    
    public Crime(UUID casenumber, String title, ArrayList<Person> people,
                    ArrayList<TypeOfCrime> typeofcrime, String location,
                    String date, ArrayList<Evidence> evidence, ArrayList<LawEnforcementUser> workingoncase,
                    String crimedescription) 
    {
        this.casenumber = casenumber;
        this.title = title;
        this.people = people;
        this.typeofcrime = typeofcrime;
        this.location = location;
        this.date = date;
        this.evidence = evidence;
        this.workingoncase = workingoncase;
        this.crimedescription = crimedescription;
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
        return People; 

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
