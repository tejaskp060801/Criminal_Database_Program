

import java.util.UUID;

public class LawEnforcementUser implements Comparable<LawEnforcementUser> {
    protected String username;
    protected String password;
    public String firstname;
    public String lastname;
    protected int clearancelevel;
    protected UUID lawenforcementID;

    public LawEnforcementUser(String username, String password, String firstname, String lastname, int clearancelevel) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.clearancelevel = clearancelevel;
        this.lawenforcementID = UUID.randomUUID();
    }

    public LawEnforcementUser(String username, String password, String firstname, String lastname, int clearancelevel, UUID id) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.clearancelevel = clearancelevel;
        this.lawenforcementID = id;
    }

    public String getUsername() {
        return this.username;
    }

    public int getClearanceLevel() {
        return this.clearancelevel;
    }

    public String getName() {
        return this.firstname + " " + this.lastname;
    }

    public boolean passwordCorrect(String password) {
        if (this.password.equals(password)) {
            return true;
        }
        return false;
    }

    public int compareTo(LawEnforcementUser officer) {
        if (this.username.compareTo(officer.getUsername()) == 0) {
            return 0;
        }
        return (this.username.compareTo(officer.getUsername()) == -1) ? -1 : 1;
    }
}