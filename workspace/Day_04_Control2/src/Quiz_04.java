import java.util.Scanner;

public class Quiz_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = 20000;
		int cola = 0;
		int cidar = 0;
		int mesill = 0;


		while(true) {
			System.out.println("====== ���Ǳ� �ùķ��̼� =======");
			System.out.println("������� �����ϼ���.");
			System.out.println("1. �ݶ�(1000) 2.���̴� (800) 3. �Ž��� (1500) [0.����ǰȮ��]");
			System.out.print(">>");
			int menu = Integer.parseInt(sc.nextLine());

			if(menu == 1) {
				if(money>=1000) {
					cola++;

					System.out.println("�ݶ� �����߽��ϴ�");
					System.out.println("�ݶ� : 1��");
					System.out.println("������ -1000");
					money-=1000;


				}else {
					System.out.println("�ܾ׺���");
				}
			}else if(menu == 2) {
				if(money>=800) {
					cidar++;


					System.out.println("���̴ٸ� �����߽��ϴ�");
					System.out.println("���̴� : 1��");
					System.out.println("������ -800");
					money-=800;


				}else {
					System.out.println("�ܾ׺���");

				}

			}else if(menu == 3) {
				if(money>=1500) {
					mesill++;


					System.out.println("�Ž����� �����߽��ϴ�");
					System.out.println("�Ž� : 1��");
					System.out.println("������ -1500");
					money-=1500;


				}else {
					System.out.println("�ܾ׺���");


				}

			}else if(menu == 0) {
				


					System.out.println("======����ǰ ��� ===");
					System.out.println("������:"+money+ "��");
					System.out.println("�ݶ�"+cola+ "��");
					System.out.println("���̴�"+cidar+"��");
					System.out.println("�Ž���"+mesill+"��");
					System.out.println("===================");
				


				}else {
					System.out.println("�ٽ� �Է����ּ���");


				}

			}

		}
}
