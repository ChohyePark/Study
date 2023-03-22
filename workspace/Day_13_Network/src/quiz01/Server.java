package quiz01;
//계산기 프로그램
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
		System.out.println("서버가 가동되었습니다.");
		Socket socket = server.accept();
		System.out.println(socket.getInetAddress()+"로 부터 연결됨");
		
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String oper = dis.readUTF();
			System.out.println("입력받은 연산자: "+oper);
			
			int num1 = Integer.parseInt(dis.readUTF());
			System.out.println("입력받은 첫번째 숫자: "+num1);
			
			int num2 = Integer.parseInt(dis.readUTF());
			System.out.println("입력받은 두번째 숫자: "+num2);
			
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
			
			System.out.println("연산결과: "+result);
			dos.writeUTF(""+result);
			dos.flush();
			System.out.println("=================");
		}
	}
}
