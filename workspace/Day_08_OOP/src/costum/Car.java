package costum;

public class Car {
	
	//this : 자기 참조 변수 - 클래스를 바탕으로 인스턴스가 생성되면, 클래스 내부에서 인스턴스 주소를 알수 있게 
	//자바에 의해 미리 준비된 멤버필드 즉 this 는 클래스 내부 멤버필드를뜻함
	
	// get set 자동 생성 alt+ s r a r

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
		
	
	

