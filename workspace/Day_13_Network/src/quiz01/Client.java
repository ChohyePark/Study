package quiz01;
//1. 클라이언트가 서버에 접속
//2. 클라이언트가 연산자를 서버에 전송
//3. 클라이언트가 숫자 하나를 서버에 전송
//4. 클라이언트가 숫자 하나를 더 서버에 전송
//5. 서버는 클라이언트가 전송한 데이터를 받아 2번 연산을 처리하고 결과를 클라이언트에 반환
//6. 클라이언트는 반환된 결과를 화면에 출력
//7. 2~6번을 무한히 반복
//(모든 입력값은 정상입력했다는 전제하에 작성)
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Client {
	public static void main(String[] args) throws Exception {

		Socket client = new Socket("192.168.50.21",44444);

		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = client.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("연산자를 입력하세요 ( + , - , * ) : ");
			dos.writeUTF(sc.nextLine());
			dos.flush();

			System.out.print("첫번째 숫자를 입력하세요: ");			
			dos.writeUTF(sc.nextLine());
			dos.flush();

			System.out.print("두번째 숫자를 입력하세요: ");			
			dos.writeUTF(sc.nextLine());
			dos.flush();

			String result = dis.readUTF();
			System.out.println("연산결과 : "+result);
			System.out.println("=================");
			
		}
	}
}
