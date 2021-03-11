import java.util.ArrayList;

public class UserSearchTree {
    private UserSearchTree userSearchTree;
    private BinarySearchTree<LawEnforcementUser> users;

    private UserSearchTree() {

    }

    public UserSearchTree getUserSearchTree() {
        return this.userSearchTree;
    }

    public boolean Login (String username, String pw) {
        return true;
    }

    public LawEnforcementUser addUser(String username, String pw, int clearance) {
        return new LawEnforcementUser(username, pw, clearance);
    }

    public LawEnforcementUser search(String username) {
        return new LawEnforcementUser("", "", 1);
    }

    public void printUserNamesInOrder() {
        return;
    }


}