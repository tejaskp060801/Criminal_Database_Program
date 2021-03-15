

import java.util.ArrayList;

public class CrimeList {
    private CrimeList crimelist;
    private ArrayList<Crime> crimes;

    private CrimeList() {

    }

    public CrimeList getCrimeList() {
        return crimelist;
    }

    public boolean removeCrime() {
        return true;
    }

    public void addCrime() {

    }

    public void editCrime(Crime crime) {

    }

    public Crime searchCrime() {
        return crimes.get(0);
    }

    public void addEvidence() {

    }
}
