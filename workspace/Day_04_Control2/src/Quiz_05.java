import java.util.Scanner;

public class Quiz_05 {

	public static int validNum(String str){
		Scanner sc = new Scanner(System.in);
		
		int a =0;
		while(true) {
			System.out.print(str);
			try {
				return a = Integer.parseInt(sc.nextLine());
				
			}catch(Exception e) {
				System.out.println("���ڸ� �Է�");
			}
		} 
	} 
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println(" === ���� ���α׷� === ");
			System.out.print("������ �Է�(+,-,*,/,q[����]) : ");
			String oper = sc.nextLine();

			if(oper.equals("q")) {

				System.out.println("���⸦ �����մϴ�.");
				System.exit(0);

			}else if(oper.equals("+") || oper.equals("-") ||
					oper.equals("*") || oper.equals("/")) { 


				int num1 = validNum("ù ���� �� : ");

						int num2 = validNum("�� ���� �� : ");


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