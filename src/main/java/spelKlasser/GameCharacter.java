package spelKlasser;

abstract class GameCharacter {

	private int velocity, maxHealth, attribute, armor; 
	
	public GameCharacter(int attribute) { 
		velocity = 50; 
		maxHealth = 100; 
		this.attribute = attribute; 
		armor = 10;
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
	
	abstract void setArmor();
	
}
