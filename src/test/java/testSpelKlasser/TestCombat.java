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
		GameCharacter[] expected = {player, monster};
		assertArrayEquals(expected, c.setAttackOrder());
	}
	
	@Test
	void testCase3() {
		player = new PlayerCharacter("player");
		monster = new MonsterCharacter(Difficulty.EASY, "monster");
		c = new Combat(player, monster);
		c.setFirstAttacker();
		player.setBaseHealth(2);
		monster.setAttackDamage(1);
		c.setAttackOrder();
		c.startCombat();
		assertSame(monster, c.winner);
	}
	
	
	

}
