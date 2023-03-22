package exam03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.println("���̺귯���� ã�� �� �����ϴ�.");
			System.exit(0);
		}
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String dbID="kh";
		String dbPW="kh";
		
		Scanner sc = new Scanner(System.in);
		
		try {
		Connection con = DriverManager.getConnection(url,dbID,dbPW);
		Statement stat = con.createStatement();
		
		
		String sql = "update cafe set price=5000 where name='Americano'";
		int result = stat.executeUpdate(sql);
		
		if(result>0) {
			System.out.println("������Ʈ ����");
		}
		else {
			System.out.println("������Ʈ ����");
		}
		
		con.commit();
		con.close();
		
		}catch(Exception e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
	}

}
