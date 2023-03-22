package main;

import java.util.List;
import java.util.Scanner;

import commons.EncryptionUtils;
import dao.MembersDAO;
import dao.MessagesDAO;
import dto.MembersDTO;
import dto.MessagesDTO;

public class Main {



	public static void main(String[] args) {




		Scanner sc = new Scanner (System.in);
		boolean flag = false;
		String isid = null;
		MembersDAO mdao = new MembersDAO();

		while(true) {


			System.out.println("===== �α��� =====");
			System.out.println("1. �α���");
			System.out.println("2. ȸ������");
			System.out.println("3. ����");
			System.out.print(">> ");
			int menu1 = Integer.parseInt(sc.nextLine());

			try {
				if(menu1 == 1) {

					System.out.print("id�� �Է����ּ��� : ");
					isid = sc.nextLine();
					boolean idresult = mdao.loginID(isid);

					if(!idresult) {
						System.out.println("id�� �ٽ� Ȯ�����ּ���");	
						continue;	
					} else  {

						System.out.print("pw�� �Է����ּ��� : ");	
						String pw = EncryptionUtils.sha512(sc.nextLine());

						boolean pwresult = mdao.loginPW(pw);

						if (!pwresult) {
							System.out.println("pw�� �ٽ� Ȯ�����ּ���");
							continue;
						} else {
							flag = true;
							break;
						}


					}



				} else if(menu1 == 2) {

					System.out.print("id�� �Է����ּ��� : ");
					String id = sc.nextLine();
					System.out.print("pw�� �Է����ּ��� : ");
					String pw = EncryptionUtils.sha512(sc.nextLine());
					System.out.print("�̸��� �Է����ּ��� : ");
					String name = sc.nextLine();
					System.out.print("����ó�� �Է����ּ��� : ");
					String contact = sc.nextLine();

					int result = mdao.insert(new MembersDTO(id,pw,name,contact,null));

					if (result > 0) {
						System.out.println("�Է¿Ϸ�");
					}


				} else if(menu1 == 3) {

					System.exit(0);

				} 
			}	 catch (Exception e) {
				System.out.println("��ɻ� ������ ������ϴ�. �����ڿ��� �����ּ���");
				e.printStackTrace();

			}
		}


		MessagesDAO dao = new MessagesDAO();


		while(flag) {
			System.out.println("===== �淮 �Խ��� ������Ʈ =====");
			System.out.println("1. �ű� �޼��� ��� "); // �ۼ���, �޼��� ���� �Է�
			System.out.println("2. �޼��� ��� ���"); // �� ��ȣ, �ۼ���, �۳���, �ۼ��� [MM/dd]
			System.out.println("3. �޼��� ����"); // seq ����
			System.out.println("4. �޼��� ����"); // seq �����ϵ� write �� message�� ���� ����
			System.out.println("5. �޼��� �˻�"); // writer �Ǵ� message�� �˻�� �����ϴ� ��� like % % ���
			System.out.println("6. �� ��������");
			System.out.println("7. (�߰�) �ۼ��� ���� ");
			System.out.println("0. �ý��� ����");

			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());

			try {

				if (menu == 1) {
					System.out.print("�޼����� �Է����ּ��� : ");
					String message = sc.nextLine();

					int result = dao.insert(isid, message);


				} else if (menu == 2) {

					List<MessagesDTO> list = dao.selectAll();

					System.out.println("�۹�ȣ\t�ۼ���\t�۳���\t�ۼ���");

					for(MessagesDTO m : list) {
						System.out.println(m.getSeq() + "\t" + m.getWriter() + "\t" + m.getMessage() + "\t" +m.getFormedDate() );
					}



				} else if (menu == 3) {

					System.out.print("������ �޼����� seq�� �Է����ּ��� : ");
					int seq = Integer.parseInt(sc.nextLine());

					int result = dao.delete(seq);

					if(result > 0 ) {
						System.out.println("���� �Ϸ�");
					}

				} else if (menu == 4) {

					System.out.print("������ �޼����� seq�� �Է����ּ��� : ");
					int seq = Integer.parseInt(sc.nextLine());
					System.out.print("������ �޼����� �Է����ּ��� : ");
					String message = sc.nextLine();
					System.out.print("������ ��¥�� �Է����ּ��� : ");
					String date = sc.nextLine();
					
					
					
					int result = dao.update(new MessagesDTO(seq,null,message,null));
					int dateresult = dao.updateDate(date,seq);

					if (result > 0) {
						System.out.println("�޼��� �����Ϸ�");
					}
					
					if(dateresult > 0) {
						System.out.println("��¥ ���� �Ϸ�");
					}


				} else if (menu == 5) {

					System.out.println("1.writer�� �˻�");
					System.out.println("2.message�� �˻�");
					System.out.print(">> ");
					int search = Integer.parseInt(sc.nextLine());

					if(search == 1) {
						System.out.print("�˻��� writer�� �Է����ּ��� : ");
						String writer = sc.nextLine();

						List<MessagesDTO> list = dao.searchByWriter(writer);

						for(MessagesDTO m : list) {

							System.out.println(m.getSeq() + "\t" + m.getWriter() + "\t" 
									+ m.getMessage() + "\t" + m.getFormedDate());
						}




					} else if (search == 2) {
						System.out.println("�˻��� message�� �Է����ּ��� : ");
						String message = sc.nextLine();

						List<MessagesDTO> list = dao.searchBymessage(message);

						for(MessagesDTO m : list) {

							System.out.println(m.getSeq() + "\t" + m.getWriter() + "\t" 
									+ m.getMessage() + "\t" + m.getFormedDate());
						}



					}


				} else if (menu == 6) {

					List<MembersDTO> info = mdao.info(isid);

					for (MembersDTO m : info) {
						System.out.println(m.getId() + "\t" + m.getName() + "\t" 
								+ m.getContact() + "\t" + m.getFormedDate());	
					}




				} else if (menu == 7) {

					
					
					}

				else if (menu == 0) {
					System.exit(0);
				} 

			}catch (Exception E) { 
				System.out.println("��ɻ� ������ �ֽ��ϴ�. �����ڿ��� �����ϼ���");
				E.printStackTrace();

			}
		}





	}

}
