package exams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//�˻�, ������ �߰��غ���
import java.util.Scanner;

import custom.Movie;
//��ȭ �׸��� �Է�,���,�˻�,����,������ �� �ִ� ���α׷� ����
public class MovieMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();
		ArrayList<Movie> movies = manager.getMovies();

		while(true) {

			System.out.println("<<Netflix Simulator>>");
			System.out.println("1. �ű� ��ȭ ���");
			System.out.println("2. ��ȭ ��� ���");
			System.out.println("0. ����");
			System.out.print(">> ");
			String menu = sc.nextLine();

			if(menu.equals("1")) {
				//��ȭ ����, �帣, ���� �Է� �޾Ƽ� movies[i] ĭ�� ���ο� Movie instance ����

				System.out.print("��ȭ ����: ");
				String title = sc.nextLine();
				System.out.print("�帣: ");
				String genre = sc.nextLine();
				System.out.print("����: ");
				double grade = Double.parseDouble(sc.nextLine());

				manager.addMovie(new Movie(title,genre,grade));
				System.out.println("��ϵǾ����ϴ�.");

			}else if(menu.equals("2")){
				System.out.println("<��ȭ ���>"); // ��ϵ� ��ȭ ������ŭ ���ʷ� ���
				for(Movie movie:movies) {
					System.out.println((movies.indexOf(movie)+1)+". "+movie.getTitle()+" / "+movie.getGenre()+" / "+movie.getGrade());
				}

				while(true) {
					System.out.println("<�߰� ����� �����ϼ���>");
					System.out.println("1. ��ȭ �˻�");
					System.out.println("2. �׸� ����");
					System.out.println("3. �׸� ����");
					System.out.println("0. ���� �޴��� ���ư���");
					System.out.print(">> ");
					String subMenu = sc.nextLine();

					if(subMenu.equals("1")) {
						while(true) {
							//�̸� ����, �帣�˻�, ���� ���� �̻��� ��ǰ
							System.out.println("1. ���� �˻�");
							System.out.println("2. �帣 �˻�");
							System.out.println("3. ���� ���� �˻�");
							System.out.println("0. ���� �޴��� ���ư���");
							System.out.print(">> ");
							String search = sc.nextLine();

							if(search.equals("1")) {
								System.out.println("�˻��� ������ �Է��ϼ���.");
								System.out.print(">> ");
								String scTitle = sc.nextLine();

								System.out.println("<'"+scTitle+"'��(��) ���Ե� ��ȭ���>");

								manager.searchByTitle(scTitle);
								
							}
							else if(search.equals("2")) {
								System.out.println("�˻��� �帣�� �Է��ϼ���.");
								System.out.print(">> ");
								String scGenre = sc.nextLine();

								System.out.println("<'"+scGenre+"' �帣 ��ȭ���>");
								
								manager.searchByGenre(scGenre);
								
							}
							else if(search.equals("3")) {
								System.out.println("������ �Է��ϼ���.");
								System.out.print(">> ");
								double scGrade = Double.parseDouble(sc.nextLine());

								System.out.println("<���� "+scGrade+"�� �̻� ��ȭ���>");
								
								manager.searchByGrade(scGrade);
								
							}
							else if(search.equals("0")) {
								System.out.println("���� �޴��� ���ư��ϴ�.");
								break;
							}
							else { //�޴� �̿��� � ���̵� �Է����� ��
								System.out.println("! �޴��� �ٽ� Ȯ���ϼ���. !");
								continue;
							}
						}

					}
					else if(subMenu.equals("2")) {
						while(true) {
						System.out.print("������ ��ȭ ��ȣ: ");
						int change = Integer.parseInt(sc.nextLine());
						
						if(movies.size()<change) {
							System.out.println("�ش� ��ȣ�� ��ȭ�� �������� �ʽ��ϴ�.");
							continue;
						}
						else {
							System.out.println("������ ������ �Է��ϼ���.");
						}

						System.out.print("��ȭ ����: ");
						String title = sc.nextLine();
						System.out.print("�帣: ");
						String genre = sc.nextLine();
						System.out.print("����: ");
						double grade = Double.parseDouble(sc.nextLine());

						movies.set(change-1, new Movie(title,genre,grade)); 
						//�ڸ��� 0������ �����ϹǷ� [change-1]��° ĭ �׸��� ���Է�
						break;
						}

					}
					else if(subMenu.equals("3")) {
						System.out.print("������ ��ȭ ��ȣ: ");
						int delete = Integer.parseInt(sc.nextLine());

						movies.remove(delete-1);
						
						System.out.println(delete+"�� ��ȭ�� �����Ǿ����ϴ�.");
					}
					else if(subMenu.equals("0")) {
						System.out.println("���� �޴��� ���ư��ϴ�.");
						break;
					}
					else { //�޴� �̿��� � ���̵� �Է����� ��
						System.out.println("! �޴��� �ٽ� Ȯ���ϼ���. !");
						continue;
					}
				}

			}

			else if(menu.equals("0")) {
				System.out.println("Netflix�� �����մϴ�.");
				System.exit(0);
			}else { //�޴� �̿��� � ���̵� �Է����� ��
				System.out.println("! �޴��� �ٽ� Ȯ���ϼ���. !");
			}
		}
	}
}
