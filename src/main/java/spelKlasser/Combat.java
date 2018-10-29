package spelKlasser;

import java.util.Random;

public class Combat {
	private PlayerCharacter player;
	private MonsterCharacter monster;
	private GameCharacter[] attackOrder;
	private GameCharacter winner;
	private GameCharacter reciever;
	private GameCharacter attacker;


	
	
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
		PlayerCharacter tempPlayer; 
		GameCharacter temp;
		reciever = attackOrder[1];
		attacker = attackOrder[0];
		while(reciever.getBaseHealth()>0) {
			reciever.damageTaken(attacker);
			temp = reciever;
			reciever = attacker;
			attacker = temp;
			if(reciever instanceof PlayerCharacter && reciever.getBaseHealth()<10 && reciever.getBaseHealth()>0) {
                tempPlayer = (PlayerCharacter)reciever;
                if(tempPlayer.getFearlessBuff() && !checkFearlessActivation()) {
                	tempPlayer.setFearlessActivated(true);
                	tempPlayer.gainFearlessModifier();
                }
                
            }
			

			
		}
		if (player.getBaseHealth()<=0) {
			winner = monster;
		}
		else {
			winner = player;
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
