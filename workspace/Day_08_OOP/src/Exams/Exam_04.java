package Exams;

import costum.Temp;

public class Exam_04 {
	public static void main(String[] args) {
		
		Temp t1 = new Temp();
		Temp t2 = new Temp ();
		
		t1.a=10;
		t2.a=20;
		
		System.out.println(t1.a);
		System.out.println(t2.a);
		
		Temp.b=30;
		System.out.println(Temp.b);								//static 요소들은 클래스명. 붙여 사용
		
		
		//지역변수 -> stack메모리
		//매개변수 -> stack메모리
		//멤버변수 -> heap메모리
		//정적변수 -> data메모리
	}
}
