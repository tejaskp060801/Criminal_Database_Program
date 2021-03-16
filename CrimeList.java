

import java.util.ArrayList;

public class CrimeList {
    private CrimeList crimelist;
    private ArrayList<Crime> crimes;

    private CrimeList(Object crimes) {
        crimes = Crime.getCriminalArray();
    }

    public CrimeList getCrimeList() {
        return this.crimelist;
    }

    public boolean removeCrime(Crime crime ) {
        return crimelist.removeCrime(crime);
    }

    public Object addCrime(Crime crime) {
        return crimelist.addCrime(crime);
    }


    public void editCrime(Crime crime) {

    }

    public Crime searchCrime() {
        return crimes.get(0);
    }

    public void addEvidence() {

    }
}
