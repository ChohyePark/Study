package exams;

import java.util.ArrayList;
import java.util.Scanner;

import custom.Contact;
import custom.ManagerContact;

//Contact 클래스 설계
//이름, 전화번호, 이메일
//getter, setter, constructor, 정보은닉

//홍길동/01012344321/hong@naver.com
//조성태/01090062139/stj@gmail.com
public class ContactMain {
	public static void main(String[] args) {
		ManagerContact manager = new ManagerContact();
		Scanner sc = new Scanner(System.in);
		ArrayList<Contact> contactList = manager.getContactList();

		while(true) {
			System.out.println("=== 연락처 관리 프로그램 ===");
			System.out.println("1. 연락처 등록");
			System.out.println("2. 연락처 목록 확인");
			System.out.println("3. 연락처 검색");
			System.out.println("4. 연락처 수정");
			System.out.println("5. 연락처 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print(">> ");
			String menu = sc.nextLine();
			System.out.println();

			if(menu.equals("1")) {
				System.out.println("새로운 연락처를 등록하세요.");
				System.out.print("이름: ");
				String name = sc.nextLine();
				System.out.print("전화번호: ");
				String phone = sc.nextLine();
				System.out.print("이메일: ");
				String email = sc.nextLine();

				manager.addContact(new Contact(name,phone,email));
				System.out.println("연락처가 등록되었습니다.\n");
			}
			else if(menu.equals("2")) {
				System.out.println("<비상연락망>");
				manager.showList();
				System.out.println();
			}
			else if(menu.equals("3")) {
				while(true) {
					System.out.println("1. 이름 검색");
					System.out.println("2. 전화번호 검색");
					System.out.println("3. 이메일 검색");
					System.out.println("0. 이전 메뉴로 돌아가기");
					System.out.print(">> ");
					String scMenu = sc.nextLine();

					if(scMenu.equals("1")) {
						System.out.print("검색할 이름: ");
						String scName = sc.nextLine();

						manager.searchName(scName);
						break;
					}
					else if(scMenu.equals("2")){
						System.out.print("검색할 전화번호: ");
						String scPhone = sc.nextLine();

						manager.searchPhone(scPhone);
						break;
					}
					else if(scMenu.equals("3")) {
						System.out.print("검색할 이메일: ");
						String scEmail = sc.nextLine();

						manager.searchEmail(scEmail);
						break;
					}
					else if(scMenu.equals("0")) {
						System.out.println("이전 메뉴로 돌아갑니다.");
						break;
					}
					else {
						System.out.println("메뉴를 다시 확인하세요.");
						continue;
					}
				}
			}
			else if(menu.equals("4")) {
				while(true) {

					System.out.println("몇 번 연락처를 수정하시겠습니까? [0 입력시 취소]");
					System.out.print(">> ");
					int num = Integer.parseInt(sc.nextLine());

					if(num==0) {
						System.out.println("수정을 취소합니다.");
						break;
					}
					else if(num>contactList.size()) {
						System.out.println("해당 번호의 연락처가 존재하지 않습니다.");
						continue;
					}
					else {
						System.out.println("수정할 정보로 재입력해주세요.");
						System.out.print("이름: ");
						String name = sc.nextLine();
						System.out.print("전화번호: ");
						String phone = sc.nextLine();
						System.out.print("이메일: ");
						String email = sc.nextLine();

						manager.edit(num-1, new Contact(name,phone,email));
						break;
					}
				}
			}
			else if(menu.equals("5")) {
				while(true) {

					System.out.println("몇 번 연락처를 삭제하시겠습니까? [0 입력시 취소]");
					System.out.print(">> ");
					int num = Integer.parseInt(sc.nextLine());

					if(num==0) {
						System.out.println("삭제를 취소합니다.");
						break;
					}
					else if(num>contactList.size()) {
						System.out.println("해당 번호의 연락처가 존재하지 않습니다.");
						continue;
					}
					else {
						manager.delete(num-1);
						break;
					}
				}
			}
			else if(menu.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			else {
				System.out.println("! 메뉴를 다시 확인하세요. !");
				continue;
			}
		}
	}
}
