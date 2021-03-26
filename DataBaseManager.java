

import java.util.*;
import java.io.*;

public class DataBaseManager {
    private UserSearchTree policeBST;
    private CrimeList crimeList;
    private PersonList personList;
    private LawEnforcementUser user;

    public DataBaseManager() {
        policeBST = UserSearchTree.getUserSearchTree(); 
        crimeList = CrimeList.getCrimeList(); 
        personList = PersonList.getPersonList(); 
    }

    public void AddCrime(Crime crime) {
        crimeList.addCrime(crime);
        return;
    }

    public void AddPerson(Person person) {
        personList.addPerson(person);
        return;
    }

    public void createUser(String username, String pw, int clearanceLevel, String firstName, String lastName) {
        policeBST.addUser(username, pw, firstName, lastName, clearanceLevel);
        return;
    }

    public void searchCrime(ArrayList<String> parameterChoices, ArrayList<String> searchParameters) {  
        crimeList.searchCrime(parameterChoices, searchParameters);
    }

    public void searchPerson(ArrayList<String> parameterChoices, ArrayList<String> searchParameters) {
        personList.searchPerson(parameterChoices, searchParameters);
    }

    public Crime searchCrime(UUID id) {
        return crimeList.searchCrime(id); 
    }

    public Person searchPerson(UUID id) {
        return personList.searchPerson(id);
    }

    public boolean loginUser(String username, String password) {
        //check if user with that username and pw exists first, if they do, login, if not create user
        return policeBST.Login(username, password);       
    }

    public void logoutUser() {
        save();
        exit();
    }

    public void export(int option, UUID id) {
        try {
            //user will select the directory they want to save the file to
            System.out.println("Enter the directory you would like to export the file to");
            Scanner scanner = new Scanner(System.in);
            String directory = scanner.nextLine();
            scanner.close();
            
            //exporting a person file
            if(option == 1) {
                Person temp = personList.searchPerson(id);
                String fileName = temp.getFirstName() + temp.getLastName() + ".txt";
                File personFile = new File(fileName);
                if(personFile.createNewFile()) {
                    FileWriter personWriter = new FileWriter(fileName);
                    personWriter.write(temp.toString());
                    personWriter.close();
                    System.out.println("Successfully exported the person's data to a text file");
                }
                //file already existed, so delete old file and make new one
                else {
                    personFile.delete();
                    File personFileUpdate = new File(fileName);
                    FileWriter personWriterUpdate = new FileWriter(fileName);
                    personWriterUpdate.write(temp.toString());
                    personWriterUpdate.close();
                    System.out.println("Successfully updated the text file");

                }
            }
            //exporting a crime file
            else if(option == 2) {
                Crime temp = crimeList.searchCrime(id);
                String fileName = temp.getTitle() + ".txt";
                File crimeFile = new File(fileName);
                if(crimeFile.createNewFile()) {
                    FileWriter crimeWriter = new FileWriter(fileName);
                    crimeWriter.write(temp.toString());
                    crimeWriter.close();
                    System.out.println("Successfully exported the crime's data to a text file");
                }
                //file already existed, so delete old file and make new one
                else {
                    crimeFile.delete();
                    File crimeFileUpdate = new File(fileName);
                    FileWriter crimeWriterUpdate = new FileWriter(fileName);
                    crimeWriterUpdate.write(temp.toString());
                    crimeWriterUpdate.close();
                    System.out.println("Successfully updated the text file");

                }
            }
        }

        catch (IOException e) {
            System.out.println("An error occurred when exporting to a file");
            e.printStackTrace();
        }
    }

    public void save() {
        JSONWriter.save();
    }

    public void exit() {
        System.exit(0);
    }

    public void editCrime(Crime old, Crime newCrime) {
        crimeList.editCrime(old, newCrime);
    }

    public void editPerson(Person old, Person newPerson) {
        personList.editPerson(old, newPerson);
    }

}