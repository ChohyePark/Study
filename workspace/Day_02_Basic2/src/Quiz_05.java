import java.util.Scanner;

public class Quiz_05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==================");
		
		System.out.print("�̸� : ");
		String str = sc.nextLine();
		
		System.out.println("==================");
		
		System.out.print("���� : ");
		String str1 = sc.nextLine();
		int num1 = Integer.parseInt(str1);
		// double num1 = Double.parseDouble(); �Է¹޴� ���� �Ǽ��� ex)3.14 �̴��� ������ ���� ����.(Integer.parseInt �� ���
		//                                                                                   ������ �ܿ� ���� �� ����.)
		System.out.print("���� : ");
		String str2 = sc.nextLine();
		int num2 = Integer.parseInt(str2);
		
		System.out.print("���� : ");
		String str3 = sc.nextLine();
		int num3 = Integer.parseInt(str3);
		
		double total = (num1+num2+num3);
		
		System.out.println("==================");
		
		System.out.println("�հ� : " + (num1 + num2 + num3));
		
		System.out.print("��� : " + (total/3) );
		//System.out.printf("��� : " + "%.3f",(total/3) ); //�Ҽ��� 'N'��° �ڸ������� ǥ�� : printf("%.'N'f");
		System.out.println("");
		
		System.out.println("==================");
		
		

	}

}
