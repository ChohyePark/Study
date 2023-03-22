import java.util.Scanner;

public class Quiz_05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==================");
		
		System.out.print("이름 : ");
		String str = sc.nextLine();
		
		System.out.println("==================");
		
		System.out.print("국어 : ");
		String str1 = sc.nextLine();
		int num1 = Integer.parseInt(str1);
		// double num1 = Double.parseDouble(); 입력받는 값이 실수값 ex)3.14 이더라도 오류가 뜨지 않음.(Integer.parseInt 의 경우
		//                                                                                   정수값 외에 받을 수 없음.)
		System.out.print("영어 : ");
		String str2 = sc.nextLine();
		int num2 = Integer.parseInt(str2);
		
		System.out.print("수학 : ");
		String str3 = sc.nextLine();
		int num3 = Integer.parseInt(str3);
		
		double total = (num1+num2+num3);
		
		System.out.println("==================");
		
		System.out.println("합계 : " + (num1 + num2 + num3));
		
		System.out.print("평균 : " + (total/3) );
		//System.out.printf("평균 : " + "%.3f",(total/3) ); //소수점 'N'번째 자리까지만 표시 : printf("%.'N'f");
		System.out.println("");
		
		System.out.println("==================");
		
		

	}

}
