package chat;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
//ä�� ���α׷� �����
//my IP : 192.168.50.47
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

class ReadThread extends Thread {
	public void run() {
		while(true) {
			try {
				String msgIn = ServerTest.dis.readUTF();
				
				ServerTest.doc.insertString(ServerTest.doc.getLength(), msgIn, ServerTest.left );
				ServerTest.doc.setParagraphAttributes(ServerTest.doc.getLength(), 1, ServerTest.left, false);
				
			//	JOptionPane.showMessageDialog(null,msgIn);
			//	System.out.println("���� �޼���: "+msgIn);
			}catch(Exception e) {
				break;
			}
		}
	}
}

public class ServerTest {

	public static DataInputStream dis;
	public static StyledDocument doc;
	public static SimpleAttributeSet left;
	public static SimpleAttributeSet right;

	public static void main(String[] args) throws Exception{
		
		JTextPane textPane = new JTextPane();

		doc = textPane.getStyledDocument();
        left = new SimpleAttributeSet();
        StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
        StyleConstants.setForeground(left, Color.RED);

        right = new SimpleAttributeSet();
        StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setForeground(right, Color.BLUE);

		ServerSocket server = new ServerSocket(33333);
		Socket socket = server.accept();//������ �������� ����� �Ѿ������ �ֽ��� - ������ accept�ϰ� break;
		//		Socket socket2 = server.accept();
		System.out.println(socket.getInetAddress()+" �κ��� ����");
		//	socket

		OutputStream os = socket.getOutputStream(); //client���� �����ٴ� �� (�⺻stream)
		DataOutputStream dos = new DataOutputStream(os);//����ϱ� ���� stream���� ���׷��̵�

		InputStream is = socket.getInputStream();
		ServerTest.dis = new DataInputStream(is);

		Scanner sc = new Scanner(System.in);

		new ReadThread().start();
		
		while(true) {
		//	String msgOut = JOptionPane.showInputDialog("Ŭ���̾�Ʈ���� ���� �޼���");
			JFrame frame = new JFrame("Text Pane Chat");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add( new JScrollPane( textPane ) );
			frame.setLocationByPlatform( true );
			frame.setSize(200, 200);
			frame.setVisible( true );
			
			String msgOut = sc.nextLine();
			doc.insertString(doc.getLength(), msgOut, right );
            doc.setParagraphAttributes(doc.getLength(), 1, right, false);
			dos.writeUTF(msgOut);//Ʈ���� �޼��� �Ʊ�
			dos.flush();//��߽�Ű��(�����Ͱ� ����á�� ��, Ŭ���̾�Ʈ �ʿ��� ��û�������� ������)
	//		System.out.println("���� �޼���: "+msgOut);

		}
		

	}
}
