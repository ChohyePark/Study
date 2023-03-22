package exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;
//강사님의 서버 코드. 서버에 접속하면 파일을 전송해주는 코드.
public class Server {
	public static void main(String[] args) {
		ServerSocket server=null;
		try {
			server = new ServerSocket(45000);
		}catch(Exception e) {
			System.exit(0);
		}
		
		System.out.println("서버를 구동했습니다.");
		
		while(true) {
			Socket sock = null;
			try {
				sock=server.accept();
				System.out.println(sock.getInetAddress()+"로 부터 연결");
				
				//네트워크 방향 stream
				DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
				
				//하드디스크 안의 파일 정보를 램으로 불러옴(내용은 아직 못불러옴). File 객체로 생성.
				File root = new File("D:/2023_01_스마트웹/FTPHome/mysong.mp3");
				
				//생성된 File 객체에 대해 inputstream 개방(HDD 방향 stream)
				FileInputStream fis = new FileInputStream(root);
				DataInputStream dis = new DataInputStream(fis);//fis도 DataStream으로 업그레이드
				
				//HDD에 보관된 파일의 사이즈만큼 RAM에 공간을 준비 (length는 long형으로 return하므로 int로 캐스팅)
				byte[] fileContents = new byte[(int)root.length()];
				
				//파일의 내용을 준비된 공간에 전부 복사해옴
				dis.readFully(fileContents);
				
				//로딩 완료된 파일 사이즈를 클라이언트에게 전송
				dos.writeInt((int)root.length());
				dos.flush();
				
				//파일 내용을 클라이언트에게 전송
				dos.write(fileContents);
				dos.flush();
				
			}catch(Exception e) {
				System.out.println(sock.getInetAddress()+" 접속 해제");
			}
		}
	
}
}
