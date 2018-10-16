package spelKlasser;

public class Player {
	private int health, experience, level, attack, velocity;
	private String name;
	
	public Player() {
		this.name = "Player";
		this.health = 50;
		this.experience = 0;
		this.level = 1; 
		this.attack = 3;
		this.velocity = 0;
	}
	
	public int getHealth() {return health;}
	public int getExperience(){return experience; }
	public int getLevel() {return level; }
	public int getAttack() {return attack;}
	public int getVelocity() {return velocity;}
	public String getName() {return name; }
	
}
