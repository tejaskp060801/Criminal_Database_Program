/**
 * 
 * @author 2021 Tyler Barrett
 * class for reading in the JSON files Crime, Person, and User
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.UUID;
import java.util.Iterator;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class JSONReader extends JSONconstants {

    public static ArrayList<LawEnforcementUser> getUsers() {
        ArrayList<LawEnforcementUser> ret = new ArrayList<LawEnforcementUser>();

        try { 
            FileReader filereader = new FileReader(USER_FILE_NAME);
            JSONArray users = (JSONArray)new JSONParser().parse(filereader);

            for (int i = 0; i < users.size(); i++) {
                JSONObject object = (JSONObject) users.get(i);
                String idstring = (String) object.get(USER_ID);
                UUID id = UUID.fromString(idstring);
                String firstname = (String) object.get(USER_FIRST_NAME);
                String lastname = (String) object.get(USER_LAST_NAME);
                String password = (String) object.get(USER_PASSWORD);
                String username = (String) object.get(USER_USERNAME);
                int clearance = ((Long) object.get(USER_CLEARANCE)).intValue();
               // LawEnforcementUser temp = new LawEnforcementUser(username, password, firstname, lastname, clearance, id);
               // ret.add(temp);
            }
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        return ret;
    }

    public static ArrayList<Person> getPeople() {
        ArrayList<Person> ret = new ArrayList<Person>();
        
        try { 
            FileReader filereader = new FileReader(PERSON_FILE_NAME);
            JSONArray people = (JSONArray)new JSONParser().parse(filereader);

            for (int i = 0; i < people.size(); i++) {
                JSONObject object = (JSONObject) people.get(i);
                String idstring = (String) object.get(PERSON_ID);
                UUID id = UUID.fromString(idstring);
                String firstname = (String) object.get(PERSON_FIRST_NAME);
                String lastname = (String) object.get(PERSON_LAST_NAME);
                int age = ((Long) object.get(PERSON_AGE)).intValue();
                String gender = (String) object.get(PERSON_GENDER);
                String race = (String) object.get(PERSON_RACE);
                String address = (String) object.get(PERSON_ADDRESS);
                String profession = (String) object.get(PERSON_PROFESSION);
                double height = (double) object.get(PERSON_HEIGHT);
                double weight = (double) object.get(PERSON_WEIGHT);
                String skincolor = (String) object.get(PERSON_SKIN_COLOR);
                String haircolornatural = (String) object.get(PERSON_HAIR_COLOR_NATURAL);
                String haircolorunnatraul = (String) object.get(PERSON_HAIR_COLOR_UNNATURAL);
                String clothing = (String) object.get(PERSON_CLOTHING);
                boolean tattoo = (boolean) object.get(PERSON_TATTOO);
                String tattoodescription = (String) object.get(PERSON_TATTOO_DESCRIPTION);
                double shoesize = (double) object.get(PERSON_SHOE_SIZE);
                boolean citizen = (boolean) object.get(PERSON_IS_CITIZEN);
                String crimeorg = (String) object.get(PERSON_CRIME_ORGANIZATION);
                String persontype = (String) object.get(PERSON_TYPE);

               if (persontype.equalsIgnoreCase("Victim")) {
                   boolean willtestify = (boolean) object.get(PERSON_TESTIFY);
                   String statement = (String) object.get(PERSON_STATEMENT);
                   JSONArray crimes = (JSONArray) object.get(PERSON_OF_INTEREST_CRIMES);
                   Iterator<String> iterator = crimes.iterator();
                   ArrayList<UUID> ids = new ArrayList<UUID>();
                   while (iterator.hasNext()) {
                    ids.add(UUID.fromString(iterator.next()));
                }
                   JSONArray jsonrelations = (JSONArray) object.get(PERSON_OF_INTEREST_RELATIONS);
                   Iterator<String> iteratorassociate = jsonrelations.iterator();
                   ArrayList<UUID> relations = new ArrayList<UUID>();
                   while (iteratorassociate.hasNext()) {
                    relations.add(UUID.fromString(iteratorassociate.next()));
                }
                    Victim temp = new Victim(); // insert parameterized constructor
                    ret.add(temp);
                } else if (persontype.equalsIgnoreCase("Witness")) {
                    boolean willtestify = (boolean) object.get(PERSON_TESTIFY);
                    String statement = (String) object.get(PERSON_STATEMENT);
                    JSONArray crimes = (JSONArray) object.get(PERSON_OF_INTEREST_CRIMES);
                    Iterator<String> iterator = crimes.iterator();
                    ArrayList<UUID> ids = new ArrayList<UUID>();
                    while (iterator.hasNext()) {
                     ids.add(UUID.fromString(iterator.next()));
                    }
                    JSONArray jsonrelations = (JSONArray) object.get(PERSON_OF_INTEREST_RELATIONS);
                    Iterator<String> iteratorassociate = jsonrelations.iterator();
                    ArrayList<UUID> relations = new ArrayList<UUID>();
                    while (iteratorassociate.hasNext()) {
                        relations.add(UUID.fromString(iteratorassociate.next()));
                    }
                    Witness temp = new Witness(); //  insert parameterized constructor
                    ret.add(temp);
                } else if (persontype.equalsIgnoreCase("Suspect")) {                    String statement = (String) object.get(PERSON_STATEMENT);
                    JSONArray crimes = (JSONArray) object.get(PERSON_OF_INTEREST_CRIMES);
                    Iterator<String> iterator = crimes.iterator();
                    ArrayList<UUID> ids = new ArrayList<UUID>();
                    while (iterator.hasNext()) {
                        ids.add(UUID.fromString(iterator.next()));
                    }
                    JSONArray jsonrelations = (JSONArray) object.get(PERSON_OF_INTEREST_RELATIONS);
                    Iterator<String> iteratorassociate = jsonrelations.iterator();
                    ArrayList<UUID> relations = new ArrayList<UUID>();
                    while (iteratorassociate.hasNext()) {
                        relations.add(UUID.fromString(iteratorassociate.next()));
                    }
                    Suspect temp = new Suspect(); //  insert parameterized constructor
                    ret.add(temp);
                } else if (persontype.equalsIgnoreCase("Criminal")) {

                    Criminal temp = new Criminal(); //  insert parameterized constructor
                    ret.add(temp);
                } else if (persontype.equalsIgnoreCase("FamilyMember")) {

                    FamilyMember temp = new FamilyMember(); //  insert parameterized constructor
                    ret.add(temp);
                } else if (persontype.equalsIgnoreCase("Associate")) {

                    Associate temp = new Associate(); // insert parameterized constructor
                    ret.add(temp);
                } else {
                    System.out.println("JSON file invalid, not a valid type of person included");
                    return null;
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        return ret;
    }

    public static ArrayList<Crime> getCrimes() {
        ArrayList<Crime> ret = new ArrayList<Crime>();

        try { 
            FileReader filereader = new FileReader(CRIME_FILE_NAME);
            JSONArray crimes = (JSONArray)new JSONParser().parse(filereader);

            for (int i = 0; i < crimes.size(); i++) {
                
            }

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        return ret;
    }
}
