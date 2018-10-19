package spelKlasser;


public class PlayerCharacter extends GameCharacter {
	
	private int experience, level;
	
	public PlayerCharacter(int attribute) { 
		super(attribute); 
		experience = 0;
		level = 1; 
	}
	
	public void setArmor() {
		int attribute = getAttribute();
		
	}
	
}
