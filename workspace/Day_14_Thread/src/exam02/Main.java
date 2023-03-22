package exam02;
//target을 계속 증가시키는 thread, 감소시키는 thread를 동시에 가동

class TargetPlus extends Thread{
	public void run() {
		while(true) {
			Main.target++; //Static한 변수를 사용하는 방법. 클래스 이름에 참조연산자(.)를 붙인다.
		}
	}
}
class TargetMinus extends Thread{
	public void run() {
		while(true) {
			Main.target--;
		}
	}
}

public class Main {
	
	public static int target = 0;//전 영역에서 target이라는 변수를 사용할 수 있도록 Static하게 선언한다.
	
	public static void main(String[] args) {

		
		new TargetPlus().start();
		new TargetMinus().start();
		

		while(true) {
			System.out.println(target);
		}
	}
}
