package spelKlasser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerCharacter extends GameCharacter {
	
	private int experience, level;
	
	public PlayerCharacter(String name) { 
		super(name); 
		experience = 0;
		level = 1; 
	}
	
	public int getArmor() {
		return getAttribute() *3;
	}
	
	public int getMaxHealth() {
		return getAttribute()*3 + getBaseHealth();
	}
	
	public int getDamage() {
		return getAttribute()*2; 
	}
	
}
