package exam01;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

//class

public class Client {
	public static void main(String[] args) throws Exception{
		//∞≠ªÁIP: 192.168.50.65	
		while(true) {
			Socket client = new Socket("192.168.50.47",35000);

			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			//		DataInputStream dis = new DataInputStream(client.getInputStream());

			Scanner sc = new Scanner(System.in);

			dos.writeUTF(sc.nextLine());
		}
	}
}
