import java.util.Scanner;

public class Quiz_05 {

	public static void main(String[] args) {
		int money = 0;
		int input = 0;
		Scanner sc =new Scanner (System.in);
		while(true) {
			System.out.println("�渶 ���ӿ� ���� ���� ȯ���մϴ�");
			System.out.println("1.���ӽ���");
			System.out.println("2.�ܾ�����");
			System.out.println("3.�ܾ���ȸ");
			System.out.println("4.����");
			System.out.print("�޴��� �������ּ��� >> ");

			int menu = Integer.parseInt(sc.nextLine());
			int horse = (int)(Math.random()*3+1);
			if (menu == 1) {
				while(true){
				System.out.println("�渶������ �����ϰڽ��ϴ�");
				System.out.println("1.1����");
				System.out.println("2.2����");
				System.out.println("3.3����");
				System.out.print("���� �� ���� �������ּ��� : ");
				 menu = Integer.parseInt(sc.nextLine());
				 System.out.print("������ �ݾ��� �Է����ּ��� :");
				 input = Integer.parseInt(sc.nextLine());
				 if(money <input) {
					 System.out.println("�ݾ��� �����մϴ�");
					 break;
				 }
				  
				 System.out.println("");
				 
				 
				}
				   
				 
				 
				 
				
				


			}else if (menu == 2) {
				
				System.out.print("������ �ݾ��� �Է����ּ��� : ");
				input = Integer.parseInt(sc.nextLine());
			
				System.out.println(input+"���� �����Ǿ����ϴ�");
			}else if (menu == 3) {
				
				money += input;
				System.out.println("���� �ݾ��� "+ money+ "���Դϴ�");
			}else if (menu == 4) {
				System.out.println("�����մϴ�");
				System.exit(0);

			}
		}


	}

}
