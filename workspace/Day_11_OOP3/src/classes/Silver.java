package classes;

public class Silver extends Member{ //�ѹ��� �ϳ��� ��ӹ��� �� �ִ�.(C�� ������ ����), �������� ���� �������� ����(����, �� ����, ���� ���� .. ����)

	public Silver() {}
	public Silver(int id, String name, double point) {
		super(id, name, point); //MemberŬ������ �����ڸ� ȣ��. �̺κ��� ��� super();�� �ڵ����� �����
	}
	
	public double getBonus() {
		return this.getPoint()*0.02;
	}// ������ getBonus�� ������ �ȴ�.
}
