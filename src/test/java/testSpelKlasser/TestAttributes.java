package testSpelKlasser;

import static org.junit.jupiter.api.Assertions.*;
import spelKlasser.Attributes; 
import org.junit.jupiter.api.Test;

class TestAttributes {

	Attributes a = new Attributes();
	
	@Test
	void testGetStrength() {
		assertEquals(0, a.getStrength()); 
	}
	
	void testGetAgility() { 
		assertEquals(0, a.getAgility()); 
	}
	
	void testIncreaseStrength() { 
		a.increaseStrength(); 
		assertEquals(1, a.getStrength()); 
	}
	
	void testIncreaseAgility() {
		a.increaseAgility(); 
		assertEquals(1, a.getAgility());
	}

}
