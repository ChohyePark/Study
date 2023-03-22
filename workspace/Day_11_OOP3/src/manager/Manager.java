package manager;

import java.util.ArrayList;

import classes.Member;

public class Manager {
	private ArrayList<Member> members = new ArrayList<>();
	
	public void insert(Member member) {
	members.add(member);	
	}
	
	public ArrayList<Member> getMembers() {
		return members;
	}
	
	// 매개변수가 있는 경우 매개변수가 다르기때문에 메서드이름 같게 해도 상관없음(overloading)
	
}
