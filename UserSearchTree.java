import java.util.ArrayList;

public class userSearchTree {
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

    public LawEnforcementUser addUser(String username, String pw, double clearance) {
        return new LawEnforcementUser();
    }

    public LawEnforcementUser search(String username) {
        return new LawEnforcementUser();
    }

    public void printUserNamesInOrder() {
        return;
    }


}