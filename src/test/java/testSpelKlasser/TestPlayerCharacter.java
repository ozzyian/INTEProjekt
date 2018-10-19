package testSpelKlasser;

import static org.junit.jupiter.api.Assertions.*;
import spelKlasser.PlayerCharacter;
import org.junit.jupiter.api.Test;

class TestPlayerCharacter {
	PlayerCharacter pc = new PlayerCharacter(10);
	
	@Test
	void testSetArmor() {
		assertEquals(30, pc.getArmor());
	}

}
