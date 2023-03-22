package quiz02;

import java.util.ArrayList;

public class Manager {

	ArrayList<Contact> contactList = new ArrayList<>();
	
	public void addContact(Contact con) {
		contactList.add(con);
	}

	public ArrayList<Contact> getContactList() {
		return contactList;
	}
	
	

	
	
}
