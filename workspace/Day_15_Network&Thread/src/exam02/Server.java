package exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;
//������� ���� �ڵ�. ������ �����ϸ� ������ �������ִ� �ڵ�.
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
				System.out.println(sock.getInetAddress()+"�� ���� ����");
				
				//��Ʈ��ũ ���� stream
				DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
				
				//�ϵ��ũ ���� ���� ������ ������ �ҷ���(������ ���� ���ҷ���). File ��ü�� ����.
				File root = new File("D:/2023_01_����Ʈ��/FTPHome/mysong.mp3");
				
				//������ File ��ü�� ���� inputstream ����(HDD ���� stream)
				FileInputStream fis = new FileInputStream(root);
				DataInputStream dis = new DataInputStream(fis);//fis�� DataStream���� ���׷��̵�
				
				//HDD�� ������ ������ �����ŭ RAM�� ������ �غ� (length�� long������ return�ϹǷ� int�� ĳ����)
				byte[] fileContents = new byte[(int)root.length()];
				
				//������ ������ �غ�� ������ ���� �����ؿ�
				dis.readFully(fileContents);
				
				//�ε� �Ϸ�� ���� ����� Ŭ���̾�Ʈ���� ����
				dos.writeInt((int)root.length());
				dos.flush();
				
				//���� ������ Ŭ���̾�Ʈ���� ����
				dos.write(fileContents);
				dos.flush();
				
			}catch(Exception e) {
				System.out.println(sock.getInetAddress()+" ���� ����");
			}
		}
	
}
}
