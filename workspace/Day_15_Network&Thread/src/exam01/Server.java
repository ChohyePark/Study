package exam01;

import java.net.ServerSocket;
import java.net.Socket;

import thread.ClientThread;

//이번엔 스레드 코드를 따로 빼서 클래스로 만든다.

public class Server {
	public static void main(String[] args) {
		//강사님의 Server 코드
		ServerSocket server = null;
		try {
			server = new ServerSocket(35000);
		}catch(Exception e) {
			System.out.println("서버를 구동할 수 없습니다.");
			System.exit(0);
		}
		System.out.println("서버를 가동했습니다.");
		//-------------------------------------------------서버가동


		Socket sock = null;
		while(true) { //여러사람이 각각의 스레드로 들어와서 메세지를 입력. 동시에 이용 가능
			try {
				sock = server.accept();
				
				ClientThread ct = new ClientThread(sock);
				ct.start();
				
			}catch(Exception e) {
				System.out.println(sock.getInetAddress()+": 접속해제");
			}
		}
	}
}
