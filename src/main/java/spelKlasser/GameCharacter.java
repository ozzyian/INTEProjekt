package spelKlasser;

abstract class GameCharacter {

	private int velocity, baseHealth, strength, agility; 
	private String name; 
	
	
	public GameCharacter(String name) { 
		velocity = 50; 
		baseHealth = 100;  
		strength = 0;
		agility = 0;
		this.name = name;
		;
	}
	
	public int getVelocity() { 
		return velocity; 
	} 
	
	public int getBaseHealth() {
		return baseHealth;
	}
	
	public String getName() {
		return name;
	}

	abstract int getMaxHealth();
	 		
	abstract int getArmor();
	
}
