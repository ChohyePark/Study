package costum;

public class Car {
	
	//this : �ڱ� ���� ���� - Ŭ������ �������� �ν��Ͻ��� �����Ǹ�, Ŭ���� ���ο��� �ν��Ͻ� �ּҸ� �˼� �ְ� 
	//�ڹٿ� ���� �̸� �غ�� ����ʵ� �� this �� Ŭ���� ���� ����ʵ带����
	
	// get set �ڵ� ���� alt+ s r a r

	private String model;
	private String color;	//heap
	private int price;
	
	public Car() {}
	public Car(String model,String color, int price) {
			this.model =model;
			this.color =color;
			this.price =price;
			
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
		
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	




	




}
		
	
	

