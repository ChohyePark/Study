import java.util.Scanner;

public class Quiz_03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~100 ���� �Է�: ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.println("===���===");
		
		if(num1 >= 1 && num1 <= 100 ) {
			if(num1 % 2 == 0 ) {
				System.out.println("�Է��� ���� ¦���Դϴ�.");
			}else{
				System.out.println("�Է��� ���� Ȧ���Դϴ�.");
			}
		}else {
			System.out.println("1~100 ������ ���� �ƴմϴ�.");
		}

	}

}
