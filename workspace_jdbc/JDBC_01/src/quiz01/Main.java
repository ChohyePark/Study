package quiz01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) {
		//employee ���̺��� ���, �����, �޿��� ������ ����ϴ� �ڵ带 �ۼ��ϼ���.
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kh";
		String dbPW = "kh";
		try {
		Connection con = DriverManager.getConnection(url, dbID, dbPW);
		Statement stat = con.createStatement();
		
		String sql="select emp_id, emp_name, salary from employee";
		ResultSet rs = stat.executeQuery(sql);
		
		System.out.println("���/�����/  �޿�");
		while(rs.next()) {
			int emp_id = rs.getInt("emp_id");
			String emp_name = rs.getString("emp_name");
			int salary = rs.getInt("salary");
			
			System.out.println(emp_id+"/"+emp_name+"/"+salary);
		}
		
		con.close();
		
		}catch(Exception e) {
			System.out.println("�����ͺ��̽� �������");
			e.printStackTrace();//���ߴܰ迡���� �̰� �� ����� ��!!
		}
		
	}
}
