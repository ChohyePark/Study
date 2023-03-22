package quiz02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception {
	
		Socket client = new Socket("192.168.50.47",33333);

		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = client.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("������ ����� ����ID(1001~1100): ");
			dos.writeUTF(sc.nextLine());
			dos.flush();
			
			System.out.print("������ ����� �̸�: ");
			dos.writeUTF(sc.nextLine());
			dos.flush();
			
			System.out.print("������ ����� ��ȭ��ȣ: ");
			dos.writeUTF(sc.nextLine());
			dos.flush();
			
			String complete = dis.readUTF();
			if(complete.equals("ack")) {
				System.out.println("���� �Ϸ�");
			}
		}
	}
}
