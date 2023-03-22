import java.util.Scanner;

public class Exam_01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("어떤 과일을 주문하시겠습니까?");
		System.out.println("1. 사과 2. 배 3. 수박 4. 오렌지");
		System.out.print(">>");
		int menu = Integer.parseInt(sc.nextLine());
		
		
		if(menu >= 1 && menu <= 3) {
			if(menu == 1) {
				System.out.println("사과 나왔습니다.");
			}else if(menu == 2) {
				System.out.println("배 나왔습니다.");
			}else if(menu == 3) {
				System.out.println("수박 나왔습니다.");
			}else if(menu == 4) {
				System.out.println("오렌지 나왔습니다.");
			}
		}else {
			System.out.println("없는 메뉴입니다.");
		}

	}

}
