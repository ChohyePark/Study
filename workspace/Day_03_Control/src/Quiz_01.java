import java.util.Scanner;

public class Quiz_01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("오늘의 점심메뉴를 선택하세요.");
		System.out.println("1.중식 2.한식 3.일식 ");
		System.out.print(">>");
		
		int menu = Integer.parseInt(sc.nextLine());
		
		if(menu >= 1 && menu <= 3) {
			if(menu == 1) {
				System.out.println("'우육면공방'이 68m 앞에 있습니다.");
			}else if(menu == 2 ) {
				System.out.println("'김밥일번가'가 84m 앞에 있습니다.");
			}else if(menu == 3 ) {
				System.out.println("'스시미토'가 164m 앞에 있습니다.");
			}
		}else {
			System.out.println("그런 선택지는 없습니다.");
		}

	}

}
