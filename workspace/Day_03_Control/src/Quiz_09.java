import java.util.Scanner;

public class Quiz_09 {

   public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      System.out.println("=== 1~n 까지의 합 구하기===");
      System.out.print("n 입력 : ");
      int num1 = Integer.parseInt(sc.nextLine());
      
      int a,b;
      
      a = 0;
      b = 0;
      
      while(a < num1) {
         a++;
         b += a;
         
      }
      System.out.println("1~"+num1+ " 까지의 합은 "+b+"입니다.");
      

   }

}