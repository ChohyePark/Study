import java.util.Scanner;

public class Exam_04 {

	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			System.out.print("�޼��� �� �Է��� �ּ��� : ");
			String msg = sc.nextLine();
			
			if(msg .equals("Apple")) {                  //���ڿ� �� ��ɾ� .equals()
				System.out.println("��� �Դϴ�.");
			}else if (msg .equals("strawberry")) {
				System.out.println("���� �Դϴ�.");
			}else {
				System.out.println("�޼����� Ȯ�� �� �� �����ϴ�.");
			}
	}
	

}
