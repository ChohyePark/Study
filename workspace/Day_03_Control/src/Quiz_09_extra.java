import java.util.Scanner;

public class Quiz_09_extra {

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      System.out.println("=== 1~n ������ �� ���ϱ�===");
      System.out.print("n �Է� : ");
      int num1 = Integer.parseInt(sc.nextLine());

      System.out.println("1����" +num1+ "������ ���� " +((1+num1)*num1/2));
   }

}