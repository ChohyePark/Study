package kr.or.iei.func;

public class User {

	private String id;
	private String pw;
	private String name;
	private int age;
	private String phone;

	//생성자가 제대로 선언되지 않음!
//	public User() { // 뭘 상속받는거야??
//		super();
//	} 가 아니라
	public User() {}
	public User(String id, String pw, String name, int age, String phone) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}