import java.util.Scanner;

public class Quiz_06 {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		while(true) {
			System.out.println(" === ���� ���α׷� === ");
			System.out.print("������ �Է�(+,-,*,/,q[����]) : ");
			String oper = sc.nextLine();

			if(oper.equals("q")) {

				System.out.println("���⸦ �����մϴ�.");
				System.exit(0);

			}else if(oper.equals("+") || oper.equals("-") ||
					oper.equals("*") || oper.equals("/")) { 
				while(true) {
					try {

						System.out.print("ù ��° �� : ");
						 num1 = Integer.parseInt(sc.nextLine());

					
						
						break; // ���� ���� �Է� �� �� ���ѷ��� Ż��

					}catch(Exception e) {
						System.out.println("���ڸ� �Է��ؾ��մϴ�.");

					}
				}
				
				
				while(true) {
					try {

					

						System.out.print("�� ��° �� : ");
						num2= Integer.parseInt(sc.nextLine());
						
						break; // ���� ���� �Է� �� �� ���ѷ��� Ż��

					}catch(Exception e) {
						System.out.println("���ڸ� �Է��ؾ��մϴ�.");

					}
				}

				System.out.println(" === �� �� === ");
				
				switch(oper) {
				case "+":
					System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
					break;
				case "-":
					System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
					break;
				case "*":
					System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
					break;
				case "/":
					System.out.println(num1 + " / " + num2 + " = " + (num1/(double)num2));
					break;
				}

			}else {
				System.out.println("�����ڸ� �ٽ� �Է����ּ���.");
			}
		}





	}

}


