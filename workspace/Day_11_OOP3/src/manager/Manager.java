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
	
	// �Ű������� �ִ� ��� �Ű������� �ٸ��⶧���� �޼����̸� ���� �ص� �������(overloading)
	
}
