import java.util.ArrayList;

public class UserSearchTree {
    private static UserSearchTree userSearchTree;
    private BinarySearchTree <LawEnforcementUser> users;

    private UserSearchTree() {
        users = JSONReader.getUsers();
    }

    public static UserSearchTree getUserSearchTree() {
        if (userSearchTree == null) {
            userSearchTree = new UserSearchTree();
        }
        
        return userSearchTree;
    }

    public boolean Login (String username, String pw) {
        return true;
    }

    public LawEnforcementUser addUser(String username, String pw, String firstname, String lastname, int clearance) {
        LawEnforcementUser user = new LawEnforcementUser(username, pw, firstname, lastname, clearance);
        users.addElement(user); 
        return user;
    }

    public LawEnforcementUser search(String username) {
        LawEnforcementUser user = new LawEnforcementUser(username,"",1); 
        users.search(user); 
    }

    public void printUserNamesInOrder() {
        users.printInOrder(); 
    }


}