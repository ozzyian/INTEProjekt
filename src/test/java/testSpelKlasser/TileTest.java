package testSpelKlasser;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import spelKlasser.Tile;

class TileTest {

	@Test
	void colorTest() {
		assertEquals(Tile.FLOOR.getColor(), Color.black);
	}
	
	@Test
	void glyphTest() {
		assertEquals(Tile.FLOOR.getGlyph(), '.');
	}

}
