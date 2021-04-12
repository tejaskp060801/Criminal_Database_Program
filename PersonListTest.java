import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;

//import jdk.jfr.Timestamp;

class PersonListTest {
    PersonList p = PersonList.getPersonList();
    private ArrayList<Person> people = p.getPeople();
    ArrayList<Person> tempList = people;

    @BeforeEach
    public void reset() {
        people = tempList;
    }

    @Test
    public void testAddPersonSuspect() {
        boolean isAdded = false;
        Person temp = new Suspect("Mike", "Smith", 35, "Male", "Caucasian", null, "123 Main", null, 10.2, 213.2, null, null, null, null, true, null, 10.5, true, null, null, null, null, true);
        people.add(temp);
        for(int i=0; i<people.size(); i++) {
            if(people.get(i) == temp) {
                isAdded = true;
                break;
            }
        }  
        assertTrue(isAdded);
    }

    @Test
    public void testAddPersonCriminal() {
        boolean isAdded = false;
        Person temp = new Criminal("Nate", "Samuel", 20, null, null, null, null, null, 6.0, 250.0, null, null, null, null, false, null, 9.5, true, null, true, false, null, null, null);
        people.add(temp);
        for(int i=0; i<people.size(); i++) {
            if(people.get(i) == temp) {
                isAdded = true;
                break;
            }
        }
        assertTrue(isAdded);
    }

    @Test
    public void testRemovePersonInvalid() {
        boolean isRemoved;
        Person tempWitness = new Witness("Idon't", "Exist", 99, null, null, null, null, null, 6.2, 167.8, null, null, null, null, true, null, 10.0, true, null, null, null, null, true);
        isRemoved = p.removePerson(tempWitness);
        assertFalse(isRemoved);
    }

    @Test
    public void testRemovePersonValidOne() {
        boolean isRemoved;
        Person temp = people.get(1);
        isRemoved = p.removePerson(temp);
        assertTrue(isRemoved);
    }

    @Test
    public void testRemovePersonValidTwo() {
        boolean isRemoved;
        Person temp = people.get(2);
        isRemoved = p.removePerson(temp);
        assertTrue(isRemoved);
    }

    @Test
    public void testEditPersonInvalidOld() {
        Person old = new Witness("Idon't", "Exist", 99, null, null, null, null, null, 5.5, 120.0, null, null, null, null, true, null, 9.0, true, null, null, null, null, false);
        Person newWitness = new Witness("Idon't", "Exist", 100, null, null, null, null, null, 5.6, 125.0, null, null, null, null, true, null, 9.0, true, null, null, null, null, true);
        Person ret = p.editPerson(old, newWitness);
        assertEquals(ret, null);
    }    

    @Test
    public void testEditPersonValidOldOne() {
        Person temp = people.get(1);
        Person newPerson = temp;
        newPerson.setFirstName("New first name");
        newPerson.setClothing("Updated clothing");
        Person ret = p.editPerson(temp, newPerson);
        assertEquals(ret, newPerson);
    }

    @Test
    public void testEditPersonValidOldTwo() {
        Person temp = people.get(2);
        Person newPerson = temp;
        newPerson.setCriminalOrganization("GDK");
        Person ret = p.editPerson(temp, newPerson);
        assertEquals(ret, newPerson);
    }

    @Test
    public void testSearchPersonByIDInvalid() {
        UUID id = UUID.randomUUID();
        Person ret = p.searchPerson(id);
        assertEquals(ret, null);
    }

    @Test
    public void testSearchPersonByIDValid() {
        Person temp = people.get(1);
        UUID id = temp.getPersonID();
        Person ret = p.searchPerson(id);
        assertEquals(ret, temp);
    }
    
