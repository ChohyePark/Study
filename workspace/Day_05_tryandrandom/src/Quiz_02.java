import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);

		int i = 0;
		int num =0;
		
			double rand =Math.random();
			i =((int)(rand * 2)+1);
			System.out.println("====���� �� �� ���߱�====");
			while(true) {
			System.out.print("���ڸ� �Է����ּ��� (1.�ո� / 2.�޸�  3����) : ");
			



			try {
				num = Integer.parseInt(sc.nextLine());
				if (num ==3 ) {
					System.out.println("�����մϴ�");
					System.exit(0);


				}if(num==1 || num ==2) {
					if(i == num) {
						System.out.println("������ϴ�");

					}else if(i != num) {
						System.out.println("Ʋ�Ƚ��ϴ�");
						System.out.println("�ٽ� ���߽ÿ�");
					
					}

				}else {
					System.out.println("1���� 2���� �ٽð�����");
				}System.out.println("==============restart");

			}catch(Exception e) {
				System.out.println("���ڸ� �Է����ּ���");

			}
		}

	}
}

