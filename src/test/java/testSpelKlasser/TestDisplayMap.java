package testSpelKlasser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import spelKlasser.DisplayMap;

class TestDisplayMap {

	@Test
	void testMainExecution() {
		DisplayMap dm = new DisplayMap();
		assertEquals(2500, dm.getDisplayNumber());
	}

}
