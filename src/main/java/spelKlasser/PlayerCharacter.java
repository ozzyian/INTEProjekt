package spelKlasser;

public class PlayerCharacter extends GameCharacter {
	
	private int experience, level;
	
	public PlayerCharacter(int velocity, int maxHealth, int attribute, int armor, int experience, int level) { 
		super(velocity, maxHealth, attribute, armor); 
		this.experience = experience;
		this.level = level; 
	}
	
}
