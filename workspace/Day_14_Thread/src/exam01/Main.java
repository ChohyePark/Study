package exam01;
//����ó��. ���ÿ� �ΰ��� �̻��� �ڵ带 �����ϱ�

class Worker extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("�ι�° for: "+i);
		}
	}
}

class Worker2 extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("����° for: "+i);
		}
	}
}

public class Main {
	public static void main(String[] args) {
		
//		Thread �����
//		1. Thread Ŭ������ ��ӹ޴� ����� ���� Ŭ������ �ۼ�
//		2. Thread Ŭ�����κ��� ��ӹ޴� public void run �޼��带 overriding �Ѵ�.
//		3. ����ó���ϰ��� �ϴ� �ҽ��ڵ带 run() ���ο� �����Ѵ�.
//		4. ���ۿϷ�� Ŭ������ �ν��Ͻ�ȭ �Ѵ�.
//		5. ������� �ν��Ͻ��κ��� start() �޼��带 call �Ѵ�. 
//		 --> �̰� main thread�� �ƴ� ���ο� thread���� run�޼��带 �����Ų��.
		
		Worker w = new Worker();
		Worker2 w2 = new Worker2();
		w.start(); //�̰� ����Ǵ� ���� multi thread process�� �Ǵ� ��
		w2.start();
		
		for(int i=0;i<10;i++) {
			System.out.println("ù��° for: "+i);
		}
		
		

	}

}
