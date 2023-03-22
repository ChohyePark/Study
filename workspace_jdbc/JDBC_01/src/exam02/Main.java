package exam02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//이번엔 방금 입력한 아메리카노를 삭제해보자.
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.println("라이브러리를 찾을 수 없습니다.");
			System.exit(0);
		}

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kh";
		String dbPW = "kh";
		
		Scanner sc = new Scanner(System.in);

		try {
			Connection con = DriverManager.getConnection(url,dbID,dbPW);
			System.out.println("연결 성공");

			Statement stat = con.createStatement();
			
			System.out.print("삭제할 메뉴의 이름: ");
			String name = sc.nextLine();
			
			String sql = "delete from cafe where name='"+name+"'";
			
			int result = stat.executeUpdate(sql);
			
			if(result>0) {
				System.out.println("삭제 성공");
			}
			else {
				System.out.println("삭제 실패");
				System.out.println("해당 이름의 메뉴를 찾을 수 없습니다.");
			}
			
			con.commit();
			con.close();
			
		}catch(Exception e) {
			System.out.println("데이터베이스 연결 실패");
			e.printStackTrace();
		}
	}
}
