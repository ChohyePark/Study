package exam01;
//병렬처리. 동시에 두가지 이상의 코드를 실행하기

class Worker extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("두번째 for: "+i);
		}
	}
}

class Worker2 extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("세번째 for: "+i);
		}
	}
}

public class Main {
	public static void main(String[] args) {
		
//		Thread 적용법
//		1. Thread 클래스를 상속받는 사용자 정의 클래스를 작성
//		2. Thread 클래스로부터 상속받는 public void run 메서드를 overriding 한다.
//		3. 병렬처리하고자 하는 소스코드를 run() 내부에 구현한다.
//		4. 제작완료된 클래스를 인스턴스화 한다.
//		5. 만들어진 인스턴스로부터 start() 메서드를 call 한다. 
//		 --> 이게 main thread가 아닌 새로운 thread에서 run메서드를 실행시킨다.
		
		Worker w = new Worker();
		Worker2 w2 = new Worker2();
		w.start(); //이게 실행되는 순간 multi thread process가 되는 것
		w2.start();
		
		for(int i=0;i<10;i++) {
			System.out.println("첫번째 for: "+i);
		}
		
		

	}

}
