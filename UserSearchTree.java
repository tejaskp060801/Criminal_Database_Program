import java.util.ArrayList;

public class UserSearchTree {
    private UserSearchTree userSearchTree;
    private BinarySearchTree<LawEnforcementUser> users;

    private UserSearchTree() {
        this.users= users; 
        this.userSearchTree = userSearchTree; 
    }

    public UserSearchTree getUserSearchTree() {
        return this.userSearchTree;
    }

    public boolean Login (String username, String pw) {
        if(users.username == username) {
            System.out.println("please type in your password"); 
            if(users.password == pw){
                return true; 
            }
            return false; 
        }
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