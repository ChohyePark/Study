import java.util.Scanner;

public class Quiz_04 {

	public static void main(String[] args) {

		while(true) {

			int player = 0;
			int com = (int)(Math.random()*3+1);


			Scanner sc = new Scanner(System.in);
			System.out.println("===���� ���� ��===");
			System.out.print("���ڸ� �����ϼ���( 1.���� / 2.���� / 3. �� : ");
			
			try {
			player = Integer.parseInt(sc.nextLine());
					
			
			}catch(Exception e) {
				System.out.println("���ڸ� �Է����ּ���");
				continue;
			}
			if(player == 1 ) {
				System.out.println("�÷��̾ ������ �½��ϴ�");
				
			}else if(player == 2 ) {
				System.out.println("�÷��̾ ������ �½��ϴ�");
				
			}else if(player == 3) {
				System.out.println("�÷��̾ �� �� �½��ϴ�");
				
			}else {
				System.out.println("���ڸ� �ٽ� �Է��� �ּ���");
				continue;
			} if(com == 1) {
				System.out.println("��ǻ�� �� ������ �½��ϴ�");
			} else if(com == 2) {
				System.out.println("��ǻ�� �� ������ �½��ϴ�");
			}else if(com == 3) {
				System.out.println("��ǻ�� �� �� �� �½��ϴ�");
			}
			
			

		
			System.out.println("========���=========");
			if(player == 1 && com == 3||
					(player == 2 && com == 1)||
					(player ==3 && com ==2)){
				System.out.println("�÷��̾ �̰���ϴ�");
			}else if(player == com) {
				System.out.println("�����ϴ�");
			}else {
				System.out.println("��ǻ�Ͱ� �̰���ϴ�");
			}



	
		}


	}

}
