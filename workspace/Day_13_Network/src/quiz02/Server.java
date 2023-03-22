package quiz02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

//1. Ŭ���̾�Ʈ�� ������ ����
//2. Ŭ���̾�Ʈ�� ����� ����ID(1001~1100)�� �Է��� ������ ����
//3. Ŭ���̾�Ʈ�� ����� �̸��� �Է��� ������ ����
//4. Ŭ���̾�Ʈ�� ����� ����ó(��ȭ��ȣ)�� �Է��� ������ ����
//5. ������ Ŭ���̾�Ʈ�κ��� ���޵� �����͸� Contact Instance�� �����.
//	Contact--> private id,name,phone/getter&setter/defalut constructor
//6. ������ ������� �ν��Ͻ��� �����Ͱ��� ���� �ν��Ͻ��� manager�� ������ ArrayList�� �����Ѵ�.
//	(���� ��, ArrayList�� ���� ��� �����Ͱ� �ִ��� server console�� ����� ��)
//7. ���� �Ϸ� ��, ������ Ŭ���̾�Ʈ�� ����Ϸ� �ǹ̷� ack�� ��ȯ
//8. Ŭ���̾�Ʈ�� ack�� ��ȯ�Ǹ� ����ڿ��� "����Ϸ�"�޼����� ���
//9. 2~8�� �ݺ�
public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(33333);
		System.out.println("������ �����Ǿ����ϴ�.");
		Socket socket = server.accept();
		System.out.println(socket.getInetAddress()+"�� ���� �����");
		
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();
		
		while(true) {
			
			ArrayList<Contact> contactList = manager.getContactList();
			
			String id = dis.readUTF();
			String name = dis.readUTF();
			String phone = dis.readUTF();
			manager.addContact(new Contact(id,name,phone));
			
			//�̰� ������ �̷��� ������µ�, ������ Client�� ��� view ��Ҹ� ������.
			System.out.println("���ο� ����ó�� ����Ǿ����ϴ�.");
			System.out.println("���� "+contactList.size()+"���� ����ó�� �������Դϴ�.");
			
			dos.writeUTF("ack");// yes, ok�� �ǹ�(�ݴ�� nak)
			dos.flush();
			
			for(Contact con:contactList) {
				System.out.println(con.getId()+" / "+con.getName()+" / "+con.getPhone());
			}
			System.out.println("===========================");
		}
	}
}
