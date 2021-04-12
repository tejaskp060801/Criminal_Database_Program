import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;

public class UserSearchTreeTest {
    private UserSearchTree people = UserSearchTree.getUserSearchTree(); 
    private BinarySearchTree <LawEnforcementUser> users;
    String username = "hehe"; 
    String password = "123"; 
    private String firstname = "tejas";
    private String lastname = "padmanabhan";
    private int clearancelevel = 1;
    private UUID id;
    @BeforeEach
    public void reset() {
        people = UserSearchTree.getUserSearchTree(); 
        users = new BinarySearchTree<LawEnforcementUser>();
    }

    @Test
	void testLogin() {
        people.addUser(username, password, firstname, lastname, clearancelevel); 
        boolean test = people.Login("hehe", "123");
        assertEquals(test, true); 
    }

    @Test
	void testAddUser() {
        boolean isAdded = false;
        LawEnforcementUser user = new LawEnforcementUser(username, password, firstname, lastname, clearancelevel, id); 
        users.addElement(user);
        if(users.search(user) == true) {
            isAdded = true; 
        }
        assertTrue(isAdded); 
    }

    @Test
	void testSearchUser() {
        boolean searchfor = false; 
        LawEnforcementUser user = new LawEnforcementUser(username, password, firstname, lastname, clearancelevel, id);
        users.addElement(user);
        users.search(user);
        if(users.search(user) == true) {
            searchfor = true; 
        }
        assertTrue(searchfor);
    }
}
