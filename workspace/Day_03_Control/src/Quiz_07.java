import java.util.Scanner;

public class Quiz_07 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("'Hello Java while'�� ��� ����Ͻðڽ��ϱ�? : ");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("===================================================");
		
		int i = 0;
		
		while ( i < num1 ) {
			i++;
			System.out.println(i + ". Hello Java while");
			
		}
		

	}

}
