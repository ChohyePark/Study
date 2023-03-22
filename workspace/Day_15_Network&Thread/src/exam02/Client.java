package exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;


public class Client {
	public static void main(String[] args) throws Exception{
		
		Socket client = new Socket("192.168.50.65",45000);
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		
		int size = dis.readInt();
		
		byte[] file = new byte[size];
		
		dis.readFully(file);
		
		//HDD������ stream�� ����
		File dst = new File("D:/2023_01_����Ʈ��/abc.mp3");
		FileOutputStream fos = new FileOutputStream(dst);
		DataOutputStream dos = new DataOutputStream(fos);
		
		//file ����Ʈ�迭 ���� ������ ������.
		dos.write(file);
		dos.flush();
		
		fos.close(); //FileOutputStream�� ����� �� �� close ������Ѵ�.
	}

}
