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


			System.out.println("===== 로그인 =====");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 종료");
			System.out.print(">> ");
			int menu1 = Integer.parseInt(sc.nextLine());

			try {
				if(menu1 == 1) {

					System.out.print("id를 입력해주세요 : ");
					isid = sc.nextLine();
					boolean idresult = mdao.loginID(isid);

					if(!idresult) {
						System.out.println("id를 다시 확인해주세요");	
						continue;	
					} else  {

						System.out.print("pw를 입력해주세요 : ");	
						String pw = EncryptionUtils.sha512(sc.nextLine());

						boolean pwresult = mdao.loginPW(pw);

						if (!pwresult) {
							System.out.println("pw를 다시 확인해주세요");
							continue;
						} else {
							flag = true;
							break;
						}


					}



				} else if(menu1 == 2) {

					System.out.print("id를 입력해주세요 : ");
					String id = sc.nextLine();
					System.out.print("pw를 입력해주세요 : ");
					String pw = EncryptionUtils.sha512(sc.nextLine());
					System.out.print("이름을 입력해주세요 : ");
					String name = sc.nextLine();
					System.out.print("연락처를 입력해주세요 : ");
					String contact = sc.nextLine();

					int result = mdao.insert(new MembersDTO(id,pw,name,contact,null));

					if (result > 0) {
						System.out.println("입력완료");
					}


				} else if(menu1 == 3) {

					System.exit(0);

				} 
			}	 catch (Exception e) {
				System.out.println("기능상 문제가 생겼습니다. 관리자에게 문의주세요");
				e.printStackTrace();

			}
		}


		MessagesDAO dao = new MessagesDAO();


		while(flag) {
			System.out.println("===== 경량 게시판 프로젝트 =====");
			System.out.println("1. 신규 메세지 등록 "); // 작성자, 메세지 직접 입력
			System.out.println("2. 메세지 목록 출력"); // 글 번호, 작성자, 글내용, 작성일 [MM/dd]
			System.out.println("3. 메세지 삭제"); // seq 삭제
			System.out.println("4. 메세지 수정"); // seq 수정하되 write 및 message만 수정 가능
			System.out.println("5. 메세지 검색"); // writer 또는 message에 검색어를 포함하는 대상 like % % 사용
			System.out.println("6. 내 정보보기");
			System.out.println("7. (추가) 작성일 수정 ");
			System.out.println("0. 시스템 종료");

			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());

			try {

				if (menu == 1) {
					System.out.print("메세지를 입력해주세요 : ");
					String message = sc.nextLine();

					int result = dao.insert(isid, message);


				} else if (menu == 2) {

					List<MessagesDTO> list = dao.selectAll();

					System.out.println("글번호\t작성자\t글내용\t작성일");

					for(MessagesDTO m : list) {
						System.out.println(m.getSeq() + "\t" + m.getWriter() + "\t" + m.getMessage() + "\t" +m.getFormedDate() );
					}



				} else if (menu == 3) {

					System.out.print("삭제할 메세지의 seq를 입력해주세요 : ");
					int seq = Integer.parseInt(sc.nextLine());

					int result = dao.delete(seq);

					if(result > 0 ) {
						System.out.println("삭제 완료");
					}

				} else if (menu == 4) {

					System.out.print("수정할 메세지의 seq를 입력해주세요 : ");
					int seq = Integer.parseInt(sc.nextLine());
					System.out.print("수정할 메세지를 입력해주세요 : ");
					String message = sc.nextLine();
					System.out.print("수정할 날짜를 입력해주세요 : ");
					String date = sc.nextLine();
					
					
					
					int result = dao.update(new MessagesDTO(seq,null,message,null));
					int dateresult = dao.updateDate(date,seq);

					if (result > 0) {
						System.out.println("메세지 수정완료");
					}
					
					if(dateresult > 0) {
						System.out.println("날짜 수정 완료");
					}


				} else if (menu == 5) {

					System.out.println("1.writer로 검색");
					System.out.println("2.message로 검색");
					System.out.print(">> ");
					int search = Integer.parseInt(sc.nextLine());

					if(search == 1) {
						System.out.print("검색할 writer를 입력해주세요 : ");
						String writer = sc.nextLine();

						List<MessagesDTO> list = dao.searchByWriter(writer);

						for(MessagesDTO m : list) {

							System.out.println(m.getSeq() + "\t" + m.getWriter() + "\t" 
									+ m.getMessage() + "\t" + m.getFormedDate());
						}




					} else if (search == 2) {
						System.out.println("검색할 message를 입력해주세요 : ");
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
				System.out.println("기능상 문제가 있습니다. 관리자에게 문의하세요");
				E.printStackTrace();

			}
		}





	}

}
