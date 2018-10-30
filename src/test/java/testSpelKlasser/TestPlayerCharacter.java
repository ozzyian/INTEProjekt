package testSpelKlasser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import spelKlasser.Difficulty;
import spelKlasser.Item;
import spelKlasser.ItemType;
import spelKlasser.MonsterCharacter;
import spelKlasser.PlayerCharacter;
import org.junit.jupiter.api.Test;

class TestPlayerCharacter {
	PlayerCharacter pc;
	
	@BeforeEach
	void setUp() {
		pc = new PlayerCharacter("player");
	}
	
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
		assertArrayEquals(expected, pc.getOutfit());
		
	}
	
	@Test 
	void testDamageReduction() {
		assertEquals(0, pc.getTotalDamageReduction());
	}
	
	@Test 
	void testVelocityModifier() {
		assertEquals(0, pc.getTotalVelocityModifier());
	}
	@Test
	void testSetTotalVelocityModifier() {
		pc.setTotalVelocityModifier(0.5);
		assertEquals(0.5, pc.getTotalVelocityModifier());
		
	}
	@Test
	void testSetTotalDamageReduction() {
		pc.setTotalDamageReduction(0.5);
		assertEquals(0.5, pc.getTotalDamageReduction());
	}
	
	@Test 
	void testCase1() {
		double[] expected = {0,0}; 
		double[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()};
		assertArrayEquals(expected, actual); 
	}
	
	@Test 
	void testCase2() {
		double[] expected = {0, 1.25};
		Item[] outfit = {new Item(ItemType.BOOTS)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		double[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()};
		assertArrayEquals(expected, actual);
		
	}
	
	@Test 
	void testCase3() {
		double[] expected = {0.8 , 0}; 
		Item[] outfit = {new Item(ItemType.GLOVES)}; 
		pc.setOutfit(outfit);
		pc.calculateValues();
		double[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()}; 
		assertArrayEquals(expected, actual);
	}
	@Test
	void testCase4() {
		double[] expected = {0.8, 1.25};
		Item[] outfit = {new Item(ItemType.GLOVES), new Item(ItemType.BOOTS)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		double[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()};
		assertArrayEquals(expected, actual);
	}
	
	@Test 
	void testCase5(){
		double[] expected = {0.7, 0};
		Item[] outfit = {new Item(ItemType.LEG)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		double[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testCase6() {
		double[] expected = {0.7, 1.2};
		Item[] outfit = {new Item(ItemType.LEG), new Item(ItemType.BOOTS)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		double[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()};
		assertArrayEquals(expected, actual);	
	}
	@Test
	void testCase7() {
		double[] expected = {0.5, 1.2};
		Item[] outfit = {new Item(ItemType.LEG), new Item(ItemType.GLOVES)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		double[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()};
		assertArrayEquals(expected, actual);
	}
	
}
