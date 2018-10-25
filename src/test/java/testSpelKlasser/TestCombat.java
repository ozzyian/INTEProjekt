package testSpelKlasser;

import spelKlasser.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TestCombat {
	MonsterCharacter monster;
	PlayerCharacter player;
	Combat c;
 
	
	@Test
	void testPlayerNull() {
		c = new Combat(new PlayerCharacter("testP"), new MonsterCharacter(Difficulty.EASY,"testM"));
		assertNotNull(c.getPlayer());
	}
	@Test
	void testMonsterNull() {
		c = new Combat(new PlayerCharacter("testP"), new MonsterCharacter(Difficulty.EASY,"testM"));
		assertNotNull(c.getMonster());
	}
	@Test
	void testSetAttackOrder() {
		player = new PlayerCharacter("player");
		monster = new MonsterCharacter(Difficulty.EASY, "monster");
		player.increaseAgility();
		c = new Combat(player,monster);
		c.setAttackOrder();
		GameCharacter[] expected = {player, monster};
		assertArrayEquals(expected, c.getAttackOrder());
	}
	@Test
	void testSetFirstAttacker() {
		player = new PlayerCharacter("player");
		monster = new MonsterCharacter(Difficulty.EASY, "monster");
		c = new Combat(player, monster);
		c.setFirstAttacker(monster);
		GameCharacter[] expected = {monster, player};
		assertArrayEquals(expected, c.getAttackOrder());
	}
	
	@Test 
	void testCheckFearlessActivation() {
		
		player = new PlayerCharacter("player"); 
		monster = new MonsterCharacter(Difficulty.EASY, "monster"); 
		c = new Combat(player, monster);
		player.setFearlessActivated(true);
		assertTrue(c.checkFearlessActivation());
	}
	
	@Test 
	void testCase1() {
		
		player = new PlayerCharacter("player"); 
		monster = new MonsterCharacter(Difficulty.EASY, "monster"); 
		c = new Combat(player, monster); 
		player.increaseAgility(); 
		player.setBaseHealth(10);
		player.setFearlessBuff(true);
		player.setFearlessActivated(true);
		player.setAttackDamage(5);
		monster.setBaseHealth(10);
		monster.setAttackDamage(3);
		c.setAttackOrder(); 
		c.startCombat();
		assertEquals(player, c.getWinner());
		
	}
	
	@Test
	void testCase2() {
		player = new PlayerCharacter("player");
		monster = new MonsterCharacter(Difficulty.EASY,"monster");
		c = new Combat(player,monster);
		c.setAttackOrder();
		c.setFirstAttacker(player);
		player.setAttackDamage(1);
		monster.setBaseHealth(1);
		c.startCombat();
		assertSame(player, c.getWinner());
	}
	
	@Test
	void testCase3() {
		player = new PlayerCharacter("player");
		monster = new MonsterCharacter(Difficulty.EASY, "monster");
		c = new Combat(player, monster);
		player.setBaseHealth(2);
		monster.setAttackDamage(1);
		c.setAttackOrder();
		c.setFirstAttacker(monster);
		c.startCombat();
		assertSame(monster, c.getWinner());
	}
	
	
	

}
