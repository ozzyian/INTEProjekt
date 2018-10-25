package testSpelKlasser;

import spelKlasser.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestCombat {
	MonsterCharacter monster;
	PlayerCharacter player;
	Combat c;
 
	

	
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
	

	
	

}
