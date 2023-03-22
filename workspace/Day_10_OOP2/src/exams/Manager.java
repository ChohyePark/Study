package exams;

import java.util.ArrayList;

import custom.Movie;

//View와 관련 없는 코드를 분리해내기
public class Manager {
	//Movie 항목을 받을 Movie형 배열 movies를 만들고
	private ArrayList<Movie> movies = new ArrayList<>(); 
//	private int index=0; // Default Value
	
	//main에서 movie값을 받아 movies의 index자리에 입력받는 메서드 작성
	public void addMovie(Movie movie) {
		movies.add(movie);
	}
	
	//movies 배열을 가져갈 수 있도록 하는 메서드 작성
	public ArrayList<Movie> getMovies() {
		return movies;
	}
	
	//index를 가져갈 수 있도록 하는 메서드 작성
//	public int getIndex() {
//		return index;
//	}
	
	//제목에 검색어가 포함된 항목들 출력하는 메서드
	public void searchByTitle(String scTitle) {
		int num=0;
		for(Movie movie:movies) {
			if(movie.getTitle().contains(scTitle)) {
				System.out.println((movies.indexOf(movie)+1)+". "
			+movie.getTitle()+" / "+movie.getGenre()+" / "+movie.getGrade());
				num++;
			}
		}
		if(num==0) {
			System.out.println("검색 결과가 없습니다.");
		}
	}
	
	public void searchByGenre(String scGenre) {
		int num=0;
		for(Movie movie:movies) { //검색어가 포함된 항목만 출력
			if(movie.getGenre().contains(scGenre)) {
				System.out.println((movies.indexOf(movie)+1)+". "
			+movie.getTitle()+" / "+movie.getGenre()+" / "+movie.getGrade());
				num++;
			}
		}
		if(num==0) { //검색어가 포함된 항목이 하나도 없을 시 출력
			System.out.println("검색 결과가 없습니다.");
		}
	}
	
	public void searchByGrade(double scGrade) {
		int num=0;
		for(Movie movie:movies) { //검색 조건에 해당하는 항목만 출력
			if(movie.getGrade()>=scGrade) {
				System.out.println((movies.indexOf(movie)+1)+". "
			+movie.getTitle()+" / "+movie.getGenre()+" / "+movie.getGrade());
				num++;
			}
		}
		if(num==0) { //검색어가 포함된 항목이 하나도 없을 시 출력
			System.out.println("검색 결과가 없습니다.");
		}
	}
}
