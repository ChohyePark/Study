import java.util.Scanner;

public class Quiz_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = 0;
		int input = 0;
		while(true) {
		System.out.println("***ATM �ùķ�����***");
		System.out.println("1.�ܾ���ȸ");
		System.out.println("2.�Ա��ϱ�");
		System.out.println("3.����ϱ�");
		System.out.println("4.�����ϱ�");
		System.out.print(">>");
		int i = Integer.parseInt(sc.nextLine());
		
		
		

		switch(i) {

	
		case 1: 
			System.out.println("���� �ܾ��� : " +money);
			
			break;
			
		case 2: 
			System.out.println("�󸶸� �Ա��Ͻðڽ��ϱ�");
			input=Integer.parseInt(sc.nextLine());
			money+=input;
			
			break;
		case 3: 
			System.out.println("�󸶸� ��� �Ͻðڽ��ϱ�");
			input=Integer.parseInt(sc.nextLine());
			if(money<input) {
				System.out.println("�ܾ׺���");
			}else {
				money-=input;
			}
			
			
			
			break;
		case 4: 
			System.out.println("�����ϱ� ����Դϴ�");
			System.exit(0);
			
		default :
			System.out.println("�ٽ� ����ּ���");

		}

		}


	}

}
