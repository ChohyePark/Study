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

		System.out.println("플레이어의 이름을 입력하세요.");
		System.out.print(">> ");
		String name = sc.nextLine();
		Player player = new Player();
		player.setName(name);

		while(player.getHp()>0) {
			System.out.println("1. 맵 이동");
			System.out.println("2. 상태 확인");
			System.out.println("3. ");
			System.out.print(">> ");
			String menu = sc.nextLine();
			if(menu.equals("1")) {
				here: while(true) {
					System.out.println("1. 마이하우스");
					System.out.println("2. 잡화점");
					System.out.println("3. 가공점");
					System.out.println("4. 사냥터");
					System.out.print(">> ");
					String map = sc.nextLine();

					if(map.equals("1")) {
						while(true) {
							System.out.println("1. 휴식");
							System.out.println("2. 장비 변경");
							System.out.println("3. 돌아가기");
							System.out.print(">> ");
							String houseMenu = sc.nextLine();

							if(houseMenu.equals("1")) {
								player.rest();
							}
							else if(houseMenu.equals("2")) {

							}
							else if(houseMenu.equals("3")){
								System.out.println("마을로 돌아갑니다.");
								break here;
							}
							else {
								System.out.println("메뉴를 다시 확인하세요.");
								continue;
							}
						}

					}
					else if(map.equals("2")) {
						while(true) {
							System.out.println("1. 아이템 구입");
							System.out.println("2. 아이템 판매");
							System.out.println("3. 아이템 조합");
							System.out.println("4. 돌아가기");
							System.out.print(">> ");
							String storeMenu = sc.nextLine();

							if(storeMenu.equals("1")) {

							}
							else if(storeMenu.equals("2")) {

							}
							else if(storeMenu.equals("3")) {

							}
							else if(storeMenu.equals("4")) {
								System.out.println("마을로 돌아갑니다.");
								break here;
							}
							else {
								System.out.println("메뉴를 다시 확인하세요.");
								continue;
							}
						}
					}
					else if(map.equals("3")) {
						Item item = new Item();
						System.out.println("1. 장비 구입");
						System.out.println("2. 장비 판매");
						System.out.println("3. 장비 강화");
						System.out.println("4. 돌아가기");
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
							System.out.println("마을로 돌아갑니다.");
							break here;
						}
						else {
							System.out.println("메뉴를 다시 확인하세요.");
							continue;
						}

					}
					else if(map.equals("4")) {
						System.out.println("사냥터로 이동합니다.");

						hunt: while(true) {
							System.out.println("1. 몬스터 탐색");
							System.out.println("2. 상태 확인");
							System.out.println("3. 마을로 귀환");
							System.out.print(">> ");
							String huntMenu = sc.nextLine();

							if(huntMenu.equals("1")) {
								while(true) {
									//몬스터 조우 
									System.out.println("와(과) 마주쳤습니다.");
									System.out.println("1. 싸운다"); 
									System.out.println("2. 도망간다");
									System.out.print(">> "); 
									String encounter = sc.nextLine();

									if(encounter.equals("1")) {
										while(true) {
											System.out.println("1. 전투");
											System.out.println("2. 아이템 사용"); 
											System.out.println("3. 도망가기");
											System.out.print(">> "); 
											String hunting = sc.nextLine();

											if(hunting.equals("1")) {

											}
											else if(hunting.equals("2")) {

											}
											else if(hunting.equals("3")) {
												System.out.println("무사히 도망쳤습니다.");
												break hunt;
											}
											else {
												System.out.println("메뉴를 다시 확인하세요.");
												continue;
											}
										}

									}
									else if(encounter.equals("2")) {
										System.out.println("무사히 도망쳤습니다.");
										break;
									}
									else {
										System.out.println("메뉴를 다시 확인하세요.");
										continue;
									}
								}
							}

							else if(huntMenu.equals("2")) {
								player.showInfo();
							}
							else if(huntMenu.equals("3")) {
								System.out.println("마을로 돌아갑니다.");
								break here;
							}
							else {
								System.out.println("메뉴를 다시 확인하세요.");
								continue;
							}
						}

					}


					else {
						System.out.println("메뉴를 다시 확인하세요.");
						continue;
					}
				}
			}
			else if(menu.equals("2")) {
				player.showInfo();
			}
			else {
				System.out.println("메뉴를 다시 확인하세요.");
				continue;
			}
		}
		System.out.println("<< Game Over >>");
		System.out.println(player.getName()+"이(가) 힘이 다했습니다.");

	}
}

