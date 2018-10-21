package testSpelKlasser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCombat {
	
	
	Combat c = new Combat(player, monster);
	@Test
	void testPlayerNull() {
		assertNotNull("inte null", c.player);
	}

}
