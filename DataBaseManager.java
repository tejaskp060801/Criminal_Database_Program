

import java.util.UUID;

public class DataBaseManager {
    private UserSearchTree policeBST;
    private CrimeList crimeList;
    private PersonList personList;
    private double timeSinceUpdate;
    private LawEnforcementUser user;

    public DataBaseManager() {
        
    }

    public void CheckUpdateTime() {
        return;
    }

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

    public void search(int option) {  
        return;
    }

    public boolean loginUser() {
        //check if user exists first, if they do, login, if not create user
        return true;
    }

    public void logoutUser() {
        return;
    }

    public void export(int option, UUID id) {
        return;
    }

    public void save() {
        return;
    }

    public void update() {
        return;
    }

    public void exit() {
        return;
    }

    public void editCrime(Crime crime) {

    }

    public void editPerson(Person person) {
        
    }

}