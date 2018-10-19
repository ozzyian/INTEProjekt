package testSpelKlasser;

import static org.junit.jupiter.api.Assertions.*;
import spelKlasser.MonsterCharacter;
import org.junit.jupiter.api.Test;

import spelKlasser.Difficulty;

class TestMonsterCharacter {
	MonsterCharacter mc = new MonsterCharacter(10, Difficulty.EASY, "Devil"); 
	
	@Test
	void testGetArmor() {
		assertEquals(10, mc.getArmor());
	}

}
