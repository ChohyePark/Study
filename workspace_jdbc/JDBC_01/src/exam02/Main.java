package exam02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//�̹��� ��� �Է��� �Ƹ޸�ī�븦 �����غ���.
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.println("���̺귯���� ã�� �� �����ϴ�.");
			System.exit(0);
		}

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kh";
		String dbPW = "kh";
		
		Scanner sc = new Scanner(System.in);

		try {
			Connection con = DriverManager.getConnection(url,dbID,dbPW);
			System.out.println("���� ����");

			Statement stat = con.createStatement();
			
			System.out.print("������ �޴��� �̸�: ");
			String name = sc.nextLine();
			
			String sql = "delete from cafe where name='"+name+"'";
			
			int result = stat.executeUpdate(sql);
			
			if(result>0) {
				System.out.println("���� ����");
			}
			else {
				System.out.println("���� ����");
				System.out.println("�ش� �̸��� �޴��� ã�� �� �����ϴ�.");
			}
			
			con.commit();
			con.close();
			
		}catch(Exception e) {
			System.out.println("�����ͺ��̽� ���� ����");
			e.printStackTrace();
		}
	}
}
