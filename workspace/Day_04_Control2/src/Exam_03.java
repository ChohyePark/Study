import java.util.Scanner;

public class Exam_03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("�����ϴ� ott ��? (0���� ����Ű) ");
			System.out.println("1.Netflix 2.Disney 3.Watcha");
			System.out.print(">> ");
			int num1 = Integer.parseInt(sc.nextLine());
			

			switch(num1) {
			case 0: 
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
				break;
			case 1: 
				System.out.println("Netflix�� ���۷θ��� �α��Դϴ�.");
				break;
			case 2:
				System.out.println("Disney�� ī���밡 �α��Դϴ�.");
				break;
			case 3:
				System.out.println("Watcha�� �𸣰ڽ��ϴ�.���߾��.");
				break;
			default:
				System.out.println("�޴��� �ٽ� Ȯ�����ּ���.");

			}
			System.out.println("===================================");

		}
	}

}
