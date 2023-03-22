import java.util.Scanner;

public class Quiz_04 {

	public static void main(String[] args) {

		while(true) {

			int player = 0;
			int com = (int)(Math.random()*3+1);


			Scanner sc = new Scanner(System.in);
			System.out.println("===가위 바위 보===");
			System.out.print("숫자를 선택하세요( 1.가위 / 2.바위 / 3. 보 : ");
			
			try {
			player = Integer.parseInt(sc.nextLine());
					
			
			}catch(Exception e) {
				System.out.println("숫자만 입력해주세요");
				continue;
			}
			if(player == 1 ) {
				System.out.println("플레이어가 가위를 냈습니다");
				
			}else if(player == 2 ) {
				System.out.println("플레이어가 바위를 냈습니다");
				
			}else if(player == 3) {
				System.out.println("플레이어가 보 를 냈습니다");
				
			}else {
				System.out.println("숫자를 다시 입력해 주세요");
				continue;
			} if(com == 1) {
				System.out.println("컴퓨터 가 가위를 냈습니다");
			} else if(com == 2) {
				System.out.println("컴퓨터 가 바위를 냈습니다");
			}else if(com == 3) {
				System.out.println("컴퓨터 가 보 를 냈습니다");
			}
			
			

		
			System.out.println("========결과=========");
			if(player == 1 && com == 3||
					(player == 2 && com == 1)||
					(player ==3 && com ==2)){
				System.out.println("플레이어가 이겼습니다");
			}else if(player == com) {
				System.out.println("비겼습니다");
			}else {
				System.out.println("컴퓨터가 이겼습니다");
			}



	
		}


	}

}
