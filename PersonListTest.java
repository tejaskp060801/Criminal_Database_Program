import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import jdk.jfr.Timestamp;

class PersonListTest {
    PersonList p = getPersonList();
    private ArrayList<Person> people = p.getPeople();
    ArrayList<Person> tempList = people;

    @BeforeEach
    public void reset() {
        people = tempList;
    }

    @Test
    public void testAddPersonSuspect() {
        boolean isAdded;
        Person temp = new Suspect("Mike", "Smith", 35, "Male", "Caucasian", null, "123 Main", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        people.addPerson(temp);
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
        boolean isAdded;
        Person temp = new Criminal("Nate", "Samuel", 20, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        p.addPerson(temp);
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
        Person tempWitness = new Witness("Idon't", "Exist", 99, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        isRemoved = p.removePerson(tempWitness);
        assertFalse(isRemoved);
    }

    @Test
    public void testRemovePersonValidOne() {
        boolean isRemoved;
        Person temp = people.get(1);
        isRemoved = p.remove(temp);
        assertTrue(isRemoved);
    }

    @Test
    public void testRemovePersonValidTwo() {
        boolean isRemoved;
        Person temp = people.get(2);
        isRemoved = p.remove(temp);
        assertTrue(isRemoved);
    }

    @Test
    public void testEditPersonInvalidOld() {
        Person old = new Witness("Idon't", "Exist", 99, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        Person newWitness = new Witness("Idon't", "Exist", 100, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        Person ret = p.editPerson(old, newWitness);
        assertEquals(ret, null);
    }    

    @Test
    public void testEditPersonValidOldOne() {
        Person temp = people.get(1);
        Person newPerson = temp;
        newPerson.setFirstName("New first name");
        newPerson.setClothing("Updated clothing");
        Person ret = p.edit(temp, newPerson);
        assertEquals(ret, newPerson);
    }

    @Test
    public void testEditPersonValidOldTwo() {
        Person temp = people.get(2);
        Person newPerson = temp;
        newPerson.setCriminalOrganization("BDK");
        Person ret = p.edit(temp, newPerson);
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
}