package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import dto.MembersDTO;

public class MembersDAO {
	
//	 DBCP (DataBase Connection Pool) - 완충장치 , 무조건 사용해야하는 기능 
//	 Database Connection 객체의 사용량이 폭발적으로 증가할 시 ,
//	 Database 가 서비스 중단되지 않게끔 충격을 완화하는 완충 장치
//	 정해진 Connection 객체를 대여 / 반환하는 시스템으로 운용하며 안정성을 도모하지만 
//	 접속자가 많을 시 상대적으로 기다리는 시간이 늘어날 수 있어 적절한 수요 배치가 필요함.

	
	
	// maven repository 저장소 
	
	// Library 간 의존성 (Dependencies)
	
	private BasicDataSource bds = new BasicDataSource(); // 멤버 필드로 설정해야 한다. 

	public MembersDAO () {
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("kh");
		bds.setPassword("kh");
		bds.setInitialSize(8); 
	}
	
	private Connection getConnection () throws Exception {
	 //  우리가 설정한 대로만 만들어진다, 외부 라이브러리  
// Connection pool안에 n개를 빌려줄 수 있게끔 미리 세팅하는것 , 인스턴스 객체 
		return bds.getConnection();
	}
	

	
//	private Connection getConnection() throws Exception{
//		
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String dbID = "kh";
//		String dbPW = "kh";
//		
//		Connection con = DriverManager.getConnection(url, dbID, dbPW);
//		return con;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	public int register(MembersDTO dto) throws Exception{
		
		//         일반 Statement를 사용한 코드 --> 보안 취약성. ' or '1'='1 와 같이 입력했을 때 너무나 쉽게 로그인 됨.
		
//		String sql = "insert into members values('"+dto.getId()+"','"+dto.getPw()+"','"
//		+dto.getName()+"','"+dto.getContact()+"',default)";
		
//		try (Connection con = this.getConnection();
//			Statement stat = con.createStatement();){
//		
//		int result = stat.executeUpdate(sql);
//		
//		con.commit();
//		return result;
//		}
		
		//         PreparedStatement를 사용한 코드로 바꿔 보안취약성과 작성시 불편함을 보완한다.
		
		String sql = "insert into members values(?,?,?,?,default)"; // ? --> place holder라고 부름(자리를 차지해두는, 빈칸으로 생각)
		
		try(Connection con = this.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);){
			
			pstat.setString(1, dto.getId()); // n번 빈칸(물음표)에 다음 String값을 채워넣겠다는 뜻
			pstat.setString(2, dto.getPw()); // (자동으로 작은따옴표를 씌워줌. setInt라고 하면 안씌움)
			pstat.setString(3, dto.getName()); // 이때 index는 1부터 시작한다.
			pstat.setString(4, dto.getContact());
			
			int result = pstat.executeUpdate(); //여긴 sql을 넣으면 안됨!
			con.commit();
			
			return result;
		}
	}
	
	public boolean isMember(String id, String pw) throws Exception{
		//로그인을 위해 입력한 ID와 PW가 DB에 존재하는지 확인하는 작업
		String sql = "select * from members where id=? and pw=?";
		try(Connection con = this.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, id);
			pstat.setString(2, pw);
			ResultSet rs = pstat.executeQuery();
			
			return rs.next();
		}
	}
	
	public boolean isDuplicate(String id) throws Exception{
		
		String sql = "select * from members where id=?";
		try(Connection con = this.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);){
			
			pstat.setString(1, id);
			
			try(ResultSet rs = pstat.executeQuery();){
				
				return rs.next();
			}
		}
	}
	
	public List<MembersDTO> selectAll() throws Exception{
		String sql = "select * from members";
		try(Connection con = this.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();){
			
			List<MembersDTO> list = new ArrayList<>();
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String contact = rs.getString("contact");
				Timestamp reg_date = rs.getTimestamp("reg_date");
				MembersDTO dto = new MembersDTO(id,pw,name,contact,reg_date);
				list.add(dto);
			}
			return list;
		}
	}
}
