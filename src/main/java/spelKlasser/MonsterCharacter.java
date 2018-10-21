package spelKlasser;


public class MonsterCharacter extends GameCharacter{
	
	private Difficulty diff; 
	public MonsterCharacter(Difficulty diff, String name) {
		super(name);
		this.diff = diff;
	}
	
	public int getArmor() {
		if(diff == Difficulty.EASY) {
			return attributes.getAgility();
		}else if(diff == Difficulty.MEDIUM) {
			return getAttribute()*2;
		}else {
			return getAttribute()*3;
		}
	}
	
	public int getMaxHealth() {
		if(diff == Difficulty.EASY) {
			return getAttribute() + getBaseHealth();
		}else if(diff == Difficulty.MEDIUM) {
			return getAttribute()*2 + getBaseHealth();
		}else {
			return getAttribute()*3 + getBaseHealth();
		} 
	}
	
	public int getDamage() {
		if(diff == Difficulty.EASY) {
			return getAttribute();
		}else if(diff == Difficulty.MEDIUM) {
			return getAttribute()*2;
		}else {
			return getAttribute()*3;
		}
	}

}
