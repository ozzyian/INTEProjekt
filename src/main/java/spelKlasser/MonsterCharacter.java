package spelKlasser;


public class MonsterCharacter extends GameCharacter{
	
	private Difficulty diff; 
	public MonsterCharacter(Difficulty diff, String name) {
		super(name);
		this.diff = diff;
	}
	
	public int getArmor() {
		if(diff == Difficulty.EASY) {
			return getAgility();
		}else if(diff == Difficulty.MEDIUM) {
			return getAgility()*2;
		}else {
			return getAgility()*3;
		}
	}
	
	public int getMaxHealth() {
		if(diff == Difficulty.EASY) {
			return getStrength() + getBaseHealth();
		}else if(diff == Difficulty.MEDIUM) {
			return getStrength()*2 + getBaseHealth();
		}else {
			return getStrength()*3 + getBaseHealth();
		} 
	}
	

	
	public Difficulty getMonsterDifficulty() {
		return diff;
	}

}
