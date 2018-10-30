package testSpelKlasser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import spelKlasser.GameMap;
import spelKlasser.Tile;

class TestGameMap {
	Tile[][] tiles = new Tile[1][1];
	GameMap gm = new GameMap(tiles);
	
	@Test
	void testWidth() {
		assertEquals(1, gm.getWidth());
	}
	
	@Test
	void testHeight() {
		assertEquals(1, gm.getHeight());
	}
	
	@Test
	void testOutOfBounds() {
		assertEquals(Tile.OUTOFBOUNDS, gm.tile(-1, -1));
	}
	
	@Test
	void testGlyph() {
		Tile tile = gm.tile(-1, -1);
		assertEquals('X', tile.getGlyph());
	}
}
