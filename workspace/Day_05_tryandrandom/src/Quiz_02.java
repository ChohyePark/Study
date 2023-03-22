import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);

		int i = 0;
		int num =0;
		
			double rand =Math.random();
			i =((int)(rand * 2)+1);
			System.out.println("====동전 앞 뒤 맞추기====");
			while(true) {
			System.out.print("숫자를 입력해주세요 (1.앞면 / 2.뒷면  3종료) : ");
			



			try {
				num = Integer.parseInt(sc.nextLine());
				if (num ==3 ) {
					System.out.println("종료합니다");
					System.exit(0);


				}if(num==1 || num ==2) {
					if(i == num) {
						System.out.println("맞췄습니다");

					}else if(i != num) {
						System.out.println("틀렸습니다");
						System.out.println("다시 맞추시오");
					
					}

				}else {
					System.out.println("1번과 2번중 다시고르세요");
				}System.out.println("==============restart");

			}catch(Exception e) {
				System.out.println("숫자를 입력해주세요");

			}
		}

	}
}

