package chat;
//�� IP: 192.168.50.47
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;
//ä�� ���α׷� 
// Upgrade--> ����� �޼����� ������ �� �ƴ�, ���ÿ� ���� �� �ֵ��� thread Ȱ��

class WriteThread extends Thread{
	public void run() {
		Scanner sc = new Scanner(System.in);

		while(true) {
			try {
			String msgOut = JOptionPane.showInputDialog("�������� ���� �޼���");
			ClientTest.dos.writeUTF(msgOut);
			ClientTest.dos.flush();
			System.out.println("���� �޼���: "+msgOut);
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

		InputStream is = client.getInputStream();//server�κ��� �ްڴٴ� ��(�⺻ stream)
		DataInputStream dis = new DataInputStream(is);//client�� �����ϰ� stream ����

		OutputStream os = client.getOutputStream();
		ClientTest.dos = new DataOutputStream(os);

		new WriteThread().start();
		
		while(true) {
			String msgIn = dis.readUTF();
			JOptionPane.showMessageDialog(null, msgIn);
			//	String msg = dis.readUTF();
			System.out.println("���� �޼���: "+msgIn);	


		}
	}
}
