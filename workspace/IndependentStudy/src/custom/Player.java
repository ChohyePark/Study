package custom;
//Player�� superŬ������ �ϴ� ���� ���� Ŭ������ �߰��ص� ���� ��!
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
	
	public void showInfo() { //���� ���� ���(�ɷ�ġ, ���������, ����������)
		System.out.println("-------------------");
		System.out.println("�̸�: "+name);
		System.out.println("����: "+level);
		System.out.println("HP: "+hp+"/"+hpVolume);
		System.out.println("STR: "+STR);
		System.out.println("DEX: "+DEX);
		System.out.println("����ġ: "+exp+"/"+expVolume);
		System.out.println("���: "+money);
		System.out.println("-------------------");
		System.out.println("<�������� ���>");
		for(Item item:equipment) {
			System.out.print(item+". ");
		}
		System.out.println("<���� ������>");
		for(Item item:inventory) {
			System.out.println(item+". ");
		}
		System.out.println("-------------------");
	}
	
	public void attack() {//����(�÷��̾� ��)
		
	}
	
	public void expUp() { //������ ������ ���� ����ġ ȹ��
		
	}
	
	public void levelUp(int expDrop){ //������ �� �ɷ�ġ ���(ü�� �ʱ�ȭ), expVolume ����
		
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
