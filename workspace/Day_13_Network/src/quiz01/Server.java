package quiz01;
//���� ���α׷�
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws Exception {
		
		ServerSocket server = new ServerSocket(33333);
		System.out.println("������ �����Ǿ����ϴ�.");
		Socket socket = server.accept();
		System.out.println(socket.getInetAddress()+"�� ���� �����");
		
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String oper = dis.readUTF();
			System.out.println("�Է¹��� ������: "+oper);
			
			int num1 = Integer.parseInt(dis.readUTF());
			System.out.println("�Է¹��� ù��° ����: "+num1);
			
			int num2 = Integer.parseInt(dis.readUTF());
			System.out.println("�Է¹��� �ι�° ����: "+num2);
			
			int result;
			
			if(oper.equals("+")) {
				result = num1+num2;
			}
			else if(oper.equals("-")) {
				result = num1-num2;
			}
			else {
				result = num1*num2;
			}
			
			System.out.println("������: "+result);
			dos.writeUTF(""+result);
			dos.flush();
			System.out.println("=================");
		}
	}
}
