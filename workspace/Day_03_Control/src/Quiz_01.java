import java.util.Scanner;

public class Quiz_01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ ���ɸ޴��� �����ϼ���.");
		System.out.println("1.�߽� 2.�ѽ� 3.�Ͻ� ");
		System.out.print(">>");
		
		int menu = Integer.parseInt(sc.nextLine());
		
		if(menu >= 1 && menu <= 3) {
			if(menu == 1) {
				System.out.println("'���������'�� 68m �տ� �ֽ��ϴ�.");
			}else if(menu == 2 ) {
				System.out.println("'����Ϲ���'�� 84m �տ� �ֽ��ϴ�.");
			}else if(menu == 3 ) {
				System.out.println("'���ù���'�� 164m �տ� �ֽ��ϴ�.");
			}
		}else {
			System.out.println("�׷� �������� �����ϴ�.");
		}

	}

}
