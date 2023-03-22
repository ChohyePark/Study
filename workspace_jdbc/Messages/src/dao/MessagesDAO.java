package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import org.apache.commons.dbcp2.BasicDataSource;

import dto.MessagesDTO;


public class MessagesDAO {

	private BasicDataSource bds = new BasicDataSource();




	public MessagesDAO () {

		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("board");
		bds.setPassword("board");
		bds.setInitialSize(8);
	}


	private Connection getConnection() throws Exception {

		return bds.getConnection();

	}


	public int insert (String isid, String message) throws Exception {

		String sql = "insert into Messages values (messages_seq.nextval, ?, ?,sysdate)";

		try (
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);) {
			
			pstat.setString(1,isid);	
			pstat.setString(2,message);

			int result = pstat.executeUpdate();

			con.commit();
			return result;

		}

	}


	public List<MessagesDTO> selectAll () throws Exception{

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		List<MessagesDTO> list = new ArrayList<>();

		String sql = "select seq, writer, message, write_date from Messages";

		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();) {

			while(rs.next()) {

				int seq =rs.getInt("seq");
				String writer = rs.getString("writer");
				String message = rs.getString("message");
				Timestamp write_date = rs.getTimestamp("write_date");

				list.add(new MessagesDTO(seq,writer,message,write_date));		
			}

			return list;

		}

	}


	public int delete (int seq) throws Exception {

		String sql = "delete from Messages where seq =?";

		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);) {

			pstat.setInt(1, seq);
			int result = pstat.executeUpdate();

			con.commit();
			return result; 

		}
	}


	public int update (MessagesDTO dto) throws Exception {

		String sql = "update Messages set message = ? where seq = ? ";

		try (
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				) {
			pstat.setString(1, dto.getMessage());
			pstat.setInt(2, dto.getSeq());

			int result = pstat.executeUpdate();

			con.commit();
			return result;
		}

	}



	public List<MessagesDTO> searchByWriter (String w) throws Exception {

		List<MessagesDTO> list = new ArrayList<>();

		String sql = "select * from messages where writer like ?";

		try (
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);)
		{pstat.setString(1, "%"+w+"%");

		try (ResultSet rs = pstat.executeQuery();) {

			while(rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String message = rs.getString("message");
				Timestamp write_date = rs.getTimestamp("write_date");

				list.add(new MessagesDTO (seq,writer,message,write_date));

			}

			return list;


		}




		}
	}


	public List<MessagesDTO> searchBymessage (String m) throws Exception {


		List<MessagesDTO> list = new ArrayList<>();

		String sql = "select * from messages where message like ?";

		try (Connection con = this.getConnection();
		PreparedStatement pstat = con.prepareStatement(sql);)
		{pstat.setString(1, "%"+m+"%");

		try (ResultSet rs = pstat.executeQuery();) {

			while(rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String message = rs.getString("message");
				Timestamp write_date = rs.getTimestamp("write_date");

				list.add(new MessagesDTO (seq,writer,message,write_date));

			}

			return list;

		}


		}

	}


	
	public int updateDate (String date,int seq) throws Exception {
		
		String sql = "update Messages set write_date = to_date(?,'yyyymmdd') where seq = ? "; 
		
		try (Connection con = this.getConnection();
		PreparedStatement pstat = con.prepareStatement(sql);) {
		pstat.setString(1, date);
		pstat.setInt(2, seq);
		int result = pstat.executeUpdate();
		
		con.commit();
		return result;
		}
		
	}
	
	
	
	




}










