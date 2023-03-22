import java.util.Scanner;

public class Exam_03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[]arr =new int[5];

		for(int i = 0; i<arr.length; i++) {
			System.out.print("arr["+i+"] : ");
			arr[i] = Integer.parseInt(sc.nextLine());
		}

		System.out.println("입력된 값은 ");
		for(int i =0 ; i <arr.length; i++) {
			System.out.println("arr["+i+"] : "+arr[i]);
		}




	}

}
