import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Random.*;
import java.util.Random;


public class JSONReaderTest {
    static UserSearchTree usersearchtree = UserSearchTree.getUserSearchTree();
    static PersonList personlistsingleton = PersonList.getPersonList();
    static CrimeList crimelistsingleton = CrimeList.getCrimeList();
    static ArrayList<LawEnforcementUser> policelist = usersearchtree.getEnforcementUsers();
    static ArrayList<Person> personlist = personlistsingleton.clearall();
    static ArrayList<Crime> crimelist = crimelistsingleton.clearall();

    @BeforeAll
    public static void preTestClear() {

    }

    @AfterAll
    public static void postTestClear() {
        personlist.clear();
        crimelist.clear();
        JSONWriter.save();
    }

    @BeforeEach 
    public void initEach() {
        policelist.clear();
        personlist.clear();
        crimelist.clear();
    }

    @AfterEach 
    public void endTests() {
        crimelist.clear();
        personlist.clear();
        JSONWriter.save();
    }


    @Test
    public void testSingleWitnessNormalTraits() {
        personlist.add(new Witness("John", "Dickens", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true));
        JSONWriter.savePeople();
        ArrayList<Person> arraylist = JSONReader.getPeople();
        assertEquals(new Witness("John", "Dickens", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true).toString(), arraylist.get(0).toString());
    }

    @Test
    public void testSingleVictimNormalTraits() {
        personlist.add(new Victim("John", "Dickens", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true));
        JSONWriter.savePeople();
        ArrayList<Person> arraylist = JSONReader.getPeople();
        assertEquals(new Victim("John", "Dickens", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true).toString(), arraylist.get(0).toString());
    }

    @Test
    public void testSingleSuspectNormalTraits() {
        personlist.add(new Suspect("John", "Dickens", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true));
        JSONWriter.savePeople();
        ArrayList<Person> arraylist = JSONReader.getPeople();
        assertEquals(new Suspect("John", "Dickens", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true).toString(), arraylist.get(0).toString());
    }

    @Test
    public void testSingleCriminalNormalTraits() {
        personlist.add(new Criminal("John", "Dickens", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", false, false, new ArrayList<UUID>(), new ArrayList<UUID>(), new ArrayList<UUID>()));
        JSONWriter.savePeople();
        ArrayList<Person> arraylist = JSONReader.getPeople();
        assertEquals(new Criminal("John", "Dickens", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", false, false, new ArrayList<UUID>(), new ArrayList<UUID>(), new ArrayList<UUID>()).toString(), arraylist.get(0).toString());
    }

    @Test
    public void testSingleFamilyMemberNormalTraits() {
        personlist.add(new FamilyMember("John", "Dickens", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003")));
        JSONWriter.savePeople();
        ArrayList<Person> arraylist = JSONReader.getPeople();
        assertEquals(new FamilyMember("John", "Dickens", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003")).toString(), arraylist.get(0).toString());
    }

    @Test
    public void testSingleAssociateNormalTraits() {
        personlist.add(new Associate("John", "Dickens", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003")));
        JSONWriter.savePeople();
        ArrayList<Person> arraylist = JSONReader.getPeople();
        assertEquals(new Associate("John", "Dickens", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003")).toString(), arraylist.get(0).toString());
    }

    @Test
    public void testOrderingOfTwoWitnesses() {
        personlist.add(new Witness("Weston", "Dickens", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true));
        personlist.add(new Witness("John", "Dickens", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true));
        JSONWriter.savePeople();
        ArrayList<Person> arraylist = JSONReader.getPeople();
        assertEquals(personlist.get(1).toString(), arraylist.get(1).toString());
    }

    @Test
    public void testNoPersonData() {
        JSONWriter.savePeople();
        ArrayList<Person> arraylist = JSONReader.getPeople();
        assertEquals(personlist.size(), arraylist.size());
    }

    @Test
    public void testLargePersonData() {
        for (int i = 0; i < 1000; i++) {
            personlist.add(new Witness("Weston", "Dickens", i, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true));
        }
        JSONWriter.savePeople();
        ArrayList<Person> arraylist = JSONReader.getPeople();
        Random r = new Random();
        int randomnum = r.nextInt(1000);
        assertEquals(personlist.get(randomnum).toString(), arraylist.get(randomnum).toString());
    }

    @Test
    public void testExtremelyLargePersonData() {
        for (int i = 0; i < 10000; i++) {
            Witness george = new Witness("Weston", "Dickens", i, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
            personlist.add(george);
        }
        JSONWriter.savePeople();
        ArrayList<Person> arraylist = JSONReader.getPeople();
        Random r = new Random();
        int randomnum = r.nextInt(10000);
        assertEquals(personlist.get(randomnum).toString(), arraylist.get(randomnum).toString());
    }

    @Test
    public void testNormalCrime() {
        Crime crime = new Crime(UUID.fromString("3019f520-9a41-11eb-a8b3-0242ac130003"), "The BeatDown", true, new ArrayList<TypeOfCrime>(), new ArrayList<Person>(), "galaxy", "February 29 2034", new ArrayList<Evidence>(), new ArrayList<LawEnforcementUser>(), "In a galaxy far far away...");
        crimelist.add(crime);
        JSONWriter.saveCrimes();
        ArrayList<Crime> crimes = JSONReader.getCrimes();
        assertEquals(crimelist.get(0).toString(), crimes.get(0).toString());
    }

    @Test
    public void testOrderTwoCrimes() {
        Crime crime = new Crime(UUID.fromString("3019f520-9a41-11eb-a8b3-0242ac130003"), "The BeatDown", true, new ArrayList<TypeOfCrime>(), new ArrayList<Person>(), "galaxy", "February 29 2034", new ArrayList<Evidence>(), new ArrayList<LawEnforcementUser>(), "In a galaxy far far away...");
        Crime crime2 = new Crime(UUID.fromString("3019f520-9a41-11eb-a8b3-0242ac130003"), "The BeatDown", true, new ArrayList<TypeOfCrime>(), new ArrayList<Person>(), "galaxy", "February 29 2034", new ArrayList<Evidence>(), new ArrayList<LawEnforcementUser>(), "In a galaxy far far away...");
        crimelist.add(crime);
        crimelist.add(crime2);
        JSONWriter.saveCrimes();
        ArrayList<Crime> crimes = JSONReader.getCrimes();
        assertEquals(crimelist.get(1).toString(), crimes.get(1).toString());
    }

    @Test
    public void testNoCrimeData() {
        crimelist.clear();
        JSONWriter.saveCrimes();
        ArrayList<Crime> crimes = JSONReader.getCrimes();
        assertEquals(crimelist.size(), crimes.size());
    }

    @Test
    public void testLargeCrimeData() {
        for (int i = 0; i < 1000; i++) {
            Crime crime = new Crime(UUID.fromString("3019f520-9a41-11eb-a8b3-0242ac130003"), "The BeatDown", true, new ArrayList<TypeOfCrime>(), new ArrayList<Person>(), "galaxy", i + "", new ArrayList<Evidence>(), new ArrayList<LawEnforcementUser>(), "In a galaxy far far away...");
            crimelist.add(crime);
        }
        JSONWriter.saveCrimes();
        ArrayList<Crime> crimes = JSONReader.getCrimes();
        Random r = new Random();
        int randomnum = r.nextInt(1000);
        assertEquals(crimelist.get(randomnum).toString(), crimes.get(randomnum).toString());
    }

    @Disabled
    @Test
    public void intentionalFailtoSeeData() {
        assertEquals('a', 'b');
    }
}
