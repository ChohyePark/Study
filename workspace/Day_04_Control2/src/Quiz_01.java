import java.util.Scanner;

public class Quiz_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int money = 0;
		int input = 0;
		while(true) {
			int menu = 0;

			try {
				System.out.println("****ATM �ùķ�����*****");
				System.out.println("1.�ܾ���ȸ");
				System.out.println("2.�Ա��ϱ�");
				System.out.println("3.����ϱ�");
				System.out.println("4.�����ϱ�");
				System.out.print(">>");
				menu = Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("���ڸ� �Է����ּ���");

			}


			if(menu == 1) {
				System.out.println("���� �ܾ���"+ money+  "�� �Դϴ�" );
		}else if(menu == 2) {
				while(true) {
					System.out.print("�Ա��� �ݾ��� �Է����ּ��� : " );

					try {
						input = Integer.parseInt(sc.nextLine());
						money += input;

						System.out.println("�ѱݾ� ��" + money + "�� �Դϴ�");
						break;
					}catch(Exception e) {
						System.out.println("���ڸ� �Է����ּ���");

					}
				}


			}else if(menu == 3) {
				while(true) {
				System.out.print("����� �ݾ��� �Է����ּ��� : " );
				
					try {
						input = Integer.parseInt(sc.nextLine());
						if(money>=input) {

							money -= input;
						System.out.println("�ѱݾ� ��" + money + "�� �Դϴ�");
						break;
						}else {
							System.out.println("����� �ݾ��� �����մϴ�");
							break;
						}
						}catch(Exception e) {
						System.out.println("���ڸ� �Է����ּ���");
					}
				}
			}if(menu == 4) {
				System.out.println("�����մϴ�" );
				System.exit(0);
			}
		}
	}
}
