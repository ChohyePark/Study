package quiz01;
//1. Ŭ���̾�Ʈ�� ������ ����
//2. Ŭ���̾�Ʈ�� �����ڸ� ������ ����
//3. Ŭ���̾�Ʈ�� ���� �ϳ��� ������ ����
//4. Ŭ���̾�Ʈ�� ���� �ϳ��� �� ������ ����
//5. ������ Ŭ���̾�Ʈ�� ������ �����͸� �޾� 2�� ������ ó���ϰ� ����� Ŭ���̾�Ʈ�� ��ȯ
//6. Ŭ���̾�Ʈ�� ��ȯ�� ����� ȭ�鿡 ���
//7. 2~6���� ������ �ݺ�
//(��� �Է°��� �����Է��ߴٴ� �����Ͽ� �ۼ�)
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
			System.out.print("�����ڸ� �Է��ϼ��� ( + , - , * ) : ");
			dos.writeUTF(sc.nextLine());
			dos.flush();

			System.out.print("ù��° ���ڸ� �Է��ϼ���: ");			
			dos.writeUTF(sc.nextLine());
			dos.flush();

			System.out.print("�ι�° ���ڸ� �Է��ϼ���: ");			
			dos.writeUTF(sc.nextLine());
			dos.flush();

			String result = dis.readUTF();
			System.out.println("������ : "+result);
			System.out.println("=================");
			
		}
	}
}
