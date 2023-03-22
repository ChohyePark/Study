import java.util.Scanner;

public class Quiz_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int money = 0;
		int input = 0;
		while(true) {
			int menu = 0;

			try {
				System.out.println("****ATM 시뮬레이터*****");
				System.out.println("1.잔액조회");
				System.out.println("2.입금하기");
				System.out.println("3.출금하기");
				System.out.println("4.종료하기");
				System.out.print(">>");
				menu = Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("숫자만 입력해주세요");

			}


			if(menu == 1) {
				System.out.println("남은 잔액은"+ money+  "원 입니다" );
		}else if(menu == 2) {
				while(true) {
					System.out.print("입금할 금액을 입력해주세요 : " );

					try {
						input = Integer.parseInt(sc.nextLine());
						money += input;

						System.out.println("총금액 은" + money + "원 입니다");
						break;
					}catch(Exception e) {
						System.out.println("숫자만 입력해주세요");

					}
				}


			}else if(menu == 3) {
				while(true) {
				System.out.print("출금할 금액을 입력해주세요 : " );
				
					try {
						input = Integer.parseInt(sc.nextLine());
						if(money>=input) {

							money -= input;
						System.out.println("총금액 은" + money + "원 입니다");
						break;
						}else {
							System.out.println("출금할 금액이 부족합니다");
							break;
						}
						}catch(Exception e) {
						System.out.println("숫자만 입력해주세요");
					}
				}
			}if(menu == 4) {
				System.out.println("종료합니다" );
				System.exit(0);
			}
		}
	}
}
