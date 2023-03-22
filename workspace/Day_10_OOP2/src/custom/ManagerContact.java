package custom;

import java.util.ArrayList;

public class ManagerContact {
	
	private ArrayList<Contact> contactList = new ArrayList<>();
	
	public ArrayList<Contact> getContactList() {
		return contactList;
	}

	public void addContact(Contact con) {
		contactList.add(con);
	}
	
	public void showList() {
		for(Contact con:contactList) {
			System.out.println((contactList.indexOf(con)+1)+". "+con.getName()+" / "+con.getPhone()+" / "+con.getEmail());
		}
	}
	
	public void searchName(String scName) {
		int num=0;
		System.out.println("<'"+scName+"'에 대한 검색 결과>");
		for(Contact con:contactList) {
			if(con.getName().contains(scName)) {
				System.out.println((contactList.indexOf(con)+1)+". "+con.getName()+" / "+con.getPhone()+" / "+con.getEmail());
			num++;
			}
		}
		if(num==0) {
			System.out.println("검색 결과가 없습니다.");
		}
		System.out.println();
	}
	public void searchPhone(String scPhone) {
		int num=0;
		System.out.println("<'"+scPhone+"'에 대한 검색 결과>");
		for(Contact con:contactList) {
			if(con.getPhone().contains(scPhone)) {
				System.out.println((contactList.indexOf(con)+1)+". "+con.getName()+" / "+con.getPhone()+" / "+con.getEmail());
			num++;
			}
		}
		if(num==0) {
			System.out.println("검색 결과가 없습니다.");
		}
		System.out.println();
		
	}
	public void searchEmail(String scEmail) {
		int num=0;
		System.out.println("<'"+scEmail+"'에 대한 검색 결과>");
		for(Contact con:contactList) {
			if(con.getEmail().contains(scEmail)) {
				System.out.println((contactList.indexOf(con)+1)+". "+con.getName()+" / "+con.getPhone()+" / "+con.getEmail());
			num++;
			}
		}
		if(num==0) {
			System.out.println("검색 결과가 없습니다.");
		}
		System.out.println();
	}
	
	public void edit(int num, Contact con) {
		contactList.set(num, con);
		System.out.println("수정되었습니다.");
		System.out.println();
	}
	
	public void delete(int num) {
		contactList.remove(num);
		System.out.println("삭제되었습니다.");
		System.out.println();
	}

}
