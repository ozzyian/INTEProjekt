package spelKlasser;

import java.util.Random;

public class Combat {
	private PlayerCharacter player;
	private MonsterCharacter monster;
	private boolean setFirstMonster;
	private GameCharacter[] attackOrder;
	private GameCharacter winner;
	
	
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
	
	public GameCharacter[] firstToAttack() {
		
		if (player.getAgility()>monster.getAgility()) {
			return attackOrder = new GameCharacter[] {player, monster};
		}
		else if(monster.getAgility()> player.getAgility()) {
			return attackOrder = new GameCharacter[] {monster, player};
		}
		else {
			return randomFirstAttack();
		}

	}
	private GameCharacter[] randomFirstAttack() {
		Random random = new Random();
		if(setFirstMonster) {
			return attackOrder = new GameCharacter[] {monster, player};
		}
		else if(random.nextBoolean()) {
			return attackOrder = new GameCharacter[] {player, monster};
		}
		else {
			return attackOrder = new GameCharacter[] {monster, player};
		}
	}
	
	public void setFirstAttacker() {
		setFirstMonster=true;
	}
	
	public GameCharacter getWinner() {
		while(attackOrder[1].getBaseHealth()>0 || attackOrder[0].getBaseHealth()>0) {
			attackOrder[1].damageTaken(attackOrder[0]);
			attackOrder[0].damageTaken(attackOrder[1]);
		}
		if (attackOrder[0].getBaseHealth()<=0) {
			return attackOrder[1];
		}
		else {
			return attackOrder[0];
		}
		
		
		
		
	}
	
	

}
