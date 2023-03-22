package exams;
//����! override, abstract, implement, ������

abstract class Animal{
	abstract public void sound();
}

class Dog extends Animal{
	public void sound() {
		System.out.println("�۸�");
	}

}
class Cat extends Animal{
	public void sound() {
		System.out.println("�߿�"); 
	}
}
class Crow extends Animal{
	public void sound() {
		System.out.println("���");
	}
}

class Exam_02 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Animal cat = new Cat();
		Crow crow = new Crow();
		dog.sound();
		cat.sound(); //cat. --> Animal�� instance�� ���´�.
		crow.sound();
		((Cat)cat).sound();//Cat�� instance�� ��������� Downcasting �ʿ�.
		
		Animal[] anis = new Animal[3];
		//�̷� �迭�� �Է������� �߻�ȭ ���ϰ� ���� �޼��尡 �ԷµǾ� �־��ٸ� Downcasting�� �ſ� ������ �������. 
		
	}

}
