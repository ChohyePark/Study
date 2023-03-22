package Exams;
import java.util.Scanner;

import costum.TV;

public class Exam_01 {

	public static void main(String[] args) {
		//void = 리턴값을 신경 쓸필요없다
//		TV samsung;           //현실에서 투영화 할 물체를 지정하고 class설계도를 작성후 new 작성시 램세상에 투영     
//		new TV();      //객체(instance)  TV(instance)를 생성한다  힙 메모리에 생성되고 new 값에 주소가 리턴됨
		
		TV samsung = new TV();
		
	//	samsung.                       // .을 찍으면 주소로 찾아가겠다
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String str1= "Apple";
		String str2= new String("Apple");
		
		System.out.println("Apple" == "Apple");
		System.out.println("Apple" == "str1");
		System.out.println("Apple" == "str2");
		
	}

}
