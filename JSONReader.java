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

    public static void LoadData() {
        getUsers();
        getPeople();
        getCrimes();
    }

    public static BinarySearchTree<LawEnforcementUser> getUsers() {
        BinarySearchTree<LawEnforcementUser> ret = new BinarySearchTree<LawEnforcementUser>();

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
                LawEnforcementUser temp = new LawEnforcementUser(username, password, firstname, lastname, clearance, id);
                ret.addElement(temp);
            }
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        return ret;
    }

    public static ArrayList<Person> getPeople() {
        //UserSearchTree users = UserSearchTree.getUserSearchTree();
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
                String haircolorunnatural = (String) object.get(PERSON_HAIR_COLOR_UNNATURAL);
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
                   ArrayList<UUID> crimeids = new ArrayList<UUID>();
                   while (iterator.hasNext()) {
                    crimeids.add(UUID.fromString(iterator.next()));
                }
                   JSONArray jsonrelations = (JSONArray) object.get(PERSON_OF_INTEREST_RELATIONS);
                   Iterator<String> iteratorassociate = jsonrelations.iterator();
                   ArrayList<UUID> relations = new ArrayList<UUID>();
                   while (iteratorassociate.hasNext()) {
                    relations.add(UUID.fromString(iteratorassociate.next()));
                }
                    Victim temp = new Victim(firstname, lastname, age, gender, race,
                        id, address, profession, height, weight, skincolor, haircolornatural, 
                        haircolorunnatural, clothing, tattoo, tattoodescription, shoesize, citizen, 
                        crimeorg, crimeids, relations, statement, willtestify); //  TODO  insert parameterized constructor
                    ret.add(temp);
                } else if (persontype.equalsIgnoreCase("Witness")) {
                    boolean willtestify = (boolean) object.get(PERSON_TESTIFY);
                    String statement = (String) object.get(PERSON_STATEMENT);
                    JSONArray crimes = (JSONArray) object.get(PERSON_OF_INTEREST_CRIMES);
                    Iterator<String> iterator = crimes.iterator();
                    ArrayList<UUID> crimeids = new ArrayList<UUID>();
                    while (iterator.hasNext()) {
                     crimeids.add(UUID.fromString(iterator.next()));
                    }
                    JSONArray jsonrelations = (JSONArray) object.get(PERSON_OF_INTEREST_RELATIONS);
                    Iterator<String> iteratorassociate = jsonrelations.iterator();
                    ArrayList<UUID> relations = new ArrayList<UUID>();
                    while (iteratorassociate.hasNext()) {
                        relations.add(UUID.fromString(iteratorassociate.next()));
                    }
                    Witness temp = new Witness(firstname, lastname, age, gender, race,
                        id, address, profession, height, weight, skincolor, haircolornatural, 
                        haircolorunnatural, clothing, tattoo, tattoodescription, shoesize, citizen, 
                        crimeorg, crimeids, relations, statement, willtestify); //  TODO  insert parameterized constructor
                    ret.add(temp);
                } else if (persontype.equalsIgnoreCase("Suspect")) {                    
                    String statement = (String) object.get(PERSON_STATEMENT);
                    boolean willtestify = (boolean) object.get(PERSON_TESTIFY);
                    JSONArray crimes = (JSONArray) object.get(PERSON_OF_INTEREST_CRIMES);
                    Iterator<String> iterator = crimes.iterator();
                    ArrayList<UUID> crimeids = new ArrayList<UUID>();
                    while (iterator.hasNext()) {
                        crimeids.add(UUID.fromString(iterator.next()));
                    }
                    JSONArray jsonrelations = (JSONArray) object.get(PERSON_OF_INTEREST_RELATIONS);
                    Iterator<String> iteratorassociate = jsonrelations.iterator();
                    ArrayList<UUID> relations = new ArrayList<UUID>();
                    while (iteratorassociate.hasNext()) {
                        relations.add(UUID.fromString(iteratorassociate.next()));
                    }
                    Suspect temp = new Suspect(firstname, lastname, age, gender, race,
                        id, address, profession, height, weight, skincolor, haircolornatural, 
                        haircolorunnatural, clothing, tattoo, tattoodescription, shoesize, citizen, 
                        crimeorg, crimeids, relations, statement, willtestify);
                    ret.add(temp);
                } else if (persontype.equalsIgnoreCase("Criminal")) {
                    boolean injail = (boolean) object.get(PERSON_IN_JAIL);
                    boolean deceased = (boolean) object.get(PERSON_DECEASED);
                    JSONArray crimes = (JSONArray) object.get(PERSON_CRIMES);
                    Iterator<String> iterator = crimes.iterator();
                    ArrayList<UUID> crimeids = new ArrayList<UUID>();
                    while (iterator.hasNext()) {
                        crimeids.add(UUID.fromString(iterator.next()));
                    }
                    JSONArray jsonfamily = (JSONArray) object.get(PERSON_FAMILY);
                    Iterator<String> iteratorfamily = jsonfamily.iterator();
                    ArrayList<UUID> family = new ArrayList<UUID>();
                    while (iteratorfamily.hasNext()) {
                        family.add(UUID.fromString(iterator.next()));
                    }
                    JSONArray jsonassociates = (JSONArray) object.get(PERSON_ASSOCIATES);
                    Iterator<String> iteratorassociates = jsonassociates.iterator();
                    ArrayList<UUID> associates =new ArrayList<UUID>();
                    while (iteratorassociates.hasNext()) {
                        associates.add(UUID.fromString(iteratorassociates.next()));
                    }

                    Criminal temp = new Criminal(firstname, lastname, age, gender, race,
                        id, address, profession, height, weight, skincolor, haircolornatural, 
                        haircolorunnatural, clothing, tattoo, tattoodescription, shoesize, citizen, 
                        crimeorg, injail, deceased, crimeids, family, associates);
                    ret.add(temp);
                } else if (persontype.equalsIgnoreCase("FamilyMember")) {
                    String relationship = (String) object.get(FAMILY_RELATIONSHIP);
                    String relationshipid = (String) object.get(FAMILY_RELATIONSHIP_ID);
                    UUID familyid = UUID.fromString(relationshipid);
                
                    FamilyMember temp = new FamilyMember(firstname, lastname, age, gender, race,
                        id, address, profession, height, weight, skincolor, haircolornatural, 
                        haircolorunnatural, clothing, tattoo, tattoodescription, shoesize, citizen, 
                        crimeorg, relationship, familyid);
                    ret.add(temp);
                } else if (persontype.equalsIgnoreCase("Associate")) {
                    String relationship = (String) object.get(FAMILY_RELATIONSHIP);
                    String relationshipid = (String) object.get(FAMILY_RELATIONSHIP_ID);
                    UUID familyid = UUID.fromString(relationshipid);

                    Associate temp = new Associate(firstname, lastname, age, gender, race,
                        id, address, profession, height, weight, skincolor, haircolornatural, 
                        haircolorunnatural, clothing, tattoo, tattoodescription, shoesize, citizen, 
                        crimeorg, relationship, familyid);
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
        UserSearchTree users = UserSearchTree.getUserSearchTree();
        PersonList people = PersonList.getPersonList();
        ArrayList<Crime> ret = new ArrayList<Crime>();

        try { 
            FileReader filereader = new FileReader(CRIME_FILE_NAME);
            JSONArray crimes = (JSONArray)new JSONParser().parse(filereader);

            for (int i = 0; i < crimes.size(); i++) {
                JSONObject object = (JSONObject) crimes.get(i);
                String caseid = (String) object.get(CRIME_ID);
                UUID crimeid = UUID.fromString(caseid);
                String title = (String) object.get(CRIME_TITLE);
                boolean issolved = (boolean) object.get(CRIME_SOLVED_FLAG);
                JSONArray peopleinvolved = (JSONArray) object.get(CRIME_PEOPLE_INVOLVED);
                Iterator<String> peopleiterator = peopleinvolved.iterator();
                ArrayList<Person> peoplearr = new ArrayList<Person>();
                while (peopleiterator.hasNext()) {
                    peoplearr.add(people.searchPerson(UUID.fromString(peopleiterator.next())));
                }
                JSONArray typesofcrime = (JSONArray) object.get(CRIME_TYPE_OF_CRIME);
                Iterator<String> typeiterator = typesofcrime.iterator();
                ArrayList<TypeOfCrime> crimetype = new ArrayList<TypeOfCrime>();
                while (typeiterator.hasNext()) {
                    String temp = typeiterator.next();
                    if (temp.equalsIgnoreCase("Class A Felony")) {
                        TypeOfCrime temp2 = TypeOfCrime.CLASSAFELONY;
                        crimetype.add(temp2);
                    } else if (temp.equalsIgnoreCase("Class B Felony")) {
                        TypeOfCrime temp2 = TypeOfCrime.CLASSBFELONY;
                        crimetype.add(temp2);
                    } else if (temp.equalsIgnoreCase("Class C Felony")) {
                        TypeOfCrime temp2 = TypeOfCrime.CLASSCFELONY;
                        crimetype.add(temp2);
                    } else if (temp.equalsIgnoreCase("Class D Felony")) {
                        TypeOfCrime temp2 = TypeOfCrime.CLASSDFELONY;
                        crimetype.add(temp2);
                    } else {
                        TypeOfCrime temp2 = TypeOfCrime.CLASSEFELONY;
                        crimetype.add(temp2);
                    }
                }
                String location = (String) object.get(CRIME_LOCATION);
                String date  = (String) object.get(CRIME_DATE);
                JSONArray jsonevidence = (JSONArray) object.get(CRIME_EVIDENCE);
                ArrayList<Evidence> evidence = new ArrayList<Evidence>();

                for (int j = 0; j < jsonevidence.size(); j++) {
                    JSONObject current = (JSONObject) jsonevidence.get(j);
                    String evidencedesc = (String) current.get(EVIDENCE_DESCRIPTION);
                    String evidenceidstr = (String) current.get(EVIDENCE_ID);
                    UUID evidenceid = UUID.fromString(evidenceidstr);
                    String evidencetype = (String) current.get(EVIDENCE_TYPE);

                    if (evidencetype.equalsIgnoreCase("normal")) {
                        Evidence eret = new Evidence(evidencedesc, evidenceid, evidencetype);
                        evidence.add(eret);
                    } else if (evidencetype.equalsIgnoreCase("BloodSample")) {
                        String bloodtype = (String) current.get(BLOOD_TYPE);
                        Double bloodvolume = Double.parseDouble((String) current.get(BLOOD_VOLUME));
                        BloodSample eret = new BloodSample(evidencedesc, evidenceid, evidencetype,
                            bloodtype, bloodvolume);
                        evidence.add(eret);
                    } else if (evidencetype.equalsIgnoreCase("HairSample")) {
                        String haircolor = (String) current.get(HAIR_COLOR);
                        double hairlength = (double) current.get(HAIR_LENGTH);
                        double hairthickness = (double) current.get(HAIR_THICKNESS);
                        HairSample eret = new HairSample(evidencedesc, evidenceid, evidencetype,
                            haircolor, hairlength, hairthickness);
                        evidence.add(eret);
                    } else if (evidencetype.equalsIgnoreCase("Gun")) {
                        String guntype = (String) current.get(GUN_TYPE);
                        String gunmodel = (String) current.get(GUN_MODEL);
                        String gunbullet = (String) current.get(GUN_BULLET_TYPE);
                        int gunyearmade = ((Long) current.get(GUN_YEAR_MADE)).intValue();
                        Gun eret = new Gun(evidencedesc, evidenceid, evidencetype,
                            guntype, gunmodel, gunbullet, gunyearmade);
                        evidence.add(eret);
                    } else if (evidencetype.equalsIgnoreCase("Bullet")) {
                        String bullettype = (String) current.get(BULLET_TYPE);
                        Bullet eret = new Bullet(evidencedesc, evidenceid, evidencetype,
                            bullettype);
                        evidence.add(eret);
                    } else {
                        System.out.println("JSON format invalid, seek assistance from a technical expert");
                        return null;
                    }
                }

                JSONArray jsonworkingoncase = (JSONArray) object.get(CRIME_WORKING_ON_CASE);
                Iterator<String> caseiterator = jsonworkingoncase.iterator();
                ArrayList<LawEnforcementUser> workingoncase = new ArrayList<LawEnforcementUser>();
                while (caseiterator.hasNext()) {
                    String temp = caseiterator.next();
                    LawEnforcementUser templaw = users.search(temp);
                    workingoncase.add(templaw);
                }
                String crimedesc = (String) object.get(CRIME_DESCRIPTION);
                Crime temp = new Crime();  //  TODO add parameterized constructor
                ret.add(temp);
            } 
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        return ret;
    }
}
