package exam03;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket server=null;
		try {
			server = new ServerSocket(45000);
		}catch(Exception e) {
			System.exit(0);
		}
		System.out.println("������ �����߽��ϴ�.");

		while(true) {
			Socket sock = null;
			try {
				sock=server.accept();
				new FileThread(sock).start();

				System.out.println(sock.getInetAddress()+" ���� Ȯ��");
			}catch(Exception e) {
				System.out.println(sock.getInetAddress()+" ���� ����");
			}
		}

	}
}
