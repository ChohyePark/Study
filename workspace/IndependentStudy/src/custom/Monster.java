package custom;

public class Monster {
	private String name;
	private int level;
	private int hp;
	private int attack;
	private int defense;
	private int DEX;
	private int dropMoney;
	private int dropExp;
	
	public void attack() {//전투(몬스터 턴)
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getDEX() {
		return DEX;
	}
	public void setDEX(int dEX) {
		DEX = dEX;
	}
	public int getDropMoney() {
		return dropMoney;
	}
	public void setDropMoney(int dropMoney) {
		this.dropMoney = dropMoney;
	}
	public int getDropExp() {
		return dropExp;
	}
	public void setDropExp(int dropExp) {
		this.dropExp = dropExp;
	}
	
	

}
