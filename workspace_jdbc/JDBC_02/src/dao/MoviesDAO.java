package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.MoviesDTO;

// 데이터와 관련된 모든 작업을 총괄하는 클래스.
// DAO (Data Access Object) 라고 부른다.
// Table마다 DAO를 하나씩 두는게 일반적이다.

public class MoviesDAO {
	//DB를 저장소로 사용하기 때문에 이전처럼 ArrayList를 사용할 필요가 없다.

	private Connection getConnection() throws Exception{ 
		//바깥에선 사용할 일이 없기때문에 private으로 생성
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String url = "jdbc:oracle:thin:@192.168.50.65:1521:xe"; //강사 IP
		String dbID = "kh";
		String dbPW = "kh";

		Connection con = DriverManager.getConnection(url, dbID, dbPW);
		return con;
	}

	//connection 된 다음 예외 발생으로 튕겨져 나갔을 때, con.close()가 실행되지 않는 문제 발생
	//--> 반드시 실행되도록 하는 방법 : try with resources.
	//close가 필요한 자원을 사용하는 경우, 절대적으로 자원을 close하는 더 심플한 문법.
	//autoCloseable을 상속한 클래스에 한하여 적용가능
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

			List<MoviesDTO> result = new ArrayList<>(); //읽은 데이터를 저장할 배열 준비
			//generic을 안써주면 모든 데이터타입이 들어가지만, 꺼내쓸 때 일일히 downcasting해야해서 매우 불편함.
			//따라서 MoviesDTO라는 타입으로 묶어 저장한다.

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

				boolean result = rs.next(); // 다음행이 존재한다면 true 반환

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
		//select all으로 뽑고 java에서 contains로 검사하기보다,
		//아래처럼 애초에 DB에서 해당항목만 뽑아오는게 더 성능이 좋다.
		String sql = "select * from movies where title like ?";

		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){

			pstat.setString(1, "%"+scTitle+"%");//setString하면 자동으로 입력값 양쪽에 따옴표를 붙이므로 이렇게.

			try(ResultSet rs = pstat.executeQuery();){ //물음표가 필요한 select sql의 경우.
				//이것처렁 2중 try resource 하거나, finally에 close 해줘도 됨

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
