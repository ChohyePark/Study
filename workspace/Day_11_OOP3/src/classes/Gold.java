package classes;

public class Gold extends Member{
	//Member�� ���� ��� ���� ��ӹޱ�(extends) + Gold���� ��ҵ� �߰�
	
	public Gold() {}
	public Gold(int id, String name, double point) {
		super(id,name,point);
	}
	
	public double getBonus() {
		return getPoint()*0.04;
	}
}
