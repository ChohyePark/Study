package custom;

public class Item {
	//가죽(돌)-뼈-사슬-철-다이아 (각각 레벨 제한)
	private String name;
	private int price;
	private int upHpVolume;
	private int upSTR;
	private int upDEX;
	
	public void upgrade(Item item) {
		upHpVolume+=5;
		upSTR+=3;
		upDEX+=1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getUpHpVolume() {
		return upHpVolume;
	}
	public void setUpHpVolume(int upHpVolume) {
		this.upHpVolume = upHpVolume;
	}
	public int getUpSTR() {
		return upSTR;
	}
	public void setUpSTR(int upSTR) {
		this.upSTR = upSTR;
	}
	public int getUpDEX() {
		return upDEX;
	}
	public void setUpDEX(int upDEX) {
		this.upDEX = upDEX;
	}
	
	
	
}
