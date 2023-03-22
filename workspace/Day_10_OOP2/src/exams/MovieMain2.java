package exams;
import java.util.ArrayList;
import java.util.Scanner;

import custom.Movie;
//더 좋은 코드로 업그레이드 하기
public class MovieMain2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager(); //Model 코드를 넣어둔 클래스
		
		
		while(true) {

			System.out.println("<<Netflix Simulator>>"); //sysout-->View
			System.out.println("1. 신규 영화 등록");
			System.out.println("2. 영화 목록 출력");
			System.out.println("0. 종료");
			System.out.print(">> ");
			String menu = sc.nextLine();//Scanner-->View

			if(menu.equals("1")) {
				
				System.out.print("영화 제목: ");
				String title = sc.nextLine();
				System.out.print("장르: ");
				String genre = sc.nextLine();
				System.out.print("평점: ");
				double grade = Double.parseDouble(sc.nextLine());

				//데이터저장-->Model
				manager.addMovie(new Movie(title,genre,grade));
				 
				System.out.println("등록되었습니다.");

			}else if(menu.equals("2")){
				ArrayList<Movie> movies = manager.getMovies();
				
				System.out.println("<영화 목록>"); 
				int i=1;
				for(Movie movie:movies) {
					System.out.println(i+". "+movie.getTitle()+" / "+movie.getGenre()+" / "+movie.getGrade());
					i++;
				}
			}
			else if(menu.equals("0")) {
				System.out.println("Netflix를 종료합니다.");
				System.exit(0);
			}else { 
				System.out.println("! 메뉴를 다시 확인하세요. !");
				continue;
			}
			
		}
	}
}
