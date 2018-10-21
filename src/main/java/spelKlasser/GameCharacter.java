package spelKlasser;

abstract class GameCharacter {

	private int velocity, baseHealth, attribute; 
	private String name; 
	
	public GameCharacter(int attribute, String name) { 
		velocity = 50; 
		baseHealth = 100; 
		this.attribute = attribute; 
		this.name = name;
	}
	
	public int getVelocity() { 
		return velocity; 
	} 
	
	public int getBaseHealth() {
		return baseHealth;
	}
	
	public int getAttribute() {
		return attribute; 
	}
	
	public String getName() {
		return name;
	}
	
	abstract int getMaxHealth();
	 		
	abstract int getArmor();
	
}
