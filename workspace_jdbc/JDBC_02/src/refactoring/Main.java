package refactoring;
//완성된 Netflix 관리 프로그램을 MVC패턴으로 리팩토링한다.

import java.util.List;
import java.util.Scanner;

import commons.EncryptionUtils;
import dao.MembersDAO;
import dao.MoviesDAO;
import dto.MembersDTO;
import dto.MoviesDTO;

public class Main {
	public static void main(String[] args) {
		//로그인 및 회원가입 기능 추가
		//1.Members 테이블 생성
		//(id(시퀀스 말고. 문자열20byte, 주키), pw(문자열 20byte, not null), 
		//name(문자열 20byte not null), contact(문자열 20byte), reg_date(기본값 sysdate, not null)
		Scanner sc = new Scanner(System.in);
		while(true) {
			try{

				MembersDAO mdao = new MembersDAO();

				System.out.println("<< Index >>");
				System.out.println("1. 로그인");
				System.out.println("2. 회원가입");
				System.out.println("3. 회원 목록 출력");
				System.out.println("0. 종료");
				System.out.print(">> ");
				String menu = sc.nextLine();

				if(menu.equals("1")) {
					System.out.print("ID: ");
					String id = sc.nextLine();
					System.out.print("PW: ");
					String pw = sc.nextLine();
					
					//PW를 암호화한 상태로 전달해야 함. 암호화 로직
					pw = EncryptionUtils.sha512(pw);

					boolean result = mdao.isMember(id,pw);
					//로그인 확인코드 --> true일 경우 본 코드 실행되도록
					if(result) {
						System.out.println("로그인 성공");
						System.out.println(id+"님 환영합니다.");
						break;
					}
					else {
						System.out.println("로그인 실패.");
						System.out.println();
						continue;
					}
				}
				else if(menu.equals("2")) {
					System.out.println("< 회원가입 >");
					System.out.print("사용할 ID: ");
					String id = sc.nextLine();
					
					//아이디 중복 검사
					boolean dup = mdao.isDuplicate(id);
					if(dup) {
						System.out.println("이미 사용중인 ID입니다.");
						continue;
					}

					System.out.print("사용할 PW: ");
					String pw = sc.nextLine();
					
					//PW를 암호화한 상태로 전달해야 함. 암호화 로직
					pw = EncryptionUtils.sha512(pw);

					System.out.print("이름: ");
					String name = sc.nextLine();

					System.out.print("연락처: ");
					String contact = sc.nextLine();

					MembersDTO mdto = new MembersDTO(id,pw,name,contact,null); 
					//마지막 값(가입날짜)은 null로 비워둔다.
					int result = mdao.register(mdto);

					if(result>0) {
						System.out.println("가입 완료");
					}
					else {
						System.out.println("회원가입 실패");
					}

				}
				else if(menu.equals("3")) {//날짜 데이터 다루는 법 익히기 목적
					System.out.println(" === 회원 목록 ===");
					System.out.println("ID\t이름\t연락처\t\t가입시기");
					
					List<MembersDTO> list = mdao.selectAll();
					for(MembersDTO dto:list) {
						
						
						System.out.println(dto.getId()+"\t"+dto.getName()+"\t"+dto.getContact()+"\t"
									+ dto.getFormedDate());
					}
					
				}
				else if(menu.equals("0")) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				}
				else {
					System.out.println("메뉴를 다시 확인해주세요.");
				}

			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("기능 수행 중 오류 발생");
			}
		}

		MoviesDAO dao = new MoviesDAO();

		while(true) {
			System.out.println("<< Nexflix 영화 관리 프로그램 >>");
			System.out.println("1. 신규 영화 등록"); 
			System.out.println("2. 영화 목록 출력"); 
			System.out.println("3. 영화 항목 수정"); 
			System.out.println("4. 영화 항목 삭제"); 
			System.out.println("5. 영화 검색");
			System.out.println("0. 프로그램 종료");
			System.out.print(">> ");
			String menu = sc.nextLine();

			try {
				if(menu.equals("1")) {

					System.out.print("신규 등록할 영화 제목: ");
					String title = sc.nextLine();
					System.out.print("영화 장르: ");
					String genre = sc.nextLine();

					int result=dao.insert(title, genre);
					if(result > 0 ) {
						System.out.println("영화가 등록되었습니다.");
					}
					else {
						System.out.println("등록 실패.");
					}
				}
				else if(menu.equals("2")) {

					List<MoviesDTO> result = dao.selectAll();
					System.out.println("고유번호\t제목\t장르");
					for(MoviesDTO dto:result) {                                               
						System.out.println(dto.getId()+"\t"+dto.getTitle()+"\t"+dto.getGenre());					
					}
				}
				else if(menu.equals("3")) {

					System.out.print("수정할 영화의 고유번호: ");
					int id = Integer.parseInt(sc.nextLine());

					boolean scan = dao.isIdExist(id);
					if(!scan) { //scan이 false일 경우
						System.out.println(id+"번 영화를 찾을 수 없습니다.");
					}
					else {

						System.out.println("영화 정보를 재입력하세요.");
						System.out.print("영화 제목: ");
						String title = sc.nextLine();
						System.out.print("영화 장르: ");
						String genre = sc.nextLine();

						MoviesDTO dto = new MoviesDTO(id,title,genre);

						int result = dao.update(dto); //dto에 담아서 한꺼번에 넘기는게 더 좋은코드.

						if(result>0) {
							System.out.println("영화 정보가 수정되었습니다.");
						}
						else {
							System.out.println("정보 수정에 실패했습니다.");
						}
					}
				}
				else if(menu.equals("4")) {
					System.out.print("삭제할 영화의 고유번호: ");
					int id = Integer.parseInt(sc.nextLine());

					boolean scan = dao.isIdExist(id);
					if(!scan) {
						System.out.println(id+"번 영화를 찾을 수 없습니다.");
					}
					else {

						int result = dao.delete(id);
						if(result>0) {
							System.out.println("항목이 삭제되었습니다.");
						}
						else {
							System.out.println("삭제에 실패했습니다.");
						}
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

							System.out.println("== 검색결과 ==");

							if(!dao.isIdExist(scId)){
								System.out.println("검색결과가 없습니다.");
							}
							else {
								MoviesDTO result = dao.searchById(scId);
								System.out.println(result.getId()+"\t"+result.getTitle()+"\t"+result.getGenre());
							}

						}
						else if(scMenu.equals("2")) {
							System.out.print("검색할 영화 제목: ");
							String scTitle = sc.nextLine();

							System.out.println("== 검색결과 ==");

							List<MoviesDTO> result = dao.searchByTitle(scTitle);
							for(MoviesDTO dto:result) {
								System.out.println(dto.getId()+"\t"+dto.getTitle()+"\t"+dto.getGenre());
							}

							if(result.size()==0) {
								System.out.println("검색결과가 없습니다.");
							}

						}
						else if(scMenu.equals("3")) {
							System.out.print("검색할 영화 장르: ");
							String scGenre = sc.nextLine();
							List<MoviesDTO> result = dao.searchByGenre(scGenre);

							System.out.println("== 검색결과 ==");
							for(MoviesDTO dto:result) {
								System.out.println(dto.getId()+"\t"+dto.getTitle()+"\t"+dto.getGenre());
							}

							if(result.size()==0) {
								System.out.println("검색결과가 없습니다.");
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
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("기능 수행 중 오류가 발생했습니다.");
			}
		}
	}
}
