package main;

import java.util.ArrayList;
import java.util.Scanner;

import custom.Item;
import custom.Manager;
import custom.Player;

public class RPGgame {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();
		ArrayList<Item> equipment = new ArrayList<>();
		ArrayList<Item> inventory = new ArrayList<>();

		System.out.println("");

		System.out.println("�÷��̾��� �̸��� �Է��ϼ���.");
		System.out.print(">> ");
		String name = sc.nextLine();
		Player player = new Player();
		player.setName(name);

		while(player.getHp()>0) {
			System.out.println("1. �� �̵�");
			System.out.println("2. ���� Ȯ��");
			System.out.println("3. ");
			System.out.print(">> ");
			String menu = sc.nextLine();
			if(menu.equals("1")) {
				here: while(true) {
					System.out.println("1. �����Ͽ콺");
					System.out.println("2. ��ȭ��");
					System.out.println("3. ������");
					System.out.println("4. �����");
					System.out.print(">> ");
					String map = sc.nextLine();

					if(map.equals("1")) {
						while(true) {
							System.out.println("1. �޽�");
							System.out.println("2. ��� ����");
							System.out.println("3. ���ư���");
							System.out.print(">> ");
							String houseMenu = sc.nextLine();

							if(houseMenu.equals("1")) {
								player.rest();
							}
							else if(houseMenu.equals("2")) {

							}
							else if(houseMenu.equals("3")){
								System.out.println("������ ���ư��ϴ�.");
								break here;
							}
							else {
								System.out.println("�޴��� �ٽ� Ȯ���ϼ���.");
								continue;
							}
						}

					}
					else if(map.equals("2")) {
						while(true) {
							System.out.println("1. ������ ����");
							System.out.println("2. ������ �Ǹ�");
							System.out.println("3. ������ ����");
							System.out.println("4. ���ư���");
							System.out.print(">> ");
							String storeMenu = sc.nextLine();

							if(storeMenu.equals("1")) {

							}
							else if(storeMenu.equals("2")) {

							}
							else if(storeMenu.equals("3")) {

							}
							else if(storeMenu.equals("4")) {
								System.out.println("������ ���ư��ϴ�.");
								break here;
							}
							else {
								System.out.println("�޴��� �ٽ� Ȯ���ϼ���.");
								continue;
							}
						}
					}
					else if(map.equals("3")) {
						Item item = new Item();
						System.out.println("1. ��� ����");
						System.out.println("2. ��� �Ǹ�");
						System.out.println("3. ��� ��ȭ");
						System.out.println("4. ���ư���");
						System.out.print(">> ");
						String armsMenu = sc.nextLine();

						if(armsMenu.equals("1")) {

						}
						else if(armsMenu.equals("2")) {
							System.out.println("");

						}
						else if(armsMenu.equals("3")) {
							
						}
						else if(armsMenu.equals("4")) {
							System.out.println("������ ���ư��ϴ�.");
							break here;
						}
						else {
							System.out.println("�޴��� �ٽ� Ȯ���ϼ���.");
							continue;
						}

					}
					else if(map.equals("4")) {
						System.out.println("����ͷ� �̵��մϴ�.");

						hunt: while(true) {
							System.out.println("1. ���� Ž��");
							System.out.println("2. ���� Ȯ��");
							System.out.println("3. ������ ��ȯ");
							System.out.print(">> ");
							String huntMenu = sc.nextLine();

							if(huntMenu.equals("1")) {
								while(true) {
									//���� ���� 
									System.out.println("��(��) �����ƽ��ϴ�.");
									System.out.println("1. �ο��"); 
									System.out.println("2. ��������");
									System.out.print(">> "); 
									String encounter = sc.nextLine();

									if(encounter.equals("1")) {
										while(true) {
											System.out.println("1. ����");
											System.out.println("2. ������ ���"); 
											System.out.println("3. ��������");
											System.out.print(">> "); 
											String hunting = sc.nextLine();

											if(hunting.equals("1")) {

											}
											else if(hunting.equals("2")) {

											}
											else if(hunting.equals("3")) {
												System.out.println("������ �����ƽ��ϴ�.");
												break hunt;
											}
											else {
												System.out.println("�޴��� �ٽ� Ȯ���ϼ���.");
												continue;
											}
										}

									}
									else if(encounter.equals("2")) {
										System.out.println("������ �����ƽ��ϴ�.");
										break;
									}
									else {
										System.out.println("�޴��� �ٽ� Ȯ���ϼ���.");
										continue;
									}
								}
							}

							else if(huntMenu.equals("2")) {
								player.showInfo();
							}
							else if(huntMenu.equals("3")) {
								System.out.println("������ ���ư��ϴ�.");
								break here;
							}
							else {
								System.out.println("�޴��� �ٽ� Ȯ���ϼ���.");
								continue;
							}
						}

					}


					else {
						System.out.println("�޴��� �ٽ� Ȯ���ϼ���.");
						continue;
					}
				}
			}
			else if(menu.equals("2")) {
				player.showInfo();
			}
			else {
				System.out.println("�޴��� �ٽ� Ȯ���ϼ���.");
				continue;
			}
		}
		System.out.println("<< Game Over >>");
		System.out.println(player.getName()+"��(��) ���� ���߽��ϴ�.");

	}
}

