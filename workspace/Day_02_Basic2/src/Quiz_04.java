import java.util.Scanner;

public class Quiz_04 {

	public static void main(String[] args) {
		
		// �� ������ �Է¹޾� ������ ����� ����ϴ� ���α׷��� �ۼ����ּ���.
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���ڸ� �Է����ּ���: ");
		String str1 = sc.nextLine();
		int num1 = Integer.parseInt(str1);
		
		System.out.print("�ι�° ���ڸ� �Է����ּ���: ");
		//String str2 = sc.nextLine();
		//int num2 = Integer.parseInt(str2);
		int num2 = Integer.parseInt(sc.nextLine());
		
		System.out.print(num1+ " + " +num2+ " = " +(num1+num2));

	}

}
