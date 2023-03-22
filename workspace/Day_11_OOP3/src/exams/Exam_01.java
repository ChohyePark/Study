package exams;

class A{
	public void funcA() {
		System.out.println("A 입니다.");
	}
}
class B extends A{
	public void funcB() {
		System.out.println("B 입니다.");
	}
}
class C extends A{
	
}
public class Exam_01 {
	public static void main(String[] args) {
		
		//다형성
		//여러 형태를 가질 수 있는 성질.
		//클래스 간 상속관계에서 부모클래스 자료형으로 만든 참조변수에게 발현되는 성질.
		//상위클래스 참조변수는 하위클래스 인스턴스의 주소를 저장할 수 있다.
		
		A a = new A(); 
		A b = new B(); //Upcasting
		A c = new C();
		
		b.funcA();
		((B)b).funcB(); //B형으로 casting한 후엔 사용가능(상속된 경우에) --> Downcasting
		//다만, B가 A를 overriding한 경우에는 downcasting 하지 않아도 됨.
		
		B d = new B(); 
	}
}
