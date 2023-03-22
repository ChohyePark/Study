package exam03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception{
		
		Socket client = new Socket("192.168.50.65",45000);
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		
		Scanner sc = new Scanner(System.in);
		
		int size = dis.readInt();
		String[] fileList = new String[size];
		//readUTF로 받은 문자열을 fileList의 i번째칸에 차례로 저장
		for(int i=0;i<size;i++) { 
			fileList[i]=dis.readUTF();
		}
		//저장된 fileList 항목 출력
		System.out.println("<< 파일 목록 >>");
		for(String s:fileList) {
			System.out.println(s);
		}
		
		System.out.println("다운받을 파일 이름을 확장자명까지 입력하세요.");
		System.out.print(">> ");
		String name = sc.nextLine();
		dos.writeUTF(name);
		dos.flush();
		
		byte[] file = new byte[dis.readInt()];
		dis.readFully(file);
		
		File dst = new File("D:/2023_01_스마트웹/"+name);
		DataOutputStream fileDos = new DataOutputStream(new FileOutputStream(dst));
		
		fileDos.write(file);
		fileDos.flush();
		
		System.out.println("다운로드가 완료되었습니다.");
		
		fileDos.close();
		
		
	}
}
