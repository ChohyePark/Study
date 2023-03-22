package custom;

public class Movie {
	public String title;
	private String genre;
	private double grade;
	
	public Movie() {} //�����ڵ� overloading ����. 
	//����� constructor�� �����ߴٸ� �׻� �⺻ contructor�� �ٽ� �����Ѱ�.
	
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
		System.out.println("<��ȭ ����>");
		System.out.println("����: "+title);
		System.out.println("�帣: "+genre);
		System.out.println("����: "+grade);
	}
}
