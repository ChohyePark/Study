package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//JDBC -데이터베이스와 자바를 연결하기 위한 문법(라이브러리)

		//DBMS의 프로토콜을 모르는데 어떻게맞추지?
		//프로토콜을 자동으로 맞춰주는 라이브러리가 존재.
		//--> OJDBC (Oracle ~) .jar (이미 oraclexe 폴더 안에 들어있음)
		
		//java를 이용해 DBMS kh계정에 있는 cafe 테이블에 메뉴를 추가해보자.

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//oracle>jdbc>driver 위치에 있는 OracleDriver라는 클래스를 실행한다는 뜻
		}catch(Exception e) {
			System.out.println("라이브러리를 찾을 수 없습니다.");
			System.exit(0);
		}
		
		Scanner sc = new Scanner(System.in);

		String url="jdbc:oracle:thin:@localhost:1521:xe";
		//라이브러리에서 어떤 기능을 사용할건지 밝히는 부분:localhost(본인ip로 접속한다. 혹은 다른ip주소 입력하면 됨):포트번호:xe()
		String dbID="kh";
		String dbPW="kh";

		try {
			//Session 만들듯이 Connection이라는 클래스를 이용해 접속한다.
			Connection con = DriverManager.getConnection(url,dbID,dbPW);
			//OracleDriver에서 instance를 만드는 방법. Oracle Instance를 반환한다.
			System.out.println("연결 성공");
			Statement stat = con.createStatement();
			
			System.out.print("신규 등록할 메뉴의 이름 : ");
			String name = sc.nextLine();
			System.out.print(name+" 메뉴의 가격 : ");
			int price = Integer.parseInt(sc.nextLine());
			System.out.print("ICE 가능 여부 (Y/N) : ");
			String isIce = sc.nextLine();

			String sql = "insert into cafe values(cafe_seq.nextval,'"+name+"',"+price+",'"+isIce+"')"; //쿼리문에 세미콜론 찍으면 안됨 주의
			int result = stat.executeUpdate(sql);
			//stat.executeQuery() 또는 executeUpdate();//DBMS에 전달하고싶은 쿼리를 String형으로 적는다.
			//executeQuery() --> 데이터 뭉치가 출력되는 형식의 쿼리일 때
			//executeUpdate() --> 'n개 행이 실행되었습니다'가 출력되는 형식의 쿼리일 때
			
			if(result>0) {
				System.out.println("입력 성공");
			}
			else {
				System.out.println("입력 실패");
			}
			
			con.commit();//query만 보내면 transaction에 들어있으니 커밋까지 해줘야 함.
			//DBMS에 만들 수 있는 세션 수에 제한이 있기 때문에, 사용후 close()로 닫아줘야 함! 필수.
			con.close();
			

		}catch(Exception e) {
			System.out.println("데이터베이스 연결 실패");
			e.printStackTrace();//오류 원인 출력
		}



	}

}
