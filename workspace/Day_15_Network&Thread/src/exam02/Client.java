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
		
		//HDD쪽으로 stream을 열고
		File dst = new File("D:/2023_01_스마트웹/abc.mp3");
		FileOutputStream fos = new FileOutputStream(dst);
		DataOutputStream dos = new DataOutputStream(fos);
		
		//file 바이트배열 안의 내용을 보낸다.
		dos.write(file);
		dos.flush();
		
		fos.close(); //FileOutputStream은 사용한 후 꼭 close 해줘야한다.
	}

}
