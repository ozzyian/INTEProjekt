package spelKlasser;

public class PlayerCharacter extends GameCharacter {
	
	private int experience, level;
	private boolean fearlessBuff, fearlessActivated;
	private boolean[] outfit = new boolean[4];
	
	public PlayerCharacter(String name) { 
		super(name); 
		experience = 0;
		level = 1; 
	}
	
	public int getArmor() {
		return getAgility() *3;
	}
	
	public int getMaxHealth() {
		return getStrength()*3 + getBaseHealth();
	}
	
	public int getDamage() {
		return getStrength()*2; 
	}
	
	public boolean getFearlessBuff() {
		return fearlessBuff;
	}
	
	public boolean getFearlessStatus() {
		return fearlessActivated;
	}
	
	public void setFearlessBuff(boolean present) {
		fearlessBuff = present;
	}
	
	public void setFearlessActivated(boolean activate) {
		fearlessActivated = activate;
	}
	
	public void gainFearlessModifier() {
		setAttackDamage(getAttackDamage() + 10);
	}
	
	public boolean[] getOutfit() {
		return outfit;
	}
	
	public void setOutfit(boolean[] outfit) {
		this.outfit = outfit;
		setVelocityModifier(1.25);
	}
	

}
