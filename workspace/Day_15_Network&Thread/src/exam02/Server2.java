package exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	public static void main(String[] args) {
		
		ServerSocket server=null;
		
		try {
			server = new ServerSocket(33333);
		}catch(Exception e) {
			System.exit(0);
		}
		System.out.println("서버를 구동했습니다.");
		
		while(true) {
			Socket sock = null;
			try {
				sock = server.accept();
				System.out.println(sock.getInetAddress()+"로 부터 연결");
				
				File root = new File("D:/2023_01_스마트웹/총을 대충쏘면.txt");
				
				FileInputStream fis = new FileInputStream(root);
				DataInputStream dis = new DataInputStream(fis);
				
				byte[] file = new byte[(int)root.length()];
				
				dis.readFully(file);
				
				DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
				dos.writeInt((int)root.length());
				dos.flush();
				
				dos.write(file);
				dos.flush();
				
			}catch(Exception e) {
				System.out.println(sock.getInetAddress()+" 접속 해제");
			}
		}
		
	}
}
