package main;

import java.util.Scanner;

import classes.Gold;
import classes.Silver;
import manager.Manager;

public class Main {
	public static void main(String[] args) {
		//���� ���� �� �߱޹�����
		//���
		//������ **
		//�߻�ȭ
		//Collection **

		//ȸ������ �ý��� �ۼ�
		//��� Ŭ���� ����. ( ���� Silver�� )
		//����: ȸ���� �̸�,����ID,����Ʈ
		
		//�ϼ��� �ڵ��� ������ �� ����
		//1. �ڵ� �ߺ��� ���� - ��޸��� �Ȱ��� �ڵ尡 �ڲ� �ݺ� (�������� ����) 
		// --> solution: "���" - �ϳ��� �ٲٸ� ���� ����
		//2. �ڵ� ���յ�(������) ���� - �ϳ��� Ŭ������ ������ ����� �ٸ� Ŭ������ ������ ��.(�������� ����) ���յ��� �������� ����.
		// --> solution: "������"
		//3. ����� ���� - ������ �����Ǿ� �ִ� �迭 ��� 
		// --> solution: "Collection" - ���� �迭!!
		
		//���� �ڵ�
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
				//			System.out.print("���̵�: ");
				//			String id = Integer.parseInt(sc.nextLine());
				//			System.out.print("�̸�: ");
				//			String name = sc.nextLine();
				//			System.out.print("����Ʈ: "); 
				//			int point = Integer.parseInt(sc.nextLine()); 

				//�� �ڵ带 ���� ������ ����� �Է¹޾Ҵٰ� ġ��. (��Ȱ�� �ǽ��� ����)
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
				System.out.println("�ý����� �����մϴ�.");
				System.exit(0);
			}
			else {
				System.out.println("�޴��� �ٽ� Ȯ�����ּ���.");
			}
		}
	}
}
