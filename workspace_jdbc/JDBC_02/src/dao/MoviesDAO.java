package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.MoviesDTO;

// �����Ϳ� ���õ� ��� �۾��� �Ѱ��ϴ� Ŭ����.
// DAO (Data Access Object) ��� �θ���.
// Table���� DAO�� �ϳ��� �δ°� �Ϲ����̴�.

public class MoviesDAO {
	//DB�� ����ҷ� ����ϱ� ������ ����ó�� ArrayList�� ����� �ʿ䰡 ����.

	private Connection getConnection() throws Exception{ 
		//�ٱ����� ����� ���� ���⶧���� private���� ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String url = "jdbc:oracle:thin:@192.168.50.65:1521:xe"; //���� IP
		String dbID = "kh";
		String dbPW = "kh";

		Connection con = DriverManager.getConnection(url, dbID, dbPW);
		return con;
	}

	//connection �� ���� ���� �߻����� ƨ���� ������ ��, con.close()�� ������� �ʴ� ���� �߻�
	//--> �ݵ�� ����ǵ��� �ϴ� ��� : try with resources.
	//close�� �ʿ��� �ڿ��� ����ϴ� ���, ���������� �ڿ��� close�ϴ� �� ������ ����.
	//autoCloseable�� ����� Ŭ������ ���Ͽ� ���밡��
	public int insert(String title, String genre) throws Exception{
		String sql = "insert into movies values(movies_seq.nextval,?,?)";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){

			pstat.setString(1, title);
			pstat.setString(2, genre);
			int result = pstat.executeUpdate();

			con.commit();
			return result;		
		}
	}

	public List<MoviesDTO> selectAll() throws Exception{

		String sql = "select * from movies";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){

			List<MoviesDTO> result = new ArrayList<>(); //���� �����͸� ������ �迭 �غ�
			//generic�� �Ƚ��ָ� ��� ������Ÿ���� ������, ������ �� ������ downcasting�ؾ��ؼ� �ſ� ������.
			//���� MoviesDTO��� Ÿ������ ���� �����Ѵ�.

			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String genre = rs.getString("genre");

				result.add(new MoviesDTO(id,title,genre));
			}
			con.close();
			return result;
		}
	}

	public int update(MoviesDTO dto) throws Exception{
		String sql = "update movies set title=?,genre=? where id=?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){

			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getGenre());
			pstat.setInt(3, dto.getId());
			int result = pstat.executeUpdate();

			con.commit();
			con.close();

			return result;
		}
	}

	public int delete(int id) throws Exception{
		String sql = "delete from movies where id=?";

		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){

			pstat.setInt(1, id);
			int result = pstat.executeUpdate();

			con.commit();
			con.close();

			return result;
		}
	}

	public boolean isIdExist(int scanID) throws Exception{
		String sql="select * from movies where id = ?";

		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){

			pstat.setInt(1, scanID);

			try(ResultSet rs = pstat.executeQuery();){

				boolean result = rs.next(); // �������� �����Ѵٸ� true ��ȯ

				return result;
			}
		}
	}

	public MoviesDTO searchById(int scId) throws Exception{
		String sql = "select * from movies where id = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){

			pstat.setInt(1, scId);

			try(ResultSet rs = pstat.executeQuery();){		

				rs.next(); 
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String genre = rs.getString("genre");

				MoviesDTO dto = new MoviesDTO(id,title,genre);

				return dto;
			}
		}
	}

	public List<MoviesDTO> searchByTitle(String scTitle) throws Exception{
		//select all���� �̰� java���� contains�� �˻��ϱ⺸��,
		//�Ʒ�ó�� ���ʿ� DB���� �ش��׸� �̾ƿ��°� �� ������ ����.
		String sql = "select * from movies where title like ?";

		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){

			pstat.setString(1, "%"+scTitle+"%");//setString�ϸ� �ڵ����� �Է°� ���ʿ� ����ǥ�� ���̹Ƿ� �̷���.

			try(ResultSet rs = pstat.executeQuery();){ //����ǥ�� �ʿ��� select sql�� ���.
				//�̰�ó�� 2�� try resource �ϰų�, finally�� close ���൵ ��

				List<MoviesDTO> result = new ArrayList<>();

				while(rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String genre = rs.getString("genre");

					MoviesDTO dto = new MoviesDTO(id,title,genre);
					result.add(dto);
				}

				con.close();
				return result;	
			}
		}
	}

	public List<MoviesDTO> searchByGenre(String scGenre) throws Exception{
		String sql = "select * from movies where genre = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){

			pstat.setString(1, scGenre);

			try(ResultSet rs = pstat.executeQuery();){

				List<MoviesDTO> result = new ArrayList<>();

				while(rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String genre = rs.getString("genre");

					MoviesDTO dto = new MoviesDTO(id,title,genre);
					result.add(dto);
				}
				con.close();
				return result;
			}
		}
	}
}
