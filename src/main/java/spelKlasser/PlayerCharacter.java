package spelKlasser;


public class PlayerCharacter extends GameCharacter {
	
	private int experience, level;
	
	public PlayerCharacter(int attribute) { 
		super(attribute); 
		experience = 0;
		level = 1; 
	}
	
	public int getArmor() {
		return 11;
		
	
	}
	
}
