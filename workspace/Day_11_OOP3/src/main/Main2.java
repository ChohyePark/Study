package main;

import java.util.ArrayList;
import java.util.Scanner;

import classes.Gold;
import classes.Member;
import classes.Ruby;
import classes.Silver;
import manager.Manager;

public class Main2 {
	public static void main(String[] args) {
		// 상속, 다형성 적용해서 코드 수정

		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();
		
		while(true) {
			System.out.println("=== 회원 관리 시스템 ===");
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 정보 출력");
			System.out.println("0. 종료");
			System.out.print(">> ");
			String menu = sc.nextLine();
			
			if(menu.equals("1")) {
//							System.out.print("아이디: ");
//							int id = Integer.parseInt(sc.nextLine());
//							System.out.print("이름: ");
//							String name = sc.nextLine();
//							System.out.print("포인트: "); 
//							double point = Double.parseDouble(sc.nextLine()); 
//				 			if(point<=3000) {manager.insert(new Silver(id,name,point));}
//							else if(point<=4000) {manager.insert(new Gold(id,name,point));}
//							else if(point<=5000) {manager.insert(new Ruby(id,name,point));}

				//위 코드를 통해 아래 멤버들을 입력받았다고 치자. (원활한 실습을 위해)
				manager.insert(new Silver(1001,"Tom",1000));
				manager.insert(new Silver(1002,"Jane",2000));
				manager.insert(new Silver(1003,"Mike",3000));
				manager.insert(new Gold(1004,"Susan",4000));
				manager.insert(new Ruby(1005,"Jack",5000));
				
			}
			else if(menu.equals("2")) {
				ArrayList<Member> members = manager.getMembers();

				System.out.println("ID\tName\tPoint\tBonus");
				
				for(Member member :members) { //
					System.out.println(member.getId()+"\t"+member.getName()+"\t"+member.getPoint()+"\t"+member.getBonus());
				}
			}
			else if(menu.equals("0")) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			}
			else {
				System.out.println("메뉴를 다시 확인해주세요.");
			}
		}
	}
}
