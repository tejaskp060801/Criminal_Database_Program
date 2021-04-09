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

public Crime(UUID id, String title, boolean isSolved, ArrayList<TypeOfCrime> typeOfCrime, ArrayList<Person> people, String location, String date, ArrayList<Evidence> evidence, ArrayList<LawEnforcementUser> workingoncase, String crimedescription) {
    this.setID(id);
    this.setCrimeDescription(crimedescription);
    this.setDate(date);
    this.setEvidence(evidence);
    this.setIsSolved(isSolved);
    this.setLocation(location);
    this.setPeople(people);
    this.setTitle(title);
    this.setTypeOfCrime(typeOfCrime);
    this.setWorkingOnCase(workingoncase);
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

    public void setTitle(String title) {
        this.title = title; 
    }

    public void setPeople(ArrayList <Person> people){
        this.people = people; 
    }

    public void setCrimeDescription(String crimedescription) {
        this.crimedescription = crimedescription; 
    }

    public void setDate(String date) {
        this.date = date; 
    }

    public void setEvidence(ArrayList<Evidence> evidence) {
        this.evidence = evidence; 
    }

    public void setIsSolved(boolean isSolved) {
        this.isSolved = isSolved; 
    }

    public void setLocation(String location) {
        this.location = location; 
    }

    public void setTypeOfCrime(ArrayList<TypeOfCrime> typeOfCrime) {
        this.typeOfCrime = typeOfCrime; 
    }

    public void setWorkingOnCase(ArrayList<LawEnforcementUser> workingoncase) {
        this.workingoncase = workingoncase; 
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

    public String toString() { 
        String tocStr = "";
        for(TypeOfCrime t : typeOfCrime) {
            tocStr += "\n" + "\t" + t.toString();
        }


        String evidenceStr = "";
        for(Evidence e : evidence) {
            evidenceStr += "\n" + "\t" + e.toString();
        }
        
        String peopleStr = "";
        for(Person p : people) {
            peopleStr += "\n" + p.toString();
        }

        String workingOnCaseStr = "";
        for(LawEnforcementUser l : workingoncase) {
            workingOnCaseStr += "\n" + "\t" + l.toString();
        }

        return "\n\n----------------------------------------------\n\n" + "Case Number: " + this.casenumber +"\nTitle "
        + this.title  + "\nSolved or Unsolved: " + this.isSolved +
        "\nPeople Involved:" + peopleStr + " \nType of Crime" + tocStr + " Location\n" +
        this.location + "\nDate: " + this.date + "\nEvidence: " + evidenceStr + 
        "\nLaw Enforcement User Working On Case: " + workingOnCaseStr +
        "\nDescription of Crime: " + this.crimedescription + "\n\n----------------------------------------------\n\n"; 
    }

    public UUID getcasenumber() {
        return this.casenumber;
    }
}