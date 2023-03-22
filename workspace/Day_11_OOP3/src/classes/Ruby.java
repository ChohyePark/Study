package classes;

public class Ruby extends Member{
	//이렇게만 쓰면 Ruby등급을 하나 손쉽게 추가할 수 있게된다.
	public Ruby() {}
	public Ruby(int id, String name, double point) {
		super(id,name,point);
	}

	public double getBonus() {
		return this.getPoint()*0.05;
	}
}
