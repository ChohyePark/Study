import java.util.Scanner;

public class Quiz_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		while(true) {
			

			System.out.println("===���� ���� �� ���� ===");
			System.out.print("���ڸ� �����ϼ���(1.���� / 2.���� / 3.�� / 4.����) : ");

			int com = (int)(Math.random()*3+1);
			int player = 0;
			try {
				player = Integer.parseInt(sc.nextLine());  //������� ���������� ���� �Ϸ�
			}catch(Exception e) {
				System.out.println("���ڸ� �Է��ϼ���");
				continue;
			}
			System.out.println("========���========");
			switch(player) {
			case 1:
				System.out.println("�÷��̾�� ������ �½��ϴ�.");
				break;
			case 2:
				System.out.println("�÷��̾�� ������ �½��ϴ�.");
				break;
			case 3:
				System.out.println("�÷��̾�� �� �� �½��ϴ�.");
				break;
			case 4 :
				System.out.println("�����մϴ�");
				System.exit(0);

			default:
				System.out.println("���ڸ� �ٽ� ����������");
				continue;
			}
			switch(com) {
			case 1:
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
				break;
			case 2:
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
				break;
			case 3:
				System.out.println("��ǻ�ʹ� �� �� �½��ϴ�.");
				break;
			}
			System.out.println("==========================");

			if((player == 1 && com ==3) ||								//�÷��̾ �̱�°��
					(player == 2 && com ==1) ||
					(player == 3 && com ==2)){
				System.out.println("�÷��̾ �¸��߽��ϴ� ^^");

			}else if((player == 3 && com == 1)||
					(player == 1 && com == 2)||
					(player == 2 && com == 3)){

				System.out.println("��ǻ�Ͱ� �¸��߽��ϴ� ��.��");

			}else {
				System.out.println("�����ϴ�");
			}


		}
	}



}
