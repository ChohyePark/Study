package classes;

public class Ruby extends Member{
	//�̷��Ը� ���� Ruby����� �ϳ� �ս��� �߰��� �� �ְԵȴ�.
	public Ruby() {}
	public Ruby(int id, String name, double point) {
		super(id,name,point);
	}

	public double getBonus() {
		return this.getPoint()*0.05;
	}
}
