import java.util.ArrayList;

public class UserSearchTree {
    private UserSearchTree userSearchTree;
    private BinarySearchTree <LawEnforcementUser> users;

    private UserSearchTree() {
        
    }

    public UserSearchTree getUserSearchTree() {
        return this.userSearchTree;
    }

    public boolean Login (String username, String pw) {
        return true;
    }

    public LawEnforcementUser addUser(String username, String pw, int clearance) {
        LawEnforcementUser user = new LawEnforcementUser<>(username, pw, clearance);
        users.addElement(user); 
    }

    public LawEnforcementUser search(String username) {
        LawEnforcementUser user = new LawEnforcementUser(username,"",1); 
        users.search(user); 
    }

    public void printUserNamesInOrder() {
        users.printInOrder(); 
    }


}