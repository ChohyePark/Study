package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//Netflix 영화 관리 프로그램 만들기
		//테이블 이름: movies
		//id(1001~no limit, 1씩 증가), title(60byte), genre(20byte)
		//모두 not null, id는 primary key 
		//시퀀스는 1001부터 1씩 증가, nocache nomaxvalue 로 DBMS에서 생성

		Scanner sc = new Scanner(System.in);

//		String url = "jdbc:oracle:thin:@192.168.50.65:1521:xe"; //강사IP
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kh";
		String dbPW = "kh";

		while(true) {
			System.out.println("<< Nexflix 영화 관리 프로그램 >>");
			System.out.println("1. 신규 영화 등록"); //C
			System.out.println("2. 영화 목록 출력"); //R
			System.out.println("3. 영화 항목 수정"); //U --ID를 기준으로 모든정보 수정
			System.out.println("4. 영화 항목 삭제"); //D --ID를 기준으로 삭제
			System.out.println("5. 영화 검색");
			System.out.println("0. 프로그램 종료");
			System.out.print(">> ");
			String menu = sc.nextLine();

			if(menu.equals("1")) {

				System.out.print("신규 등록할 영화 제목: ");
				String title = sc.nextLine();
				System.out.print("영화 장르: ");
				String genre = sc.nextLine();

				try {
					Connection con = DriverManager.getConnection(url, dbID, dbPW);
					Statement stat = con.createStatement();

					String sql = "insert into movies values(movies_seq.nextval,'"+title+"','"+genre+"')";
					int result = stat.executeUpdate(sql);

					if(result>0) {
						System.out.println("영화가 등록되었습니다.");
						con.commit();
					}
					else {
						System.out.println("등록 실패.");
					}
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else if(menu.equals("2")) {

				try {
					Connection con = DriverManager.getConnection(url, dbID, dbPW);
					Statement stat = con.createStatement();

					String sql = "select * from movies";
					ResultSet rs = stat.executeQuery(sql);

					System.out.println("고유번호\t제목\t장르");
					while(rs.next()) {
						int id = rs.getInt("id");
						String title = rs.getString("title");
						String genre = rs.getString("genre");

						System.out.println(id+"\t"+title+"\t"+genre);
					}
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else if(menu.equals("3")) {

				System.out.print("수정할 영화의 고유번호: ");
				int id = Integer.parseInt(sc.nextLine());
				
				try {
					Connection con = DriverManager.getConnection(url,dbID,dbPW);
					Statement stat = con.createStatement();
					
					String sql = "select * from movies";
					ResultSet rs = stat.executeQuery(sql);
					while(rs.next()) {
						
					}
				}catch(Exception e) {
					e.printStackTrace();
				}

				System.out.println("영화 정보를 재입력하세요.");
				System.out.print("영화 제목: ");
				String title = sc.nextLine();
				System.out.print("영화 장르: ");
				String genre = sc.nextLine();

				try {
					Connection con = DriverManager.getConnection(url, dbID, dbPW);
					Statement stat = con.createStatement();

					String sql = "update movies set title='"+title+"',genre='"+genre+"' where id="+id;
					int result = stat.executeUpdate(sql);

					if(result>0) {
						System.out.println("영화 정보가 수정되었습니다.");
						con.commit();
					}
					else {
						System.out.println("정보 수정에 실패했습니다.");
						System.out.println(id+"번 영화가 존재하지 않습니다.");
					}
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else if(menu.equals("4")) {
				System.out.print("삭제할 영화의 고유번호: ");
				int id = Integer.parseInt(sc.nextLine());

				try {
					Connection con = DriverManager.getConnection(url, dbID, dbPW);
					Statement stat = con.createStatement();

					String sql = "delete from movies where id="+id;
					int result = stat.executeUpdate(sql);

					if(result>0) {
						System.out.println("항목이 삭제되었습니다.");
						con.commit();
					}
					else {
						System.out.println("삭제에 실패했습니다.");
						System.out.println(id+"번 영화가 존재하지 않습니다.");
					}
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else if(menu.equals("5")) {
				while(true) {
					System.out.println("1. 고유번호로 검색");
					System.out.println("2. 제목으로 검색");
					System.out.println("3. 장르로 검색");
					System.out.println("0. 이전 메뉴로 돌아가기");
					System.out.print(">> ");
					String scMenu = sc.nextLine();

					if(scMenu.equals("1")) {
						System.out.print("검색할 영화 번호: ");
						int scId = Integer.parseInt(sc.nextLine());
						int count=0;

						try {
							Connection con = DriverManager.getConnection(url, dbID, dbPW);
							Statement stat = con.createStatement();

							String sql = "select * from movies";
							ResultSet rs = stat.executeQuery(sql);

							System.out.println("== 검색결과 ==");
							while(rs.next()) {
								int id = rs.getInt("id");
								String title = rs.getString("title");
								String genre = rs.getString("genre");

								if(id==scId) {
									System.out.println(id+"\t"+title+"\t"+genre);
									count++;
								}
							}
							if(count==0) {
								System.out.println("검색결과가 없습니다.");
							}
							con.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					else if(scMenu.equals("2")) {
						System.out.print("검색할 영화 제목: ");
						String scTitle = sc.nextLine();
						int count=0;

						try {
							Connection con = DriverManager.getConnection(url, dbID, dbPW);
							Statement stat = con.createStatement();

							String sql = "select * from movies";
							ResultSet rs = stat.executeQuery(sql);

							System.out.println("== 검색결과 ==");
							while(rs.next()) {
								int id = rs.getInt("id");
								String title = rs.getString("title");
								String genre = rs.getString("genre");

								if(title.contains(scTitle)) {
									System.out.println(id+"\t"+title+"\t"+genre);
									count++;
								}
							}
							if(count==0) {
								System.out.println("검색결과가 없습니다.");
							}
							con.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					else if(scMenu.equals("3")) {
						System.out.print("검색할 영화 장르: ");
						String scGenre = sc.nextLine();
						int count=0;

						try {
							Connection con = DriverManager.getConnection(url, dbID, dbPW);
							Statement stat = con.createStatement();

							String sql = "select * from movies";
							ResultSet rs = stat.executeQuery(sql);

							System.out.println("== 검색결과 ==");
							while(rs.next()) {
								int id = rs.getInt("id");
								String title = rs.getString("title");
								String genre = rs.getString("genre");

								if(genre.equals(scGenre)) {
									System.out.println(id+"\t"+title+"\t"+genre);
									count++;
								}
							}
							if(count==0) {
								System.out.println("검색결과가 없습니다.");
							}
							con.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					else if(scMenu.equals("0")) {
						System.out.println("이전메뉴로 돌아갑니다.");
						break;
					}
					else {
						System.out.println("메뉴를 다시 확인하세요.");
						continue;
					}
				}
			}
			else if(menu.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			else {
				System.out.println("메뉴를 다시 확인하세요.");
				continue;
			}
		}
	}
}
