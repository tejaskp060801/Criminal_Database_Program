import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;

class CrimeListTest{
    CrimeList crime = CrimeList.getCrimeList();
    private ArrayList<Crime> crimes = crime.getCrimes();
    ArrayList<Crime> tempList = crimes;

    @BeforeEach
    public void reset(){
        crimes = tempList;
    }

    @Test
    public void testAddHairSample(){
        boolean isAdded;
        HairSample temp = new HairSample(null, null, null, null, 10, 10); //this is wrong
        crimes.add(temp);
        for(int i=0; i< crimes.size(); i++) {
            if(crimes.get(i) == temp) {
                isAdded = true;
                break;
            }
        }
        assertTrue(isAdded);

    }

    @Test
    public void testAddBloodSample(){
        boolean isAdded;
        Crime temp = new BloodSample(); //this is wrong
        crimes.add(temp);
        for(int i=0; i< crimes.size(); i++) {
            if(crimes.get(i) == temp) {
                isAdded = true;
                break;
            }
        }
        assertTrue(isAdded);
    }

    @Test
    public void testRemoveCrimeInvalid(){
        boolean isRemoved;
        Crime tempCrime = new Crime(null, "a crime has occurred", false, new ArrayList<TypeOfCrime>(), new ArrayList<Person>(), "Blossom and 21", "February 30 2020", new ArrayList<Evidence>(), new ArrayList<LawEnforcementUser>(), "A crime occurred at a time and place!");
        isRemoved = crime.removeCrime(tempCrime);
        assertFalse(isRemoved);
    }

    @Test
    public void testRemoveCrimeValidOne(){
        boolean isRemoved;
        Crime temp = crimes.get(1);
        isRemoved = crime.removeCrime(temp);
        assertTrue(isRemoved);
    }

    @Test 
    public void testRemoveCrimeValidTwo(){
        boolean isRemoved;
        Crime temp = crimes.get(2);
        isRemoved = crime.removeCrime(temp);
        assertTrue(isRemoved);
    }

    @Test
    public void testEditCrimeInvalidOld() {
        Crime old = new Crime(null, "a crime has occurred", false, new ArrayList<TypeOfCrime>(), new ArrayList<Person>(), "Blossom and 21", "February 30 2020", new ArrayList<Evidence>(), new ArrayList<LawEnforcementUser>(), "A crime occurred at a time and place!");
        Crime newCrime = new Crime(null, "a crime has occurred", false, new ArrayList<TypeOfCrime>(), new ArrayList<Person>(), "Blossom and 21", "February 30 2020", new ArrayList<Evidence>(), new ArrayList<LawEnforcementUser>(), "A crime occurred at a time and place!");
        Crime ret = crime.editCrime(old, newCrime);
        assertEquals(ret, null);
    }

    @Test
    public void testEditCrimeValidOldOne() {
        Crime temp = crimes.get(1);
        Crime newCrime = temp;
        newCrime.setTitle("New Title");
        newCrime.setLocation("Updated Location");
        Crime ret = crime.editCrime(temp, newCrime);
        assertEquals(ret, newCrime);
    }

    @Test
    public void testEditCrimeValidOldTwo() {
        Crime temp = crimes.get(2);
        Crime newCrime = temp;
        newCrime.setCrimeDescription("Bleh");
        Crime ret = crime.editCrime(temp, newCrime);
        assertEquals(ret, newCrime);
    }

    @Test
    public void testSearchCrimeByIDInvalid() {
        UUID id = UUID.randomUUID();
        Crime ret = crime.searchCrime(id);
        assertEquals(ret, null);
    }

    @Test
    public void testSearchCrimeByIDValid() {
        Crime temp = crimes.get(1);
        UUID id = temp.getcasenumber();
        Crime ret = crime.searchCrime(id);
        assertEquals(ret, temp);
    }
    
