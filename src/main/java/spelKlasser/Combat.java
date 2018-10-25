package spelKlasser;

import java.util.Random;

public class Combat {
	private PlayerCharacter player;
	private MonsterCharacter monster;
	private GameCharacter[] attackOrder;
	private GameCharacter winner;
	private boolean healthCheckFearlessSecondAttacker = attackOrder[1].getBaseHealth()<10 && attackOrder[1].getBaseHealth()>0 && attackOrder[1] instanceof PlayerCharacter; 
	private boolean healthCheckFearlessFirstAttacker = attackOrder[0].getBaseHealth()<10 && attackOrder[0].getBaseHealth()>0 && attackOrder[0] instanceof PlayerCharacter;
	
	
	public Combat(PlayerCharacter player, MonsterCharacter monster) {
		this.player = player;
		this.monster = monster;
		
	}
	
	public PlayerCharacter getPlayer() {
		return player;
	}
	public MonsterCharacter getMonster() {
		return monster;
	}
	
	public void setAttackOrder() {
		
		if (player.getAgility()>monster.getAgility()) {
			attackOrder = new GameCharacter[] {player, monster};
		}
		else if(monster.getAgility()> player.getAgility()) {
			attackOrder = new GameCharacter[] {monster, player};
		}
		else {
			attackOrder = randomFirstAttack();
		}

	}
	private GameCharacter[] randomFirstAttack() {
		Random random = new Random();

		if(random.nextBoolean()) {
			return attackOrder = new GameCharacter[] {player, monster};
		}
		else {
			return attackOrder = new GameCharacter[] {monster, player};
		}
	}
	
	public void setFirstAttacker(GameCharacter firstAttacker) {
		if(firstAttacker instanceof PlayerCharacter) {
			attackOrder = new GameCharacter[] {player, monster};
		}
		else  {
			attackOrder = new GameCharacter[] {monster, player};
		}
	}
	
	public void startCombat() {
		while(attackOrder[0].getBaseHealth()>0) {
			
			attackOrder[1].damageTaken(attackOrder[0]);
//			if(healthCheckFearlessSecondAttacker) {
//				PlayerCharacter playerTwo = (PlayerCharacter) attackOrder[1];
//				if(playerTwo.getFearlessBuff()) {
//					if(!playerTwo.getFearlessStatus()) {
//						playerTwo.setFearlessActivated(true);
//						playerTwo.gainFearlessModifier();
//					}
//				}else {
//					break;
//				}
//			}
			
			if(attackOrder[1].getBaseHealth()<=0) {
				break;
			}
			
			attackOrder[0].damageTaken(attackOrder[1]);
//			if(healthCheckFearlessFirstAttacker) {
//				PlayerCharacter playerOne = (PlayerCharacter) attackOrder[1];
//				if(playerOne.getFearlessBuff()) {
//					if(!playerOne.getFearlessStatus()) {
//						playerOne.setFearlessActivated(true);
//						playerOne.gainFearlessModifier();
//					}
//				}else {
//					break;
//				}
//			}
		}
		
		if (attackOrder[0].getBaseHealth()<=0) {
			winner = attackOrder[1];
		}
		else {
			winner = attackOrder[0];
		}
		
		
		
	}
	
	public GameCharacter getWinner() {
		return winner;
	}
	
	public GameCharacter[] getAttackOrder() {
		return attackOrder;
	}

	
	public boolean checkFearlessActivation() {
		return player.getFearlessStatus();
	}


}
