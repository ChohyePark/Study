package exam03;
//10�� �ȿ� ���õ� �޼����� �Է��ϵ��� �ϴ� ����!
import javax.swing.JOptionPane;

class Countdown extends Thread{
	
	public static int i=10;
	public static int score=0;
	
	public void run() {
		for( i=10;i>0;i--) {
			System.out.println(i);
			score++;
			try {
				Thread.sleep(2000);//1�ʰ� thread ����
			}catch(Exception e) {}
		}
		System.out.println("Game Over");
		System.out.println("��ƾ �ð�: "+score+"��");
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
