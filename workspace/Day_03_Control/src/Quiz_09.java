import java.util.Scanner;

public class Quiz_09 {

   public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      System.out.println("=== 1~n ������ �� ���ϱ�===");
      System.out.print("n �Է� : ");
      int num1 = Integer.parseInt(sc.nextLine());
      
      int a,b;
      
      a = 0;
      b = 0;
      
      while(a < num1) {
         a++;
         b += a;
         
      }
      System.out.println("1~"+num1+ " ������ ���� "+b+"�Դϴ�.");
      

   }

}