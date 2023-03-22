package exams;

import java.util.ArrayList;
import java.util.Scanner;

import custom.Contact;
import custom.ManagerContact;

//Contact Ŭ���� ����
//�̸�, ��ȭ��ȣ, �̸���
//getter, setter, constructor, ��������

//ȫ�浿/01012344321/hong@naver.com
//������/01090062139/stj@gmail.com
public class ContactMain {
	public static void main(String[] args) {
		ManagerContact manager = new ManagerContact();
		Scanner sc = new Scanner(System.in);
		ArrayList<Contact> contactList = manager.getContactList();

		while(true) {
			System.out.println("=== ����ó ���� ���α׷� ===");
			System.out.println("1. ����ó ���");
			System.out.println("2. ����ó ��� Ȯ��");
			System.out.println("3. ����ó �˻�");
			System.out.println("4. ����ó ����");
			System.out.println("5. ����ó ����");
			System.out.println("0. ���α׷� ����");
			System.out.print(">> ");
			String menu = sc.nextLine();
			System.out.println();

			if(menu.equals("1")) {
				System.out.println("���ο� ����ó�� ����ϼ���.");
				System.out.print("�̸�: ");
				String name = sc.nextLine();
				System.out.print("��ȭ��ȣ: ");
				String phone = sc.nextLine();
				System.out.print("�̸���: ");
				String email = sc.nextLine();

				manager.addContact(new Contact(name,phone,email));
				System.out.println("����ó�� ��ϵǾ����ϴ�.\n");
			}
			else if(menu.equals("2")) {
				System.out.println("<��󿬶���>");
				manager.showList();
				System.out.println();
			}
			else if(menu.equals("3")) {
				while(true) {
					System.out.println("1. �̸� �˻�");
					System.out.println("2. ��ȭ��ȣ �˻�");
					System.out.println("3. �̸��� �˻�");
					System.out.println("0. ���� �޴��� ���ư���");
					System.out.print(">> ");
					String scMenu = sc.nextLine();

					if(scMenu.equals("1")) {
						System.out.print("�˻��� �̸�: ");
						String scName = sc.nextLine();

						manager.searchName(scName);
						break;
					}
					else if(scMenu.equals("2")){
						System.out.print("�˻��� ��ȭ��ȣ: ");
						String scPhone = sc.nextLine();

						manager.searchPhone(scPhone);
						break;
					}
					else if(scMenu.equals("3")) {
						System.out.print("�˻��� �̸���: ");
						String scEmail = sc.nextLine();

						manager.searchEmail(scEmail);
						break;
					}
					else if(scMenu.equals("0")) {
						System.out.println("���� �޴��� ���ư��ϴ�.");
						break;
					}
					else {
						System.out.println("�޴��� �ٽ� Ȯ���ϼ���.");
						continue;
					}
				}
			}
			else if(menu.equals("4")) {
				while(true) {

					System.out.println("�� �� ����ó�� �����Ͻðڽ��ϱ�? [0 �Է½� ���]");
					System.out.print(">> ");
					int num = Integer.parseInt(sc.nextLine());

					if(num==0) {
						System.out.println("������ ����մϴ�.");
						break;
					}
					else if(num>contactList.size()) {
						System.out.println("�ش� ��ȣ�� ����ó�� �������� �ʽ��ϴ�.");
						continue;
					}
					else {
						System.out.println("������ ������ ���Է����ּ���.");
						System.out.print("�̸�: ");
						String name = sc.nextLine();
						System.out.print("��ȭ��ȣ: ");
						String phone = sc.nextLine();
						System.out.print("�̸���: ");
						String email = sc.nextLine();

						manager.edit(num-1, new Contact(name,phone,email));
						break;
					}
				}
			}
			else if(menu.equals("5")) {
				while(true) {

					System.out.println("�� �� ����ó�� �����Ͻðڽ��ϱ�? [0 �Է½� ���]");
					System.out.print(">> ");
					int num = Integer.parseInt(sc.nextLine());

					if(num==0) {
						System.out.println("������ ����մϴ�.");
						break;
					}
					else if(num>contactList.size()) {
						System.out.println("�ش� ��ȣ�� ����ó�� �������� �ʽ��ϴ�.");
						continue;
					}
					else {
						manager.delete(num-1);
						break;
					}
				}
			}
			else if(menu.equals("0")) {
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
			else {
				System.out.println("! �޴��� �ٽ� Ȯ���ϼ���. !");
				continue;
			}
		}
	}
}
