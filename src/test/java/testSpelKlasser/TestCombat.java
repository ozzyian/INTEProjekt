package testSpelKlasser;
import spelKlasser.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;



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
	void testFirstToAttackPlayer() {
		assertSame(player, c.firstToAttack());
	}
	@Test
	void testFirstToAttackMonster() {
		assertSame(monster, c.firstToAttack());
	}
	@Test
	void testCase3() {
		player = new PlayerCharacter("player");
		monster = new MonsterCharacter(Difficulty.EASY, "monster");
		c = new Combat(player, monster);
		c.setFirstAttacker();
		player.setHealth(2);
		
	}
	
	
	

}