import java.util.Scanner;

public class Quiz_09_extra {

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      System.out.println("=== 1~n 까지의 합 구하기===");
      System.out.print("n 입력 : ");
      int num1 = Integer.parseInt(sc.nextLine());

      System.out.println("1부터" +num1+ "까지의 합은 " +((1+num1)*num1/2));
   }

}