import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int money = 0;
		int menu = 0;

		while(true) {
		
			try {
				System.out.println("***ATM 시뮬레이터****");
				System.out.println("1.잔액조회");
				System.out.println("2.입금하기");
				System.out.println("3.출금하기");
				System.out.println("4.종료하기");
				System.out.print(">>");
				menu = Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("메뉴에 해당하는 숫자를 입력해주세요.");
				continue;
			}





			if (menu ==  1) {
				System.out.println("남은 잔액은 " + money + " 원 입니다");


			}else if (menu == 2) {
				while(true)
					try {

						System.out.print("얼마를 입금 하시겠습니까 : ");


						int input = Integer.parseInt(sc.nextLine());
						money+=input;
						System.out.println(money+ "원 이 입금되었습니다");
					}catch(Exception e) {
						System.out.println("금액은 숫자로 입력해야합니다");
					}
			}

			else if (menu == 3) {
				while(true) {
				try {
					System.out.print("출금할 금액을 입력해주세요 : ");
					int input = Integer.parseInt(sc.nextLine());
					if(money >= input) {
						money-=input;
						System.out.println(money + "원 이 출금되었습니다");

					}else {
						System.out.println("금액이 부족합니다");
					}
				}catch(Exception e) {
					System.out.println("굼액은 숫자로 입력해야합니다");
				}
				}
			}else if (menu == 4) {
				System.out.println("종료합니다");
				System.exit(0);
			}else {
				System.out.println("숫자를 다시 골라주세요");
			}
		}
	}
}

