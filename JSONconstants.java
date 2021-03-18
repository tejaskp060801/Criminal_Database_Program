/**
 * 
 * @author 2021 Tyler Barrett
 * denotes the constants for all the JSON data
 */

public abstract class JSONconstants {
    public static final String USER_FILE_NAME = "JSON-files/User.json";
    public static final String PERSON_FILE_NAME = "JSON-files/Person.json";
    public static final String CRIME_FILE_NAME = "JSON-files/Crime.json";
    
    public static final String USER_ID = "LawEnforcementID";
    public static final String USER_USERNAME = "username";
    public static final String USER_PASSWORD = "password";
    public static final String USER_FIRST_NAME = "firstName";
    public static final String USER_LAST_NAME = "lastName";
    public static final String USER_CLEARANCE = "clearanceLevel";

    public static final String PERSON_ID = "PersonID";
    public static final String PERSON_FIRST_NAME = "firstName";
    public static final String PERSON_LAST_NAME = "lastName";
    public static final String PERSON_AGE = "age";
    public static final String PERSON_GENDER = "gender";
    public static final String PERSON_RACE = "race";
    public static final String PERSON_ADDRESS = "address";
    public static final String PERSON_PROFESSION = "profession";
    public static final String PERSON_HEIGHT = "height";
    public static final String PERSON_WEIGHT = "weight";
    public static final String PERSON_SKIN_COLOR = "skinColor";
    public static final String PERSON_HAIR_COLOR_NATURAL = "hairColorNatural";
    public static final String PERSON_HAIR_COLOR_UNNATURAL = "hairColorUnnatural";
    public static final String PERSON_CLOTHING = "clothing";
    public static final String PERSON_TATTOO = "tattoo";
    public static final String PERSON_TATTOO_DESCRIPTION = "tattooDescription";
    public static final String PERSON_SHOE_SIZE = "shoeSize";
    public static final String PERSON_IS_CITIZEN = "isUSCitizen";
    public static final String PERSON_CRIME_ORGANIZATION = "crimeOrganization";
    public static final String PERSON_TYPE = "personType";
    //  Need to add Person subtypes of data
    // Criminal Data
    public static final String PERSON_IN_JAIL = "isInJail";
    public static final String PERSON_DECEASED = "Deceased";
    public static final String PERSON_CRIMES = "crimes";
    public static final String PERSON_FAMILY = "family";
    public static final String PERSON_ASSOCIATES = "associates";
    //  PersonofInterest Data
    public static final String PERSON_TESTIFY = "willTestify";
    public static final String PERSON_STATEMENT = "statement";
    public static final String PERSON_OF_INTEREST_CRIMES = "crimes";
    public static final String PERSON_OF_INTEREST_RELATIONS = "relations";
    //  FamilyMember/Associate Data
    public static final String FAMILY_RELATIONSHIP = "relationship";
    public static final String FAMILY_RELATIONSHIP_ID = "relationshipID";

    public static final String CRIME_ID = "caseNumber";
    public static final String CRIME_TITLE = "title";
    public static final String CRIME_SOLVED_FLAG = "isSolved";
    public static final String CRIME_PEOPLE_INVOLVED =  "People";
    public static final String CRIME_TYPE_OF_CRIME = "typeofCrime";
    public static final String CRIME_PERSON_INVOLVED = "PersonID";
    public static final String CRIME_LOCATION = "location";
    public static final String CRIME_DATE = "date";
    public static final String CRIME_EVIDENCE = "evidence";
    public static final String CRIME_WORKING_ON_CASE = "workingOnCase";
    public static final String CRIME_ID_WORKING_ON_CASE = "LawEnforcementID";
    public static final String CRIME_DESCRIPTION = "crimeDescription";

    public static final String EVIDENCE_DESCRIPTION = "eviddescription";
    public static final String EVIDENCE_ID = "evidenceId";
    public static final String EVIDENCE_TYPE = "evidenceType";
    //  Add Evidence Type info
    public static final String BLOOD_TYPE = "bloodType";
    public static final String BLOOD_VOLUME = "bloodVolume";
    public static final String HAIR_COLOR = "color";
    public static final String HAIR_LENGTH = "length";
    public static final String HAIR_THICKNESS = "thickness";
    public static final String GUN_TYPE = "GunType";
    public static final String GUN_MODEL = "model";
    public static final String GUN_BULLET_TYPE = "bulletType";
    public static final String GUN_YEAR_MADE = "yearmade";
    public static final String BULLET_TYPE = "Type";

}
