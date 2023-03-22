package dto; //Data Transfer Object (또는 VO. value object) 
// 정보를 DAO로, 또 main으로 전달하기만 하는 객체. (값만을 저장하는 객체)

public class MoviesDTO {
	private int id;
	private String title;
	private String genre;
	
	public MoviesDTO() {}
	public MoviesDTO(int id, String title, String genre) {
		super(); //모든 클래스의 상위클래스인 object를 call한다. 기본으로 들어있음.
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
