package testSpelKlasser;

import spelKlasser.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestCombat {
	MonsterCharacter monster;
	PlayerCharacter player;
	Combat c;
	
	
	@BeforeEach
	void setUp() {
		player = new PlayerCharacter("player");
		monster = new MonsterCharacter(Difficulty.EASY, "monster");
		c = new Combat(player,monster);
	}
	@Test
	void testPlayerNull() {
		assertNotNull(c.getPlayer());
	}
	@Test
	void testMonsterNull() {
		assertNotNull(c.getMonster());
	}
	@Test
	void testSetAttackOrder() {
		player.increaseAgility();
		c.setAttackOrder();
		GameCharacter[] expected = {player, monster};
		assertArrayEquals(expected, c.getAttackOrder());
	}
	@Test
	void testSetFirstAttacker() {
		c.setFirstAttacker(monster);
		GameCharacter[] expected = {monster, player};
		assertArrayEquals(expected, c.getAttackOrder());
	}

	
	@Test 
	void testCheckFearlessActivation() {
		player.setFearlessActivated(true);
		assertTrue(c.checkFearlessActivation());
	}
	
	@Test 
	void testCase1() {
		player.increaseAgility(); 
		player.setBaseHealth(10);
		monster.setBaseHealth(10);
		monster.setAttackDamage(3);
		player.setFearlessBuff(true);
		player.setFearlessActivated(true);
		c.setAttackOrder(); 
		c.startCombat();
		assertEquals(monster, c.getWinner());
		
	}
	
	@Test
	void testCase2() {
		c.setAttackOrder();
		c.setFirstAttacker(player);
		player.setAttackDamage(1);
		monster.setBaseHealth(2);
		c.startCombat();
		assertSame(player, c.getWinner());
	}
	
	@Test
	void testCase3() {
		player.setBaseHealth(1);
		monster.setAttackDamage(1);
		c.setAttackOrder();
		c.setFirstAttacker(monster);
		c.startCombat();
		assertSame(monster, c.getWinner());
	}
	
	@Test
	void testCase4() {
		player.setBaseHealth(10);
		monster.setAttackDamage(1);
		monster.increaseAgility();
		c.setAttackOrder();
		c.startCombat();
		assertEquals(monster, c.getWinner());

	}
	

	@Test
    void testCase5() {
        player.setBaseHealth(2);
        player.setAttackDamage(1);
        player.setFearlessBuff(true);
        monster.setAttackDamage(1);
        monster.setBaseHealth(1);
        monster.increaseAgility();
        c.setAttackOrder();
        c.startCombat();
        assertEquals(player, c.getWinner());
    }
	

}
