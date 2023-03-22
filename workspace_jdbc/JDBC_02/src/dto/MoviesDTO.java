package dto; //Data Transfer Object (�Ǵ� VO. value object) 
// ������ DAO��, �� main���� �����ϱ⸸ �ϴ� ��ü. (������ �����ϴ� ��ü)

public class MoviesDTO {
	private int id;
	private String title;
	private String genre;
	
	public MoviesDTO() {}
	public MoviesDTO(int id, String title, String genre) {
		super(); //��� Ŭ������ ����Ŭ������ object�� call�Ѵ�. �⺻���� �������.
		this.id=id;
		this.title=title;
		this.genre=genre;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
}
