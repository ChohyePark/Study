package exam03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
//�����ϸ� ���� ��� ����, ���� �ٿ�ް���� �����̸��� Ŭ���̾�Ʈ�� �Է��ϸ� �ش������� �����ϵ��� �ڵ�
public class FileThread extends Thread{

	private Socket sock;
	
	public FileThread(Socket sock) {
		this.sock = sock;
	}
	public void run() {
		System.out.println(sock.getInetAddress()+" ���� Ȯ��");
		try {
			DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
			DataInputStream dis = new DataInputStream(sock.getInputStream());
			
			File root = new File("D:/2023_01_����Ʈ��/FTPHome");
			File[] fileList = root.listFiles();//�ش� ���� ���� ���� ���
			
			dos.writeInt(fileList.length);
			dos.flush();
			
			for(File f:fileList) {
				dos.writeUTF(f.getName());
				dos.flush();
			}
			
			String targetName = dis.readUTF();
			System.out.println(sock.getInetAddress()+"���� ������ ����: "+targetName);
			
			File target = new File(root.getAbsoluteFile()+"/"+targetName);
			DataInputStream fileDis = new DataInputStream(new FileInputStream(target));
			byte[] fileContents = new byte[(int)target.length()];
			fileDis.readFully(fileContents);
			
			dos.writeInt((int)target.length());
			dos.write(fileContents);
			dos.flush();
		}catch(Exception e) {
			System.out.println(sock.getInetAddress()+" ���� ����");
		}
	}
}
