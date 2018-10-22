package spelKlasser;

import java.util.Random;

public class Combat {
	private PlayerCharacter player;
	private MonsterCharacter monster;
	private boolean setFirstMonster;
	
	
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
	
	public GameCharacter firstToAttack() {
		if (player.getAgility()>monster.getAgility()) {
			return player;
		}
		else if(monster.getAgility()> player.getAgility()) {
			return monster;
		}
		else {
			return randomFirstAttack();
		}

	}
	private GameCharacter randomFirstAttack() {
		Random random = new Random();
		if(setFirstMonster) {
			return monster;
		}
		else if(random.nextBoolean()) {
			return player;
		}
		else {
			return monster;
		}
	}
	
	public void setFirstAttacker() {
		setFirstMonster=true;
	}
	

}
