package custom;

public class Movie {
	public String title;
	private String genre;
	private double grade;
	
	public Movie() {} //생성자도 overloading 가능. 
	//명시적 constructor를 생성했다면 항상 기본 contructor도 다시 만들어둘것.
	
	public Movie(String title, String genre, double grade) {
		this.title = title;
		this.genre = genre;
		this.grade = grade;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	public void showInfo() {
		System.out.println("<영화 정보>");
		System.out.println("제목: "+title);
		System.out.println("장르: "+genre);
		System.out.println("평점: "+grade);
	}
}
