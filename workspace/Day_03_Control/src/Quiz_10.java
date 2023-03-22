import java.util.Scanner;

public class Quiz_10 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("n 입력 :");
		int num1 = Integer.parseInt(sc.nextLine());
		
		int sum = 0;
		for(int i = 0;i<=num1;i++) {
			sum += i;
			
		}
		System.out.println("1부터" +num1+ "까지의 합은 " +sum+ "입니다.");
	}

}
