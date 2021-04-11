import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Random;


public class JSONWriterTest {
    UserSearchTree usersearchtree = UserSearchTree.getUserSearchTree();
    PersonList personlistsingleton = PersonList.getPersonList();
    CrimeList crimelistsingleton = CrimeList.getCrimeList();
    ArrayList<LawEnforcementUser> policelist = usersearchtree.getEnforcementUsers();
    ArrayList<Person> personlist = personlistsingleton.clearall();
    ArrayList<Crime> crimelist = crimelistsingleton.clearall();

    @Before 
    public void preTestClear() {

    }

    @After
    public void postTestClear() {
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
        policelist.clear();
        personlist.clear();
        crimelist.clear();
        JSONWriter.save();
    }

    @RepeatedTest(6)
    public void testNullNamesPerson(RepetitionInfo repetitioninfo) {
        Witness witness = new Witness(null, null, 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Victim victim = new Victim(null, null, 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Suspect suspect = new Suspect(null, null, 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Criminal criminal = new Criminal(null, null, 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", false, false, new ArrayList<UUID>(), new ArrayList<UUID>(), new ArrayList<UUID>());
        FamilyMember familymember = new FamilyMember(null, null, 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        Associate associate = new Associate(null, null, 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        personlist.add(witness);
        personlist.add(victim);
        personlist.add(suspect);
        personlist.add(criminal);
        personlist.add(familymember);
        personlist.add(associate);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        int curr = repetitioninfo.getCurrentRepetition() - 1;
        assertEquals(people.get(curr).toString(), personlist.get(curr).toString());
    }

    @RepeatedTest(6)
    public void testNullGenderPerson(RepetitionInfo repetitioninfo) {
        Witness witness = new Witness("John", "Clark", 23, null, "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Victim victim = new Victim("John", "Clark", 23, null, "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Suspect suspect = new Suspect("John", "Clark", 23, null, "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Criminal criminal = new Criminal("John", "Clark", 23, null, "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", false, false, new ArrayList<UUID>(), new ArrayList<UUID>(), new ArrayList<UUID>());
        FamilyMember familymember = new FamilyMember("John", "Clark", 23, null, "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        Associate associate = new Associate("John", "Clark", 23, null, "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        personlist.add(witness);
        personlist.add(victim);
        personlist.add(suspect);
        personlist.add(criminal);
        personlist.add(familymember);
        personlist.add(associate);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        int curr = repetitioninfo.getCurrentRepetition() - 1;
        assertEquals(people.get(curr).toString(), personlist.get(curr).toString());
    }

    @RepeatedTest(6)
    public void testNullRacePerson(RepetitionInfo repetitioninfo) {
        Witness witness = new Witness("John", "Clark", 23, "male", null, UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Victim victim = new Victim("John", "Clark", 23, "male", null, UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Suspect suspect = new Suspect("John", "Clark", 23, "male", null, UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Criminal criminal = new Criminal("John", "Clark", 23, "male", null, UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", false, false, new ArrayList<UUID>(), new ArrayList<UUID>(), new ArrayList<UUID>());
        FamilyMember familymember = new FamilyMember("John", "Clark", 23, null, "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        Associate associate = new Associate("John", "Clark", 23, "male", null, UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        personlist.add(witness);
        personlist.add(victim);
        personlist.add(suspect);
        personlist.add(criminal);
        personlist.add(familymember);
        personlist.add(associate);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        int curr = repetitioninfo.getCurrentRepetition() - 1;
        assertEquals(people.get(curr).toString(), personlist.get(curr).toString());
    }

    @RepeatedTest(6)
    public void testNullUUIDPerson(RepetitionInfo repetitioninfo) {
        Witness witness = new Witness("John", "Clark", 23, "male", "white", null, "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Victim victim = new Victim("John", "Clark", 23, "male", "white", null, "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Suspect suspect = new Suspect("John", "Clark", 23, "male", "white", null, "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Criminal criminal = new Criminal("John", "Clark", 23, "male", "white", null, "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", false, false, new ArrayList<UUID>(), new ArrayList<UUID>(), new ArrayList<UUID>());
        FamilyMember familymember = new FamilyMember("John", "Clark", 23, "male", "white", null, "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        Associate associate = new Associate("John", "Clark", 23, "male", "white", null, "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        personlist.add(witness);
        personlist.add(victim);
        personlist.add(suspect);
        personlist.add(criminal);
        personlist.add(familymember);
        personlist.add(associate);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        int curr = repetitioninfo.getCurrentRepetition() - 1;
        assertEquals(people.get(curr).toString(), personlist.get(curr).toString());
    }

    @RepeatedTest(6)
    public void testNullAddress(RepetitionInfo repetitioninfo) {
        Witness witness = new Witness("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), null, "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Victim victim = new Victim("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), null, "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Suspect suspect = new Suspect("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), null, "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Criminal criminal = new Criminal("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), null, "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", false, false, new ArrayList<UUID>(), new ArrayList<UUID>(), new ArrayList<UUID>());
        FamilyMember familymember = new FamilyMember("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), null, "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        Associate associate = new Associate("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), null, "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        personlist.add(witness);
        personlist.add(victim);
        personlist.add(suspect);
        personlist.add(criminal);
        personlist.add(familymember);
        personlist.add(associate);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        int curr = repetitioninfo.getCurrentRepetition() - 1;
        assertEquals(people.get(curr).toString(), personlist.get(curr).toString());
    }

    @RepeatedTest(6)
    public void testNullProfessionPerson(RepetitionInfo repetitioninfo) {
        Witness witness = new Witness("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", null, 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Victim victim = new Victim("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", null, 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Suspect suspect = new Suspect("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", null, 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Criminal criminal = new Criminal("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", null, 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", false, false, new ArrayList<UUID>(), new ArrayList<UUID>(), new ArrayList<UUID>());
        FamilyMember familymember = new FamilyMember("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", null, 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        Associate associate = new Associate("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", null, 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        personlist.add(witness);
        personlist.add(victim);
        personlist.add(suspect);
        personlist.add(criminal);
        personlist.add(familymember);
        personlist.add(associate);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        int curr = repetitioninfo.getCurrentRepetition() - 1;
        assertEquals(people.get(curr).toString(), personlist.get(curr).toString());
    }

    @RepeatedTest(6)
    public void testNullSkinColorPerson(RepetitionInfo repetitioninfo) {
        Witness witness = new Witness("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, null, "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Victim victim = new Victim("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, null, "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Suspect suspect = new Suspect("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, null, "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Criminal criminal = new Criminal("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, null, "blonde", "black", "jorts", true, "spider", 12, true, "none", false, false, new ArrayList<UUID>(), new ArrayList<UUID>(), new ArrayList<UUID>());
        FamilyMember familymember = new FamilyMember("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, null, "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        Associate associate = new Associate("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, null, "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        personlist.add(witness);
        personlist.add(victim);
        personlist.add(suspect);
        personlist.add(criminal);
        personlist.add(familymember);
        personlist.add(associate);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        int curr = repetitioninfo.getCurrentRepetition() - 1;
        assertEquals(people.get(curr).toString(), personlist.get(curr).toString());
    }

    @RepeatedTest(6)
    public void testNullHairColorNaturalPerson(RepetitionInfo repetitioninfo) {
        Witness witness = new Witness("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", null, "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Victim victim = new Victim("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", null, "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Suspect suspect = new Suspect("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", null, "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Criminal criminal = new Criminal("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", null, "black", "jorts", true, "spider", 12, true, "none", false, false, new ArrayList<UUID>(), new ArrayList<UUID>(), new ArrayList<UUID>());
        FamilyMember familymember = new FamilyMember("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", null, "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        Associate associate = new Associate("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", null, "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        personlist.add(witness);
        personlist.add(victim);
        personlist.add(suspect);
        personlist.add(criminal);
        personlist.add(familymember);
        personlist.add(associate);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        int curr = repetitioninfo.getCurrentRepetition() - 1;
        assertEquals(people.get(curr).toString(), personlist.get(curr).toString());
    }

    @RepeatedTest(6)
    public void testNullHairColorUnnaturalPerson(RepetitionInfo repetitioninfo) {
        Witness witness = new Witness("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", null, "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Victim victim = new Victim("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", null, "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Suspect suspect = new Suspect("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", null, "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Criminal criminal = new Criminal("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", null, "jorts", true, "spider", 12, true, "none", false, false, new ArrayList<UUID>(), new ArrayList<UUID>(), new ArrayList<UUID>());
        FamilyMember familymember = new FamilyMember("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", null, "black", "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        Associate associate = new Associate("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", null, "jorts", true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        personlist.add(witness);
        personlist.add(victim);
        personlist.add(suspect);
        personlist.add(criminal);
        personlist.add(familymember);
        personlist.add(associate);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        int curr = repetitioninfo.getCurrentRepetition() - 1;
        assertEquals(people.get(curr).toString(), personlist.get(curr).toString());
    }

    @RepeatedTest(6)
    public void testNullClothingPerson(RepetitionInfo repetitioninfo) {
        Witness witness = new Witness("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", null, true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Victim victim = new Victim("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", null, true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Suspect suspect = new Suspect("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", null, true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Criminal criminal = new Criminal("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", null, true, "spider", 12, true, "none", false, false, new ArrayList<UUID>(), new ArrayList<UUID>(), new ArrayList<UUID>());
        FamilyMember familymember = new FamilyMember("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", null, true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        Associate associate = new Associate("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", null, true, "spider", 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        personlist.add(witness);
        personlist.add(victim);
        personlist.add(suspect);
        personlist.add(criminal);
        personlist.add(familymember);
        personlist.add(associate);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        int curr = repetitioninfo.getCurrentRepetition() - 1;
        assertEquals(people.get(curr).toString(), personlist.get(curr).toString());
    }

    @RepeatedTest(6)
    public void testNullTattooDescriptionPerson(RepetitionInfo repetitioninfo) {
        Witness witness = new Witness("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, null, 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Victim victim = new Victim("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, null, 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Suspect suspect = new Suspect("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, null, 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Criminal criminal = new Criminal("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, null, 12, true, "none", false, false, new ArrayList<UUID>(), new ArrayList<UUID>(), new ArrayList<UUID>());
        FamilyMember familymember = new FamilyMember("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, null, 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        Associate associate = new Associate("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, null, 12, true, "none", "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        personlist.add(witness);
        personlist.add(victim);
        personlist.add(suspect);
        personlist.add(criminal);
        personlist.add(familymember);
        personlist.add(associate);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        int curr = repetitioninfo.getCurrentRepetition() - 1;
        assertEquals(people.get(curr).toString(), personlist.get(curr).toString());
    }

    @RepeatedTest(6)
    public void testNullCrimeOrganizationPerson(RepetitionInfo repetitioninfo) {
        Witness witness = new Witness("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, null, new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Victim victim = new Victim("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, null, new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Suspect suspect = new Suspect("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, null, new ArrayList<UUID>(), new ArrayList<UUID>(), "I'm innocent!", true);
        Criminal criminal = new Criminal("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, null, false, false, new ArrayList<UUID>(), new ArrayList<UUID>(), new ArrayList<UUID>());
        FamilyMember familymember = new FamilyMember("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, null, "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        Associate associate = new Associate("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, null, "granny", UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        personlist.add(witness);
        personlist.add(victim);
        personlist.add(suspect);
        personlist.add(criminal);
        personlist.add(familymember);
        personlist.add(associate);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        int curr = repetitioninfo.getCurrentRepetition() - 1;
        assertEquals(people.get(curr).toString(), personlist.get(curr).toString());
    }
    
    @RepeatedTest(4)
    public void testNullCrimesPerson(RepetitionInfo repetitioninfo) {
        Witness witness = new Witness("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", null, new ArrayList<UUID>(), "I'm innocent!", true);
        Victim victim = new Victim("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", null, new ArrayList<UUID>(), "I'm innocent!", true);
        Suspect suspect = new Suspect("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", null, new ArrayList<UUID>(), "I'm innocent!", true);
        Criminal criminal = new Criminal("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", false, false, null, new ArrayList<UUID>(), new ArrayList<UUID>());
        personlist.add(witness);
        personlist.add(victim);
        personlist.add(suspect);
        personlist.add(criminal);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        int curr = repetitioninfo.getCurrentRepetition() - 1;
        assertEquals(people.get(curr).toString(), personlist.get(curr).toString());
    }

    @RepeatedTest(3)
    public void  testNullStatementPerson(RepetitionInfo repetitioninfo) {
        Witness witness = new Witness("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), null, true);
        Victim victim = new Victim("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), null, true);
        Suspect suspect = new Suspect("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), new ArrayList<UUID>(), null, true);
        personlist.add(witness);
        personlist.add(victim);
        personlist.add(suspect);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        int curr = repetitioninfo.getCurrentRepetition() - 1;
        assertEquals(people.get(curr).toString(), personlist.get(curr).toString());
    }

    @RepeatedTest(3)
    public void testNullRelationsPerson(RepetitionInfo repetitioninfo) {
        Witness witness = new Witness("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), null, "I'm innocent!", true);
        Victim victim = new Victim("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), null, "I'm innocent!", true);
        Suspect suspect = new Suspect("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", new ArrayList<UUID>(), null, "I'm innocent!", true);
        personlist.add(witness);
        personlist.add(victim);
        personlist.add(suspect);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        int curr = repetitioninfo.getCurrentRepetition() - 1;
        assertEquals(people.get(curr).toString(), personlist.get(curr).toString());
    }

    @Test
    public void testNullFamilyRelationsPerson() {
        Criminal criminal = new Criminal("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", false, false, new ArrayList<UUID>(), null, new ArrayList<UUID>());
        personlist.add(criminal);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        assertEquals(people.get(0).toString(), personlist.get(0).toString());
    }

    @Test
    public void testNullAssociatesPerson() {
        Criminal criminal = new Criminal("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", false, false, new ArrayList<UUID>(), new ArrayList<UUID>(), null);
        personlist.add(criminal);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        assertEquals(people.get(0).toString(), personlist.get(0).toString());
    }

    @RepeatedTest(2)
    public void testNullRelationshipDescriptionPerson(RepetitionInfo repetitioninfo) {
        FamilyMember familymember = new FamilyMember("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", null, UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        Associate associate = new Associate("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", null, UUID.fromString("79c43922-9a3e-11eb-a8b3-0242ac130003"));
        personlist.add(familymember);
        personlist.add(associate);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        int curr = repetitioninfo.getCurrentRepetition() - 1;
        assertEquals(people.get(curr).toString(), personlist.get(curr).toString());
    }

    @RepeatedTest(2)
    public void testNullRelationshipIDPerson(RepetitionInfo repetitioninfo) {
        FamilyMember familymember = new FamilyMember("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", null);
        Associate associate = new Associate("John", "Clark", 23, "male", "white", UUID.fromString("0e54c510-9a3b-11eb-a8b3-0242ac130003"), "Mt. Pleasant", "docyor", 7.0, 124, "white", "blonde", "black", "jorts", true, "spider", 12, true, "none", "granny", null);
        personlist.add(familymember);
        personlist.add(associate);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        int curr = repetitioninfo.getCurrentRepetition() - 1;
        assertEquals(people.get(curr).toString(), personlist.get(curr).toString());
    }

    @RepeatedTest(6)
    public void testAllNullPropertiesPerson(RepetitionInfo repetitioninfo) {
        Witness witness = new Witness(null, null, 12, null, null, null, null, null, 1.2, 124, null, null, null, null, false, null, 124, false, null, null, null, null, false);
        Victim victim = new Victim(null, null, 12, null, null, null, null, null, 1.2, 124, null, null, null, null, false, null, 124, false, null, null, null, null, false);
        Suspect suspect = new Suspect(null, null, 12, null, null, null, null, null, 1.2, 124, null, null, null, null, false, null, 124, false, null, null, null, null, false);
        Criminal criminal = new Criminal(null, null, 12, null, null, null, null, null, 123, 151, null, null, null, null, false, null, 321, false, null, false, false, null, null, null);
        FamilyMember familymember = new FamilyMember(null, null, 12, null, null, null, null, null, 123, 4125, null, null, null, null, false, null, 124, false, null, null, null);
        Associate associate = new Associate(null, null, 12, null, null, null, null, null, 123, 4125, null, null, null, null, false, null, 124, false, null, null, null);
        personlist.add(witness);
        personlist.add(victim);
        personlist.add(suspect);
        personlist.add(criminal);
        personlist.add(familymember);
        personlist.add(associate);
        JSONWriter.savePeople();
        ArrayList<Person> people = JSONReader.getPeople();
        int curr = repetitioninfo.getCurrentRepetition() - 1;
        assertEquals(people.get(curr).toString(), personlist.get(curr).toString());
    }

    @Test
    public void testNullIDCrime() {
        Crime crime = new Crime(null, "a crime has occurred", false, new ArrayList<TypeOfCrime>(), new ArrayList<Person>(), "Blossom and 21", "February 30 2020", new ArrayList<Evidence>(), new ArrayList<LawEnforcementUser>(), "A crime occurred at a time and place!");
        crimelist.add(crime);
        JSONWriter.saveCrimes();
        ArrayList<Crime> crimes = JSONReader.getCrimes();
        assertEquals(crimelist.get(0).toString(), crimes.get(0).toString());
    }

    @Test
    public void testNullNameCrime() {
        Crime crime = new Crime(UUID.fromString("528de6e2-9af6-11eb-a8b3-0242ac130003"), null, false, new ArrayList<TypeOfCrime>(), new ArrayList<Person>(), "Blossom and 21", "February 30 2020", new ArrayList<Evidence>(), new ArrayList<LawEnforcementUser>(), "A crime occurred at a time and place!");
        crimelist.add(crime);
        JSONWriter.saveCrimes();
        ArrayList<Crime> crimes = JSONReader.getCrimes();
        assertEquals(crimelist.get(0).toString(), crimes.get(0).toString());
    }

    @Test
    public void testNullTypeOfCrime() {
        Crime crime = new Crime(UUID.fromString("528de6e2-9af6-11eb-a8b3-0242ac130003"), "a crime has occurred", false, null, new ArrayList<Person>(), "Blossom and 21", "February 30 2020", new ArrayList<Evidence>(), new ArrayList<LawEnforcementUser>(), "A crime occurred at a time and place!");
        crimelist.add(crime);
        JSONWriter.saveCrimes();
        ArrayList<Crime> crimes = JSONReader.getCrimes();
        assertEquals(crimelist.get(0).toString(), crimes.get(0).toString());
    }

    @Test
    public void testNullPersonArrayListCrime() {
        Crime crime = new Crime(UUID.fromString("528de6e2-9af6-11eb-a8b3-0242ac130003"), "a crime has occurred", false, new ArrayList<TypeOfCrime>(), null, "Blossom and 21", "February 30 2020", new ArrayList<Evidence>(), new ArrayList<LawEnforcementUser>(), "A crime occurred at a time and place!");
        crimelist.add(crime);
        JSONWriter.saveCrimes();
        ArrayList<Crime> crimes = JSONReader.getCrimes();
        assertEquals(crimelist.get(0).toString(), crimes.get(0).toString());
    }

    @Test
    public void testNullLocationCrime() {
        Crime crime = new Crime(UUID.fromString("528de6e2-9af6-11eb-a8b3-0242ac130003"), "a crime has occurred", false, new ArrayList<TypeOfCrime>(), new ArrayList<Person>(), null, "February 30 2020", new ArrayList<Evidence>(), new ArrayList<LawEnforcementUser>(), "A crime occurred at a time and place!");
        crimelist.add(crime);
        JSONWriter.saveCrimes();
        ArrayList<Crime> crimes = JSONReader.getCrimes();
        assertEquals(crimelist.get(0).toString(), crimes.get(0).toString());
    }

    @Test
    public void testNullDateCrime() {
        Crime crime = new Crime(UUID.fromString("528de6e2-9af6-11eb-a8b3-0242ac130003"), "a crime has occurred", false, new ArrayList<TypeOfCrime>(), new ArrayList<Person>(), "Blossom and 21", null, new ArrayList<Evidence>(), new ArrayList<LawEnforcementUser>(), "A crime occurred at a time and place!");
        crimelist.add(crime);
        JSONWriter.saveCrimes();
        ArrayList<Crime> crimes = JSONReader.getCrimes();
        assertEquals(crimelist.get(0).toString(), crimes.get(0).toString());
    }

    @Test
    public void testNullEvidenceCrime() {
        Crime crime = new Crime(UUID.fromString("528de6e2-9af6-11eb-a8b3-0242ac130003"), "a crime has occurred", false, new ArrayList<TypeOfCrime>(), new ArrayList<Person>(), "Blossom and 21", "February 30 2020", null, new ArrayList<LawEnforcementUser>(), "A crime occurred at a time and place!");
        crimelist.add(crime);
        JSONWriter.saveCrimes();
        ArrayList<Crime> crimes = JSONReader.getCrimes();
        assertEquals(crimelist.get(0).toString(), crimes.get(0).toString());
    }

    @Test
    public void testNullLawEnforcementUserCrime() {
        Crime crime = new Crime(UUID.fromString("528de6e2-9af6-11eb-a8b3-0242ac130003"), "a crime has occurred", false, new ArrayList<TypeOfCrime>(), new ArrayList<Person>(), "Blossom and 21", "February 30 2020", new ArrayList<Evidence>(), null, "A crime occurred at a time and place!");
        crimelist.add(crime);
        JSONWriter.saveCrimes();
        ArrayList<Crime> crimes = JSONReader.getCrimes();
        assertEquals(crimelist.get(0).toString(), crimes.get(0).toString());
    }

    @Test
    public void testNullDescriptionCrime() {
        Crime crime = new Crime(UUID.fromString("528de6e2-9af6-11eb-a8b3-0242ac130003"), "a crime has occurred", false, new ArrayList<TypeOfCrime>(), new ArrayList<Person>(), "Blossom and 21", "February 30 2020", new ArrayList<Evidence>(), new ArrayList<LawEnforcementUser>(), null);
        crimelist.add(crime);
        JSONWriter.saveCrimes();
        ArrayList<Crime> crimes = JSONReader.getCrimes();
        assertEquals(crimelist.get(0).toString(), crimes.get(0).toString());
    }
}
