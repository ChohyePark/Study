package main;

import java.util.Scanner;

import classes.Gold;
import classes.Silver;
import manager.Manager;

public class Main {
	public static void main(String[] args) {
		//새로 배우게 될 중급문법들
		//상속
		//다형성 **
		//추상화
		//Collection **

		//회원관리 시스템 작성
		//등급 클래스 설계. ( 아직 Silver만 )
		//정보: 회원의 이름,고유ID,포인트
		
		//완성된 코드의 문제점 세 가지
		//1. 코드 중복도 문제 - 등급마다 똑같은 코드가 자꾸 반복 (유지보수 문제) 
		// --> solution: "상속" - 하나만 바꾸면 전부 변경
		//2. 코드 결합도(의존도) 문제 - 하나의 클래스에 문제가 생기면 다른 클래스도 못쓰게 됨.(유지보수 문제) 결합도가 낮을수록 좋다.
		// --> solution: "다형성"
		//3. 저장소 문제 - 공간이 지정되어 있는 배열 사용 
		// --> solution: "Collection" - 동적 배열!!
		
		//원래 코드
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
				//			System.out.print("아이디: ");
				//			String id = Integer.parseInt(sc.nextLine());
				//			System.out.print("이름: ");
				//			String name = sc.nextLine();
				//			System.out.print("포인트: "); 
				//			int point = Integer.parseInt(sc.nextLine()); 

				//위 코드를 통해 세명의 멤버를 입력받았다고 치자. (원활한 실습을 위해)
				manager.insert(new Silver(1001,"Tom",1000));
				manager.insert(new Silver(1002,"Jane",2000));
				manager.insert(new Silver(1003,"Mike",3000));
				manager.insert(new Gold(1004,"Susan",4000));
				
			}
			else if(menu.equals("2")) {

				Silver[] silverMembers = manager.getSilverMembers();
				Gold[] goldMembers = manager.getGoldMembers();
				
				System.out.println("ID\tName\tPoint\tBonus");
				for(int i=0;i<manager.getSilverIndex();i++) {
					System.out.println(silverMembers[i].getId()+"\t"+silverMembers[i].getName()+"\t"+silverMembers[i].getPoint()+"\t"+silverMembers[i].getBonus());
				}
				for(int i=0;i<manager.getGoldIndex();i++) {
					System.out.println(goldMembers[i].getId()+"\t"+goldMembers[i].getName()+"\t"+goldMembers[i].getPoint()+"\t"+goldMembers[i].getBonus());
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
