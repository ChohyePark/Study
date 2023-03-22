package exam04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) {
		
		// Select query의 경우!
		
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String dbID="kh";
			String dbPW="kh";
			Connection con = DriverManager.getConnection(url,dbID,dbPW);
			Statement stat = con.createStatement();

			String sql = "select * from department";
			ResultSet rs = stat.executeQuery(sql); 
			//만들어진 자료에 접근할 수 있는 '주소값'을 return한다. 
			//--> 따라서 connection이 연결되어있는 동안만 사용가능
			
			//정확히는 header 행의 시작점의 주소를 반환하므로, 메서드를 통해 데이터를 꺼내온다.
			while(rs.next()){ //rs.next()가 true인 동안 == 다음 행이 존재하는 동안.
			//.next() : 행을 한줄 내려서 다음행이 존재하면 true를 반환한다.
			
			String dept_id = rs.getString("dept_id");//꺼내올 컬럼의 번호 혹은 이름
			String dept_title = rs.getString(2);
			String location_id = rs.getString("location_id");
			
			System.out.println(dept_id+"/"+dept_title+"/"+location_id);
			}
			con.close();

		}catch(Exception e) {
			System.out.println("데이터베이스 연결 실패");
			e.printStackTrace();
		}
	}
}
