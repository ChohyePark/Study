import java.util.Scanner;

public class Quiz_00 { // 1~ n ������ ���� ������ �ڵ忡�� ������ �ʴ� ���α׷�  (�� 0Ű�� ����Ű)

	public static void main(String[] args) {


		while(true) {

			Scanner sc = new Scanner(System.in);
			System.out.print("���� n �Է� (0�� ����Ű) : ");
			int num1 = Integer.parseInt(sc.nextLine());

			if(num1 == 0) {
				System.out.println("���α׷��� �����մϴ�.");
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

