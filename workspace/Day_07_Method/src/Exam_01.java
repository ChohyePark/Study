
public class Exam_01 {
		// 메서드 기준 우측은 매개변수구  좌측은 리턴데이터타입(돌려보낼 자료형)
	
	public static int plus(int num1 ,int num2){    //<-메서드 프로토타입
		return num1+num2;         ////Method 정의부(Definition)    
	}
	
	public static void main(String[] args) {
		//System.out.println(plus(10,5)); // 메서드 호출부
		int result = plus(11,5);
		System.out.println(result);
		//plus method 에 전달하는 10과 5를 인자,인수값 (parameter,argument) 이라고 부른다.
		//메서드에 전달되어지는 값을 받는 변수를 매개변수라고 부른다.
		//return 값은 콜 된 지점으로 돌아감
		
		
		
	}
}
