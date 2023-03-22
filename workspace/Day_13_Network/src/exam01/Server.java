package exam01;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
//ä�� ���α׷� �����
//my IP : 192.168.50.47
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

class ReadThread extends Thread {
	public void run() {
		while(true) {
			try {
				String msgIn = Server.dis.readUTF();
				JOptionPane.showMessageDialog(null,msgIn);
				System.out.println("���� �޼���: "+msgIn);
			}catch(Exception e) {
				break;
			}
		}
	}
}

public class Server {

	public static DataInputStream dis;

	public static void main(String[] args) throws Exception{

		ServerSocket server = new ServerSocket(33333);
		Socket socket = server.accept();//������ �������� ����� �Ѿ������ �ֽ��� - ������ accept�ϰ� break;
		//		Socket socket2 = server.accept();
		System.out.println(socket.getInetAddress()+" �κ��� ����");
		//	socket

		OutputStream os = socket.getOutputStream(); //client���� �����ٴ� �� (�⺻stream)
		DataOutputStream dos = new DataOutputStream(os);//����ϱ� ���� stream���� ���׷��̵�

		InputStream is = socket.getInputStream();
		Server.dis = new DataInputStream(is);

		Scanner sc = new Scanner(System.in);

		new ReadThread().start();
		
		while(true) {
			String msgOut = JOptionPane.showInputDialog("Ŭ���̾�Ʈ���� ���� �޼���");
			dos.writeUTF(msgOut);//Ʈ���� �޼��� �Ʊ�
			dos.flush();//��߽�Ű��(�����Ͱ� ����á�� ��, Ŭ���̾�Ʈ �ʿ��� ��û�������� ������)
			System.out.println("���� �޼���: "+msgOut);



		}


	}
}
