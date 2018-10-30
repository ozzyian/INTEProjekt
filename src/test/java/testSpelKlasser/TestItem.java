package testSpelKlasser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import spelKlasser.Item;
import spelKlasser.ItemType;

class TestItem {
	
	Item item = new Item(ItemType.BOOTS);
	@Test
	void testGetItemType() {
		assertEquals(ItemType.BOOTS, item.getItemType());
	}

}
