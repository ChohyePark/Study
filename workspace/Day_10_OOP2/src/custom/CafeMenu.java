package custom;

public class CafeMenu {

	private String name;
	private int price;
	
	public CafeMenu() {} //default constructor ���� ��������
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
		System.out.println("<�޴� ����>");
		System.out.println("�޴���: "+name);
		System.out.println("����: "+price);
	}

}
