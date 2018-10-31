package testSpelKlasser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import spelKlasser.Combat;
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
	void testGetName() {
		assertEquals("player", pc.getName());
	}
	@Test
	void testGetVelocity() {
		assertEquals(50, pc.getVelocity());
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
	
	@Test
	void testGetMaxHealth() {
		assertEquals(100, pc.getMaxHealth());
	}
	@Test
	void testGetStrength() {
		assertEquals(0, pc.getStrength()); 
	}
	@Test
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
		
		Item[] expected = {new Item(ItemType.BOOTS)};
		pc.setOutfit(expected);
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
		pc.setTotalVelocityModifier(50);
		assertEquals(50, pc.getTotalVelocityModifier());
		
	}
	@Test
	void testSetTotalDamageReduction() {
		pc.setTotalDamageReduction(50);
		assertEquals(50, pc.getTotalDamageReduction());
	}
	
	@Test 
	void testCase1() {
		int[] expected = {0,0}; 
		int[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()};
		assertArrayEquals(expected, actual); 
	}
	
	@Test 
	void testCase2() {
		int[] expected = {0, 125};
		Item[] outfit = {new Item(ItemType.BOOTS)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		int[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()};
		assertArrayEquals(expected, actual);
		
	}
	
	@Test 
	void testCase3() {
		int[] expected = {80 , 0}; 
		Item[] outfit = {new Item(ItemType.GLOVES)}; 
		pc.setOutfit(outfit);
		pc.calculateValues();
		int[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()}; 
		assertArrayEquals(expected, actual);
	}
	@Test
	void testCase4() {
		int[] expected = {80, 125};
		Item[] outfit = {new Item(ItemType.GLOVES), new Item(ItemType.BOOTS)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		int[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()};
		assertArrayEquals(expected, actual);
	}
	
	@Test 
	void testCase5(){
		int[] expected = {70, 0};
		Item[] outfit = {new Item(ItemType.LEG)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		int[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testCase6() {
		int[] expected = {70, 120};
		Item[] outfit = {new Item(ItemType.LEG), new Item(ItemType.BOOTS)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		int[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()};
		assertArrayEquals(expected, actual);	
	}
	@Test
	void testCase7() {
		int[] expected = {50, 0};
		Item[] outfit = {new Item(ItemType.LEG), new Item(ItemType.GLOVES)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		int[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()};
		assertArrayEquals(expected, actual);
	}
	
	@Test 
	void testCase8() {
		int[] expected = {50, 120}; 
		Item[] outfit = {new Item(ItemType.LEG), new Item(ItemType.GLOVES), new Item(ItemType.BOOTS)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		int[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()}; 
		assertArrayEquals(expected, actual); 
	}
	
	@Test
	void testCase9() {
		int[] expected = {50, 0}; 
		Item[] outfit = {new Item(ItemType.CHEST)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		int[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()}; 
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testCase10() {
		int[] expected = {50, 120};
		Item[] outfit = {new Item(ItemType.CHEST), new Item(ItemType.BOOTS)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		int[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()}; 
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testCase11() {
		int[] expected = {30, 0};
		Item[] outfit = {new Item(ItemType.CHEST), new Item(ItemType.GLOVES)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		int[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testCase12() {
		int[] expected = {30, 115};
		Item[] outfit = {new Item(ItemType.CHEST), new Item(ItemType.GLOVES), new Item(ItemType.BOOTS)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		int[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testCase13() {
		int[] expected = {20, 0};
		Item[] outfit = {new Item(ItemType.CHEST), new Item(ItemType.LEG)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		int[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testCase14() {
		int[] expected = {20, 115};
		Item[] outfit = {new Item(ItemType.CHEST), new Item(ItemType.LEG), new Item(ItemType.BOOTS)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		int[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testCase15() {
		int[] expected = {10, 0};
		Item[] outfit = {new Item(ItemType.CHEST), new Item(ItemType.LEG), new Item(ItemType.GLOVES)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		int[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testCase16() {
		int[] expected = {10, 105};
		Item[] outfit = {new Item(ItemType.CHEST), new Item(ItemType.LEG), new Item(ItemType.GLOVES), new Item(ItemType.BOOTS)};
		pc.setOutfit(outfit);
		pc.calculateValues();
		int[] actual = {pc.getTotalDamageReduction(), pc.getTotalVelocityModifier()};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testLevel() {
		pc.increaseExperience(100);
		assertEquals(2, pc.getLevel());
	}
	
	@Test
	void testLeveling() {
		MonsterCharacter monster = new MonsterCharacter(Difficulty.EASY, "monster");
		PlayerCharacter player = new PlayerCharacter("player");
		player.setAttackDamage(2);
		monster.setBaseHealth(2);
		Combat combat = new Combat(player, monster);
		player.increaseAgility();
		combat.setAttackOrder();
		combat.startCombat();
		assertEquals(2, player.getLevel());
	}
}


