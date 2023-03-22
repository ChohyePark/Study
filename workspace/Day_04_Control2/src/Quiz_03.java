import java.util.Scanner;

public class Quiz_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = 0;
		int input = 0;
		while(true) {
		System.out.println("***ATM 시뮬레이터***");
		System.out.println("1.잔액조회");
		System.out.println("2.입금하기");
		System.out.println("3.출금하기");
		System.out.println("4.종료하기");
		System.out.print(">>");
		int i = Integer.parseInt(sc.nextLine());
		
		
		

		switch(i) {

	
		case 1: 
			System.out.println("남은 잔액은 : " +money);
			
			break;
			
		case 2: 
			System.out.println("얼마를 입금하시겠습니까");
			input=Integer.parseInt(sc.nextLine());
			money+=input;
			
			break;
		case 3: 
			System.out.println("얼마를 출금 하시겠습니까");
			input=Integer.parseInt(sc.nextLine());
			if(money<input) {
				System.out.println("잔액부족");
			}else {
				money-=input;
			}
			
			
			
			break;
		case 4: 
			System.out.println("종료하기 기능입니다");
			System.exit(0);
			
		default :
			System.out.println("다시 골라주세요");

		}

		}


	}

}
