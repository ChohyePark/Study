package custom;
//Player를 super클래스로 하는 하위 직업 클래스를 추가해도 좋을 듯!
import java.util.ArrayList;

public class Player {
	private String name;
	private int level=1;
	private int hp=100;
	private int hpVolume=100;
	private int exp=0;
	private int expVolume=10;
	private int STR=0;
	private int DEX=0;
	private ArrayList<Item> equipment;
	private ArrayList<Item> inventory;
	private int money=0;
	
	public void showInfo() { //현재 상태 출력(능력치, 착용아이템, 보유아이템)
		System.out.println("-------------------");
		System.out.println("이름: "+name);
		System.out.println("레벨: "+level);
		System.out.println("HP: "+hp+"/"+hpVolume);
		System.out.println("STR: "+STR);
		System.out.println("DEX: "+DEX);
		System.out.println("경험치: "+exp+"/"+expVolume);
		System.out.println("골드: "+money);
		System.out.println("-------------------");
		System.out.println("<착용중인 장비>");
		for(Item item:equipment) {
			System.out.print(item+". ");
		}
		System.out.println("<보유 아이템>");
		for(Item item:inventory) {
			System.out.println(item+". ");
		}
		System.out.println("-------------------");
	}
	
	public void attack() {//전투(플레이어 턴)
		
	}
	
	public void expUp() { //몬스터의 레벨에 따른 경험치 획득
		
	}
	
	public void levelUp(int expDrop){ //레벨업 시 능력치 향상(체력 초기화), expVolume 증가
		
	}
	
	public void rest() {
		hp=hpVolume;
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
	public int getHpVolume() {
		return hpVolume;
	}
	public void setHpVolume(int hpVolume) {
		this.hpVolume = hpVolume;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getExpVolume() {
		return expVolume;
	}
	public void setExpVolume(int expVolume) {
		this.expVolume = expVolume;
	}
	public int getSTR() {
		return STR;
	}
	public void setSTR(int sTR) {
		STR = sTR;
	}
	public int getDEX() {
		return DEX;
	}
	public void setDEX(int dEX) {
		DEX = dEX;
	}
	public ArrayList<Item> getEquipment() {
		return equipment;
	}
	public void setEquipment(ArrayList<Item> equipment) {
		this.equipment = equipment;
	}
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
}
