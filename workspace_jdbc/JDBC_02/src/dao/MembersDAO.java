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
	
//	 DBCP (DataBase Connection Pool) - ������ġ , ������ ����ؾ��ϴ� ��� 
//	 Database Connection ��ü�� ��뷮�� ���������� ������ �� ,
//	 Database �� ���� �ߴܵ��� �ʰԲ� ����� ��ȭ�ϴ� ���� ��ġ
//	 ������ Connection ��ü�� �뿩 / ��ȯ�ϴ� �ý������� ����ϸ� �������� ���������� 
//	 �����ڰ� ���� �� ��������� ��ٸ��� �ð��� �þ �� �־� ������ ���� ��ġ�� �ʿ���.

	
	
	// maven repository ����� 
	
	// Library �� ������ (Dependencies)
	
	private BasicDataSource bds = new BasicDataSource(); // ��� �ʵ�� �����ؾ� �Ѵ�. 

	public MembersDAO () {
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("kh");
		bds.setPassword("kh");
		bds.setInitialSize(8); 
	}
	
	private Connection getConnection () throws Exception {
	 //  �츮�� ������ ��θ� ���������, �ܺ� ���̺귯��  
// Connection pool�ȿ� n���� ������ �� �ְԲ� �̸� �����ϴ°� , �ν��Ͻ� ��ü 
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
		
		//         �Ϲ� Statement�� ����� �ڵ� --> ���� ��༺. ' or '1'='1 �� ���� �Է����� �� �ʹ��� ���� �α��� ��.
		
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
		
		//         PreparedStatement�� ����� �ڵ�� �ٲ� ������༺�� �ۼ��� �������� �����Ѵ�.
		
		String sql = "insert into members values(?,?,?,?,default)"; // ? --> place holder��� �θ�(�ڸ��� �����صδ�, ��ĭ���� ����)
		
		try(Connection con = this.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);){
			
			pstat.setString(1, dto.getId()); // n�� ��ĭ(����ǥ)�� ���� String���� ä���ְڴٴ� ��
			pstat.setString(2, dto.getPw()); // (�ڵ����� ��������ǥ�� ������. setInt��� �ϸ� �Ⱦ���)
			pstat.setString(3, dto.getName()); // �̶� index�� 1���� �����Ѵ�.
			pstat.setString(4, dto.getContact());
			
			int result = pstat.executeUpdate(); //���� sql�� ������ �ȵ�!
			con.commit();
			
			return result;
		}
	}
	
	public boolean isMember(String id, String pw) throws Exception{
		//�α����� ���� �Է��� ID�� PW�� DB�� �����ϴ��� Ȯ���ϴ� �۾�
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
