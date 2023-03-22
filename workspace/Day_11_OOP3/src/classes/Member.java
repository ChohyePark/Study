package classes;

abstract public class Member { 
	//���� Ŭ�������� �����Ҹ��� ���� Member Ŭ����.(���� Ŭ����, �θ� Ŭ����, Super class)
	//�� �Ʒ� Silver, Gold�� ���� �Ǵ� �ڽ� Ŭ����, Derived class�� �� �� ����.
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
	//��� ���� Ŭ�������� implement �ϵ��� body�� ���ʿ� ������ �ʴ´�.
	//abstract(�߻���) ��� Ű���带 �߰��ؾ� �Ѵ� --> Ŭ�������� �ٿ��� ��.
	
}
