package spelKlasser;


public class PlayerCharacter extends GameCharacter {
	
	private int experience, level;
	
	public PlayerCharacter(int attribute, String name) { 
		super(attribute, name); 
		experience = 0;
		level = 1; 
	}
	
	public int getArmor() {
		return getAttribute() *3;
	}
	
	public int getMaxHealth() {
		return 1;
	}
	
}
