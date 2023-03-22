
public class Exam_04 {

	public static void main(String[] args) {
			
		int a = 50;
		int b = 40;
		
		System.out.println(a + " : "+ b);
		
		int tmp; // 값교환을 위한 임시 변수
		
		tmp = a;
		a=b;
		b=tmp;
		//swap 기법
		
		
		System.out.println(a + " : "+ b);
	}

}
