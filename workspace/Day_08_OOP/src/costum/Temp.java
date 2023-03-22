package costum;

public class Temp {
	public int a;				// Instance Member field 인스턴스가 존재해야 a도 존재
	public static int b;		// Class Member field	인스턴스가 존재하지 않아도 b는 존재 static 이 붙으면 정적 변수
								// main 이 만들어짐 과 동시에 생성
	public void func1() {
		
	}
	
	public static void func2() {     //static 요소에서 none static 요소 사용불가능
		 
	}
}

