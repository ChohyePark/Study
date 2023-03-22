package quiz03;
//연락처 등록,출력,검색,삭제 - 여러사람이 동시에 입장 및 이용 가능하도록!
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import quiz02.Contact;
import quiz02.Manager;

public class ClientThread extends Thread{

	private Socket socket;

	public ClientThread(Socket socket) {
		this.socket = socket;
	}

	public static Manager manager = new Manager();
	public static ArrayList<Contact> contactList = manager.getContactList();
	
	public void run() {

		
		try {
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);

			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			String menu = dis.readUTF();

			if(menu.equals("1")) { //신규 연락처 등록
				String id = dis.readUTF();
				String name = dis.readUTF();
				String phone = dis.readUTF();

				manager.addContact(new Contact(id,name,phone));
			}
			else if(menu.equals("2")) { //연락처 목록 출력
				dos.writeUTF(""+contactList.size());
				dos.flush();

				for(Contact con:contactList) {
					dos.writeUTF(con.getId()+" / "+con.getName()+" / "+con.getPhone());
					dos.flush();
				}

			}
			else if(menu.equals("3")) { //이름으로 검색
				String scName = dis.readUTF();
				int k=0;
				for(Contact con:contactList) {
					if(scName.equals(con.getName())) {
						k++;
						dos.writeUTF(con.getId()+" / "+con.getName()+" / "+con.getPhone());
						dos.flush();
					}
				}
				if(k==0) { //해당하는 이름이 없으면 nak 반환
					dos.writeUTF("nak");
					dos.flush();
				}
			}
			else if(menu.equals("4")) { //ID로 삭제
				String scId = dis.readUTF();
				int k=0;
				ArrayList<Contact> tmp = new ArrayList<>();
				for(Contact con:contactList) {
					if(con.getId().equals(scId)) {
						k++;
						tmp.add(con);
						dos.writeUTF(scId);
						dos.flush();
					}
				}
				contactList.removeAll(tmp);
				if(k==0) { //해당하는 이름이 없으면 nak 반환
					dos.writeUTF("nak");
					dos.flush();
				}
			}
			else {

			}
		}catch(Exception e) {
			System.out.println("시스템 가동 불가");
			System.exit(0);
		}
	}

}
