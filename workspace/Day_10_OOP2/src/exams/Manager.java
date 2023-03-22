package exams;

import java.util.ArrayList;

import custom.Movie;

//View�� ���� ���� �ڵ带 �и��س���
public class Manager {
	//Movie �׸��� ���� Movie�� �迭 movies�� �����
	private ArrayList<Movie> movies = new ArrayList<>(); 
//	private int index=0; // Default Value
	
	//main���� movie���� �޾� movies�� index�ڸ��� �Է¹޴� �޼��� �ۼ�
	public void addMovie(Movie movie) {
		movies.add(movie);
	}
	
	//movies �迭�� ������ �� �ֵ��� �ϴ� �޼��� �ۼ�
	public ArrayList<Movie> getMovies() {
		return movies;
	}
	
	//index�� ������ �� �ֵ��� �ϴ� �޼��� �ۼ�
//	public int getIndex() {
//		return index;
//	}
	
	//���� �˻�� ���Ե� �׸�� ����ϴ� �޼���
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
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}
	
	public void searchByGenre(String scGenre) {
		int num=0;
		for(Movie movie:movies) { //�˻�� ���Ե� �׸� ���
			if(movie.getGenre().contains(scGenre)) {
				System.out.println((movies.indexOf(movie)+1)+". "
			+movie.getTitle()+" / "+movie.getGenre()+" / "+movie.getGrade());
				num++;
			}
		}
		if(num==0) { //�˻�� ���Ե� �׸��� �ϳ��� ���� �� ���
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}
	
	public void searchByGrade(double scGrade) {
		int num=0;
		for(Movie movie:movies) { //�˻� ���ǿ� �ش��ϴ� �׸� ���
			if(movie.getGrade()>=scGrade) {
				System.out.println((movies.indexOf(movie)+1)+". "
			+movie.getTitle()+" / "+movie.getGenre()+" / "+movie.getGrade());
				num++;
			}
		}
		if(num==0) { //�˻�� ���Ե� �׸��� �ϳ��� ���� �� ���
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}
}
