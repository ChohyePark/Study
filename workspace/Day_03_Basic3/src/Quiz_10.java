import java.util.Scanner;

public class Quiz_10 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("n �Է� :");
		int num1 = Integer.parseInt(sc.nextLine());
		
		int sum = 0;
		for(int i = 0;i<=num1;i++) {
			sum += i;
			
		}
		System.out.println("1����" +num1+ "������ ���� " +sum+ "�Դϴ�.");
	}

}
