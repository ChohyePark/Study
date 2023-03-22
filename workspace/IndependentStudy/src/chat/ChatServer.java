package chat;
//여러 클라이언트와 동시에 연결하기 위해 각 클라이언트 연결을 스레드로 처리하며 
//클라이언트를 종료할 때 해당 스레드도 종료하도록 프로그래밍한다. 
//연결된 클라이언트가 있으면 새로운 스레드 클래스인 ChatThread 클래스를 생성하며, 
//생성된 인스턴스를 ArrayList인 chatlist에 추가한다.
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ChatServer {
	public static void main(String[] args) throws Exception {
		
		ServerSocket server = new ServerSocket(33333);
		
		Socket socket = server.accept();
		System.out.println(socket.getInetAddress()+" 로부터 연결");
		
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("");
			String msgOut = sc.nextLine(); 
			
		}
	}

}
