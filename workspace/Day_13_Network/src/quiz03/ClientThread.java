package quiz03;
//����ó ���,���,�˻�,���� - ��������� ���ÿ� ���� �� �̿� �����ϵ���!
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

			if(menu.equals("1")) { //�ű� ����ó ���
				String id = dis.readUTF();
				String name = dis.readUTF();
				String phone = dis.readUTF();

				manager.addContact(new Contact(id,name,phone));
			}
			else if(menu.equals("2")) { //����ó ��� ���
				dos.writeUTF(""+contactList.size());
				dos.flush();

				for(Contact con:contactList) {
					dos.writeUTF(con.getId()+" / "+con.getName()+" / "+con.getPhone());
					dos.flush();
				}

			}
			else if(menu.equals("3")) { //�̸����� �˻�
				String scName = dis.readUTF();
				int k=0;
				for(Contact con:contactList) {
					if(scName.equals(con.getName())) {
						k++;
						dos.writeUTF(con.getId()+" / "+con.getName()+" / "+con.getPhone());
						dos.flush();
					}
				}
				if(k==0) { //�ش��ϴ� �̸��� ������ nak ��ȯ
					dos.writeUTF("nak");
					dos.flush();
				}
			}
			else if(menu.equals("4")) { //ID�� ����
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
				if(k==0) { //�ش��ϴ� �̸��� ������ nak ��ȯ
					dos.writeUTF("nak");
					dos.flush();
				}
			}
			else {

			}
		}catch(Exception e) {
			System.out.println("�ý��� ���� �Ұ�");
			System.exit(0);
		}
	}

}
