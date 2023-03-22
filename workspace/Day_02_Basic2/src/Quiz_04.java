import java.util.Scanner;

public class Quiz_04 {

	public static void main(String[] args) {
		
		// 두 정수를 입력받아 덧셈한 결과를 출력하는 프로그램을 작성해주세요.
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력해주세요: ");
		String str1 = sc.nextLine();
		int num1 = Integer.parseInt(str1);
		
		System.out.print("두번째 숫자를 입력해주세요: ");
		//String str2 = sc.nextLine();
		//int num2 = Integer.parseInt(str2);
		int num2 = Integer.parseInt(sc.nextLine());
		
		System.out.print(num1+ " + " +num2+ " = " +(num1+num2));

	}

}
