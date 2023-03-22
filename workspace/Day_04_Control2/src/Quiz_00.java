import java.util.Scanner;

public class Quiz_00 { // 1~ n 까지의 합이 나오는 코드에서 꺼지지 않는 프로그램  (단 0키는 종료키)

	public static void main(String[] args) {


		while(true) {

			Scanner sc = new Scanner(System.in);
			System.out.print("숫자 n 입력 (0은 종료키) : ");
			int num1 = Integer.parseInt(sc.nextLine());

			if(num1 == 0) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}

			int a, sum;
			sum = 0;

			for(a=1 ; a<=num1 ; a++) {
				sum += a;
				if(a == num1) {
					break;
				}

			}
			System.out.println(sum);
		}

	}

}

