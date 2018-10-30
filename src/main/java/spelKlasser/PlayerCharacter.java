package spelKlasser;

import java.util.HashMap;
import java.util.Map;

public class PlayerCharacter extends GameCharacter {
	
	private int experience, level;
	private boolean fearlessBuff, fearlessActivated, fleeingStatus;
	private Map<ItemType,Item> outfit = new HashMap<ItemType, Item>();
	
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

	public void setFleeingStatus(boolean flee) {
		fleeingStatus = flee;
	}
	public boolean getFleeingStatus() {
		return fleeingStatus;
	}
	
	public Item[] getOutfit() {
		Item[] arrayOutfit = new Item[outfit.size()]; 
		int i = 0;
		for(Map.Entry<ItemType, Item> mapValue: outfit.entrySet()) {
			Item item = mapValue.getValue(); 
			arrayOutfit[i] = item;
			i++;
		}
		
		return arrayOutfit;
	}
	public void setOutfit(Item[] items) {
		outfit.clear();
		for(int i=0; i<items.length; i++) {
			Item item = items[i];
			outfit.put(item.getItemType(), item);
		}
	}

	
	public void calculateValues() {
		boolean specialCaseTwoItemsOne = outfit.size() == 2 && outfit.containsKey(ItemType.LEG) && outfit.containsKey(ItemType.BOOTS);
		boolean specialCaseThreeItemsOne = outfit.size() == 3 && outfit.containsKey(ItemType.LEG) && outfit.containsKey(ItemType.GLOVES) && outfit.containsKey(ItemType.BOOTS);
		
		double tempDmgReduc = 0;
		if(specialCaseTwoItemsOne) {
			setTotalVelocityModifier(1.2);
			setTotalDamageReduction(0.7);
		}else if(specialCaseThreeItemsOne) {
			setTotalVelocityModifier(1.2);
			setTotalDamageReduction(0.5);
			
		}else {
		
			for(Map.Entry<ItemType, Item> i : outfit.entrySet()) {
				Item item = i.getValue();
				switch(item.getItemType()) {
				case CHEST: 
					tempDmgReduc += 0.50;
					break;
				case LEG: 
					tempDmgReduc += 0.30;
					break;
				case GLOVES: 
					tempDmgReduc += 0.20;
					break;
				case BOOTS: 
					setTotalVelocityModifier(1.25);
					break;
				
				}
				
				if(tempDmgReduc!=0) {
					setTotalDamageReduction(1-tempDmgReduc);
				}
			
			
			}
		
		
		
		
		}
	}
	



}
