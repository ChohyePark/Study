import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class shopmember_dao {


	public ShopMember searchUser(String memberId)  {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password = "test";
		ShopMember shopMember = null;
		

		try {
			con = DriverManager.getConnection(url, user, password);
			String query = "SELECT * FROM SHOP_MEMBER WHERE MEMBER_ID = ?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, memberId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				shopMember = new ShopMember(); // °´Ã¼ »ý¼º 
				shopMember.setMemberId(rs.getString("MEMBER_ID"));
				shopMember.setMemberPw(rs.getString("MEMBER_PW"));
				shopMember.setMemberName(rs.getString("MEMBER_NAME"));
				shopMember.setMemberAge(rs.getInt("MEMBER_AGE"));
				shopMember.setPhone(rs.getString("MEMBER_PHONE"));
				shopMember.setAddr(rs.getString("MEMBER_ADDR"));
			}
			rs.close(); 
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shopMember;
	}







}
