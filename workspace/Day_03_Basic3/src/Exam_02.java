
public class Exam_02 {

	public static void main(String[] args) {
		
		int i = 49; // 초기값 지정
		
		while( i < 100 )/*조건문*/ { 
			if (i % 2 == 0) {
				
				i++;
				System.out.println(" i = " + i);
				
			}else {
				i++;
			}
//			i++; // 증감문
//			System.out.println(i);
		}
	}

}
