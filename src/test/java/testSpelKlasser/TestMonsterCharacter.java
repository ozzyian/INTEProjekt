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
	
	@Test
	void testGetMaxHealthEasy() {
		assertEquals(100, mc.getMaxHealth());
		int[] expected = {100, 0};
		int[] actual = {mc.getMaxHealth(), mc.getArmor()};
		assertArrayEquals(expected, actual);
	}
	@Test 
	void testGetMaxHealthMedium() {
		mc = new MonsterCharacter(Difficulty.MEDIUM, "Devil"); 
		mc.increaseAgility();
		int[] expected = {100, 2};
		int[] actual = {mc.getMaxHealth(), mc.getArmor()};
		assertArrayEquals(expected, actual);
	}
	@Test 
	void testGetMaxHealthHard() {
		mc = new MonsterCharacter(Difficulty.HARD, "Devil"); 
		mc.increaseAgility();
		int[] expected = {100, 3};
		int[] actual = {mc.getMaxHealth(), mc.getArmor()};
		assertArrayEquals(expected, actual);
		
	}
	
	
	@Test
	void testgetMonsterDifficulty() {
		mc = new MonsterCharacter(Difficulty.MEDIUM, "monster");
		assertEquals(Difficulty.MEDIUM, mc.getMonsterDifficulty());
	}

	
	

}
