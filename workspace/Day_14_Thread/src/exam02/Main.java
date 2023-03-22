package exam02;
//target�� ��� ������Ű�� thread, ���ҽ�Ű�� thread�� ���ÿ� ����

class TargetPlus extends Thread{
	public void run() {
		while(true) {
			Main.target++; //Static�� ������ ����ϴ� ���. Ŭ���� �̸��� ����������(.)�� ���δ�.
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
	
	public static int target = 0;//�� �������� target�̶�� ������ ����� �� �ֵ��� Static�ϰ� �����Ѵ�.
	
	public static void main(String[] args) {

		
		new TargetPlus().start();
		new TargetMinus().start();
		

		while(true) {
			System.out.println(target);
		}
	}
}
