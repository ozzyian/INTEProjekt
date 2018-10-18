package spelKlasser;

public class GameCharacter {
	private int velocity, maxHealth, attribute, armor; 
	
	public GameCharacter(int velocity, int maxHealth, int attribute, int armor) { 
		this.velocity = velocity; 
		this.maxHealth = maxHealth; 
		this.attribute = attribute; 
		this.armor = armor;
	}
	
	public int getVelocity() { 
		return velocity; 
	} 
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public int getAttribute() {
		return attribute; 
	}
	
	public int getArmor() {
		return armor;
	}
	
	
}
