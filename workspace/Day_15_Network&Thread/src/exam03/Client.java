package exam03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception{
		
		Socket client = new Socket("192.168.50.65",45000);
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		
		Scanner sc = new Scanner(System.in);
		
		int size = dis.readInt();
		String[] fileList = new String[size];
		//readUTF�� ���� ���ڿ��� fileList�� i��°ĭ�� ���ʷ� ����
		for(int i=0;i<size;i++) { 
			fileList[i]=dis.readUTF();
		}
		//����� fileList �׸� ���
		System.out.println("<< ���� ��� >>");
		for(String s:fileList) {
			System.out.println(s);
		}
		
		System.out.println("�ٿ���� ���� �̸��� Ȯ���ڸ���� �Է��ϼ���.");
		System.out.print(">> ");
		String name = sc.nextLine();
		dos.writeUTF(name);
		dos.flush();
		
		byte[] file = new byte[dis.readInt()];
		dis.readFully(file);
		
		File dst = new File("D:/2023_01_����Ʈ��/"+name);
		DataOutputStream fileDos = new DataOutputStream(new FileOutputStream(dst));
		
		fileDos.write(file);
		fileDos.flush();
		
		System.out.println("�ٿ�ε尡 �Ϸ�Ǿ����ϴ�.");
		
		fileDos.close();
		
		
	}
}
