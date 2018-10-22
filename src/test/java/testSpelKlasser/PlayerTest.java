package testSpelKlasser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import spelKlasser.Player;

class PlayerTest {
	Player player = new Player();
	@Test
	void healthTest() {
		assertEquals(player.getHealth(), 50);
	}
	
	@Test
	void nameTest() {
		assertEquals(player.getName(), "Player");
	}
	
	@Test
	void experienceTest() {
		assertEquals(player.getExperience(), 0);
	}
	//hej
	@Test
	void levelTest() {
		assertEquals(player.getLevel(), 1);
	}
	
	@Test
	void velocityTest() {
		assertEquals(player.getVelocity(), 0);
	}
	
	@Test
	void attackTest() {
		assertEquals(player.getAttack(), 3);
	}
	
	

}
