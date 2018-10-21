package testSpelKlasser;
import spelKlasser.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCombat {
	MonsterCharacter monster = new MonsterCharacter(Difficulty.EASY, "monster");
	PlayerCharacter player = new PlayerCharacter("player");
	Combat c = new Combat(player, monster);
	
	@Test
	void testPlayerNull() {
		assertNotNull(c.getPlayer());
	}
	void testMonsterNull() {
		assertNotNull(c.getMonster());
	}
	void testFirstToAttack() {
		assertSame(player, c.firstToAttack());
	}

}
