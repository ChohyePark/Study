
public class Exam_02 {

	public static void main(String[] args) {

		//난수 예제
		
		double rand = Math.random(); // 0 ~ 1.0사이의 실수를 무작위로 생성
		System.out.println((int)(rand*10));  //난수 0 ~ 9 까지를 출력하는 코드
		
		System.out.println((int)(rand * 6)+1); // 주사위 1 ~ 6
		
		//37 ~ 52 사이의 난수를 출력하려면?
		//난수 범위 공식
		//구하고자 하는 난수의 최소값 X
		//구하고자 하는 난수의 최대값 Y
		//(Y-X+1)+X
		// rand * (52-37+1)+37
		
		
	}

}
