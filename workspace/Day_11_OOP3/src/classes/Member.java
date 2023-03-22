package classes;

abstract public class Member { 
	//여러 클래스들의 공통요소만을 묶은 Member 클래스.(상위 클래스, 부모 클래스, Super class)
	//그 아래 Silver, Gold는 하위 또는 자식 클래스, Derived class라 할 수 있음.
	private int id;		
	private String name;
	private double point;
	
	public Member() {}
	public Member(int id, String name, double point) {
		this.id = id;
		this.name = name;
		this.point = point;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	
	abstract public double getBonus(); 
	//모든 하위 클래스에서 implement 하도록 body를 애초에 만들지 않는다.
	//abstract(추상적) 라는 키워드를 추가해야 한다 --> 클래스에도 붙여야 함.
	
}
