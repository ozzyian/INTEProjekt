package spelKlasser;

public class Item {
	private double damageReduction, velocityModifier; 
	private ItemType type;
	public Item(ItemType type) {
		this.type = type; 
		switch(type) {
		case CHEST: 
			damageReduction = 0.50;
			velocityModifier = 0;
			break;
		case LEG: 
			damageReduction = 0.70;
			velocityModifier = 0;
			break;
		case GLOVES: 
			damageReduction = 0.80;
			velocityModifier = 0;
			break;
		case BOOTS: 
			damageReduction = 0; 
			velocityModifier = 1.25;
			break;
			
		}
	}
	
	public double getDamageReduction() {
		return damageReduction;
	}
	
	public double getVelocityModifier() {
		return velocityModifier;
	}
	
	
}
