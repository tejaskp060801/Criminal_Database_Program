

public class LawEnforcementUser implements Comparable{
    protected String username;
    protected String password;
    public String firstName;
    public String lastName;
    protected int clearanceLevel;
    protected UUID LawEnforcementID;

    public LawEnforcementUser(String username, String password, int clearance) {
        
    }

    public String getUsername() {
        return this.username;
    }

    public int getClearanceLevel() {
        return this.clearanceLevel;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public boolean passwordCorrect(String password) {
        return true;
    }

    public int compareTo(LawEnforcementUser officer) {
        return 1;
    }
}