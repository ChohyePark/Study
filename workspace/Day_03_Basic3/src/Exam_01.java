import java.util.Scanner;

public class Exam_01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("� ������ �ֹ��Ͻðڽ��ϱ�?");
		System.out.println("1. ��� 2. �� 3. ���� 4. ������");
		System.out.print(">>");
		int menu = Integer.parseInt(sc.nextLine());
		
		
		if(menu >= 1 && menu <= 3) {
			if(menu == 1) {
				System.out.println("��� ���Խ��ϴ�.");
			}else if(menu == 2) {
				System.out.println("�� ���Խ��ϴ�.");
			}else if(menu == 3) {
				System.out.println("���� ���Խ��ϴ�.");
			}else if(menu == 4) {
				System.out.println("������ ���Խ��ϴ�.");
			}
		}else {
			System.out.println("���� �޴��Դϴ�.");
		}

	}

}
