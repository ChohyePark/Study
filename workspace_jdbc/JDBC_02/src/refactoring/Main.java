package refactoring;
//�ϼ��� Netflix ���� ���α׷��� MVC�������� �����丵�Ѵ�.

import java.util.List;
import java.util.Scanner;

import commons.EncryptionUtils;
import dao.MembersDAO;
import dao.MoviesDAO;
import dto.MembersDTO;
import dto.MoviesDTO;

public class Main {
	public static void main(String[] args) {
		//�α��� �� ȸ������ ��� �߰�
		//1.Members ���̺� ����
		//(id(������ ����. ���ڿ�20byte, ��Ű), pw(���ڿ� 20byte, not null), 
		//name(���ڿ� 20byte not null), contact(���ڿ� 20byte), reg_date(�⺻�� sysdate, not null)
		Scanner sc = new Scanner(System.in);
		while(true) {
			try{

				MembersDAO mdao = new MembersDAO();

				System.out.println("<< Index >>");
				System.out.println("1. �α���");
				System.out.println("2. ȸ������");
				System.out.println("3. ȸ�� ��� ���");
				System.out.println("0. ����");
				System.out.print(">> ");
				String menu = sc.nextLine();

				if(menu.equals("1")) {
					System.out.print("ID: ");
					String id = sc.nextLine();
					System.out.print("PW: ");
					String pw = sc.nextLine();
					
					//PW�� ��ȣȭ�� ���·� �����ؾ� ��. ��ȣȭ ����
					pw = EncryptionUtils.sha512(pw);

					boolean result = mdao.isMember(id,pw);
					//�α��� Ȯ���ڵ� --> true�� ��� �� �ڵ� ����ǵ���
					if(result) {
						System.out.println("�α��� ����");
						System.out.println(id+"�� ȯ���մϴ�.");
						break;
					}
					else {
						System.out.println("�α��� ����.");
						System.out.println();
						continue;
					}
				}
				else if(menu.equals("2")) {
					System.out.println("< ȸ������ >");
					System.out.print("����� ID: ");
					String id = sc.nextLine();
					
					//���̵� �ߺ� �˻�
					boolean dup = mdao.isDuplicate(id);
					if(dup) {
						System.out.println("�̹� ������� ID�Դϴ�.");
						continue;
					}

					System.out.print("����� PW: ");
					String pw = sc.nextLine();
					
					//PW�� ��ȣȭ�� ���·� �����ؾ� ��. ��ȣȭ ����
					pw = EncryptionUtils.sha512(pw);

					System.out.print("�̸�: ");
					String name = sc.nextLine();

					System.out.print("����ó: ");
					String contact = sc.nextLine();

					MembersDTO mdto = new MembersDTO(id,pw,name,contact,null); 
					//������ ��(���Գ�¥)�� null�� ����д�.
					int result = mdao.register(mdto);

					if(result>0) {
						System.out.println("���� �Ϸ�");
					}
					else {
						System.out.println("ȸ������ ����");
					}

				}
				else if(menu.equals("3")) {//��¥ ������ �ٷ�� �� ������ ����
					System.out.println(" === ȸ�� ��� ===");
					System.out.println("ID\t�̸�\t����ó\t\t���Խñ�");
					
					List<MembersDTO> list = mdao.selectAll();
					for(MembersDTO dto:list) {
						
						
						System.out.println(dto.getId()+"\t"+dto.getName()+"\t"+dto.getContact()+"\t"
									+ dto.getFormedDate());
					}
					
				}
				else if(menu.equals("0")) {
					System.out.println("�ý����� �����մϴ�.");
					System.exit(0);
				}
				else {
					System.out.println("�޴��� �ٽ� Ȯ�����ּ���.");
				}

			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("��� ���� �� ���� �߻�");
			}
		}

		MoviesDAO dao = new MoviesDAO();

		while(true) {
			System.out.println("<< Nexflix ��ȭ ���� ���α׷� >>");
			System.out.println("1. �ű� ��ȭ ���"); 
			System.out.println("2. ��ȭ ��� ���"); 
			System.out.println("3. ��ȭ �׸� ����"); 
			System.out.println("4. ��ȭ �׸� ����"); 
			System.out.println("5. ��ȭ �˻�");
			System.out.println("0. ���α׷� ����");
			System.out.print(">> ");
			String menu = sc.nextLine();

			try {
				if(menu.equals("1")) {

					System.out.print("�ű� ����� ��ȭ ����: ");
					String title = sc.nextLine();
					System.out.print("��ȭ �帣: ");
					String genre = sc.nextLine();

					int result=dao.insert(title, genre);
					if(result > 0 ) {
						System.out.println("��ȭ�� ��ϵǾ����ϴ�.");
					}
					else {
						System.out.println("��� ����.");
					}
				}
				else if(menu.equals("2")) {

					List<MoviesDTO> result = dao.selectAll();
					System.out.println("������ȣ\t����\t�帣");
					for(MoviesDTO dto:result) {                                               
						System.out.println(dto.getId()+"\t"+dto.getTitle()+"\t"+dto.getGenre());					
					}
				}
				else if(menu.equals("3")) {

					System.out.print("������ ��ȭ�� ������ȣ: ");
					int id = Integer.parseInt(sc.nextLine());

					boolean scan = dao.isIdExist(id);
					if(!scan) { //scan�� false�� ���
						System.out.println(id+"�� ��ȭ�� ã�� �� �����ϴ�.");
					}
					else {

						System.out.println("��ȭ ������ ���Է��ϼ���.");
						System.out.print("��ȭ ����: ");
						String title = sc.nextLine();
						System.out.print("��ȭ �帣: ");
						String genre = sc.nextLine();

						MoviesDTO dto = new MoviesDTO(id,title,genre);

						int result = dao.update(dto); //dto�� ��Ƽ� �Ѳ����� �ѱ�°� �� �����ڵ�.

						if(result>0) {
							System.out.println("��ȭ ������ �����Ǿ����ϴ�.");
						}
						else {
							System.out.println("���� ������ �����߽��ϴ�.");
						}
					}
				}
				else if(menu.equals("4")) {
					System.out.print("������ ��ȭ�� ������ȣ: ");
					int id = Integer.parseInt(sc.nextLine());

					boolean scan = dao.isIdExist(id);
					if(!scan) {
						System.out.println(id+"�� ��ȭ�� ã�� �� �����ϴ�.");
					}
					else {

						int result = dao.delete(id);
						if(result>0) {
							System.out.println("�׸��� �����Ǿ����ϴ�.");
						}
						else {
							System.out.println("������ �����߽��ϴ�.");
						}
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

							System.out.println("== �˻���� ==");

							if(!dao.isIdExist(scId)){
								System.out.println("�˻������ �����ϴ�.");
							}
							else {
								MoviesDTO result = dao.searchById(scId);
								System.out.println(result.getId()+"\t"+result.getTitle()+"\t"+result.getGenre());
							}

						}
						else if(scMenu.equals("2")) {
							System.out.print("�˻��� ��ȭ ����: ");
							String scTitle = sc.nextLine();

							System.out.println("== �˻���� ==");

							List<MoviesDTO> result = dao.searchByTitle(scTitle);
							for(MoviesDTO dto:result) {
								System.out.println(dto.getId()+"\t"+dto.getTitle()+"\t"+dto.getGenre());
							}

							if(result.size()==0) {
								System.out.println("�˻������ �����ϴ�.");
							}

						}
						else if(scMenu.equals("3")) {
							System.out.print("�˻��� ��ȭ �帣: ");
							String scGenre = sc.nextLine();
							List<MoviesDTO> result = dao.searchByGenre(scGenre);

							System.out.println("== �˻���� ==");
							for(MoviesDTO dto:result) {
								System.out.println(dto.getId()+"\t"+dto.getTitle()+"\t"+dto.getGenre());
							}

							if(result.size()==0) {
								System.out.println("�˻������ �����ϴ�.");
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
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("��� ���� �� ������ �߻��߽��ϴ�.");
			}
		}
	}
}
