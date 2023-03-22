import java.util.Scanner;

public class Exam_04 {

	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			System.out.print("메세지 를 입력해 주세요 : ");
			String msg = sc.nextLine();
			
			if(msg .equals("Apple")) {                  //문자열 비교 명령어 .equals()
				System.out.println("사과 입니다.");
			}else if (msg .equals("strawberry")) {
				System.out.println("딸기 입니다.");
			}else {
				System.out.println("메세지를 확인 할 수 없습니다.");
			}
	}
	

}
