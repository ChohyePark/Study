package custom;

public class CafeMenu {

	private String name;
	private int price;
	
	public CafeMenu() {} //default constructor 생성 잊지말기
	public CafeMenu(String name, int price) {
		this.name = name;
		this.price = price;
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
	
	public void showInfo() {
		System.out.println("<메뉴 정보>");
		System.out.println("메뉴명: "+name);
		System.out.println("가격: "+price);
	}

}
