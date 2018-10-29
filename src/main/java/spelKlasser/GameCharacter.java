package spelKlasser;

public abstract class GameCharacter {

	private int velocity, baseHealth, strength, agility, attackDamage; 
	private double damageReduction, velocityModifier;
	private String name;
	
	public GameCharacter(String name) { 
		velocity = 50; 
		baseHealth = 100;  
		strength = 0;
		agility = 0;
		attackDamage = 0;
		damageReduction = 0;
		velocityModifier = 0; 
		this.name = name;
		
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
	
	public int getAgility() {
		return agility;
	}
	
	public int getStrength() {
		return strength;
	}
	public void increaseAgility() {
		agility=+1;
	}
	public void setBaseHealth(int health) {
		baseHealth = health;
	}
	public void setAttackDamage(int damage) {
		attackDamage = damage;
	}
	public int getAttackDamage() {
		return attackDamage;
	}
	public void damageTaken(GameCharacter attacker) {
		baseHealth =- attacker.getAttackDamage();
	}
	
	public double getDamageReduction() {
		return damageReduction;
	}
	
	public double getVelocityModifier() {
		return velocityModifier;
	}
	
	abstract int getMaxHealth();
	 		
	abstract int getArmor();
	
}
