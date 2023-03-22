package quiz02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

//1. 클라이언트가 서버에 접속
//2. 클라이언트는 사람의 고유ID(1001~1100)를 입력해 서버에 전송
//3. 클라이언트는 사람의 이름을 입력해 서버에 전송
//4. 클라이언트는 사람의 연락처(전화번호)를 입력해 서버에 전송
//5. 서버는 클라이언트로부터 전달된 데이터를 Contact Instance로 만든다.
//	Contact--> private id,name,phone/getter&setter/defalut constructor
//6. 서버는 만들어진 인스턴스를 데이터관리 전용 인스턴스인 manager에 전달해 ArrayList에 보관한다.
//	(저장 후, ArrayList에 현재 몇개의 데이터가 있는지 server console에 출력할 것)
//7. 보관 완료 후, 서버는 클라이언트에 저장완료 의미로 ack를 반환
//8. 클라이언트는 ack가 반환되면 사용자에게 "저장완료"메세지를 출력
//9. 2~8번 반복
public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(33333);
		System.out.println("서버가 가동되었습니다.");
		Socket socket = server.accept();
		System.out.println(socket.getInetAddress()+"로 부터 연결됨");
		
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
			
			//이건 예제라서 이렇게 만들었는데, 원래는 Client가 모든 view 요소를 가진다.
			System.out.println("새로운 연락처가 저장되었습니다.");
			System.out.println("현재 "+contactList.size()+"개의 연락처를 보관중입니다.");
			
			dos.writeUTF("ack");// yes, ok의 의미(반대는 nak)
			dos.flush();
			
			for(Contact con:contactList) {
				System.out.println(con.getId()+" / "+con.getName()+" / "+con.getPhone());
			}
			System.out.println("===========================");
		}
	}
}
