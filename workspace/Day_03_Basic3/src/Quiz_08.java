import java.util.Scanner;

public class Quiz_08 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("2~9���� ���Ͻô� ���� �������ּ���.(0 -> ����) : ");
			int dan = Integer.parseInt(sc.nextLine());
			System.out.println("=========================================");


			if(dan == 0) {
				System.out.println("�������� �����մϴ�.");
				System.exit(0);
			}
			
			if(1 < dan && dan < 10) {
				int i = 0;

				while(i<9) {
					i++;
					System.out.println(dan+ " * " +i+ " = " +dan*i );
				}
			}else {
				System.out.println("2~9���� �������ּ���.");
			}
			// System.exit(0); // ���α׷��� ������
		}

	}

}
