import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;
class CrimeListTest {

    CrimeList crimeList = getCrimeList();
    private ArrayList<Crime> crimes = crimeList.getCrimes();
    ArrayList<Crime> tempList = crimes;

    @BeforeEach
    public void reset(){
        crimes = tempList;
    }

   
   
    
}
