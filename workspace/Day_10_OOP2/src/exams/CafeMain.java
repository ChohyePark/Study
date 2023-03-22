package exams;

import java.util.ArrayList;
import java.util.Scanner;

import custom.CafeMenu;
import custom.ManagerCafe;

//CafeMenu 클래스 설계
//상품번호(숫자), 상품명(문자열), 가격(숫자)
//getter, setter, constructor, 정보은닉

//다음 메뉴 인스턴스 생성
//1001/Americano/2500
//1002/CafeLatte/3000
public class CafeMain {
	public static void main(String[] args) {

		ManagerCafe manager = new ManagerCafe();
		ArrayList<CafeMenu> menus = manager.getMenus();
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("=== 카페 메뉴 관리 프로그램 ===");
			System.out.println("1. 신규 메뉴 등록 ");
			System.out.println("2. 메뉴 목록 확인");
			System.out.println("3. 메뉴 검색");
			System.out.println("4. 메뉴 수정");
			System.out.println("5. 메뉴 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print(">> ");
			String select = sc.nextLine();

			if(select.equals("1")) {

				System.out.println("등록할 메뉴 정보를 입력하세요.");
				System.out.println("메뉴 이름: ");
				String name = sc.nextLine();
				System.out.println("가격: ");
				int price = Integer.parseInt(sc.nextLine());
				
				manager.addMenu(new CafeMenu(name,price));
				

				//썼다 치고~
				manager.addMenu(new CafeMenu("Americano",2500));
				manager.addMenu(new CafeMenu("CafeLatte",3000));
			}

			else if(select.equals("2")) {

			}
			else if(select.equals("3")) {

			}
			else if(select.equals("4")) {

			}
			else if(select.equals("5")) {

			}
			else if(select.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);

			}
			else {
				System.out.println("메뉴를 다시 확인하세요.");
				continue;
			}
		}



	}
}
