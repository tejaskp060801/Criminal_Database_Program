
import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class DataBaseUI {
    private static final String WELCOME_MSG = "**********Welcome to the Criminal Database system**********";
    private DataBaseManager databaseManager;
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
        System.out.println("Please enter your username followed by ENTER and then your password");
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
            String choice = scanner.nextLine();
            if(choice == "Y" || choice == "y")
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
        System.out.println("What would you like to do?\n1. Search\n2. Export Criminal Profile\n3. Add crime\n4. Edit crime\n5. Update files\n6. Logout");
    }

    private void search() {
        System.out.println("What would you like to search for?\n 1. Person\n2. Crime");
        int choice = scanner.nextInt();
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
        String[] paramChoices = new String[7];
        paramChoices = input.split(",");
        List<String> paramChoiceList = Arrays.asList(paramChoices);
        ArrayList<String> paramChoiceArrayList = new ArrayList<String>(paramChoiceList);
        
        ArrayList<Object> searchParams = new ArrayList<Object>();
        for(int i=0; i<7; i++) {
            if(paramChoices[i] == "1") {
                System.out.println("\nEnter the CaseID of the crime you would like to search");
                UUID caseID = scanner.nextLine();
                searchParams.add(caseID);
            }

            if(paramChoices[i] == "2") {
                System.out.println("\nEnter the case title of the crime you would like to search");
                String title = scanner.nextLine();
                searchParams.add(title);
            }

            if(paramChoices[i] == "3") {
                System.out.println("\nEnter the UUIDs of the people involved separated by a comma (no spaces)");
                input = scanner.nextLine();
                UUID[] people = inpus.split(",");
                List<String> peopleList = Arrays.asList(people);
                ArrayList<UUID> peopleInvolved = new ArrayList<UUID>(peopleList);
                searchParams.add(peopleInvolved);
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
                System.out.println("Enter the UUIDs of the evidence related to the crime separated by a comma (no spaces)");
                input = scanner.nextLine();
                UUID[] evidence = inpus.split(",");
                List<String> evidenceList = Arrays.asList(evidence);
                ArrayList<UUID> evidenceArrayList = new ArrayList<UUID>(evidenceList);
                searchParams.add(evidenceArrayList);
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
        
        ArrayList<Object> searchParams = new ArrayList<Object>();
        for(int i=0; i<18; i++) {
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
                int age = scanner.nextInt();
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
                UUID personID = scanner.nextLine();
                searchParams.add(personID);
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
                double height = scanner.nextLine();
                searchParams.add(height);
            }

            if(paramChoices[i] == "10") {
                System.out.println("\nEnter the weight of the person you would like to search");
                double weight = scanner.nextLine();
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
                double shoeSize = scanner.nextLine();
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
        if(choice == 1) {
            System.out.println("Adding new person");
            addPerson();
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
        UUID crimeID = UUID.randomUUID();
        System.out.println("Crime ID: " + crimeID);

        System.out.println("Enter a title for the crime");
        String title = scanner.nextLine();

        System.out.println("Is this crime solved (Y/N");
        String solved = scanner.nextLine();
        boolean isSolved;
        if(solved == "Y" || solved == "y");
            isSolved = true;
        if(solved == "N" || solved == "n");
            isSolved = false;
        
        System.out.println("Would you like to add a person to this crime? (Y/N)");
        String s = scanner.nextLine();
        if(s == "Y" || s == "y")
            addPerson();
        while(true) {
            System.out.println("Would you like to add another person? (Y/N)");
            String more = scanner.nextLine();
            if(more == "Y" || more == "y") {
                addPerson();
                continue;
            }
            if(more == "N" || more == "n")
                break;
            else
                break;
        }
        /*
            NEED TO ADD FUNCTIONALITY TO SELECT MULTIPLE LEVELS OF FELONY
        */
        System.out.println("What type of felony is this crime?\n1. Class A felony\n2. Class B felony\n3. Class C felony\n4. Class D felony\n5. Class E felony\n6. Class F felony");
        int felonyType = scanner.NextInt();

        System.out.println("Enter the location of where the crime took place:");
        String location = scanner.nextLine();

        System.out.println("Enter the date that the crime took place");
        String date = scanner.nextLine();

        /*
            REEXAMINE. MIGHT NEED TO MAKE METHOD FOR ADD EVIDENCE
        
        System.out.println("Would you like to add evidence? (Y/N)");
        String aChoice = scanner.nextLine();
        if(aChoice == "Y" || aChoice == "y") {
           
        }
        */


         /*
            NEED TO ADD FUNCTIONALITY TO ENTER MULTIPLE UUIDS AT A TIME
            looping and adding 1 by 1 might be easier
         */
        System.out.println("Please enter the UUIDs of the officers working on the case");
        UUID officerID = scanner.nextLine();

        System.out.println("Please enter a description for the crime");
        String description = scanner.nextLine();
        Crime newCrime = new Crime(crimeID, title, isSolved, location, date, officerID, description);
        databaseManager.AddCrime(newCrime);
    }

    private void addPerson() {
        //find what kind of person they want to add
        System.out.println("Please enter the type of person you would like to add\n1. Victim\n2. Witness\n3. Suspect\n4. Criminal\n5. Family member\n6. Associate");
        int personType = scanner.nextInt();
        
        System.out.println("If there is any information that you are unsure of, press ENTER that pieice of information will be skipped for now");

        //get all attributes for general person
        System.out.println("Enter the first name of the person you would like to add");
        String firstName = scanner.nextLine();

        System.out.println("Enter the last name of the person you would like to add");
        String lastName = scanner.nextLine();
        
        System.out.println("Enter the age of the person");
        int age = scanner.nextInt();

        System.out.println("Enter the gender of this person");
        String gender = scanner.nextLine();

        System.out.println("Enter the race of this person");
        String race = scanner.nextLine();

        UUID personID = UUID.randomUUID();

        System.out.println("Enter the address of the person");
        String address = scanner.nextLine();

        System.out.println("Enter the profession of the person");
        String profession = scanner.nextLine();

        System.out.println("Enter the height of the person");
        double height = scanner.nextDouble();

        System.out.println("Enter the weight of the person");
        double weight = scanner.nextDouble();

        System.out.println("Enter the skin color of the person");
        String skinColor = scanner.nextLine();

        System.out.println("Enter the natural hair color of the person");
        String natHair = scanner.nextLine();

        System.out.println("Enter the un-natural hair color of the person");
        String unNatHair = scanner.nextLine();

        System.out.println("Enter the clothing that the person was wearing");
        String clothing = scanner.nextLine();

        System.out.println("Was this person wearing a tatoo? (Y/N)");
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

        System.out.println("Is this person a US citizen (Y/N)");
        String cit = scanner.nextLine();
        boolean isUSCitizen;
        if(cit == "Y" || cit == "y")
            isUSCitizen = true;
        else
            isUSCitizen = false;

        System.out.println("Enter the crime organization (if any) that this person is associated with");
        String crimeOrg = scanner.nextLine();

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
                //construct victim
                Person newVictim = new Victim(firstName, lastName, age, gender, race, address, profession, height, weight, skinColor, natHair, unNatHair, clothing, hasTattoo, tatDescription, shoeSize, isUSCitizen, crimeOrg, willTestify);
                break;

            case 2:
                System.out.println("Will this victim testify (Y/N)");
                String test1 = scanner.nextLine();
                boolean willTestify1;
                if(test == "Y" || test == "y")
                    willTestify1 = true;
                else
                    willTestify1 = false;
                 //construct witness
                Person newWitness= new Witness(firstName, lastName, age, gender, race, address, profession, height, weight, skinColor, natHair, unNatHair, clothing, hasTattoo, tatDescription, shoeSize, isUSCitizen, crimeOrg, willTestify1);
                break;

            case 3:
                 //construct suspect
                 Person newSuspect = new Suspect(firstName, lastName, age, gender, race, address, profession, height, weight, skinColor, natHair, unNatHair, clothing, hasTattoo, tatDescription, shoeSize, isUSCitizen, crimeOrg);
                break;

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
                    ?NEED TO ADD ARRAY LISTS OF CRIMES, FAMILY, ASSOCIATES?
                */

                //construct criminal

                break;

            case 5:
                System.out.println("What is the relationship of this person to the criminal?");
                String relationship = scanner.nextLine();

                UUID relationshipID = UUID.randomUUID();

                Person newFamilyMember = new FamilyMember(firstName, lastName, age, gender, race, address, profession, height, weight, skinColor, natHair, unNatHair, clothing, hasTattoo, tatDescription, shoeSize, isUSCitizen, crimeOrg, relationship, relationshipID);
                break;
            
            case 6:
                System.out.println("What is the relationship of this person to the criminal?");
                String relationship1 = scanner.nextLine();

                UUID relationshipID1 = UUID.randomUUID();

                Person newAssociate = new Associate(firstName, lastName, age, gender, race, address, profession, height, weight, skinColor, natHair, unNatHair, clothing, hasTattoo, tatDescription, shoeSize, isUSCitizen, crimeOrg, relationship1, relationshipID1);
                break;
        }
    }

    private void export() {
        System.out.println("What would you like to export?\n1. Person\n2. Crime?");
        int choice = scanner.nextInt();
        System.out.println("Please enter the UUID corresponding to what you would like to export");
        UUID id = scanner.nextLine();
        databaseManager.export(choice, id);
        return;
    }

    private void loginUser(String username, String password) {
        if (databaseManager.loginUser(username, password) == false) {
            System.out.println("There is no user with that username and password.\nWould you like to create a user? (Y/N)");
            String c = scanner.nextLine();
            if(c == "Y" || c == "y") {
                System.out.println("The same username and password you previously entered will be used to create your user account.\nWhat is your clearance level?");
                int level = scanner.nextInt();
                databaseManager.createUser(username, password, level);
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

    private void update() {
        databaseManager.update();
        return;
    }

    private void edit() {
        System.out.println("What Would you like to add?\n1. Crime\n2. Person");
        int userInput = scanner.nextInt();
        if(userInput == 1)
            editCrime();
        else if(userInput == 2)
            editPerson();
        return;
    }

    private void editPerson() {
        System.out.println("Enter the UUID of the person you would like to edit");
        UUID personIDEdit = scanner.nextLine();
        /*do a search person with the UUID parameter... return the person and then allow them to edit
        Construct new Person with new attributes
        Edit the person; will be swapping out old person for new person
        databaseManager.editPerson(old, newPerson);
        */
        ArrayList<String> paramChoices = new ArrayList<String>();
        //putting "6" in paramChocies arrayList so we are specifying we will search by UUID
        paramChocies.add("6");
        ArrayList<Object> searchParams = new ArrayList<Object>();
        searchParams.add(personIDEdit);

        //this should put the person that they searched for into Person temp
        Person temp = databaseManager.searchPerson(paramChoices, searchParams);
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
                repalcement.setRace(race);
            }

            if(editChoices[i] == "6") {
                System.out.println("\nEnter the UUID of the person you would like to edit");
                UUID personID = scanner.nextLine();
                replacement.setPersonID(personID);
            }

            if(editChoices[i] == "7") {
                System.out.println("\nEnter the address of the person you would like to edit");
                String address = scanner.nextLine();
                repalcement.setAddress(address);
            }

            if(editChoices[i] == "8") {
                System.out.println("\nEnter the profession of the person you would like to edit");
                String profession = scanner.nextLine();
                replacement.setProfession(profession);
            }

            if(editChoices[i] == "9") {
                System.out.println("\nEnter the height of the person you would like to edit");
                double height = scanner.nextLine();
                replacement.setHeight(height);
            }

            if(editChoices[i] == "10") {
                System.out.println("\nEnter the weight of the person you would like to edit");
                double weight = scanner.nextLine();
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
                double shoeSize = scanner.nextLine();
                replacement.setShoeSize(shoeSize);
            }

            if(editChoices[i] == "17") {
                System.out.println("\nEnter the criminal organization of the person you would like to edit");
                String crimeOrganization = scanner.nextLine();
                replacement.setCrimeOrganization(crimeOrganization);
            }
        }
        databaseManager.editPerson(temp, replacement);
    }

    private void editCrime() {
        System.out.println("Enter the UUID of the crime you would like to edit");
        UUID crimeIDEdit = scanner.nextLine();
        /*
            search for crime with UUID parameter... return crime and allow user to edit
        */
        ArrayList<String> paramChoices = new ArrayList<String>();
        //putting "1" in paramChocies arrayList so we are specifying we will search by UUID
        paramChocies.add("1");
        ArrayList<Object> searchParams = new ArrayList<Object>();
        searchParams.add(crimeIDEdit);

        //this should put the person that they searched for into Person temp
        Crime temp = databaseManager.searchCrime(paramChoices, searchParams);
        Crime replacement = temp;

        System.out.println("What attributes of this crime would you like to edit?\n1. First name\n2. Last name\n3. Age\n4. Gender\n5. Race\n6. Person UUID\n7. Address\n8. Profession\n9. Height\n10. Weight\n11. Skin Color\n12. Natural hair color\n13. Unnatural hair color\n14. Clothing\n15. Tattoo Description\n16. ShoeSize\n17. crimeOrganization\nPlease enter the numbers corresponding to the attributes you would like to search for separated by a comma (no space).\n");
        String input = scanner.nextLine();
        String[] editChoices = input.split(",");

        for(int i=0; i<7; i++) {
            if(editChoices[i] == "1") {
                System.out.println("\nEnter the CaseID of the crime you would like to edit");
                UUID caseID = scanner.nextLine();
                replacement.setCaseID(caseID);
            }

            if(editChoices[i] == "2") {
                System.out.println("\nEnter the case title of the crime you would like to edit");
                String title = scanner.nextLine();
                replacement.setTitle(title);
            }

            if(editChoices[i] == "3") {
                System.out.println("\nEnter the UUIDs of the people involved separated by a comma (no spaces)");
                input = scanner.nextLine();
                UUID[] people = inpus.split(",");
                List<String> peopleList = Arrays.asList(people);
                ArrayList<UUID> peopleInvolved = new ArrayList<UUID>(peopleList);
                replacement.setPeopleInvolved(people);
            }

            if(editChoices[i] == "4") {
                System.out.println("\nEnter the type of crime");
                String crimeType = scanner.nextLine();
                replacement.setCrimeType(crimeType);
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
                System.out.println("Enter the UUIDs of the evidence related to the crime separated by a comma (no spaces)");
                input = scanner.nextLine();
                UUID[] evidence = inpus.split(",");
                List<String> evidenceList = Arrays.asList(evidence);
                ArrayList<UUID> evidenceArrayList = new ArrayList<UUID>(evidenceList);
                replacement.setEvidence(evidence);
            }
        }
        databaseManager.editCrime(temp, replacement);
    }
}