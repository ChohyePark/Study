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
		// ���, ������ �����ؼ� �ڵ� ����

		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();
		
		while(true) {
			System.out.println("=== ȸ�� ���� �ý��� ===");
			System.out.println("1. �ű� ȸ�� ���");
			System.out.println("2. ȸ�� ���� ���");
			System.out.println("0. ����");
			System.out.print(">> ");
			String menu = sc.nextLine();
			
			if(menu.equals("1")) {
//							System.out.print("���̵�: ");
//							int id = Integer.parseInt(sc.nextLine());
//							System.out.print("�̸�: ");
//							String name = sc.nextLine();
//							System.out.print("����Ʈ: "); 
//							double point = Double.parseDouble(sc.nextLine()); 
//				 			if(point<=3000) {manager.insert(new Silver(id,name,point));}
//							else if(point<=4000) {manager.insert(new Gold(id,name,point));}
//							else if(point<=5000) {manager.insert(new Ruby(id,name,point));}

				//�� �ڵ带 ���� �Ʒ� ������� �Է¹޾Ҵٰ� ġ��. (��Ȱ�� �ǽ��� ����)
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
				System.out.println("�ý����� �����մϴ�.");
				System.exit(0);
			}
			else {
				System.out.println("�޴��� �ٽ� Ȯ�����ּ���.");
			}
		}
	}
}
