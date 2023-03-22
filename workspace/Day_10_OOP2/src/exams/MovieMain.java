package exams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//검색, 삭제도 추가해보기
import java.util.Scanner;

import custom.Movie;
//영화 항목을 입력,출력,검색,수정,삭제할 수 있는 프로그램 제작
public class MovieMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();
		ArrayList<Movie> movies = manager.getMovies();

		while(true) {

			System.out.println("<<Netflix Simulator>>");
			System.out.println("1. 신규 영화 등록");
			System.out.println("2. 영화 목록 출력");
			System.out.println("0. 종료");
			System.out.print(">> ");
			String menu = sc.nextLine();

			if(menu.equals("1")) {
				//영화 제목, 장르, 평점 입력 받아서 movies[i] 칸에 새로운 Movie instance 생성

				System.out.print("영화 제목: ");
				String title = sc.nextLine();
				System.out.print("장르: ");
				String genre = sc.nextLine();
				System.out.print("평점: ");
				double grade = Double.parseDouble(sc.nextLine());

				manager.addMovie(new Movie(title,genre,grade));
				System.out.println("등록되었습니다.");

			}else if(menu.equals("2")){
				System.out.println("<영화 목록>"); // 등록된 영화 개수만큼 차례로 출력
				for(Movie movie:movies) {
					System.out.println((movies.indexOf(movie)+1)+". "+movie.getTitle()+" / "+movie.getGenre()+" / "+movie.getGrade());
				}

				while(true) {
					System.out.println("<추가 기능을 선택하세요>");
					System.out.println("1. 영화 검색");
					System.out.println("2. 항목 수정");
					System.out.println("3. 항목 삭제");
					System.out.println("0. 이전 메뉴로 돌아가기");
					System.out.print(">> ");
					String subMenu = sc.nextLine();

					if(subMenu.equals("1")) {
						while(true) {
							//이름 포함, 장르검색, 평점 몇점 이상인 작품
							System.out.println("1. 제목 검색");
							System.out.println("2. 장르 검색");
							System.out.println("3. 평점 조건 검색");
							System.out.println("0. 이전 메뉴로 돌아가기");
							System.out.print(">> ");
							String search = sc.nextLine();

							if(search.equals("1")) {
								System.out.println("검색할 제목을 입력하세요.");
								System.out.print(">> ");
								String scTitle = sc.nextLine();

								System.out.println("<'"+scTitle+"'이(가) 포함된 영화목록>");

								manager.searchByTitle(scTitle);
								
							}
							else if(search.equals("2")) {
								System.out.println("검색할 장르를 입력하세요.");
								System.out.print(">> ");
								String scGenre = sc.nextLine();

								System.out.println("<'"+scGenre+"' 장르 영화목록>");
								
								manager.searchByGenre(scGenre);
								
							}
							else if(search.equals("3")) {
								System.out.println("평점을 입력하세요.");
								System.out.print(">> ");
								double scGrade = Double.parseDouble(sc.nextLine());

								System.out.println("<평점 "+scGrade+"점 이상 영화목록>");
								
								manager.searchByGrade(scGrade);
								
							}
							else if(search.equals("0")) {
								System.out.println("이전 메뉴로 돌아갑니다.");
								break;
							}
							else { //메뉴 이외의 어떤 값이든 입력했을 시
								System.out.println("! 메뉴를 다시 확인하세요. !");
								continue;
							}
						}

					}
					else if(subMenu.equals("2")) {
						while(true) {
						System.out.print("수정할 영화 번호: ");
						int change = Integer.parseInt(sc.nextLine());
						
						if(movies.size()<change) {
							System.out.println("해당 번호의 영화가 존재하지 않습니다.");
							continue;
						}
						else {
							System.out.println("수정할 내용을 입력하세요.");
						}

						System.out.print("영화 제목: ");
						String title = sc.nextLine();
						System.out.print("장르: ");
						String genre = sc.nextLine();
						System.out.print("평점: ");
						double grade = Double.parseDouble(sc.nextLine());

						movies.set(change-1, new Movie(title,genre,grade)); 
						//자리는 0번부터 시작하므로 [change-1]번째 칸 항목을 재입력
						break;
						}

					}
					else if(subMenu.equals("3")) {
						System.out.print("삭제할 영화 번호: ");
						int delete = Integer.parseInt(sc.nextLine());

						movies.remove(delete-1);
						
						System.out.println(delete+"번 영화가 삭제되었습니다.");
					}
					else if(subMenu.equals("0")) {
						System.out.println("이전 메뉴로 돌아갑니다.");
						break;
					}
					else { //메뉴 이외의 어떤 값이든 입력했을 시
						System.out.println("! 메뉴를 다시 확인하세요. !");
						continue;
					}
				}

			}

			else if(menu.equals("0")) {
				System.out.println("Netflix를 종료합니다.");
				System.exit(0);
			}else { //메뉴 이외의 어떤 값이든 입력했을 시
				System.out.println("! 메뉴를 다시 확인하세요. !");
			}
		}
	}
}
