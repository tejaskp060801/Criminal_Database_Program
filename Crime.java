import java.util.ArrayList;
import java.util.UUID;

public class Crime {
    protected UUID caseNumber; 
    protected String title; 
    protected boolean isSolved; 
    protected ArrayList<Person> People; 
    protected ArrayList<TypeOfCrime> typeOfCrime; 
    protected String location; 
    protected String date;
    protected ArrayList<Evidence> evidence; 
    protected ArrayList<LawEnforcementUser> workingOnCase; 
    protected String crimeDescription; 

    public Crime() {
        this.caseNumber = caseNumber; 
        this.title = title; 
        this.People = People; 
        this.crimeDescription = crimeDescription; 
        this.date = date; 
        this.evidence = evidence; 
        this.isSolved = isSolved; 
        this.location = location; 
        this.typeOfCrime = typeOfCrime; 
        this.workingOnCase = workingOnCase; 
    }
    
    public void deleteCrime() {

    }
    public void crimeSolved() {
        
    }
    public String getTitle() {
        return title; 
    }
    public ArrayList<Person> getPOIArray() {
        return People; 
    }
    public ArrayList<Criminal> getCriminalArray() {
         return 
    }
    public ArrayList<UUID> getWorkingOnCaseArrayList() {
        return workingOnCase; 
    }
    public String getCrimeDescription() {
        return crimeDescription; 
    }
    public String getDate() {
        return date; 
    }
    public ArrayList<TypeOfCrime> getTypeOfCrime() {
        return typeOfCrime; 
    }
    public void addInformation() {

    }
    public void editInformation(){
        
    }
    public String toString() {
        return ""; 
    }
}
