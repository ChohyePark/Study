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

	private BasicDataSource bds = new BasicDataSource();



	public MembersDAO () {
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("board");
		bds.setPassword("board");
		bds.setInitialSize(8);
	}


	private  Connection getConnection() throws Exception {

		return bds.getConnection();

	}



	public int insert (MembersDTO dto) throws Exception {

		String sql = "insert into Members values(?,?,?,?,sysdate) ";
		try (
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				) {
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getContact());

			con.commit();
			int result = pstat.executeUpdate();
			return result;
		}
	}



	public boolean loginID (String id) throws Exception {

		String sql = "select * from Members where id = ?";
		try (		
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);

				) {

			pstat.setString(1, id);	

			try (ResultSet rs = pstat.executeQuery();) {

				if(rs.next()) {
					return true;
				} else {return false;}	
			}
		}

	}

	public boolean loginPW (String pw) throws Exception {

		String sql = "select * from Members where pw = ?";

		try (		
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);

				) {

			pstat.setString(1, pw);	

			try (ResultSet rs = pstat.executeQuery();) {

				if(rs.next()) {
					return true;
				} else {return false;}	
			}
		}		
		
	}


	
	public List<MembersDTO> info (String isid) throws Exception{
		
		List<MembersDTO> info = new ArrayList<>();
		
		String sql = "select id,name,contact,reg_date from Members where id = ?";
		
		try (
		Connection con = this.getConnection();
		PreparedStatement pstat = con.prepareStatement(sql);
		
		) {
		pstat.setString(1, isid);
		
		try (
		ResultSet rs = pstat.executeQuery();
		) {
			
			rs.next();
			String id = rs.getString("id");
			String name = rs.getString("name");
			String contact = rs.getString("contact");
			Timestamp reg_date = rs.getTimestamp("reg_date");
			
			info.add(new MembersDTO(id,null,name,contact,reg_date));
			return info;			
			
		}
		
		
		}
		
	}
	
	
	
	

	}








