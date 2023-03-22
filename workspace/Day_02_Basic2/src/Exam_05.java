
public class Exam_05 {

	public static void main(String[] args) {
		
		int      a       =          10        ;
//	   (자료형)  (변수) (대입연산자) (literal 값)
		
		// 대입 연산자 규칙1. 우항이 좌항으로 대입된다. (예외없음)
		// 대입 연산자 규칙2. 그러므로 좌항은 반드시 공간이어야만 한다. (변수)
		
		// A+=B
		// int A = 10; int B = 20;
		// A = A + B; , A+=B; 같은것
		// A = 10 + 20;
		
		// A++; // 후치형
		// ++A; // 전치형
		
		int A = 10; int B = 20;
		System.out.println("A : " + ++A);
		System.out.println("B : " + B);
		
		System.out.println("========================================");
		
		// 관계연산자
		// A == B : A 값이 B 값과 같다.
		// A != B : A 값이 B 값과 같지 않다.
		// A < B  : A 값이 B 값보다 작다.
		// A > B  : A 값이 B 값보다 크다.
		// A <= B : A 값이 B 값보다 작거나 같다.
		// A >= B : A 값이 B 값보다 크거나 같다.
		System.out.println(A == B);
		System.out.println(A != B);
		System.out.println(A < B);
		System.out.println(A > B);
		System.out.println(A <= B);
		System.out.println(A >= B);
		
		System.out.println("========================================");
		
		// 논리연산자
		// A && B : A 와 B 둘다 true 일때만 true
	    //          하나라도 false 면 false
		
		// A || B : A 나 B 둘중 하나라도 true 이면 true
		//          둘 다 false 면 false
		
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(false && false);
		
		System.out.println("========================================");

		System.out.println(true || true);
		System.out.println(true || false);
		System.out.println(false || true);
		System.out.println(false || false);
		
		System.out.println("========================================");
		
		System.out.println(!(A == B));
	}

}
