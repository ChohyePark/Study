package main;

import java.util.List;
import java.util.Scanner;

import dao.StudentsDAO;
import dto.StudentsDTO;

public class Main {
	public static void main(String[] args) {
		


		Scanner sc = new Scanner(System.in);
		

		
		
		
//		StudentsDAO dao = new StudentsDAO();
//
//		while(true) {
//			System.out.println("<< 학생 정보 관리 프로그램 >>");
//			System.out.println("1. 학생 정보 입력");
//			System.out.println("2. 학생 목록 출력");
//			System.out.println("3. 학생 정보 수정");
//			System.out.println("4. 학생 정보 삭제");
//			System.out.println("5. 학생 정보 검색");
//			System.out.println("0. 시스템 종료");
//			System.out.print(">> ");
//			menu = sc.nextLine();
//			
//
//			try {
//				if(menu.equals("1")) {
//					int id=0;
//					System.out.print("학생 이름: ");
//					String name = sc.nextLine();
//					System.out.print("국어 성적: ");
//					int kor = Integer.parseInt(sc.nextLine());
//					System.out.print("영어 성적: ");
//					int eng = Integer.parseInt(sc.nextLine());
//					System.out.print("수학 성적: ");
//					int math = Integer.parseInt(sc.nextLine());
//
//					StudentsDTO dto = new StudentsDTO(id,name,kor,eng,math);
//					int result = dao.insert(dto);
//
//					if(result>0) {
//						System.out.println("정보 입력 완료");
//					}
//					else {
//						System.out.println("입력 실패.");
//					}
//
//				}
//				else if(menu.equals("2")) {
//
//					List<StudentsDTO> result = dao.selectAll();
//
//					System.out.println("=== 학생 정보 목록 ===");
//					System.out.println("<학번>\t<이름>\t<국어>\t<영어>\t<수학>\t<합계>\t<평균>");
//					for(StudentsDTO dto:result) {
//						int sum = dto.getKor()+dto.getEng()+dto.getMath();
//						String avg = String.format("%.1f", sum/3.0);
//						System.out.println(dto.getId()+"\t"+dto.getName()+"\t"+dto.getKor()
//						+"\t"+dto.getEng()+"\t"+dto.getMath()+"\t"+sum+"\t"+avg);
//					}
//
//				}else if(menu.equals("3")) {
//
//					System.out.print("수정할 학생의 학번 : ");
//					int id = Integer.parseInt(sc.nextLine());
//
//					boolean scanId = dao.scanId(id);
//					if(!scanId) {
//						System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
//					}
//					else {
//
//						System.out.print("수정할 이름: ");
//						String name = sc.nextLine();
//						System.out.print("국어 성적: ");
//						int kor = Integer.parseInt(sc.nextLine());
//						System.out.print("영어 성적: ");
//						int eng = Integer.parseInt(sc.nextLine());
//						System.out.print("수학 성적: ");
//						int math = Integer.parseInt(sc.nextLine());
//
//						StudentsDTO dto = new StudentsDTO(id,name,kor,eng,math);
//						int result = dao.update(dto);
//
//						if(result>0) {
//							System.out.println("정보 수정 완료");
//						}
//						else {
//							System.out.println("정보 수정 실패");
//						}
//					}
//
//				}else if(menu.equals("4")) {
//
//					System.out.print("삭제할 학생의 학번: ");
//					int id = Integer.parseInt(sc.nextLine());
//
//					boolean scanId = dao.scanId(id);
//					if(!scanId) {
//						System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
//					}
//					else {
//						int result = dao.delete(id);
//
//						if(result>0) {
//							System.out.println("정보 삭제 완료");
//						}
//						else {
//							System.out.println("삭제 실패");
//						}
//					}
//
//				}else if(menu.equals("5")) {
//
//					while(true) {
//						System.out.println("1. 학번으로 검색");
//						System.out.println("2. 이름으로 검색");
//						System.out.println("0. 이전 메뉴로 돌아가기");
//						System.out.println(">> ");
//						String scMenu = sc.nextLine();
//
//						if(scMenu.equals("1")) {
//							System.out.print("검색할 학번: ");
//							int scId = Integer.parseInt(sc.nextLine());
//
//							System.out.println("=== 검색 결과 ===");
//							boolean scanId = dao.scanId(scId);
//							if(!scanId) {
//								System.out.println("검색결과가 없습니다.");
//							}
//							else {
//								StudentsDTO dto = dao.searchById(scId);
//								
//								int sum = dto.getKor()+dto.getEng()+dto.getMath();
//								String avg = String.format("%.1f", sum/3.0);
//								
//								System.out.println("<학번>\t<이름>\t<국어>\t<영어>\t<수학>\t<합계>\t<평균>");
//								System.out.println(dto.getId()+"\t"+dto.getName()+"\t"+dto.getKor()
//								+"\t"+dto.getEng()+"\t"+dto.getMath()+"\t"+sum+"\t"+avg);
//							}
//
//						}
//						else if(scMenu.equals("2")) {
//							System.out.print("검색할 이름: ");
//							String scName = sc.nextLine();
//
//							List<StudentsDTO> result = dao.searchByName(scName);
//							
//							System.out.println("=== 검색 결과 ===");
//							if(result.size()==0) {
//								System.out.println("검색결과가 없습니다.");
//							}
//							else {
//								System.out.println("<학번>\t<이름>\t<국어>\t<영어>\t<수학>\t<합계>\t<평균>");
//								for(StudentsDTO dto:result) {
//									int sum = dto.getKor()+dto.getEng()+dto.getMath();
//									String avg = String.format("%.1f", sum/3.0);
//									System.out.println(dto.getId()+"\t"+dto.getName()+"\t"+dto.getKor()
//									+"\t"+dto.getEng()+"\t"+dto.getMath()+"\t"+sum+"\t"+avg);
//								}
//							}
//
//						}
//						else if(scMenu.equals("0")) {
//							System.out.println("이전 메뉴로 돌아갑니다.");
//							break;
//						}
//						else {
//							System.out.println("메뉴를 다시 확인하세요.");
//						}
//					}
//
//				}else if(menu.equals("0")) {
//					System.out.println("시스템을 종료합니다.");
//					System.exit(0);
//				}else {
//					System.out.println("메뉴를 다시 확인하세요.");
//					continue;
//				}
//			}catch(Exception e) {
//				e.printStackTrace();
//				System.out.println("기능 수행 중 오류가 발생했습니다.");
//			}
//		}

	}

}
