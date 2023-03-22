
public class Exam_04 {

	public static void main(String[] args) {
		
		int i1 = 10;
		int i2 = 20;
		float f1 = 3.14f;
		char c1 = 'A';
		char c2 = 'B';
		

		System.out.println("결과 : " + i1 + i2);      //결과 : 1020
		System.out.println("결과 : " + (i1 + i2));    //결과 : 30
		System.out.println("결과 : " + i1 + f1);      //결과 : 103.14
		System.out.println("결과 : " + (i1 + f1));    //결과 : 13.14
		System.out.println("결과 : " + f1 + c1);      //결과 : 3.14A
		System.out.println("결과 : " + (f1 + c1));    //결과 : 68.14
		System.out.println("결과 : " + c1 + c2 );     //결과 : AB
		System.out.println("결과 : " + (c1 + c2));    //결과 : 131
	}

}
