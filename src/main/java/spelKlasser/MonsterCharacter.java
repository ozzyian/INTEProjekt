package spelKlasser;


public class MonsterCharacter extends GameCharacter{
	
	private Difficulty diff; 
	public MonsterCharacter(int attribute,Difficulty diff, String name) {
		super(attribute, name);
		this.diff = diff;
	}
	
	public int getArmor() {
		if(diff == Difficulty.EASY) {
			return getAttribute();
		}else if(diff == Difficulty.MEDIUM) {
			return getAttribute()*2;
		}else {
			return getAttribute()*3;
		}
	}

}
