import java.util.Scanner;

public class Quiz_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = 20000;
		int cola = 0;
		int cidar = 0;
		int mesill = 0;


		while(true) {
			System.out.println("====== 자판기 시뮬레이션 =======");
			System.out.println("음료수를 선택하세요.");
			System.out.println("1. 콜라(1000) 2.사이다 (800) 3. 매실차 (1500) [0.소지품확인]");
			System.out.print(">>");
			int menu = Integer.parseInt(sc.nextLine());

			if(menu == 1) {
				if(money>=1000) {
					cola++;

					System.out.println("콜라를 구매했습니다");
					System.out.println("콜라 : 1개");
					System.out.println("소지금 -1000");
					money-=1000;


				}else {
					System.out.println("잔액부족");
				}
			}else if(menu == 2) {
				if(money>=800) {
					cidar++;


					System.out.println("사이다를 구매했습니다");
					System.out.println("사이다 : 1개");
					System.out.println("소지금 -800");
					money-=800;


				}else {
					System.out.println("잔액부족");

				}

			}else if(menu == 3) {
				if(money>=1500) {
					mesill++;


					System.out.println("매실차를 구매했습니다");
					System.out.println("매실 : 1개");
					System.out.println("소지금 -1500");
					money-=1500;


				}else {
					System.out.println("잔액부족");


				}

			}else if(menu == 0) {
				


					System.out.println("======소지품 목록 ===");
					System.out.println("소지금:"+money+ "개");
					System.out.println("콜라"+cola+ "개");
					System.out.println("사이다"+cidar+"개");
					System.out.println("매실차"+mesill+"개");
					System.out.println("===================");
				


				}else {
					System.out.println("다시 입력해주세요");


				}

			}

		}
}
