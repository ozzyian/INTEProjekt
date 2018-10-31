package spelKlasser;

import static org.junit.jupiter.api.Assumptions.assumingThat;

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
	
	public int getLevel() {
		return level;
	}
	
	public void increaseExperience(int experience) {
		this.experience += experience;
		int experienceCap = (100 * this.getLevel());
		if (this.experience >= experienceCap) {
			this.level++; 
			this.experience -= experienceCap;
		}
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
		boolean specialCaseTwoItemsTwo = outfit.size() == 2 && outfit.containsKey(ItemType.CHEST) && outfit.containsKey(ItemType.BOOTS); 
		boolean specialCaseThreeItemsTwo = outfit.size() == 3 && outfit.containsKey(ItemType.CHEST) && outfit.containsKey(ItemType.GLOVES) && outfit.containsKey(ItemType.BOOTS);
		boolean specialCaseThreeItemsThree = outfit.size() == 3 && outfit.containsKey(ItemType.CHEST) && outfit.containsKey(ItemType.LEG) && outfit.containsKey(ItemType.BOOTS);
		boolean specialCaseThreeItemsFour = outfit.size() == 3 && outfit.containsKey(ItemType.CHEST) && outfit.containsKey(ItemType.LEG) && outfit.containsKey(ItemType.GLOVES);
		boolean specialCaseFourItemsOne = outfit.size() == 4 && outfit.containsKey(ItemType.CHEST) && outfit.containsKey(ItemType.LEG) && outfit.containsKey(ItemType.BOOTS) && outfit.containsKey(ItemType.GLOVES);

		
		int tempDmgReduc = 0;
		
		if(specialCaseTwoItemsOne) {
			setModifiers(120, 70);

		}else if(specialCaseThreeItemsOne || specialCaseTwoItemsTwo) {
			setModifiers(120, 50);
		
		}else if(specialCaseThreeItemsTwo) {
			setModifiers(115, 30);
			
		}else if(specialCaseThreeItemsThree) {
			setModifiers(115, 20);
			
		}else if(specialCaseThreeItemsFour) {
			setModifiers(0, 10);
			
		}else if(specialCaseFourItemsOne) {
			setModifiers(105, 10);
		}
		else {
		
			for(Map.Entry<ItemType, Item> i : outfit.entrySet()) {
				Item item = i.getValue();
				switch(item.getItemType()) {
				case CHEST: 
					tempDmgReduc += 50;
					break;
				case LEG: 
					tempDmgReduc += 30;
					break;
				case GLOVES: 
					tempDmgReduc += 20;
					break;
				case BOOTS: 
					setTotalVelocityModifier(125);
					break;
				
				}
				
				if(tempDmgReduc!=0) {
					setTotalDamageReduction(100-tempDmgReduc);
				}
			
			
			}
		
		
		
		
		}
	}
	



}
