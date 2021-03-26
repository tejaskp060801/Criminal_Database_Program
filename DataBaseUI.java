
import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class DataBaseUI {
    private static final String WELCOME_MSG = "**********Welcome to the Criminal Database system**********";
    private DataBaseManager databaseManager = new DataBaseManager(); 
    private Scanner scanner = new Scanner(System.in);

    /**
     * THIS CLASS WILL BE INTERACTING WITH THE DATABASEMANAGER
     * ESSENTIALLY CALLING "databsemanager.[methodname]"
     */


    public static void main(String [] args) {
        DataBaseUI ui = new DataBaseUI();
        ui.run();
    }

    public void run() {
        System.out.println(WELCOME_MSG);
        System.out.println("Please enter your username followed by ENTER and then your password to login.");
        String uname = scanner.nextLine();
        String pw = scanner.nextLine();
        loginUser(uname, pw);

        while(true) {
            DisplayMenu();
            int userInput = scanner.nextInt();
            switch(userInput) {
                case 1: //search
                    search();
                    break;

                case 2: //export
                    export();
                    break;

                case 3: //add
                    add();
                    break;

                case 4: //edit
                    edit();
                    break;

                case 5: //save and files
                    save();
                    break;

                case 6: //logout
                    logoutUser();
                    break;
            }
            System.out.println("Would you like to do something else (Y/N)");
            String choice; 
            choice = scanner.nextLine();
            if(choice.equalsIgnoreCase("y"))
                continue;
            else {
                //not sure if we should logout here or what
                logoutUser();
                break;
            }
        }   

    }

    private void DisplayMenu() {
        System.out.println("***** Main Menu *****");
        System.out.println("What would you like to do?\n1. Search a person or crime\n2. Export a person or crime\n3. Add a person or crime to the database\n4. Edit an existing person or crime\n5. Update files\n6. Logout");
    }

    private void search() {
        System.out.println("What would you like to search for?\n 1. Person\n2. Crime");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice == 1) {
            System.out.println("Searching for person:\nHow would you like to search for this person?");
            searchPerson();
            
        }
        if(choice == 2) {
            System.out.println("Searching for crime\nHow would you like to search for this crime?");
            searchCrime();
           }
        else  
            System.out.println("Invalid input");
        return;
    }

    private void searchCrime() {
        System.out.println("\n1. Case ID\n2. Case title\n3. By people involved in crime\n4. Type of crime\n5. Location of crime\n6. Date of crime\n7. Evidence related to crime\nPlease enter the numbers corresponding to the attributes you would like to search for separated by a comma(no space).\n");
        String input = scanner.nextLine();
        String [] paramChoices = input.split(",");
        List<String> paramChoiceList = Arrays.asList(paramChoices);
        ArrayList<String> paramChoiceArrayList = new ArrayList<String>(paramChoiceList);
        
        ArrayList<String> searchParams = new ArrayList<String>();
        for(int i=0; i<paramChoices.length; i++) {
            if(paramChoices[i] == "1") {
                System.out.println("\nEnter the CaseID of the crime you would like to search");
                String caseid = scanner.nextLine();
                searchParams.add(caseid);
            }

            if(paramChoices[i] == "2") {
                System.out.println("\nEnter the case title of the crime you would like to search");
                String title = scanner.nextLine();
                searchParams.add(title);
            }

            if(paramChoices[i] == "3") {
                System.out.println("\nEnter the UUID of a person who was involved in the crime");
                String personInvolvedID = scanner.nextLine();
                searchParams.add(personInvolvedID);
            }

            if(paramChoices[i] == "4") {
                System.out.println("\nEnter the type of crime");
                String crimeType = scanner.nextLine();
                searchParams.add(crimeType);
            }

            if(paramChoices[i] == "5") {
                System.out.println("\nEnter the location of the crime");
                String location = scanner.nextLine();
                searchParams.add(location);
            }

            if(paramChoices[i] == "6") {
                System.out.println("\nEnter the date that the crime took place");
                String date = scanner.nextLine();
                searchParams.add(date);
            }

            if(paramChoices[i] == "7") {
                System.out.println("Enter the UUID of a piece of evidence related to the crime.");
                String evidenceID = scanner.nextLine();
                searchParams.add(evidenceID);
            }
        }
        databaseManager.searchCrime(paramChoiceArrayList, searchParams);
    }

    private void searchPerson() {
        System.out.println("\n1. First name\n2. Last name\n3. Age\n4. Gender\n5. Race\n6. Person UUID\n7. Address\n8. Profession\n9. Height\n10. Weight\n11. Skin Color\n12. Natural hair color\n13. Unnatural hair color\n14. Clothing\n15. Tattoo Description\n16. ShoeSize\n17. crimeOrganization\nPlease enter the numbers corresponding to the attributes you would like to search for separated by a comma (no space).\n");
        String input = scanner.nextLine();
        String[] paramChoices = new String[7];
        paramChoices = input.split(",");
        List<String> paramChoiceList = Arrays.asList(paramChoices);
        ArrayList<String> paramChoiceArrayList = new ArrayList<String>(paramChoiceList);
        
        ArrayList<String> searchParams = new ArrayList<String>();
        for(int i=0; i<paramChoices.length; i++) {
            if(paramChoices[i] == "1") {
                System.out.println("\nEnter the first name of the person you would like to search");
                String firstName = scanner.nextLine();
                searchParams.add(firstName);
            }

            if(paramChoices[i] == "2") {
                System.out.println("\nEnter the last name of the person you would like to search");
                String lastName = scanner.nextLine();
                searchParams.add(lastName);
            }

            if(paramChoices[i] == "3") {
                System.out.println("\nEnter the age of the person you would like to search");
                String age = scanner.nextLine();
                searchParams.add(age);
            }

            if(paramChoices[i] == "4") {
                System.out.println("\nEnter the gender of the person you would like to search");
                String gender = scanner.nextLine();
                searchParams.add(gender);
            }

            if(paramChoices[i] == "5") {
                System.out.println("\nEnter the race or ethnicity of the person you would like to search");
                String race = scanner.nextLine();
                searchParams.add(race);
            }

            if(paramChoices[i] == "6") {
                System.out.println("\nEnter the UUID of the person you would like to search");
                String personid = scanner.nextLine();
                searchParams.add(personid);
            }

            if(paramChoices[i] == "7") {
                System.out.println("\nEnter the address of the person you would like to search");
                String address = scanner.nextLine();
                searchParams.add(address);
            }

            if(paramChoices[i] == "8") {
                System.out.println("\nEnter the profession of the person you would like to search");
                String profession = scanner.nextLine();
                searchParams.add(profession);
            }

            if(paramChoices[i] == "9") {
                System.out.println("\nEnter the height of the person you would like to search");
                String height = scanner.nextLine();
                searchParams.add(height);
            }

            if(paramChoices[i] == "10") {
                System.out.println("\nEnter the weight of the person you would like to search");
                String weight = scanner.nextLine();
                searchParams.add(weight);
            }

            if(paramChoices[i] == "11") {
                System.out.println("\nEnter the skin color of the person you would like to search");
                String skinColor = scanner.nextLine();
                searchParams.add(skinColor);
            }

            if(paramChoices[i] == "12") {
                System.out.println("\nEnter the natural hair color of the person you would like to search");
                String naturalHairColor = scanner.nextLine();
                searchParams.add(naturalHairColor);
            }

            if(paramChoices[i] == "13") {
                System.out.println("\nEnter the un-natural hair color of the person you would like to search");
                String unNaturalHairColor = scanner.nextLine();
                searchParams.add(unNaturalHairColor);
            }

            if(paramChoices[i] == "14") {
                System.out.println("\nEnter the clothing of the person you would like to search");
                String clothing = scanner.nextLine();
                searchParams.add(clothing);
            }

            if(paramChoices[i] == "15") {
                System.out.println("\nEnter the tattoo description of the person you would like to search");
                String tattooDescription = scanner.nextLine();
                searchParams.add(tattooDescription);
            }

            if(paramChoices[i] == "16") {
                System.out.println("\nEnter the shoe size of the person you would like to search");
                String shoeSize = scanner.nextLine();
                searchParams.add(shoeSize);
            }

            if(paramChoices[i] == "17") {
                System.out.println("\nEnter the criminal organization of the person you would like to search");
                String crimeOrganization = scanner.nextLine();
                searchParams.add(crimeOrganization);
            }
        }
        databaseManager.searchPerson(paramChoiceArrayList, searchParams);
    }

    private void add() {
        System.out.println("What would you like to add?\n 1. Person\n2. Crime");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice == 1) {
            System.out.println("Adding new person");
            Person temp = addPerson();
            databaseManager.AddPerson(temp);
            System.out.println("The person has been added to the database");
        }
        if(choice == 2) {
            System.out.println("Generating new crime");
            addCrime();
            System.out.println("The crime has been added to the database");
        }
        else  
            System.out.println("Invalid input");
    }

    private void addCrime() {
        System.out.println("Enter a title for the crime");
        String title = scanner.nextLine();

        System.out.println("Is this crime solved (Y/N");
        String solved = scanner.nextLine();
        boolean isSolved;
        if(solved == "Y" || solved == "y");
            isSolved = true;
        if(solved == "N" || solved == "n");
            isSolved = false;
        
        ArrayList<Person> people = new ArrayList<Person>();
        System.out.println("Would you like to add a person to this crime? (Y/N)");
        String s = scanner.nextLine();
        if(s == "Y" || s == "y") {
            Person temp = addPerson();
            people.add(temp);
        }
        while(true) {
            System.out.println("Would you like to add another person? (Y/N)");
            String more = scanner.nextLine();
            if(more == "Y" || more == "y") {
                Person temp = addPerson();
                people.add(temp);
                continue;
            }
            if(more == "N" || more == "n")
                break;
            else
                break;
        }
        
        System.out.println("What type of felony is this crime?\n1. Class A felony\n2. Class B felony\n3. Class C felony\n4. Class D felony\n5. Class E felony\n6. Class F felony\nPlease enter the numbers corresponding to the type of felonies that this crime falls under. Separate numbers by comma with no space");
        String input = scanner.nextLine();
        String[] inputArr = input.split(",");
        ArrayList<TypeOfCrime> felonyType = new ArrayList<TypeOfCrime>();
        for(int i=0; i<felonyType.size(); i++) {
            if(inputArr[i] == "1") {
                felonyType.add(TypeOfCrime.CLASSAFELONY);
            }

            if(inputArr[i] == "2") {
                felonyType.add(TypeOfCrime.CLASSBFELONY);
            }

            if(inputArr[i] == "3") {
                felonyType.add(TypeOfCrime.CLASSCFELONY);
            }

            if(inputArr[i] == "4") {
                felonyType.add(TypeOfCrime.CLASSDFELONY);
            }

            if(inputArr[i] == "5") {
                felonyType.add(TypeOfCrime.CLASSEFELONY);
            }

            if(inputArr[i] == "6") {
                felonyType.add(TypeOfCrime.CLASSFFELONY);   
            }
        }

        System.out.println("Enter the location of where the crime took place:");
        String location = scanner.nextLine();

        System.out.println("Enter the date that the crime took place");
        String date = scanner.nextLine();

        ArrayList<Evidence> evidenceList = new ArrayList<Evidence>();
        while(true) { 
            System.out.println("Would you like to add evidence? (Y/N)");
            String aChoice = scanner.nextLine();
            if(aChoice == "Y" || aChoice == "y") {
                System.out.println("\nEnter the type of evidence you would like to add.\n1. Hair sample\n2. Blood sample\n3. Gun\n4. Bullet\n5. Normal/other"); 
                String input1 = scanner.nextLine();
                int selector = Integer.parseInt(input1);
                System.out.println("\nEnter the description of the evidence");
                String description = scanner.nextLine();
                switch(selector) {
                    case 1:
                        System.out.println("\nEnter the color of the hair sample");
                        String color = scanner.nextLine();
                        
                        System.out.println("\nEnter the length of the hair sample");
                        double length = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.println("\nEnter the thickness of the hair sample");
                        double thickness = scanner.nextDouble();
                        scanner.nextLine();
                        Evidence newHairSample = new HairSample(description, null, "HairSample", color, length, thickness);
                        evidenceList.add(newHairSample);
                        break;
                    
                    case 2:
                        System.out.println("\nEnter the blood type");
                        String bloodType = scanner.nextLine();

                        System.out.println("\nEnter the volume of blood in this sample");
                        double bloodVolume = scanner.nextDouble();
                        scanner.nextLine();
                        Evidence newBloodSample = new BloodSample(description, null, "BloodSample", bloodType, bloodVolume);
                        evidenceList.add(newBloodSample);
                        break;

                    case 3:
                        System.out.println("\nEnter the type of gun");
                        String gunType = scanner.nextLine();

                        System.out.println("\nEnter the model of the gun");
                        String model = scanner.nextLine();

                        System.out.println("\nEnter the type of bullet");
                        String bulletType = scanner.nextLine();

                        System.out.println("\nEnter the year the gun was manufactured");
                        int yearMade = scanner.nextInt();
                        scanner.nextLine();
                        Evidence newGun = new Gun(description, null, "Gun", gunType, model, bulletType, yearMade);
                        evidenceList.add(newGun);
                        break;

                    case 4:
                        System.out.println("\nEnter the type of bullet");
                        String type = scanner.nextLine();
                        Evidence newBullet = new Bullet(description, null, "Bullet", type);
                        evidenceList.add(newBullet);
                        break;

                    case 5:
                        Evidence newNormal = new Evidence(description, null, "Other");
                        evidenceList.add(newNormal);
                        break;
                }
            }
            System.out.println("Would you like to add more evidence to the crime?");  
            String choice = scanner.nextLine();
            if(choice == "Y" || choice == "y") {
                continue;
            } 
            else {
                break;
            }
        }
        ArrayList<LawEnforcementUser> officersOnCase = new ArrayList<LawEnforcementUser>();
        while(true) {
            System.out.println("Please enter the username of an officer working on the case and then press ENTER");
            String name = scanner.nextLine();
            UserSearchTree lookingforpolice = UserSearchTree.getUserSearchTree();
            LawEnforcementUser temp = lookingforpolice.search(name);
            officersOnCase.add(temp);
            System.out.println("Would you like to add another officer? (Y/N)");
            String input1 = scanner.nextLine();
            if(input1.equalsIgnoreCase("y")) {
                continue;
            }
            else {
                break;
            }
        }

        System.out.println("Please enter a description for the crime");
        String description = scanner.nextLine();
        Crime newCrime = new Crime(null, title, isSolved, felonyType, people, location, date, evidenceList, officersOnCase/*Type mismatch -- lawenforcementusers*/, description);
        databaseManager.AddCrime(newCrime);
    }

    private Person addPerson() {
        //find what kind of person they want to add
        System.out.println("Please enter the type of person you would like to add\n1. Victim\n2. Witness\n3. Suspect\n4. Criminal\n5. Family member\n6. Associate");
        int personType = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("If there is any information that you are unsure of, press ENTER that pieice of information will be skipped for now");

        //get all attributes for general person
        System.out.println("Enter the first name of the person you would like to add");
        String firstName = scanner.nextLine();

        System.out.println("Enter the last name of the person you would like to add");
        String lastName = scanner.nextLine();
        
        System.out.println("Enter the age of the person");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the gender of this person");
        String gender = scanner.nextLine();

        System.out.println("Enter the race of this person");
        String race = scanner.nextLine();

        UUID personID = null;

        System.out.println("Enter the address of the person");
        String address = scanner.nextLine();

        System.out.println("Enter the profession of the person");
        String profession = scanner.nextLine();

        System.out.println("Enter the height of the person");
        double height = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter the weight of the person");
        double weight = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter the skin color of the person");
        String skinColor = scanner.nextLine();

        System.out.println("Enter the natural hair color of the person");
        String natHair = scanner.nextLine();

        System.out.println("Enter the un-natural hair color of the person");
        String unNatHair = scanner.nextLine();

        System.out.println("Enter the clothing that the person was wearing");
        String clothing = scanner.nextLine();

        System.out.println("Did this person have a tattoo? (Y/N)");
        String tat = scanner.nextLine();
        boolean hasTattoo;
        String tatDescription;
        if(tat == "Y" || tat == "y") {
            hasTattoo = true;
            System.out.println("Enter the tattoo description");
            tatDescription = scanner.nextLine();
        }
        else {
            hasTattoo = false;
            tatDescription = "";
        }

        System.out.println("Enter the shoe size of the person");
        double shoeSize = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Is this person a US citizen (Y/N)");
        String cit = scanner.nextLine();
        boolean isUSCitizen;
        if(cit == "Y" || cit == "y")
            isUSCitizen = true;
        else
            isUSCitizen = false;

        System.out.println("Enter the crime organization (if any) that this person is associated with");
        String crimeOrg = scanner.nextLine();

        ArrayList<UUID> crimes = new ArrayList<UUID>();
        ArrayList<UUID> relations = new ArrayList<UUID>();
        if(personType == 1 || personType == 2 || personType == 3) {
            System.out.println("Would you like to add Crimes to the Person? Enter Y / N");  
            String choice1 = scanner.nextLine();
            boolean crimescheck = false;
            if (choice1.equalsIgnoreCase("y"))
                crimescheck = true;
            while (crimescheck) {
                System.out.println("Please enter the UUID of the crime to be added");
                String idstr = scanner.nextLine();
                UUID temp = UUID.fromString(idstr);
                crimes.add(temp);
                System.out.println("Would you like to add more Crimes to the Person? Enter Y / N");  
                String choice = scanner.nextLine();
                if(choice == "Y" || choice == "y") {
                    continue;
                } 
                else {
                    break;
                }
            }

            
            System.out.println("Would you like to add Relations to the Person? Enter Y / N");  
            String choice2 = scanner.nextLine();
            boolean relationscheck = false;
            if (choice2.equalsIgnoreCase("y"))
                relationscheck = true;
            while (relationscheck) {
                System.out.println("Please enter the UUID of the Person to be added");
                String idstr = scanner.nextLine();
                UUID temp = UUID.fromString(idstr);
                relations.add(temp);
                System.out.println("Would you like to add more relations to the Person?");  
                String choice = scanner.nextLine();
                if(choice == "Y" || choice == "y") {
                    continue;
                } 
                else {
                    break;
                }
            }
        }
        //create new person based on person type
        switch(personType) {
            case 1:
                System.out.println("Will this victim testify (Y/N)");
                String test = scanner.nextLine();
                boolean willTestify;
                if(test == "Y" || test == "y")
                    willTestify = true;
                else
                    willTestify = false;
                System.out.println("Please enter the statement for the Person of Interest, if none, simply hit enter");
                String statement = scanner.nextLine();
                //construct victim
                Person newVictim = new Victim(firstName, lastName, age, gender, race, personID, address, profession, height, weight, skinColor, natHair, unNatHair, clothing, hasTattoo, tatDescription, shoeSize, isUSCitizen, crimeOrg, crimes, relations, statement, willTestify);
                return newVictim;

            case 2:
                System.out.println("Will this Witness testify (Y/N)");
                String test1 = scanner.nextLine();
                boolean willTestify1;
                if(test1 == "Y" || test1 == "y")
                    willTestify1 = true;
                else
                    willTestify1 = false;
                System.out.println("Please enter the statement for the Person of Interest, if none, simply hit enter");
                String statement1 = scanner.nextLine();
                 //construct witness
                Person newWitness= new Witness(firstName, lastName, age, gender, race, personID, address, profession, height, weight, skinColor, natHair, unNatHair, clothing, hasTattoo, tatDescription, shoeSize, isUSCitizen, crimeOrg, crimes, relations, statement1, willTestify1);
                return newWitness;

            case 3:
                //construct suspect
                System.out.println("Will this suspect testify (Y/N)");
                String test2 = scanner.nextLine();
                boolean willTestify2;
                if(test2 == "Y" || test2 == "y")
                    willTestify2 = true;
                else
                    willTestify2 = false;
                System.out.println("Please enter the statement for the Person of Interest, if none, simply hit enter");
                String statement2 = scanner.nextLine();
                Person newSuspect = new Suspect(firstName, lastName, age, gender, race, personID, address, profession, height, weight, skinColor, natHair, unNatHair, clothing, hasTattoo, tatDescription, shoeSize, isUSCitizen, crimeOrg, crimes, relations, statement2, willTestify2);
                return newSuspect;

            case 4:
                System.out.println("Is this person in jail? (Y/N");
                String inJail = scanner.nextLine();
                boolean isInJail;
                if(inJail == "Y" || inJail == "y")
                    isInJail = true;
                else
                    isInJail = false;
                    
                System.out.println("Is this person deceased? (Y/N");
                String deceased = scanner.nextLine();
                boolean isDeceased;
                if(deceased == "Y" || deceased == "y")
                    isDeceased = true;
                else
                    isDeceased = false;
                    
                /*
                    NEED TO ADD ARRAY LISTS OF CRIMES, FAMILY, ASSOCIATES
                */
                
                ArrayList<UUID> crimesCriminal = new ArrayList<UUID>();
                while(true) {
                    System.out.println("\nEnter the UUID of the cime you would like to add to this person");
                    UUID pCrime = UUID.fromString(scanner.nextLine());
                    crimesCriminal.add(pCrime);
                    System.out.println("\nWould you like to add another crime to this person? (Y/N)");
                    String choice = scanner.nextLine();
                    if(choice == "Y" || choice == "y") {
                        continue;
                    }
                    else {
                        break;
                    }
                }
                

                ArrayList<UUID> family = new ArrayList<UUID>();
                while(true) {
                    System.out.println("\nEnter the UUID of the family member you would like to add to this person");
                    String fam = scanner.nextLine();
                    UUID pFamMem = UUID.fromString(fam);
                    family.add(pFamMem);
                    System.out.println("\nWould you like to add another family member to this person? (Y/N)");
                    String choice = scanner.nextLine();
                    if(choice == "Y" || choice == "y") {
                        continue;
                    }
                    else {
                        break;
                    }
                }

                ArrayList<UUID> associates = new ArrayList<UUID>();
                while(true) {
                    System.out.println("\nEnter the UUID of the associate you would like to add to this person");
                    String associ = scanner.nextLine();
                    UUID pAssociate = UUID.fromString(associ);
                    associates.add(pAssociate);
                    System.out.println("\nWould you like to add another associate to this person? (Y/N)");
                    String choice = scanner.nextLine();
                    if(choice == "Y" || choice == "y") {
                        continue;
                    }
                    else {
                        break;
                    }
                }
                
                //construct criminal
                Person newCriminal = new Criminal(firstName, lastName, age, gender, race, personID, address, profession, height, weight, skinColor, natHair, unNatHair, clothing, hasTattoo, tatDescription, shoeSize, isUSCitizen, crimeOrg, isInJail, isDeceased, crimesCriminal, family, associates);
                return newCriminal;

            case 5:
                System.out.println("What is the relationship of this person to the criminal?");
                String relationship = scanner.nextLine();

                UUID relationshipID = UUID.randomUUID();

                Person newFamilyMember = new FamilyMember(firstName, lastName, age, gender, race, personID, address, profession, height, weight, skinColor, natHair, unNatHair, clothing, hasTattoo, tatDescription, shoeSize, isUSCitizen, crimeOrg, relationship, relationshipID);
                return newFamilyMember;
            
            case 6:
                System.out.println("What is the relationship of this person to the criminal?");
                String relationship1 = scanner.nextLine();

                UUID relationshipID1 = UUID.randomUUID();

                Person newAssociate = new Associate(firstName, lastName, age, gender, race, personID, address, profession, height, weight, skinColor, natHair, unNatHair, clothing, hasTattoo, tatDescription, shoeSize, isUSCitizen, crimeOrg, relationship1, relationshipID1);
                return newAssociate;
        }
        return null; 
    }

    private void export() {
        System.out.println("What would you like to export?\n1. Person\n2. Crime?");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the UUID corresponding to what you would like to export");
        String id = scanner.nextLine();
        UUID iD = UUID.fromString(id);
        databaseManager.export(choice, iD);
        return;
    }

    private void loginUser(String username, String password) {
        if (!databaseManager.loginUser(username, password)) {
            System.out.println("There is no user with that username and password.\nWould you like to create a user? (Y/N)");
            String c = scanner.nextLine();
            if(c == "Y" || c == "y") {
                System.out.println("The same username and password you previously entered will be used to create your user account.\nWhat is your clearance level?");
                int level = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter your first name");
                String f = scanner.nextLine();
                System.out.println("Enter your last name");
                String l = scanner.nextLine();
                databaseManager.createUser(username, password, level, f, l);
            }
            else if(c == "N" || c == "n") {
                databaseManager.exit();
            }
        }
        return;
    }

    private void logoutUser() {
        System.out.println("- - - Logging you out of the Criminal Database - - -\nSee you next time!");
        databaseManager.logoutUser();
        databaseManager.exit();
        return;
    }
  
    private void save() {
        databaseManager.save();
        return;
    }

    /*private void update() {
        databaseManager.update();       I believe this is unnecessary, delete at your discretion
        return;
    }*/         

    private void edit() {
        System.out.println("What Would you like to add?\n1. Crime\n2. Person");
        int userInput = scanner.nextInt();
        scanner.nextLine();
        if(userInput == 1)
            editCrime();
        else if(userInput == 2)
            editPerson();
        return;
    }

    private void editPerson() {
        System.out.println("Enter the UUID of the person you would like to edit");
        String pIDEdit = scanner.nextLine();
        UUID personIDEdit = UUID.fromString(pIDEdit);
        /*do a search person with the UUID parameter... return the person and then allow them to edit
        Construct new Person with new attributes
        Edit the person; will be swapping out old person for new person
        databaseManager.editPerson(old, newPerson);
        */

        //this should put the person that they searched for into Person temp
        Person temp = databaseManager.searchPerson(personIDEdit);
        Person replacement = temp;

        System.out.println("What attributes of this person would you like to edit?\n1. First name\n2. Last name\n3. Age\n4. Gender\n5. Race\n6. Person UUID\n7. Address\n8. Profession\n9. Height\n10. Weight\n11. Skin Color\n12. Natural hair color\n13. Unnatural hair color\n14. Clothing\n15. Tattoo Description\n16. ShoeSize\n17. crimeOrganization\nPlease enter the numbers corresponding to the attributes you would like to search for separated by a comma (no space).\n");
        String input = scanner.nextLine();
        String[] editChoices = input.split(",");

        for(int i=0; i<18; i++) {
            if(editChoices[i] == "1") {
                System.out.println("\nEnter the first name of the person you would like to edit");
                String firstName = scanner.nextLine();
                replacement.setFirstName(firstName);
            }

            if(editChoices[i] == "2") {
                System.out.println("\nEnter the last name of the person you would like to edit");
                String lastName = scanner.nextLine();
                replacement.setLastName(lastName);
            }

            if(editChoices[i] == "3") {
                System.out.println("\nEnter the age of the person you would like to edit");
                int age = scanner.nextInt();
                scanner.nextLine();
                replacement.setAge(age);
            }

            if(editChoices[i] == "4") {
                System.out.println("\nEnter the gender of the person you would like to edit");
                String gender = scanner.nextLine();
                replacement.setGender(gender);
            }

            if(editChoices[i] == "5") {
                System.out.println("\nEnter the race or ethnicity of the person you would like to edit");
                String race = scanner.nextLine();
                replacement.setRace(race);
            }

            if(editChoices[i] == "6") {
                System.out.println("\nEnter the UUID of the person you would like to edit");
                String pID = scanner.nextLine();
                UUID personID = UUID.fromString(pID);
                replacement.setPersonID(personID);
            }

            if(editChoices[i] == "7") {
                System.out.println("\nEnter the address of the person you would like to edit");
                String address = scanner.nextLine();
                replacement.setAddress(address);
            }

            if(editChoices[i] == "8") {
                System.out.println("\nEnter the profession of the person you would like to edit");
                String profession = scanner.nextLine();
                replacement.setProfession(profession);
            }

            if(editChoices[i] == "9") {
                System.out.println("\nEnter the height of the person you would like to edit");
                double height = scanner.nextDouble();
                scanner.nextLine();
                replacement.setHeight(height);
            }

            if(editChoices[i] == "10") {
                System.out.println("\nEnter the weight of the person you would like to edit");
                double weight = scanner.nextDouble();
                scanner.nextLine();
                replacement.setWeight(weight);
            }

            if(editChoices[i] == "11") {
                System.out.println("\nEnter the skin color of the person you would like to edit");
                String skinColor = scanner.nextLine();
                replacement.setSkinColor(skinColor);
            }

            if(editChoices[i] == "12") {
                System.out.println("\nEnter the natural hair color of the person you would like to edit");
                String naturalHairColor = scanner.nextLine();
                replacement.setHairColorNatural(naturalHairColor);
            }

            if(editChoices[i] == "13") {
                System.out.println("\nEnter the un-natural hair color of the person you would like to edit");
                String unNaturalHairColor = scanner.nextLine();
                replacement.setHairColorUnNatural(unNaturalHairColor);
            }

            if(editChoices[i] == "14") {
                System.out.println("\nEnter the clothing of the person you would like to edit");
                String clothing = scanner.nextLine();
                replacement.setClothing(clothing);
            }

            if(editChoices[i] == "15") {
                System.out.println("\nEnter the tattoo description of the person you would like to edit");
                String tattooDescription = scanner.nextLine();
                replacement.setTattooDescription(tattooDescription);
            }

            if(editChoices[i] == "16") {
                System.out.println("\nEnter the shoe size of the person you would like to edit");
                double shoeSize = scanner.nextDouble();
                scanner.nextLine();
                replacement.setShoeSize(shoeSize);
            }

            if(editChoices[i] == "17") {
                System.out.println("\nEnter the criminal organization of the person you would like to edit");
                String crimeOrganization = scanner.nextLine();
                replacement.setCriminalOrganization(crimeOrganization);
            }
        }
        databaseManager.editPerson(temp, replacement);
    }

    private void editCrime() {
        System.out.println("Enter the UUID of the crime you would like to edit");
        String cIDEdit = scanner.nextLine();
        UUID crimeIDEdit = UUID.fromString(cIDEdit);
        /*
            search for crime with UUID parameter... return crime and allow user to edit
        */
       
        //this should put the person that they searched for into Person temp
        Crime temp = databaseManager.searchCrime(crimeIDEdit); 
        Crime replacement = temp;

        System.out.println("What attributes of this crime would you like to edit?\n1. First name\n2. Last name\n3. Age\n4. Gender\n5. Race\n6. Person UUID\n7. Address\n8. Profession\n9. Height\n10. Weight\n11. Skin Color\n12. Natural hair color\n13. Unnatural hair color\n14. Clothing\n15. Tattoo Description\n16. ShoeSize\n17. crimeOrganization\nPlease enter the numbers corresponding to the attributes you would like to search for separated by a comma (no space).\n");
        String input = scanner.nextLine();
        String[] editChoices = input.split(",");

        for(int i=0; i<editChoices.length; i++) {
            if(editChoices[i] == "1") {
                System.out.println("\nEnter the CaseID of the crime you would like to edit");
                UUID caseID = UUID.fromString(scanner.nextLine());
                replacement.setID(caseID);
            }

            if(editChoices[i] == "2") {
                System.out.println("\nEnter the case title of the crime you would like to edit");
                String title = scanner.nextLine();
                replacement.setTitle(title);
            }

            if(editChoices[i] == "3") {
                System.out.println("\nEnter the UUIDs of the people involved separated by a comma (no spaces)");
                input = scanner.nextLine();
                String[] p1 = input.split(",");
                UUID[] people1 = new UUID[p1.length];
                for(int t=0; t<p1.length; t++) {
                    people1[t] = UUID.fromString(p1[t]);
                }
                List<UUID> peopleList = Arrays.asList(people1);
                ArrayList<UUID> peopleInvolved = new ArrayList<UUID>(peopleList);
                ArrayList<Person> setpeople = new ArrayList<Person>();
                PersonList temppersonlist = PersonList.getPersonList();
                for (int f = 0; f < peopleInvolved.size(); f++) {
                    setpeople.add(temppersonlist.searchPerson(peopleInvolved.get(i)));
                }
                replacement.setPeople(setpeople);
            }

            if(editChoices[i] == "4") {
                System.out.println("What type of felony is this crime?\n1. Class A felony\n2. Class B felony\n3. Class C felony\n4. Class D felony\n5. Class E felony\n6. Class F felony\nPlease enter the numbers corresponding to the type of felonies that this crime falls under. Separate numbers by comma with no space");
                String input2 = scanner.nextLine();
                String[] inputArr = input2.split(",");
                ArrayList<TypeOfCrime> felonyType = new ArrayList<TypeOfCrime>();
                for(int j=0; i<inputArr.length; i++) {
                    if(inputArr[i] == "1") {
                        felonyType.add(TypeOfCrime.CLASSAFELONY);
                    }
        
                    if(inputArr[i] == "2") {
                        felonyType.add(TypeOfCrime.CLASSBFELONY);
                    }
        
                    if(inputArr[i] == "3") {
                        felonyType.add(TypeOfCrime.CLASSCFELONY);
                    }
        
                    if(inputArr[i] == "4") {
                        felonyType.add(TypeOfCrime.CLASSDFELONY);
                    }
        
                    if(inputArr[i] == "5") {
                        felonyType.add(TypeOfCrime.CLASSEFELONY);
                    }
        
                    if(inputArr[i] == "6") {
                        felonyType.add(TypeOfCrime.CLASSFFELONY);   
                    }
                }
                replacement.setTypeOfCrime(felonyType);
            }

            if(editChoices[i] == "5") {
                System.out.println("\nEnter the location of the crime");
                String location = scanner.nextLine();
                replacement.setLocation(location);
            }

            if(editChoices[i] == "6") {
                System.out.println("\nEnter the date that the crime took place");
                String date = scanner.nextLine();
                replacement.setDate(date);
            }

            if(editChoices[i] == "7") {
                ArrayList<Evidence> evidence = temp.getEvidence();
                for(int j=0; j<evidence.size(); j++) {
                    Evidence tempEvidence = evidence.get(j);
                    System.out.println("Would you like to edit the following piece of evidence:\n" + tempEvidence.toString() + "\nEnter \"Y\" if you would like to edit this evidence");
                    String in = scanner.nextLine();
                    if(in == "Y" || in == "y") {
                        String type = tempEvidence.getEvidenceType();
                        System.out.println("Would you like to edit the description? (Y/N)");
                        in = scanner.nextLine();
                        if(in == "Y" || in == "y") {
                            String description = scanner.nextLine();
                            tempEvidence.setDescription(description);
                        }
                        if(type == "HairSample") {
                            System.out.println("Would you like to edit the color? (Y/N)");
                            in = scanner.nextLine();
                            HairSample tempEvidence2 = (HairSample) tempEvidence;
                            if(in == "Y" || in == "y") {
                                String color = scanner.nextLine();
                                tempEvidence2.setColor(color);
                            }

                            System.out.println("Would you like to edit the length? (Y/N)");
                            in = scanner.nextLine();
                            HairSample tempEvidence3 = (HairSample) tempEvidence; 
                            if(in == "Y" || in == "y") {
                                double length = scanner.nextDouble();
                                tempEvidence3.setLength(length);
                            }

                            System.out.println("Would you like to edit the thickness? (Y/N)");
                            in = scanner.nextLine();
                            HairSample tempEvidence4 = (HairSample) tempEvidence; 
                            if(in == "Y" || in == "y") {
                                double thickness = scanner.nextDouble();
                                tempEvidence4.setThickness(thickness);
                            }
                        }

                        if(type == "BloodSample") {
                            System.out.println("Would you like to edit the blood type? (Y/N)");
                            in = scanner.nextLine();
                            BloodSample tempEvidence5 = (BloodSample) tempEvidence; 
                            if(in == "Y" || in == "y") {
                                String bloodType = scanner.nextLine();
                                tempEvidence5.setType(bloodType);
                            }

                            System.out.println("Would you like to edit the blood volume? (Y/N)");
                            in = scanner.nextLine();
                            BloodSample tempEvidence6 = (BloodSample) tempEvidence; 
                            if(in == "Y" || in == "y") {
                                double vol = scanner.nextDouble();
                                tempEvidence6.setBloodVolume(vol);
                            }
                        }

                        if(type == "Gun") {
                            System.out.println("Would you like to edit the gun type? (Y/N)");
                            in = scanner.nextLine();
                            Gun tempEvidence7 = (Gun) tempEvidence; 
                            if(in == "Y" || in == "y") {
                                String gunType = scanner.nextLine();
                                tempEvidence7.setGunType(gunType);
                            }

                            System.out.println("Would you like to edit the gun model? (Y/N)");
                            in = scanner.nextLine();
                            Gun tempEvidence8 = (Gun) tempEvidence; 
                            if(in == "Y" || in == "y") {
                                String model = scanner.nextLine();
                                tempEvidence8.setModel(model);
                            }

                            System.out.println("Would you like to edit the bullet type? (Y/N)");
                            in = scanner.nextLine();
                            Gun tempEvidence9 = (Gun) tempEvidence; 
                            if(in == "Y" || in == "y") {
                                String bulletType = scanner.nextLine();
                                tempEvidence9.setBulletType(bulletType);
                            }

                            System.out.println("Would you like to edit the year made? (Y/N)");
                            in = scanner.nextLine();
                            Gun tempEvidence10 = (Gun) tempEvidence; 
                            if(in == "Y" || in == "y") {
                                int year = scanner.nextInt();
                                tempEvidence10.setYearMade(year);
                            }
                        }

                        if(type == "Bullet") {
                            System.out.println("Would you like to edit the bullet type? (Y/N)");
                            in = scanner.nextLine();
                            Bullet tempEvidence11 = (Bullet) tempEvidence; 
                            if(in == "Y" || in == "y") {
                                String bulletT = scanner.nextLine();
                                tempEvidence11.setType(bulletT);
                            }
                        }
                        evidence.set(j, tempEvidence);
                    }
                }
                while(true) {
                    System.out.println("Would you like to add more evidence to this crime? (Y/N)");
                    String n = scanner.nextLine();
                    if(n != "Y" || n != "y")
                        break;
                    System.out.println("\nEnter the type of evidence you would like to add.\n1. Hair sample\n2. Blood sample\n3. Gun\n4. Bullet\n5. Normal/other"); 
                    String input1 = scanner.nextLine();
                    int select = Integer.parseInt(input1);
                    System.out.println("\nEnter the description of the evidence");
                    String description = scanner.nextLine();
                    switch(select) {
                        case 1:
                            System.out.println("\nEnter the color of the hair sample");
                            String color = scanner.nextLine();
                                
                            System.out.println("\nEnter the length of the hair sample");
                            double length = scanner.nextDouble();
                            scanner.nextLine();
        
                            System.out.println("\nEnter the thickness of the hair sample");
                            double thickness = scanner.nextDouble();
                            scanner.nextLine();
                            Evidence newHairSample = new HairSample(description, null, "HairSample", color, length, thickness);
                            evidence.add(newHairSample);
                            break;
                            
                        case 2:
                            System.out.println("\nEnter the blood type");
                            String bloodType = scanner.nextLine();
        
                            System.out.println("\nEnter the volume of blood in this sample");
                            double bloodVolume = scanner.nextDouble();
                            scanner.nextLine();
                            Evidence newBloodSample = new BloodSample(description, null, "BloodSample", bloodType, bloodVolume);
                            evidence.add(newBloodSample);
                            break;
        
                        case 3:
                            System.out.println("\nEnter the type of gun");
                            String gunType = scanner.nextLine();
        
                            System.out.println("\nEnter the model of the gun");
                            String model = scanner.nextLine();
        
                            System.out.println("\nEnter the type of bullet");
                            String bulletType = scanner.nextLine();
        
                            System.out.println("\nEnter the year the gun was manufactured");
                            int yearMade = scanner.nextInt();
                            scanner.nextLine();
                            Evidence newGun = new Gun(description, null, "Gun", gunType, model, bulletType, yearMade);
                            evidence.add(newGun);
                            break;
        
                        case 4:
                            System.out.println("\nEnter the type of bullet");
                            String type = scanner.nextLine();
                            Evidence newBullet = new Bullet(description, null, "Bullet", type);
                            evidence.add(newBullet);
                            break;
        
                        case 5:
                            Evidence newNormal = new Evidence(description, null, "Other");
                            evidence.add(newNormal);
                            break;
                        }
                }
                replacement.setEvidence(evidence);
            }
        }
        databaseManager.editCrime(temp, replacement);
    }
}