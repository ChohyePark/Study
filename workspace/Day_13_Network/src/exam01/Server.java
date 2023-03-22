package exam01;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
//채팅 프로그램 만들기
//my IP : 192.168.50.47
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

class ReadThread extends Thread {
	public void run() {
		while(true) {
			try {
				String msgIn = Server.dis.readUTF();
				JOptionPane.showMessageDialog(null,msgIn);
				System.out.println("받은 메세지: "+msgIn);
			}catch(Exception e) {
				break;
			}
		}
	}
}

public class Server {

	public static DataInputStream dis;

	public static void main(String[] args) throws Exception{

		ServerSocket server = new ServerSocket(33333);
		Socket socket = server.accept();//실행한 순간부터 통신이 넘어오는지 주시중 - 들어오면 accept하고 break;
		//		Socket socket2 = server.accept();
		System.out.println(socket.getInetAddress()+" 로부터 연결");
		//	socket

		OutputStream os = socket.getOutputStream(); //client에게 보낸다는 뜻 (기본stream)
		DataOutputStream dos = new DataOutputStream(os);//사용하기 좋은 stream으로 업그레이드

		InputStream is = socket.getInputStream();
		Server.dis = new DataInputStream(is);

		Scanner sc = new Scanner(System.in);

		new ReadThread().start();
		
		while(true) {
			String msgOut = JOptionPane.showInputDialog("클라이언트에게 보낼 메세지");
			dos.writeUTF(msgOut);//트럭에 메세지 싣기
			dos.flush();//출발시키기(데이터가 가득찼을 때, 클라이언트 쪽에서 요청했을때도 보내짐)
			System.out.println("보낸 메세지: "+msgOut);



		}


	}
}
