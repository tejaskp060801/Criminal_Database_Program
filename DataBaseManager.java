

import java.util.*;

public class DataBaseManager {
    private UserSearchTree policeBST;
    private CrimeList crimeList;
    private PersonList personList;
    private double timeSinceUpdate;
    private LawEnforcementUser user;
/*
    public DataBaseManager() {
        
    }
*/

    public void AddCrime(Crime crime) {
        crimeList.addCrime(crime);
        return;
    }

    public void AddPerson(Person person) {
        personList.addPerson(person);
        return;
    }

    public void createUser(String username, String pw, int clearanceLevel) {
        LawEnforcementUser newUser = new LawEnforcementUser(username, pw, clearanceLevel);
        return;
    }

    public void searchCrime(ArrayList<String> parameterChoices, ArrayList<Object> searchParameters) {  
        crimeList.searchCrime(parameterChoices, searchParameters);
    }

    public void searchPerson(ArrayList<String> parameterChoices, ArrayList<Object> searchParameters) {
        personList.searchPerson(parameterChoices, searchParameters);
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
        /*
            Maybe should export to text file instead of just println
        */
        if(option == 1) {
            System.out.println(personList.searchPerson(id));
        }
        else if(option == 2) {
            System.out.println(crimeList.searchCrime(id));
        }
    }

    public void save() {
        DataWriter.save(crimeList.getCrimeArrayList(), personList.getPersonArrayList());
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