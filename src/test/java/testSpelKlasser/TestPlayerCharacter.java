package testSpelKlasser;

import static org.junit.jupiter.api.Assertions.*;
import spelKlasser.PlayerCharacter;
import org.junit.jupiter.api.Test;

class TestPlayerCharacter {
	PlayerCharacter pc = new PlayerCharacter("Hulken");
	
	@Test
	void testGetArmor() {
		assertEquals(30, pc.getArmor());
	}
	
	void testGetDamage() {
		assertEquals(20, pc.getDamage());
	}
	
	void testGetMaxHealth() {
		assertEquals(130, pc.getMaxHealth());
	}

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
