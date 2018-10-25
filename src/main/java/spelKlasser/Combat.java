package spelKlasser;

import java.util.Random;

public class Combat {
	private PlayerCharacter player;
	private MonsterCharacter monster;
	//private GameCharacter firstAttacker;
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
			if(attackOrder[1].getBaseHealth()<=0)
				break;
			attackOrder[0].damageTaken(attackOrder[1]);
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


}
