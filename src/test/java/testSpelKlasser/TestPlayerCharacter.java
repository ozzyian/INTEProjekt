package testSpelKlasser;

import static org.junit.jupiter.api.Assertions.*;
import spelKlasser.PlayerCharacter;
import org.junit.jupiter.api.Test;

class TestPlayerCharacter {
	PlayerCharacter pc = new PlayerCharacter("Hulken");
	
	@Test
	void testGetArmor() {
		assertEquals(0, pc.getArmor());
	}
	
	@Test
	void testSetBaseHealth() {
		pc.setBaseHealth(2);
		assertEquals(2,pc.getBaseHealth());
	}
	@Test void testSetAttackDamage() {
		pc.setAttackDamage(2);
		assertEquals(2, pc.getAttackDamage());
	}
	
	void testGetDamage() {
		assertEquals(20, pc.getDamage());
	}
	
	void testGetMaxHealth() {
		assertEquals(130, pc.getMaxHealth());
	}

	void testGetStrength() {
		assertEquals(0, pc.getStrength()); 
	}
	
	void testGetAgility() { 
		assertEquals(0, pc.getAgility()); 
	}
	
}
