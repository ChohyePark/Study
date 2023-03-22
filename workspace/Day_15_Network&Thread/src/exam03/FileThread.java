package exam03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
//접속하면 파일 명단 제시, 그중 다운받고싶은 파일이름을 클라이언트가 입력하면 해당파일을 전송하도록 코딩
public class FileThread extends Thread{

	private Socket sock;
	
	public FileThread(Socket sock) {
		this.sock = sock;
	}
	public void run() {
		System.out.println(sock.getInetAddress()+" 접속 확인");
		try {
			DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
			DataInputStream dis = new DataInputStream(sock.getInputStream());
			
			File root = new File("D:/2023_01_스마트웹/FTPHome");
			File[] fileList = root.listFiles();//해당 폴더 안의 파일 목록
			
			dos.writeInt(fileList.length);
			dos.flush();
			
			for(File f:fileList) {
				dos.writeUTF(f.getName());
				dos.flush();
			}
			
			String targetName = dis.readUTF();
			System.out.println(sock.getInetAddress()+"님이 선택한 파일: "+targetName);
			
			File target = new File(root.getAbsoluteFile()+"/"+targetName);
			DataInputStream fileDis = new DataInputStream(new FileInputStream(target));
			byte[] fileContents = new byte[(int)target.length()];
			fileDis.readFully(fileContents);
			
			dos.writeInt((int)target.length());
			dos.write(fileContents);
			dos.flush();
		}catch(Exception e) {
			System.out.println(sock.getInetAddress()+" 접속 해제");
		}
	}
}
