import java.util.Scanner;

public class Exam_03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("좋아하는 ott 는? (0번은 종료키) ");
			System.out.println("1.Netflix 2.Disney 3.Watcha");
			System.out.print(">> ");
			int num1 = Integer.parseInt(sc.nextLine());
			

			switch(num1) {
			case 0: 
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			case 1: 
				System.out.println("Netflix는 더글로리가 인기입니다.");
				break;
			case 2:
				System.out.println("Disney는 카지노가 인기입니다.");
				break;
			case 3:
				System.out.println("Watcha는 모르겠습니다.망했어요.");
				break;
			default:
				System.out.println("메뉴를 다시 확인해주세요.");

			}
			System.out.println("===================================");

		}
	}

}
