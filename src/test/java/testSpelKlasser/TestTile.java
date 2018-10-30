package testSpelKlasser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import spelKlasser.Tile;

public class TestTile {
	@Test 
	void glyphTest() {
		assertEquals('.', Tile.FLOOR.getGlyph());
	}
}
