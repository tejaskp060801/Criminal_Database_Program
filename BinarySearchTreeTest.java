import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;
public class BinarySearchTreeTest {
    private BinarySearchTree <Integer> user; 
    private String username = "hehe";
    private String password = "guess123";
    private String firstname = "tejas";
    private String lastname = "padmanabhan";
    private int clearancelevel = 1;
    private UUID id;
    @BeforeEach
    public void reset() {
        user = new BinarySearchTree<Integer>();
    }
    @Test
	void testAddElement() {
        boolean isAdded = false; 
        int heh = 5; 
        user.addElement(heh);
        if(user.search(heh) == true) {
            isAdded = true; 
        }
        assertTrue(isAdded); 
	}

    @Test
	void testRemoveElement() {
        boolean isRemoved = false; 
        int heh = 6; 
        user.addElement(heh);
        user.removeElement(heh);
        if(user.search(heh) == false) {
            isRemoved = true;  
        }
        assertTrue(isRemoved);
    }

    @Test
    void testsearch() {
        boolean searchfor = false; 
        int heh = 7; 
        user.addElement(heh);
        user.search(heh);
        if(user.search(heh) == true) {
            searchfor = true; 
        }
        assertTrue(searchfor);
	}

    @Test
    void testgetTrue() {
        boolean searchfor = false; 
        int heh = 7; 
        user.addElement(heh);
        user.get(heh);
        if(user.search(heh) == true) {
            searchfor = true; 
        }
        assertTrue(searchfor);
	}    
}
