import java.util.ArrayList;
import java.util.UUID;
import java.util.Iterator;

public class CrimeList {
    private static CrimeList crimelist;
    private ArrayList<Crime> crimes;

    private CrimeList() {
        crimes = JSONReader.getCrimes();
    }

    public static CrimeList getCrimeList() {
        if (crimelist == null) {
            crimelist = new CrimeList();
        }
        
        return crimelist;
    }

    public void addCrime(Crime crime) {
        crimelist.addCrime(crime);
    }

    public boolean removeCrime(Crime crime ) {
        for(int i =0; i < crimes.size(); i++){
            if(crimes.get(i) == crime){
                crimes.remove(i);
                return true;
            }
        }
        return false;
    }


    public Crime editCrime(Crime oldCrime, Crime newCrime) {
        searchCrime(oldCrime);
        return crime;
    }

    public Crime searchCrime(Crime crime) {
        boolean found = false;
        for(int i = 0; i<crimes.size(); i++) {
            if(crimes.get(i).getcasenumber() == crime.getcasenumber()) {
                found = true;  
            }
        }
        if (found == false){
            System.out.println("Sorry, this crime does not exist");
        }
        return crime;
    }

    public Crime searchCrime(UUID id) {
        return crimes.get(0);
    }

    public Crime searchCrime(ArrayList<String> parameterChoices, ArrayList<Object> searchParameters) {
        return Crime;
    }

    public void addEvidence() {

    }
    public void getInformation(Crime crimes){
        crimes.toString();
    }

    public ArrayList<Crime> getCrimes() {
        return this.crimes;
    }
}

