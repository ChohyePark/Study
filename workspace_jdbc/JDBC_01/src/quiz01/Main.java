package quiz01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) {
		//employee 테이블에서 사번, 사원명, 급여를 가져와 출력하는 코드를 작성하세요.
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kh";
		String dbPW = "kh";
		try {
		Connection con = DriverManager.getConnection(url, dbID, dbPW);
		Statement stat = con.createStatement();
		
		String sql="select emp_id, emp_name, salary from employee";
		ResultSet rs = stat.executeQuery(sql);
		
		System.out.println("사번/사원명/  급여");
		while(rs.next()) {
			int emp_id = rs.getInt("emp_id");
			String emp_name = rs.getString("emp_name");
			int salary = rs.getInt("salary");
			
			System.out.println(emp_id+"/"+emp_name+"/"+salary);
		}
		
		con.close();
		
		}catch(Exception e) {
			System.out.println("데이터베이스 연결실패");
			e.printStackTrace();//개발단계에서는 이걸 꼭 써줘야 함!!
		}
		
	}
}
