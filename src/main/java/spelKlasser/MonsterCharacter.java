package spelKlasser;


public class MonsterCharacter extends GameCharacter{
	
	private Difficulty diff; 
	public MonsterCharacter(int attribute,Difficulty diff) {
		super(attribute);
		this.diff = diff;
	}
	
	public int getArmor() {
		return 11;
	}

}
