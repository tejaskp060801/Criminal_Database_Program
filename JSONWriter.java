/**
 * 
 * @author 2021 Tyler Barrett 
 * class for writing in new JSON files
 */

import java.util.UUID;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONWriter extends JSONconstants {
    public static void save() {
        saveUsers();
        savePeople();
        saveCrimes();
    }

    public static void saveUsers() {
        UserSearchTree temp = UserSearchTree.getUserSearchTree();
        ArrayList<LawEnforcementUser> users = temp.getEnforcementUsers();
        JSONArray jsonarr = new JSONArray();
        for (int i = 0; i < users.size(); i++) {
            jsonarr.add(userConvert(users.get(i)));
        }

        try {
            FileWriter filewriter = new FileWriter(USER_FILE_NAME);
            filewriter.write(jsonarr.toJSONString());
            filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject userConvert(LawEnforcementUser user) {
        JSONObject ret = new JSONObject();
        ret.put(USER_ID, user.getID().toString());
        ret.put(USER_USERNAME, user.getUsername());
        ret.put(USER_PASSWORD, user.getPassword());
        ret.put(USER_FIRST_NAME, user.getFirstName());
        ret.put(USER_LAST_NAME, user.getLastName());
        ret.put(USER_CLEARANCE, user.getClearanceLevel());
        return ret;
    }

    public static void savePeople() {
        PersonList temp = PersonList.getPersonList();
        ArrayList<Person> people = temp.getPeople();
        JSONArray jsonarr = new JSONArray();
        for (int i = 0; i < people.size(); i++) {
            jsonarr.add(personConvert(people.get(i)));
        }
        try {
            FileWriter filewriter = new FileWriter(PERSON_FILE_NAME);
            filewriter.write(jsonarr.toJSONString());
            filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject personConvert(Person person) {
        JSONObject ret = new JSONObject();
        ret.put(PERSON_ID, person.getPersonID().toString());
        ret.put(PERSON_FIRST_NAME, person.getFirstName());
        ret.put(PERSON_LAST_NAME, person.getLastName());
        ret.put(PERSON_AGE, person.getAge());
        ret.put(PERSON_GENDER, person.getGender());
        ret.put(PERSON_RACE, person.getRace());
        ret.put(PERSON_ADDRESS, person.getAddress());
        ret.put(PERSON_PROFESSION, person.getProfession());
        ret.put(PERSON_HEIGHT, person.getHeight());
        ret.put(PERSON_WEIGHT, person.getWeight());
        ret.put(PERSON_SKIN_COLOR, person.getSkinColor());
        ret.put(PERSON_HAIR_COLOR_NATURAL, person.getHairColorNatural());
        ret.put(PERSON_HAIR_COLOR_UNNATURAL, person.getHairColorUnNatural());
        ret.put(PERSON_CLOTHING, person.getClothing());
        ret.put(PERSON_TATTOO, person.getTattoo());
        ret.put(PERSON_TATTOO_DESCRIPTION, person.getTattooDescription());
        ret.put(PERSON_SHOE_SIZE, person.getShoeSize());
        ret.put(PERSON_IS_CITIZEN, person.getIsUSCitizen());
        ret.put(PERSON_CRIME_ORGANIZATION, person.getOrganization());
        ret.put(PERSON_TYPE, person.getType());
        String temptype = person.getType();
        if (temptype.equalsIgnoreCase("Criminal")) {
            Criminal criminal = (Criminal) person;
            ret.put(PERSON_IN_JAIL, criminal.getIsInJail());
            ret.put(PERSON_DECEASED, criminal.getDeceased());
            ArrayList<UUID> crimesid = criminal.getCrimes();
            JSONArray crimes = new JSONArray();
            for (int i = 0; i < crimesid.size(); i++) {
                crimes.add(crimesid.get(i).toString());
            }
            ret.put(PERSON_CRIMES, crimes);
            ArrayList<UUID> familyid = criminal.getFamily();
            JSONArray family = new JSONArray();
            for (int i = 0; i < familyid.size(); i++) {
                family.add(familyid.get(i).toString());
            }
            ret.put(PERSON_FAMILY, family);
            ArrayList<UUID> associateid = criminal.getAssociates();
            JSONArray associates = new JSONArray();
            for (int i = 0; i < associateid.size(); i++) {
                associates.add(associateid.get(i).toString());
            }
            ret.put(PERSON_ASSOCIATES, associates);
        } else if (temptype.equalsIgnoreCase("Witness")) {
            Witness witness = (Witness) person;
            ret.put(PERSON_TESTIFY, witness.getWillTestify());
            ret.put(PERSON_STATEMENT, witness.getStatement());
            ArrayList<UUID> crimesid = witness.getCrimes();
            JSONArray crimes = new JSONArray();
            for (int i = 0; i < crimesid.size(); i++) {
                crimes.add(crimesid.get(i).toString());
            }
            ret.put(PERSON_OF_INTEREST_CRIMES, crimes);
            ArrayList<UUID> relationsid = witness.getRelations();
            JSONArray relations = new JSONArray();
            for (int i = 0; i < relationsid.size(); i++) {
                relations.add(relationsid.get(i).toString());
            }
            ret.put(PERSON_OF_INTEREST_RELATIONS, relations);
        } else if (temptype.equalsIgnoreCase("Victim")) {
            Victim victim = (Victim) person;
            ret.put(PERSON_TESTIFY, victim.getWillTestify());
            ret.put(PERSON_STATEMENT, victim.getStatement());
            ArrayList<UUID> crimesid = victim.getCrimes();
            JSONArray crimes = new JSONArray();
            for (int i = 0; i < crimesid.size(); i++) {
                crimes.add(crimesid.get(i).toString());
            }
            ret.put(PERSON_OF_INTEREST_CRIMES, crimes);
            ArrayList<UUID> relationsid = victim.getRelations();
            JSONArray relations = new JSONArray();
            for (int i = 0; i < relationsid.size(); i++) {
                relations.add(relationsid.get(i).toString());
            }
            ret.put(PERSON_OF_INTEREST_RELATIONS, relations);

        } else if (temptype.equalsIgnoreCase("Suspect")) {
            Suspect suspect = (Suspect) person;
            ret.put(PERSON_TESTIFY, suspect.getWillTestify());
            ret.put(PERSON_STATEMENT, suspect.getStatement());
            ArrayList<UUID> crimesid = suspect.getCrimes();
            JSONArray crimes = new JSONArray();
            for (int i = 0; i < crimesid.size(); i++) {
                crimes.add(crimesid.get(i).toString());
            }
            ret.put(PERSON_OF_INTEREST_CRIMES, crimes);
            ArrayList<UUID> relationsid = suspect.getRelations();
            JSONArray relations = new JSONArray();
            for (int i = 0; i < relationsid.size(); i++) {
                relations.add(relationsid.get(i).toString());
            }
            ret.put(PERSON_OF_INTEREST_RELATIONS, relations);

        } else if (temptype.equalsIgnoreCase("FamilyMember")) {
            FamilyMember familymember = (FamilyMember) person;
            ret.put(FAMILY_RELATIONSHIP, familymember.getRelationship());
            ret.put(FAMILY_RELATIONSHIP_ID, familymember.getRelationshipID().toString());

        } else if (temptype.equalsIgnoreCase("Associate")) {
            Associate associate = (Associate) person;
            ret.put(FAMILY_RELATIONSHIP, associate.getRelationship());
            ret.put(FAMILY_RELATIONSHIP_ID, associate.getRelationshipID().toString());

        } else {
            System.out.println("Your Person files are not in the correct format, please contact a technical expert");
            return null;
        }
        return ret;

    }

    public static void saveCrimes() {
        CrimeList temp = CrimeList.getCrimeList();
        ArrayList<Crime> crimes = temp.getCrimes();
        JSONArray array = new JSONArray();

        for (int i = 0; i < crimes.size(); i++) {
            array.add(crimeConvert(crimes.get(i)));
        }
        try {
            FileWriter filewriter = new FileWriter(CRIME_FILE_NAME);
            filewriter.write(array.toJSONString());
            filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static JSONObject crimeConvert(Crime crime) {
        JSONObject ret = new JSONObject();
        ret.put(CRIME_ID, crime.getcasenumber().toString());
        ret.put(CRIME_TITLE, crime.getTitle());
        ret.put(CRIME_SOLVED_FLAG, crime.isSolved());
        JSONArray people = new JSONArray();
        ArrayList<Person> peopleid = crime.getPeople();
        for (int i = 0; i < peopleid.size(); i++) {
            String temp = peopleid.get(i).getPersonID().toString();
            people.add(temp);
        }
        ret.put(CRIME_PEOPLE_INVOLVED, people);
        JSONArray typeofcrime = new JSONArray();
        ArrayList<TypeOfCrime> typeofcrimeids = crime.getTypeOfCrime();
        for (int i = 0; i < typeofcrimeids.size(); i++) {
            String temp = typeofcrimeids.get(i).toString();
            typeofcrime.add(temp);
        }
        ret.put(CRIME_TYPE_OF_CRIME, typeofcrime);
        ret.put(CRIME_LOCATION, crime.getLocation());
        ret.put(CRIME_DATE, crime.getDate());
        JSONArray evidencearr = new JSONArray();
        ArrayList<Evidence> javaevidence = crime.getEvidence();
        for (int i = 0; i < javaevidence.size(); i++) {
            JSONObject evidence = new JSONObject();
            Evidence tempevid = javaevidence.get(i);
            evidence.put(EVIDENCE_DESCRIPTION, tempevid.getDescription());
            evidence.put(EVIDENCE_ID, tempevid.getID().toString());
            String javaevidtype = tempevid.getEvidenceType();
            evidence.put(EVIDENCE_TYPE, javaevidtype);
            if (javaevidtype.equalsIgnoreCase("Bullet")) {
                Bullet tempevid2 = (Bullet) tempevid;
                evidence.put(BULLET_TYPE, tempevid2.getType());
            } else if (javaevidtype.equalsIgnoreCase("Gun")) {
                Gun tempevid2 = (Gun) tempevid;
                evidence.put(GUN_TYPE, tempevid2.getGunType());
                evidence.put(GUN_MODEL, tempevid2.getModel());
                evidence.put(GUN_BULLET_TYPE, tempevid2.getBulletType());
                evidence.put(GUN_YEAR_MADE, tempevid2.getYearMade());
            } else if (javaevidtype.equalsIgnoreCase("HairSample")) {
                HairSample tempevid2 = (HairSample) tempevid;
                evidence.put(HAIR_COLOR, tempevid2.getColor());
                evidence.put(HAIR_LENGTH, tempevid2.getLength());
                evidence.put(HAIR_THICKNESS, tempevid2.getThickness());
            } else if (javaevidtype.equalsIgnoreCase("BloodSample")) {
                BloodSample tempevid2 = (BloodSample) tempevid;
                evidence.put(BLOOD_TYPE, tempevid2.getBloodType());
                evidence.put(BLOOD_VOLUME, Double.toString(tempevid2.getBloodAmount()));
            } else if (javaevidtype.equalsIgnoreCase("normal")) {

            } else {
                System.out.println("Evidence Type format in java structure invalid. Contact Technical Expert");
                return null;
            }
            evidencearr.add(evidence);
        }
        ret.put(CRIME_EVIDENCE, evidencearr);
        JSONArray workingoncase = new JSONArray();
        ArrayList<LawEnforcementUser> workingoncaseids = crime.getWorkingOnCaseArrayList();
        for (int i = 0; i < workingoncaseids.size(); i++) {
            String temp = workingoncaseids.get(i).getUsername();
            workingoncase.add(temp);
        }
        ret.put(CRIME_WORKING_ON_CASE, workingoncase);
        ret.put(CRIME_DESCRIPTION, crime.getCrimeDescription());
        return ret;
    }
}
