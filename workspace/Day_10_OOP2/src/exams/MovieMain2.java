package exams;
import java.util.ArrayList;
import java.util.Scanner;

import custom.Movie;
//�� ���� �ڵ�� ���׷��̵� �ϱ�
public class MovieMain2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager(); //Model �ڵ带 �־�� Ŭ����
		
		
		while(true) {

			System.out.println("<<Netflix Simulator>>"); //sysout-->View
			System.out.println("1. �ű� ��ȭ ���");
			System.out.println("2. ��ȭ ��� ���");
			System.out.println("0. ����");
			System.out.print(">> ");
			String menu = sc.nextLine();//Scanner-->View

			if(menu.equals("1")) {
				
				System.out.print("��ȭ ����: ");
				String title = sc.nextLine();
				System.out.print("�帣: ");
				String genre = sc.nextLine();
				System.out.print("����: ");
				double grade = Double.parseDouble(sc.nextLine());

				//����������-->Model
				manager.addMovie(new Movie(title,genre,grade));
				 
				System.out.println("��ϵǾ����ϴ�.");

			}else if(menu.equals("2")){
				ArrayList<Movie> movies = manager.getMovies();
				
				System.out.println("<��ȭ ���>"); 
				int i=1;
				for(Movie movie:movies) {
					System.out.println(i+". "+movie.getTitle()+" / "+movie.getGenre()+" / "+movie.getGrade());
					i++;
				}
			}
			else if(menu.equals("0")) {
				System.out.println("Netflix�� �����մϴ�.");
				System.exit(0);
			}else { 
				System.out.println("! �޴��� �ٽ� Ȯ���ϼ���. !");
				continue;
			}
			
		}
	}
}