    //TODO tests for seachPerson(parameterChoices, searchParameters)
    //one parameter valid
    @Test
    public void testSearchCrimeByParamsOneValid() {
        ArrayList<String> paramChoices = new ArrayList<>();
        ArrayList<String> searchParams = new ArrayList<>();
        ArrayList<Crime> crimes= new ArrayList<>();
        Crime temp = crimes.get(1);
        crimes.add(temp);
        String Title = temp.getTitle();
        paramChoices.add("1");
        searchParams.add(Title);
        ArrayList <Crime> ret = crime.searchCrime(paramChoices, searchParams);
        assertEquals(crimes, ret);
    }

    //one parameter invalid (no search result)
    @Test
    public void testSearchCrimeByParamsOneNoSearchResult() {
        ArrayList<String> paramChoices = new ArrayList<>();
        ArrayList<String> searchParams = new ArrayList<>();
        ArrayList<Crime> crimes = new ArrayList<>();
        String date = "";
        paramChoices.add("3");
        searchParams.add(date);
        ArrayList <Crime> ret = crime.searchCrime(paramChoices, searchParams);
        assertEquals(crimes, ret);
    }

     //two parameters valid
     @Test
     public void testSearchCrimeByParamsTwoParamsValid() {
         ArrayList<String> paramChoices = new ArrayList<>();
         ArrayList<String> searchParams = new ArrayList<>();
         ArrayList<Crime> crimes= new ArrayList<>();
         Crime temp = crimes.get(3);
         crimes.add(temp);
         String id = temp.getcasenumber().toString();
         String title = temp.getTitle();
         paramChoices.add("1");
         searchParams.add(id);
         paramChoices.add("2");
         searchParams.add(title);
         ArrayList <Crime> ret = crime.searchCrime(paramChoices, searchParams);
         assertEquals(crimes, ret);
     }
 
     //two parameters one valid one invalid
     @Test
     public void testSearchCrimeByParamsOneValidOneInvalidParam() {
         ArrayList<String> paramChoices = new ArrayList<>();
         ArrayList<String> searchParams = new ArrayList<>();
         ArrayList<Crime> crimes = new ArrayList<>();
         Crime temp = crimes.get(3);
         String weight = temp.getWeight() + "";
         String lName = "Not real last name";
         paramChoices.add("10");
         searchParams.add(weight);
         paramChoices.add("2");
         searchParams.add(lName);
         ArrayList<Crime> ret = crimes.searchCrime(paramChoices, searchParams);
         assertEquals(crimes, ret);
     }
 
     //two parameters both invalid
     @Test
     public void testSearchPersonByParamsTwoInvalid() {
         ArrayList<String> paramChoices = new ArrayList<>();
         ArrayList<String> searchParams = new ArrayList<>();
         ArrayList<Crime> crimes = new ArrayList<>();
         String hairColorNat = "infared"; //this
         String lName = "Not real last name"; //this
         paramChoices.add("12"); //this
         searchParams.add(hairColorNat); //this
         paramChoices.add("2"); //this 
         searchParams.add(lName); //this
         ArrayList <Crime> ret = crime.searchCrime(paramChoices, searchParams);
         assertEquals(crimes, ret);
     }
 
     //no parameters
     @Test
     public void testSearchCrimeByParamsNoParams() {
         ArrayList<String> paramChoices = new ArrayList<>();
         ArrayList<String> searchParams = new ArrayList<>();
         ArrayList<Crime> ret = crime.searchCrime(paramChoices, searchParams);
         assertEquals(crimes, ret);
     }
 
     //would be valid but search param does not correspond with paramchocies
     @Test
     public void testSearchCrimeByParamsSParAndParChoicesDoNotMatch() {
         ArrayList<String> paramChoices = new ArrayList<>();
         ArrayList<String> searchParams = new ArrayList<>();
         ArrayList<Crime> crimes = new ArrayList<>();
         Crime temp = crimes.get(2);
         String shoeSize = temp.getShoeSize() + ""; //this
         paramChoices.add("1");
         searchParams.add(shoeSize); //this
         ArrayList<Crime> ret = crime.searchCrime(paramChoices, searchParams);
         assertEquals(crimes, ret);
     }


}

    