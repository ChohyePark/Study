import java.util.Scanner;

public class Quiz_03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~100 사이 입력: ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.println("===결과===");
		
		if(num1 >= 1 && num1 <= 100 ) {
			if(num1 % 2 == 0 ) {
				System.out.println("입력한 수는 짝수입니다.");
			}else{
				System.out.println("입력한 수는 홀수입니다.");
			}
		}else {
			System.out.println("1~100 사이의 수가 아닙니다.");
		}

	}

}
