package exam04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) {
		
		// Select query�� ���!
		
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String dbID="kh";
			String dbPW="kh";
			Connection con = DriverManager.getConnection(url,dbID,dbPW);
			Statement stat = con.createStatement();

			String sql = "select * from department";
			ResultSet rs = stat.executeQuery(sql); 
			//������� �ڷῡ ������ �� �ִ� '�ּҰ�'�� return�Ѵ�. 
			//--> ���� connection�� ����Ǿ��ִ� ���ȸ� ��밡��
			
			//��Ȯ���� header ���� �������� �ּҸ� ��ȯ�ϹǷ�, �޼��带 ���� �����͸� �����´�.
			while(rs.next()){ //rs.next()�� true�� ���� == ���� ���� �����ϴ� ����.
			//.next() : ���� ���� ������ �������� �����ϸ� true�� ��ȯ�Ѵ�.
			
			String dept_id = rs.getString("dept_id");//������ �÷��� ��ȣ Ȥ�� �̸�
			String dept_title = rs.getString(2);
			String location_id = rs.getString("location_id");
			
			System.out.println(dept_id+"/"+dept_title+"/"+location_id);
			}
			con.close();

		}catch(Exception e) {
			System.out.println("�����ͺ��̽� ���� ����");
			e.printStackTrace();
		}
	}
}
