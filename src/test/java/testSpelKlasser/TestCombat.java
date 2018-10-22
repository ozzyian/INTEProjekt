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
		assertNotNull(c.getPlayer());
	}
	@Test
	void testMonsterNull() {
		assertNotNull(c.getMonster());
	}
	@Test
	void testFirstToAttackPlayer(PlayerCharacter p) {
		assertSame(p, c.firstToAttack());
	}
	
	@Test
	void testFirstToAttackMonster(MonsterCharacter m) {
		assertSame(m, c.firstToAttack());
	}
	@Test
	void testCase3() {
		player = new PlayerCharacter("player");
		monster = new MonsterCharacter(Difficulty.EASY, "monster");
		c = new Combat(player, monster);
		c.setFirstAttacker();
		testFirstToAttackMonster(monster);
		
	}
	
	
	

}
