package spelKlasser;

abstract class GameCharacter {

	private int velocity, maxHealth, attribute; 
	
	public GameCharacter(int attribute) { 
		velocity = 50; 
		maxHealth = 100; 
		this.attribute = attribute; 
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
		
	abstract int getArmor();
	
}
