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
		reciever = attackOrder[1];
		attacker = attackOrder[0];
		
		while(true) {
			reciever.damageTaken(attacker);
			if (reciever.isDead()) {
				break;
			}
			if (reciever instanceof PlayerCharacter && reciever.getBaseHealth()<10 && reciever.getBaseHealth()>0){

				if(player.getFearlessBuff()) {
					if(!player.getFearlessStatus()) {
						player.gainFearlessModifier();
					}
				}else {
					player.setFleeingStatus(true);
					break;
				}
			}
			
			temp = reciever;
			reciever = attacker;
			attacker = temp;

			
		}
		if (player.isDead() || player.getFleeingStatus()) {
			winner = monster;
		}
		else {
			increaseExperience(monster, player);
			winner = player;
		}
		
	}
	
	public void increaseExperience(MonsterCharacter monster, PlayerCharacter player) {
		if (monster.getMonsterDifficulty() == Difficulty.EASY) {
			player.increaseExperience(100);
		} else if (monster.getMonsterDifficulty() == Difficulty.MEDIUM) {
			player.increaseExperience(150);
		} else if (monster.getMonsterDifficulty() == Difficulty.HARD) {
			player.increaseExperience(200);
		} else {
			return; 
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
