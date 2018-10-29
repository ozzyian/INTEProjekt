package spelKlasser;

import java.util.HashMap;
import java.util.Map;

public class PlayerCharacter extends GameCharacter {
	
	private int experience, level;
	private boolean fearlessBuff, fearlessActivated;
	private Map<ItemType,Item> outfit = new HashMap<ItemType, Item>();
	
	public PlayerCharacter(String name) { 
		super(name); 
		experience = 0;
		level = 1; 
	}
	
	public int getArmor() {
		return getAgility() *3;
	}
	
	public int getMaxHealth() {
		return getStrength()*3 + getBaseHealth();
	}
	
	public int getDamage() {
		return getStrength()*2; 
	}
	
	public boolean getFearlessBuff() {
		return fearlessBuff;
	}
	
	public boolean getFearlessStatus() {
		return fearlessActivated;
	}
	
	public void setFearlessBuff(boolean present) {
		fearlessBuff = present;
	}
	
	public void setFearlessActivated(boolean activate) {
		fearlessActivated = activate;
	}
	
	public void gainFearlessModifier() {
		setAttackDamage(getAttackDamage() + 10);
	}
	
	public Item[] getOutfit() {
		Item[] arrayOutfit = new Item[outfit.size()]; 
		int i = 0;
		for(Map.Entry<ItemType, Item> mapValue: outfit.entrySet()) {
			Item item = mapValue.getValue(); 
			arrayOutfit[i] = item;
			i++;
		}
		
		return arrayOutfit;
	}
	public void setOutfit() {
	
	}
	
	

}
