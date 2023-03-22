import java.util.Scanner;

public class Quiz_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		while(true) {
			

			System.out.println("===가위 바위 보 게임 ===");
			System.out.print("숫자를 선택하세요(1.가위 / 2.바위 / 3.보 / 4.종료) : ");

			int com = (int)(Math.random()*3+1);
			int player = 0;
			try {
				player = Integer.parseInt(sc.nextLine());  //사용자의 가위바위보 선택 완료
			}catch(Exception e) {
				System.out.println("숫자를 입력하세요");
				continue;
			}
			System.out.println("========결과========");
			switch(player) {
			case 1:
				System.out.println("플레이어는 가위를 냈습니다.");
				break;
			case 2:
				System.out.println("플레이어는 바위를 냈습니다.");
				break;
			case 3:
				System.out.println("플레이어는 보 를 냈습니다.");
				break;
			case 4 :
				System.out.println("종료합니다");
				System.exit(0);

			default:
				System.out.println("숫자를 다시 선택히세요");
				continue;
			}
			switch(com) {
			case 1:
				System.out.println("컴퓨터는 가위를 냈습니다.");
				break;
			case 2:
				System.out.println("컴퓨터는 바위를 냈습니다.");
				break;
			case 3:
				System.out.println("컴퓨터는 보 를 냈습니다.");
				break;
			}
			System.out.println("==========================");

			if((player == 1 && com ==3) ||								//플레이어가 이기는경우
					(player == 2 && com ==1) ||
					(player == 3 && com ==2)){
				System.out.println("플레이어가 승리했습니다 ^^");

			}else if((player == 3 && com == 1)||
					(player == 1 && com == 2)||
					(player == 2 && com == 3)){

				System.out.println("컴퓨터가 승리했습니다 ㅜ.ㅜ");

			}else {
				System.out.println("비겼습니다");
			}


		}
	}



}
