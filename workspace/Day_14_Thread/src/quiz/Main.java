package quiz;
//+�� ����ϴ� PlusThread
//-�� ����ϴ� MinusThread
//*�� ����ϴ� MplyThread
//�� ���� �����Ͽ� 100���� ��ȣ�� ���ÿ� ����ϰ� ������.
//����� ���ι�������. ----***++--**--+++*------++*** �̷� ��

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
