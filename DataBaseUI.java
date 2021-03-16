
import java.util.Scanner;
import java.util.UUID;

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

                case 5: //save and update files
                    save();
                    update();
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
        return;
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
        System.out.println("\n1. Case ID\n2. Case title\n3. By people involved in crime\n4. Type of crime\n5. Location of crime\n6. Date of crime\n7. Evidence related to crime\nPlease enter the numbers corresponding to the attributes you would like to search for separated by a comma");
        /*
            need to be able to take multiple parameters at a time and search for them
        */
    }

    private void searchPerson() {
        System.out.println("\n1. First name\n2. Last name\n3. Age\n4. Gender\n5. Race\n6. Person UUID\n7. Address\n8. Profession\n9. Height\n10. Weight\n11. Skin Color\n12. Natural hair color\n13. Unnatural hair color\n14. Clothing\n15. Shoe size\n16. US Citizenship\n17. Crime Organization\n18. Associate\nPlease enter the numbers corresponding to the attributes you would like to search for separated by a comma");
        /*
            need to be able to take multiple parameters at a time and search for them
        */

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
    }

    private void editCrime() {
        System.out.println("Enter the UUID of the crime you would oike to edit");
        UUID crimeIDEdit = scanner.nextLine();
        /*
            search for crime with UUID parameter... return crime and allow user to edit
        */
    }
}