package exams;

import java.util.ArrayList;
import java.util.Scanner;

import custom.CafeMenu;
import custom.ManagerCafe;

//CafeMenu Ŭ���� ����
//��ǰ��ȣ(����), ��ǰ��(���ڿ�), ����(����)
//getter, setter, constructor, ��������

//���� �޴� �ν��Ͻ� ����
//1001/Americano/2500
//1002/CafeLatte/3000
public class CafeMain {
	public static void main(String[] args) {

		ManagerCafe manager = new ManagerCafe();
		ArrayList<CafeMenu> menus = manager.getMenus();
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("=== ī�� �޴� ���� ���α׷� ===");
			System.out.println("1. �ű� �޴� ��� ");
			System.out.println("2. �޴� ��� Ȯ��");
			System.out.println("3. �޴� �˻�");
			System.out.println("4. �޴� ����");
			System.out.println("5. �޴� ����");
			System.out.println("0. ���α׷� ����");
			System.out.print(">> ");
			String select = sc.nextLine();

			if(select.equals("1")) {

				System.out.println("����� �޴� ������ �Է��ϼ���.");
				System.out.println("�޴� �̸�: ");
				String name = sc.nextLine();
				System.out.println("����: ");
				int price = Integer.parseInt(sc.nextLine());
				
				manager.addMenu(new CafeMenu(name,price));
				

				//��� ġ��~
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
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);

			}
			else {
				System.out.println("�޴��� �ٽ� Ȯ���ϼ���.");
				continue;
			}
		}



	}
}