    //TODO tests for seachPerson(parameterChoices, searchParameters)
    //one parameter valid
    @Test
    public void testSearchPersonByParamsOneValid() {
        ArrayList<String> paramChoices = new ArrayList<>();
        ArrayList<String> searchParams = new ArrayList<>();
        ArrayList<Person> persons= new ArrayList<>();
        Person temp = people.get(1);
        persons.add(temp);
        String fName = temp.getFirstName();
        paramChoices.add("1");
        searchParams.add(fName);
        ArrayList <Person> ret = p.searchPerson(paramChoices, searchParams);
        assertEquals(persons, ret);
    }

    //one parameter invalid (no search result)
    @Test
    public void testSearchPersonByParamsOneNoSearchResult() {
        ArrayList<String> paramChoices = new ArrayList<>();
        ArrayList<String> searchParams = new ArrayList<>();
        ArrayList<Person> persons= new ArrayList<>();
        String age = "465";
        paramChoices.add("3");
        searchParams.add(age);
        ArrayList <Person> ret = p.searchPerson(paramChoices, searchParams);
        assertEquals(persons, ret);
    }
    
    //two parameters valid
    @Test
    public void testSearchPersonByParamsTwoParamsValid() {
        ArrayList<String> paramChoices = new ArrayList<>();
        ArrayList<String> searchParams = new ArrayList<>();
        ArrayList<Person> persons= new ArrayList<>();
        Person temp = people.get(2);
        persons.add(temp);
        String gender = temp.getGender();
        String skinColor = temp.getSkinColor();
        paramChoices.add("4");
        searchParams.add(gender);
        paramChoices.add("11");
        searchParams.add(skinColor);
        ArrayList <Person> ret = p.searchPerson(paramChoices, searchParams);
        assertEquals(persons, ret);
    }

    //two parameters one valid one invalid
    @Test
    public void testSearchPersonByParamsOneValidOneInvalidParam() {
        ArrayList<String> paramChoices = new ArrayList<>();
        ArrayList<String> searchParams = new ArrayList<>();
        ArrayList<Person> persons= new ArrayList<>();
        Person temp = people.get(3);
        String weight = temp.getWeight() + "";
        String lName = "Not real last name";
        paramChoices.add("10");
        searchParams.add(weight);
        paramChoices.add("2");
        searchParams.add(lName);
        ArrayList <Person> ret = p.searchPerson(paramChoices, searchParams);
        assertEquals(persons, ret);
    }

    //two parameters both invalid
    @Test
    public void testSearchPersonByParamsTwoInvalid() {
        ArrayList<String> paramChoices = new ArrayList<>();
        ArrayList<String> searchParams = new ArrayList<>();
        ArrayList<Person> persons= new ArrayList<>();
        String hairColorNat = "infared";
        String lName = "Not real last name";
        paramChoices.add("12");
        searchParams.add(hairColorNat);
        paramChoices.add("2");
        searchParams.add(lName);
        ArrayList <Person> ret = p.searchPerson(paramChoices, searchParams);
        assertEquals(persons, ret);
    }

    //no parameters
    @Test
    public void testSearchPersonByParamsNoParams() {
        ArrayList<String> paramChoices = new ArrayList<>();
        ArrayList<String> searchParams = new ArrayList<>();
        ArrayList<Person> persons= new ArrayList<>();
        ArrayList<Person> ret = p.searchPerson(paramChoices, searchParams);
        assertEquals(persons, ret);
    }

    //would be valid but search param does not correspond with paramchocies
    @Test
    public void testSearchPersonByParamsSParAndParChoicesDoNotMatch() {
        ArrayList<String> paramChoices = new ArrayList<>();
        ArrayList<String> searchParams = new ArrayList<>();
        ArrayList<Person> persons= new ArrayList<>();
        Person temp = people.get(2);
        String shoeSize = temp.getShoeSize() + "";
        paramChoices.add("1");
        searchParams.add(shoeSize);
        ArrayList<Person> ret = p.searchPerson(paramChoices, searchParams);
        assertEquals(persons, ret);
    }    
     
}