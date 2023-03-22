package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.StudentsDTO;

public class StudentsDAO {
	
	private Connection getConnection() throws Exception{
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String url = "jdbc:oracle:thin:@192.168.50.21:1521:xe";
//		String url = "jdbc:oracle:thin:@192.168.50.65:1521:xe";	//강사 IP
		String dbID="kh";
		String dbPW="kh";
		
		Connection con = DriverManager.getConnection(url, dbID, dbPW);
		return con;
	}
	
	public int insert(StudentsDTO dto) throws Exception{
		Connection con = this.getConnection();
		Statement stat = con.createStatement();
		
		String name = dto.getName();
		int kor = dto.getKor();
		int eng = dto.getEng();
		int math = dto.getMath();
		int sum = kor+eng+math;
		String avg = String.format("%.1f", sum/3.0);
		
		String sql="insert into students values(students_seq.nextval,"
				+ "'"+name+"',"+kor+","+eng+","+math+")";
		
//students table에 합계, 평균 column 만들어서 insert로 넣어줘도 될듯
		//String sql = "insert into students values(students_seq.nextval, '"+name+"',"+kor+","+eng+","+math+","+sum+","+avg+")";
		
		int result = stat.executeUpdate(sql);
		
		con.commit();
		con.close();
		
		return result;
	}
	
	public List<StudentsDTO> selectAll() throws Exception{
		Connection con = this.getConnection();
		Statement stat = con.createStatement();
		
		List<StudentsDTO> result = new ArrayList<>();
		
		String sql = "select * from students";
		ResultSet rs = stat.executeQuery(sql);
		
		while(rs.next()) {
			StudentsDTO dto = new StudentsDTO(rs.getInt("id"),rs.getString("name"),rs.getInt("kor"),rs.getInt("eng"),rs.getInt("math"));
			result.add(dto);
		}

		con.close();
		return result;
	}
	
	public boolean scanId(int id) throws Exception{
		Connection con = this.getConnection();
		Statement stat = con.createStatement();
		
		String sql = "select * from students where id="+id;
		ResultSet rs = stat.executeQuery(sql);
		
		boolean result = rs.next();
		
		return result;
	}
	
	public int update(StudentsDTO dto) throws Exception{
		Connection con = this.getConnection();
		Statement stat = con.createStatement();
		
		String sql = "update students set name='"+dto.getName()+"',kor="
		+dto.getKor()+",eng="+dto.getEng()+",math="+dto.getMath()+" where id="+dto.getId();
		int result = stat.executeUpdate(sql);
		
		con.commit();
		con.close();
		return result;
	}
	
	public int delete(int id) throws Exception{
		Connection con = this.getConnection();
		Statement stat = con.createStatement();
		
		String sql="delete from students where id="+id;
		int result = stat.executeUpdate(sql);
		
		con.commit();
		con.close();
		
		return result;
	}
	
	public StudentsDTO searchById(int scId) throws Exception{
		Connection con = this.getConnection();
		Statement stat = con.createStatement();
		
		String sql="select * from students where id="+scId;
		ResultSet rs = stat.executeQuery(sql);
		
		rs.next();
		StudentsDTO dto = new StudentsDTO(rs.getInt("id"),rs.getString("name"),
					rs.getInt("kor"),rs.getInt("eng"),rs.getInt("math"));
		
		con.close();
		return dto;
	}
	
	public List<StudentsDTO> searchByName(String scName) throws Exception{
		Connection con = this.getConnection();
		Statement stat = con.createStatement();
		
		String sql = "select * from students where name like '%"+scName+"%'";
		ResultSet rs = stat.executeQuery(sql);
		
		List<StudentsDTO> result = new ArrayList<>();
		
		while(rs.next()) {
			StudentsDTO dto = new StudentsDTO(rs.getInt("id"),rs.getString("name"),
					rs.getInt("kor"),rs.getInt("eng"),rs.getInt("math"));
			result.add(dto);
		}
		
		con.close();
		return result;
	}
	
//	public List<StudentsDTO> searchByGrade(int scGrade) throws Exception{
//		Connection con = this.getConnection();
//		Statement stat = con.createStatement();
//		
//		
//	}

}
