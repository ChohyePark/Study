import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int money = 0;
		int menu = 0;

		while(true) {
		
			try {
				System.out.println("***ATM �ùķ�����****");
				System.out.println("1.�ܾ���ȸ");
				System.out.println("2.�Ա��ϱ�");
				System.out.println("3.����ϱ�");
				System.out.println("4.�����ϱ�");
				System.out.print(">>");
				menu = Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("�޴��� �ش��ϴ� ���ڸ� �Է����ּ���.");
				continue;
			}





			if (menu ==  1) {
				System.out.println("���� �ܾ��� " + money + " �� �Դϴ�");


			}else if (menu == 2) {
				while(true)
					try {

						System.out.print("�󸶸� �Ա� �Ͻðڽ��ϱ� : ");


						int input = Integer.parseInt(sc.nextLine());
						money+=input;
						System.out.println(money+ "�� �� �ԱݵǾ����ϴ�");
					}catch(Exception e) {
						System.out.println("�ݾ��� ���ڷ� �Է��ؾ��մϴ�");
					}
			}

			else if (menu == 3) {
				while(true) {
				try {
					System.out.print("����� �ݾ��� �Է����ּ��� : ");
					int input = Integer.parseInt(sc.nextLine());
					if(money >= input) {
						money-=input;
						System.out.println(money + "�� �� ��ݵǾ����ϴ�");

					}else {
						System.out.println("�ݾ��� �����մϴ�");
					}
				}catch(Exception e) {
					System.out.println("������ ���ڷ� �Է��ؾ��մϴ�");
				}
				}
			}else if (menu == 4) {
				System.out.println("�����մϴ�");
				System.exit(0);
			}else {
				System.out.println("���ڸ� �ٽ� ����ּ���");
			}
		}
	}
}

