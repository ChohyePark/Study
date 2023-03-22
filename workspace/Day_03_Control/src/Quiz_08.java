import java.util.Scanner;

public class Quiz_08 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("2~9단중 원하시는 단을 선택해주세요.(0 -> 종료) : ");
			int dan = Integer.parseInt(sc.nextLine());
			System.out.println("=========================================");


			if(dan == 0) {
				System.out.println("구구단을 종료합니다.");
				System.exit(0);
			}
			
			if(1 < dan && dan < 10) {
				int i = 0;

				while(i<9) {
					i++;
					System.out.println(dan+ " * " +i+ " = " +dan*i );
				}
			}else {
				System.out.println("2~9단중 선택해주세요.");
			}
			// System.exit(0); // 프로그램을 꺼버림
		}

	}

}
