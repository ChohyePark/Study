package chat;
//내 IP: 192.168.50.47
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;
//채팅 프로그램 
// Upgrade--> 교대로 메세지를 보내는 게 아닌, 동시에 보낼 수 있도록 thread 활용

class WriteThread extends Thread{
	public void run() {
		Scanner sc = new Scanner(System.in);

		while(true) {
			try {
			String msgOut = JOptionPane.showInputDialog("서버에게 보낼 메세지");
			ClientTest.dos.writeUTF(msgOut);
			ClientTest.dos.flush();
			System.out.println("보낸 메세지: "+msgOut);
			}catch(Exception e){
				break;
			}
		}
	}
}

public class ClientTest {
	public static DataOutputStream dos; 
	
	public static void main(String[] args) throws Exception{
		Socket client = new Socket("192.168.50.47",33333);
		//client.

		InputStream is = client.getInputStream();//server로부터 받겠다는 뜻(기본 stream)
		DataInputStream dis = new DataInputStream(is);//client도 동일하게 stream 보강

		OutputStream os = client.getOutputStream();
		ClientTest.dos = new DataOutputStream(os);

		new WriteThread().start();
		
		while(true) {
			String msgIn = dis.readUTF();
			JOptionPane.showMessageDialog(null, msgIn);
			//	String msg = dis.readUTF();
			System.out.println("받은 메세지: "+msgIn);	


		}
	}
}
