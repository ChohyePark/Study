package classes;

public class Gold extends Member{
	//Member가 가진 모든 것을 상속받기(extends) + Gold만의 요소도 추가
	
	public Gold() {}
	public Gold(int id, String name, double point) {
		super(id,name,point);
	}
	
	public double getBonus() {
		return getPoint()*0.04;
	}
}
