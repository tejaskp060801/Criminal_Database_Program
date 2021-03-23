

import java.util.ArrayList;

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

    public boolean removeCrime(Crime crime ) {
        return crimelist.removeCrime(crime);
    }

    public Object addCrime(Crime crime) {
        return crimelist.addCrime(crime);
    }


    public void editCrime(Crime old, Crime newCrime) {

    }

    public Crime searchCrime(UUID id) {
        return crimes.get(0);
    }

    public Crime searchCrime(ArrayList<String> parameterChoices, ArrayList<Object> searchParameters) {
        return Crime;
    }

    public void addEvidence() {

    }
}
