package spelKlasser;

public class Attributes {

		int strength, agility;
		
		public Attributes() {
			strength = 0; 
			agility = 0;
		}
		public int getStrength() {
			return strength; 
		}
		
		public int getAgility() {
			return agility; 
		}
		
		public void increaseStrength() {
			strength+=1; 
		}
		
		public void increaseAgility() {
			agility+=1;
		}
}
