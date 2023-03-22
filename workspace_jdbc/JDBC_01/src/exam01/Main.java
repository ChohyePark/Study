package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//JDBC -�����ͺ��̽��� �ڹٸ� �����ϱ� ���� ����(���̺귯��)

		//DBMS�� ���������� �𸣴µ� ��Ը�����?
		//���������� �ڵ����� �����ִ� ���̺귯���� ����.
		//--> OJDBC (Oracle ~) .jar (�̹� oraclexe ���� �ȿ� �������)
		
		//java�� �̿��� DBMS kh������ �ִ� cafe ���̺� �޴��� �߰��غ���.

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//oracle>jdbc>driver ��ġ�� �ִ� OracleDriver��� Ŭ������ �����Ѵٴ� ��
		}catch(Exception e) {
			System.out.println("���̺귯���� ã�� �� �����ϴ�.");
			System.exit(0);
		}
		
		Scanner sc = new Scanner(System.in);

		String url="jdbc:oracle:thin:@localhost:1521:xe";
		//���̺귯������ � ����� ����Ұ��� ������ �κ�:localhost(����ip�� �����Ѵ�. Ȥ�� �ٸ�ip�ּ� �Է��ϸ� ��):��Ʈ��ȣ:xe()
		String dbID="kh";
		String dbPW="kh";

		try {
			//Session ������� Connection�̶�� Ŭ������ �̿��� �����Ѵ�.
			Connection con = DriverManager.getConnection(url,dbID,dbPW);
			//OracleDriver���� instance�� ����� ���. Oracle Instance�� ��ȯ�Ѵ�.
			System.out.println("���� ����");
			Statement stat = con.createStatement();
			
			System.out.print("�ű� ����� �޴��� �̸� : ");
			String name = sc.nextLine();
			System.out.print(name+" �޴��� ���� : ");
			int price = Integer.parseInt(sc.nextLine());
			System.out.print("ICE ���� ���� (Y/N) : ");
			String isIce = sc.nextLine();

			String sql = "insert into cafe values(cafe_seq.nextval,'"+name+"',"+price+",'"+isIce+"')"; //�������� �����ݷ� ������ �ȵ� ����
			int result = stat.executeUpdate(sql);
			//stat.executeQuery() �Ǵ� executeUpdate();//DBMS�� �����ϰ���� ������ String������ ���´�.
			//executeQuery() --> ������ ��ġ�� ��µǴ� ������ ������ ��
			//executeUpdate() --> 'n�� ���� ����Ǿ����ϴ�'�� ��µǴ� ������ ������ ��
			
			if(result>0) {
				System.out.println("�Է� ����");
			}
			else {
				System.out.println("�Է� ����");
			}
			
			con.commit();//query�� ������ transaction�� ��������� Ŀ�Ա��� ����� ��.
			//DBMS�� ���� �� �ִ� ���� ���� ������ �ֱ� ������, ����� close()�� �ݾ���� ��! �ʼ�.
			con.close();
			

		}catch(Exception e) {
			System.out.println("�����ͺ��̽� ���� ����");
			e.printStackTrace();//���� ���� ���
		}



	}

}
