package chat;
//���� Ŭ���̾�Ʈ�� ���ÿ� �����ϱ� ���� �� Ŭ���̾�Ʈ ������ ������� ó���ϸ� 
//Ŭ���̾�Ʈ�� ������ �� �ش� �����嵵 �����ϵ��� ���α׷����Ѵ�. 
//����� Ŭ���̾�Ʈ�� ������ ���ο� ������ Ŭ������ ChatThread Ŭ������ �����ϸ�, 
//������ �ν��Ͻ��� ArrayList�� chatlist�� �߰��Ѵ�.
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ChatServer {
	public static void main(String[] args) throws Exception {
		
		ServerSocket server = new ServerSocket(33333);
		
		Socket socket = server.accept();
		System.out.println(socket.getInetAddress()+" �κ��� ����");
		
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("");
			String msgOut = sc.nextLine(); 
			
		}
	}

}
