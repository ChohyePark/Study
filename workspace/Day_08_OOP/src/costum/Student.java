package costum;

public class Student {

	private String name;
	private int kor;
	private int eng;
	private int math;
	
	// Constructor - 생성자
	//목적 - 만들어진 인스턴스에 초기값을 세팅하기 위한 목적으로 사용되는 메서드
	//생성자 메서드의 이름은 클래스 이름과 동일 해야한다.
	// 생성자 메서드는 여타 다른 메서드 들과 다르게 return 값을 가질 수 없다.
	// 생성자 메서드는 다른 메서드들과 다르게 method call 타이밍을 선택할 수 없다.
	//기타 특성은 일반 메서드 와 동일하다.
	//만들지 않아도 무조건 존재한다 (Student(){})
	

	
	
	//Default Constructor : 개발자가 생성자를 명시하지 않았을 경우 , 내장되어 숨겨져 있는 생성자
	//Default Constructor : 개발자의 명시적 생성자에 의해 지워진다.**
	
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

