package testSpelKlasser;

import static org.junit.jupiter.api.Assertions.*;
import spelKlasser.MonsterCharacter;
import org.junit.jupiter.api.Test;

import spelKlasser.Difficulty;

class TestMonsterCharacter {
	MonsterCharacter mc = new MonsterCharacter(Difficulty.EASY, "Devil"); 
	
	@Test
	void testGetArmor() {
		assertEquals(0, mc.getArmor());
	}
	
	void testGetDamage() {
		assertEquals(0, mc.getDamage()); 
	}
	
	void testGetMaxHealth() {
		assertEquals(110, mc.getMaxHealth());
	}
	
	

}
