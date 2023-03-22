package exam01;

import java.net.ServerSocket;
import java.net.Socket;

import thread.ClientThread;

//�̹��� ������ �ڵ带 ���� ���� Ŭ������ �����.

public class Server {
	public static void main(String[] args) {
		//������� Server �ڵ�
		ServerSocket server = null;
		try {
			server = new ServerSocket(35000);
		}catch(Exception e) {
			System.out.println("������ ������ �� �����ϴ�.");
			System.exit(0);
		}
		System.out.println("������ �����߽��ϴ�.");
		//-------------------------------------------------��������


		Socket sock = null;
		while(true) { //��������� ������ ������� ���ͼ� �޼����� �Է�. ���ÿ� �̿� ����
			try {
				sock = server.accept();
				
				ClientThread ct = new ClientThread(sock);
				ct.start();
				
			}catch(Exception e) {
				System.out.println(sock.getInetAddress()+": ��������");
			}
		}
	}
}
