package exam03;
//10초 안에 제시된 메세지를 입력하도록 하는 게임!
import javax.swing.JOptionPane;

class Countdown extends Thread{
	
	public static int i=10;
	public static int score=0;
	
	public void run() {
		for( i=10;i>0;i--) {
			System.out.println(i);
			score++;
			try {
				Thread.sleep(2000);//1초간 thread 정지
			}catch(Exception e) {}
		}
		System.out.println("Game Over");
		System.out.println("버틴 시간: "+score+"초");
		System.exit(0);
	}
}

public class Main {
	public static void main(String[] args) throws Exception {

		String[] quizs = new String[] {
				"public static void main(String[] ar)"
				,"Scanner sc = new Scanner(System.in)"
				,"DataOutputStream dos = new DataOutputStream(os)"};
		
		new Countdown().start();

		while(true) {
			int index = (int)(Math.random()*3);
			String msg = JOptionPane.showInputDialog(quizs[index]);

			if(msg.equals(quizs[index])) {
				System.out.println("Success! time +5");
				Countdown.i+=5;
			}
			else {
				System.out.println("Wrong Answer! time -3");
				Countdown.i-=3;
			}
		}
	}
}
