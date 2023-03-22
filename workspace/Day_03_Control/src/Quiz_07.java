import java.util.Scanner;

public class Quiz_07 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("'Hello Java while'을 몇번 출력하시겠습니까? : ");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("===================================================");
		
		int i = 0;
		
		while ( i < num1 ) {
			i++;
			System.out.println(i + ". Hello Java while");
			
		}
		

	}

}
