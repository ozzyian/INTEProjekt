package testSpelKlasser;

import static org.junit.jupiter.api.Assertions.*;

import spelKlasser.Difficulty;
import spelKlasser.Effect;
import spelKlasser.Item;
import spelKlasser.ItemType;
import spelKlasser.MonsterCharacter;
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
	@Test 
	void testSetAttackDamage() {
		pc.setAttackDamage(2);
		assertEquals(2, pc.getAttackDamage());
	}
	@Test
	void testDamageTaken() {
		MonsterCharacter monster = new MonsterCharacter(Difficulty.EASY, "monster");
		monster.setAttackDamage(1);
		pc.damageTaken(monster);
		assertEquals(99, pc.getBaseHealth());
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
	
	@Test
	void testGetBaseHealth() {
		pc.setBaseHealth(2);
		assertEquals(2, pc.getBaseHealth());
	}
	
	@Test 
	void testFearlessBuff() {
		assertFalse(pc.getFearlessBuff());
	}
	
	@Test 
	void testSetFearlessBuff() {
		pc.setFearlessBuff(true); 
		assertTrue(pc.getFearlessBuff()); 
	}
	
	@Test 
	void testGetFearlessStatus() { 
		pc.setFearlessActivated(true);
		assertTrue(pc.getFearlessStatus());
	}
	
	@Test 
	void testGainFearlessModifier() {
		pc.gainFearlessModifier();
		assertEquals(10, pc.getAttackDamage());
	}
	
	@Test
	void testGetOutfit() {
		Item[] expected = new Item[0];
		expected = pc.getOutfit();
		assertArrayEquals(expected, pc.getOutfit());
		
	}
	
	@Test 
	void testDamageReduction() {
		assertEquals(0, pc.getDamageReduction());
	}
	
	@Test 
	void testVelocityModifier() {
		assertEquals(0, pc.getVelocityModifier());
	}
	
	@Test 
	void testCase1() {
		double[] expected = {0,0}; 
		double[] actual = {pc.getDamageReduction(), pc.getVelocityModifier()};
		assertArrayEquals(expected, actual); 
	}
	
	@Test 
	void testCase2() {
		double[] expected = {0, 1.25};
		Item[] outfit = {new Item(ItemType.BOOTS)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		double[] actual = {pc.getDamageReduction(), pc.getVelocityModifier()};
		assertArrayEquals(expected, actual);
		
	}
	
//	@Test 
//	void testCase3() {
//		double[] expected = {0.8 , 0}; 
//		boolean[] outfit = {false, false, true, false}; 
//		pc.setOutfit(outfit);
//		double[] actual = {pc.getDamageReduction(), pc.getVelocityModifier()}; 
//		assertArrayEquals(expected, actual);
//	}
	
	
}
