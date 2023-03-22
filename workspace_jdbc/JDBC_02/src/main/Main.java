package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//Netflix ��ȭ ���� ���α׷� �����
		//���̺� �̸�: movies
		//id(1001~no limit, 1�� ����), title(60byte), genre(20byte)
		//��� not null, id�� primary key 
		//�������� 1001���� 1�� ����, nocache nomaxvalue �� DBMS���� ����

		Scanner sc = new Scanner(System.in);

//		String url = "jdbc:oracle:thin:@192.168.50.65:1521:xe"; //����IP
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kh";
		String dbPW = "kh";

		while(true) {
			System.out.println("<< Nexflix ��ȭ ���� ���α׷� >>");
			System.out.println("1. �ű� ��ȭ ���"); //C
			System.out.println("2. ��ȭ ��� ���"); //R
			System.out.println("3. ��ȭ �׸� ����"); //U --ID�� �������� ������� ����
			System.out.println("4. ��ȭ �׸� ����"); //D --ID�� �������� ����
			System.out.println("5. ��ȭ �˻�");
			System.out.println("0. ���α׷� ����");
			System.out.print(">> ");
			String menu = sc.nextLine();

			if(menu.equals("1")) {

				System.out.print("�ű� ����� ��ȭ ����: ");
				String title = sc.nextLine();
				System.out.print("��ȭ �帣: ");
				String genre = sc.nextLine();

				try {
					Connection con = DriverManager.getConnection(url, dbID, dbPW);
					Statement stat = con.createStatement();

					String sql = "insert into movies values(movies_seq.nextval,'"+title+"','"+genre+"')";
					int result = stat.executeUpdate(sql);

					if(result>0) {
						System.out.println("��ȭ�� ��ϵǾ����ϴ�.");
						con.commit();
					}
					else {
						System.out.println("��� ����.");
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

					System.out.println("������ȣ\t����\t�帣");
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

				System.out.print("������ ��ȭ�� ������ȣ: ");
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

				System.out.println("��ȭ ������ ���Է��ϼ���.");
				System.out.print("��ȭ ����: ");
				String title = sc.nextLine();
				System.out.print("��ȭ �帣: ");
				String genre = sc.nextLine();

				try {
					Connection con = DriverManager.getConnection(url, dbID, dbPW);
					Statement stat = con.createStatement();

					String sql = "update movies set title='"+title+"',genre='"+genre+"' where id="+id;
					int result = stat.executeUpdate(sql);

					if(result>0) {
						System.out.println("��ȭ ������ �����Ǿ����ϴ�.");
						con.commit();
					}
					else {
						System.out.println("���� ������ �����߽��ϴ�.");
						System.out.println(id+"�� ��ȭ�� �������� �ʽ��ϴ�.");
					}
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else if(menu.equals("4")) {
				System.out.print("������ ��ȭ�� ������ȣ: ");
				int id = Integer.parseInt(sc.nextLine());

				try {
					Connection con = DriverManager.getConnection(url, dbID, dbPW);
					Statement stat = con.createStatement();

					String sql = "delete from movies where id="+id;
					int result = stat.executeUpdate(sql);

					if(result>0) {
						System.out.println("�׸��� �����Ǿ����ϴ�.");
						con.commit();
					}
					else {
						System.out.println("������ �����߽��ϴ�.");
						System.out.println(id+"�� ��ȭ�� �������� �ʽ��ϴ�.");
					}
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else if(menu.equals("5")) {
				while(true) {
					System.out.println("1. ������ȣ�� �˻�");
					System.out.println("2. �������� �˻�");
					System.out.println("3. �帣�� �˻�");
					System.out.println("0. ���� �޴��� ���ư���");
					System.out.print(">> ");
					String scMenu = sc.nextLine();

					if(scMenu.equals("1")) {
						System.out.print("�˻��� ��ȭ ��ȣ: ");
						int scId = Integer.parseInt(sc.nextLine());
						int count=0;

						try {
							Connection con = DriverManager.getConnection(url, dbID, dbPW);
							Statement stat = con.createStatement();

							String sql = "select * from movies";
							ResultSet rs = stat.executeQuery(sql);

							System.out.println("== �˻���� ==");
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
								System.out.println("�˻������ �����ϴ�.");
							}
							con.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					else if(scMenu.equals("2")) {
						System.out.print("�˻��� ��ȭ ����: ");
						String scTitle = sc.nextLine();
						int count=0;

						try {
							Connection con = DriverManager.getConnection(url, dbID, dbPW);
							Statement stat = con.createStatement();

							String sql = "select * from movies";
							ResultSet rs = stat.executeQuery(sql);

							System.out.println("== �˻���� ==");
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
								System.out.println("�˻������ �����ϴ�.");
							}
							con.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					else if(scMenu.equals("3")) {
						System.out.print("�˻��� ��ȭ �帣: ");
						String scGenre = sc.nextLine();
						int count=0;

						try {
							Connection con = DriverManager.getConnection(url, dbID, dbPW);
							Statement stat = con.createStatement();

							String sql = "select * from movies";
							ResultSet rs = stat.executeQuery(sql);

							System.out.println("== �˻���� ==");
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
								System.out.println("�˻������ �����ϴ�.");
							}
							con.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					else if(scMenu.equals("0")) {
						System.out.println("�����޴��� ���ư��ϴ�.");
						break;
					}
					else {
						System.out.println("�޴��� �ٽ� Ȯ���ϼ���.");
						continue;
					}
				}
			}
			else if(menu.equals("0")) {
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
			else {
				System.out.println("�޴��� �ٽ� Ȯ���ϼ���.");
				continue;
			}
		}
	}
}
