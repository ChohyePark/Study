package quiz03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import quiz02.Contact;
import quiz02.Manager;

public class Server {

	public static void main(String[] args) {
		ServerSocket server=null;
		try {
			server = new ServerSocket(33333);
		}catch(Exception e) {
			System.out.println("서버를 구동할 수 없습니다.");
			System.exit(0);
		}
		System.out.println("서버가 가동되었습니다.");



		while(true) {
			Socket socket=null;
			try {
				socket = server.accept();

				ClientThread ct = new ClientThread(socket);
				ct.start();
			}catch(Exception e) {
				System.out.println(socket.getInetAddress()+" 접속해제");
			}



		}


	}

}
