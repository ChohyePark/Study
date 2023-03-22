package quiz;
//+를 출력하는 PlusThread
//-를 출력하는 MinusThread
//*를 출력하는 MplyThread
//를 각각 생성하여 100개씩 기호를 동시에 출력하게 만들어보자.
//출력은 가로방향으로. ----***++--**--+++*------++*** 이런 식

class PlusThread extends Thread{
	public void run() {
		for(int i=0;i<100;i++) {
		System.out.print("+");
		}
	}
}
class MinusThread extends Thread{
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.print("-");
		}
	}
}
class MplyThread extends Thread{
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.print("*");
		}
	}
}


public class Main {
	public static void main(String[] args) {
		
		PlusThread plus = new PlusThread();
		MinusThread minus = new MinusThread();
		MplyThread mply = new MplyThread();
		
		plus.start();
		minus.start();
		mply.start();
		
	}

}
