import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;
class LawEnforcementUserTest {
    private String username = "hehe";
    private String password = "guess123";
    private String firstname = "tejas";
    private String lastname = "padmanabhan";
    private int clearancelevel = 1;
    private UUID id;
    private LawEnforcementUser user = new LawEnforcementUser(username, password, firstname, lastname, clearancelevel, id); 

    @Test
	void testPasswordCorrect() {
		boolean correct = user.passwordCorrect("guess123"); 
        assertTrue(correct); 
	}

    @Test
	void testCompareToASimilarUser() { //only thing different is the ID
        LawEnforcementUser user1 = new LawEnforcementUser(username, password, firstname, lastname, clearancelevel, id);
		int checker = user.compareTo(user1); 
        assertNotEquals(user,user1); 
	}

    @Test
    void testCompareToIdenticalUser() { 
		int checker = user.compareTo(user); 
        assertEquals(user,user); 
	}



}