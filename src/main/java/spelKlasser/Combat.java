package spelKlasser;

import java.util.Random;

public class Combat {
	private PlayerCharacter player;
	private MonsterCharacter monster;
	private GameCharacter[] attackOrder;
	private GameCharacter winner;
	private GameCharacter receiver;
	private GameCharacter attacker;


	
	
	public Combat(PlayerCharacter player, MonsterCharacter monster) {
		if (player.getAttackDamage() == 0 && monster.getAttackDamage() == 0) {
			throw new IllegalArgumentException();
		}
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

		GameCharacter temp;
		receiver = attackOrder[1];
		attacker = attackOrder[0];
		
		while(true) {
			receiver.damageTaken(attacker);
			if (receiver.isDead()) {
				break;
			}
			if (receiver instanceof PlayerCharacter && receiver.getBaseHealth()<10 && receiver.getBaseHealth()>0){

				if(player.getFearlessBuff()) {
					if(!player.getFearlessStatus()) {
						player.gainFearlessModifier();
					}
				}else {
					player.setFleeingStatus(true);
					break;
				}
			}
			
			temp = receiver;
			receiver = attacker;
			attacker = temp;

			
		}
		if (player.isDead() || player.getFleeingStatus()) {
			winner = monster;
		}
		else {
			winner = player;
		}
		
	}
	
	public GameCharacter getWinner() {
		if (winner==null) {
			throw new NullPointerException();
		}
		return winner;
	}
	
	public GameCharacter[] getAttackOrder() {
		return attackOrder;
	}

	


}
