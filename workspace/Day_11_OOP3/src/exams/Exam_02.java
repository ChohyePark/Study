package exams;
//복습! override, abstract, implement, 다형성

abstract class Animal{
	abstract public void sound();
}

class Dog extends Animal{
	public void sound() {
		System.out.println("멍멍");
	}

}
class Cat extends Animal{
	public void sound() {
		System.out.println("야옹"); 
	}
}
class Crow extends Animal{
	public void sound() {
		System.out.println("까악");
	}
}

class Exam_02 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Animal cat = new Cat();
		Crow crow = new Crow();
		dog.sound();
		cat.sound(); //cat. --> Animal의 instance만 나온다.
		crow.sound();
		((Cat)cat).sound();//Cat의 instance를 쓰고싶으면 Downcasting 필요.
		
		Animal[] anis = new Animal[3];
		//이런 배열에 입력했을때 추상화 안하고 각각 메서드가 입력되어 있었다면 Downcasting이 매우 귀찮고 어려워짐. 
		
	}

}
