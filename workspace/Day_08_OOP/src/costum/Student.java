package costum;

public class Student {

	private String name;
	private int kor;
	private int eng;
	private int math;
	
	// Constructor - ������
	//���� - ������� �ν��Ͻ��� �ʱⰪ�� �����ϱ� ���� �������� ���Ǵ� �޼���
	//������ �޼����� �̸��� Ŭ���� �̸��� ���� �ؾ��Ѵ�.
	// ������ �޼���� ��Ÿ �ٸ� �޼��� ��� �ٸ��� return ���� ���� �� ����.
	// ������ �޼���� �ٸ� �޼����� �ٸ��� method call Ÿ�̹��� ������ �� ����.
	//��Ÿ Ư���� �Ϲ� �޼��� �� �����ϴ�.
	//������ �ʾƵ� ������ �����Ѵ� (Student(){})
	

	
	
	//Default Constructor : �����ڰ� �����ڸ� ������� �ʾ��� ��� , ����Ǿ� ������ �ִ� ������
	//Default Constructor : �������� ����� �����ڿ� ���� ��������.**
	
	public Student(String name,int kor , int eng , int math){
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
		
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSum() {
		return kor+eng+math;
	}
	public double getAvg() {
		return (kor+eng+math)/3.0;
	}

	String name1;
	int kor1;
	int eng1;
	int math1;

	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public int getKor1() {
		return kor1;
	}
	public void setKor1(int kor1) {
		this.kor1 = kor1;
	}
	public int getEng1() {
		return eng1;
	}
	public void setEng1(int eng1) {
		this.eng1 = eng1;
	}
	public int getMath1() {
		return math1;
	}
	public void setMath1(int math1) {
		this.math1 = math1;
	}
	public int getSum1() {
		return kor1+eng1+math1;
	}
	public double getAvg1() {
		return (kor1+eng1+math1)/3.0;
	}
	
}

