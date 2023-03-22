import java.util.Scanner;

public class Quiz_05 {

	public static void main(String[] args) {
		int money = 0;
		int input = 0;
		Scanner sc =new Scanner (System.in);
		while(true) {
			System.out.println("경마 게임에 오신 것을 환영합니다");
			System.out.println("1.게임시작");
			System.out.println("2.잔액충전");
			System.out.println("3.잔액조회");
			System.out.println("4.종료");
			System.out.print("메뉴를 선택해주세요 >> ");

			int menu = Integer.parseInt(sc.nextLine());
			int horse = (int)(Math.random()*3+1);
			if (menu == 1) {
				while(true){
				System.out.println("경마게임을 시작하겠습니다");
				System.out.println("1.1번말");
				System.out.println("2.2번말");
				System.out.println("3.3번말");
				System.out.print("베팅 할 말을 선택해주세요 : ");
				 menu = Integer.parseInt(sc.nextLine());
				 System.out.print("베팅할 금액을 입력해주세요 :");
				 input = Integer.parseInt(sc.nextLine());
				 if(money <input) {
					 System.out.println("금액이 부족합니다");
					 break;
				 }
				  
				 System.out.println("");
				 
				 
				}
				   
				 
				 
				 
				
				


			}else if (menu == 2) {
				
				System.out.print("충전할 금액을 입력해주세요 : ");
				input = Integer.parseInt(sc.nextLine());
			
				System.out.println(input+"원이 충전되었습니다");
			}else if (menu == 3) {
				
				money += input;
				System.out.println("현재 금액은 "+ money+ "원입니다");
			}else if (menu == 4) {
				System.out.println("종료합니다");
				System.exit(0);

			}
		}


	}

}
