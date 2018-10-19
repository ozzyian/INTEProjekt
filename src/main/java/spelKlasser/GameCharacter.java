package spelKlasser;

abstract class GameCharacter {

	private int velocity, maxHealth, attribute; 
	private String name; 
	
	public GameCharacter(int attribute, String name) { 
		velocity = 50; 
		maxHealth = 100; 
		this.attribute = attribute; 
		this.name = name;
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
	
	public String getName() {
		return name;
	}
		
	abstract int getArmor();
	
}
