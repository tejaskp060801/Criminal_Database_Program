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
        Crime temp = searchCrime(oldCrime);
        if (temp == null) {
            return null;
        } 
        removeCrime(temp);
        addCrime(newCrime);
        return newCrime;
    }

    public Crime searchCrime(Crime crime) {
        return searchCrime(crime.getcasenumber());
    }

    public Crime searchCrime(UUID id) {
        for (int i = 0; i < crimes.size(); i++) {
            if (crimes.get(i).getcasenumber().compareTo(id) == 0) {
                return crimes.get(i);
            }
        }
        System.out.println("Sorry, this crime does not exist");
        return null;
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

