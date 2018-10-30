package testSpelKlasser;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.MenuComponent;

import org.junit.jupiter.api.Test;

import spelKlasser.MapBuilder;

class TestMapBuilder {
	MapBuilder mb = new MapBuilder(10, 10);

	@Test
	void testWidth() {
		assertEquals(10, mb.getWidth());
		
	}
	
	@Test
	void testHeight() {
		assertEquals(10, mb.getHeight());
	}
	
	@Test
	void testMapCreation() {
		mb.createRooms();
		assertEquals(true, mb.isMapBuildSuccessful());
	}

}
