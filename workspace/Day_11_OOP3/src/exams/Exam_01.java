package exams;

class A{
	public void funcA() {
		System.out.println("A �Դϴ�.");
	}
}
class B extends A{
	public void funcB() {
		System.out.println("B �Դϴ�.");
	}
}
class C extends A{
	
}
public class Exam_01 {
	public static void main(String[] args) {
		
		//������
		//���� ���¸� ���� �� �ִ� ����.
		//Ŭ���� �� ��Ӱ��迡�� �θ�Ŭ���� �ڷ������� ���� ������������ �����Ǵ� ����.
		//����Ŭ���� ���������� ����Ŭ���� �ν��Ͻ��� �ּҸ� ������ �� �ִ�.
		
		A a = new A(); 
		A b = new B(); //Upcasting
		A c = new C();
		
		b.funcA();
		((B)b).funcB(); //B������ casting�� �Ŀ� ��밡��(��ӵ� ��쿡) --> Downcasting
		//�ٸ�, B�� A�� overriding�� ��쿡�� downcasting ���� �ʾƵ� ��.
		
		B d = new B(); 
	}
}
