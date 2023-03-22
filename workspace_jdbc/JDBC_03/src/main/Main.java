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
//			System.out.println("<< �л� ���� ���� ���α׷� >>");
//			System.out.println("1. �л� ���� �Է�");
//			System.out.println("2. �л� ��� ���");
//			System.out.println("3. �л� ���� ����");
//			System.out.println("4. �л� ���� ����");
//			System.out.println("5. �л� ���� �˻�");
//			System.out.println("0. �ý��� ����");
//			System.out.print(">> ");
//			menu = sc.nextLine();
//			
//
//			try {
//				if(menu.equals("1")) {
//					int id=0;
//					System.out.print("�л� �̸�: ");
//					String name = sc.nextLine();
//					System.out.print("���� ����: ");
//					int kor = Integer.parseInt(sc.nextLine());
//					System.out.print("���� ����: ");
//					int eng = Integer.parseInt(sc.nextLine());
//					System.out.print("���� ����: ");
//					int math = Integer.parseInt(sc.nextLine());
//
//					StudentsDTO dto = new StudentsDTO(id,name,kor,eng,math);
//					int result = dao.insert(dto);
//
//					if(result>0) {
//						System.out.println("���� �Է� �Ϸ�");
//					}
//					else {
//						System.out.println("�Է� ����.");
//					}
//
//				}
//				else if(menu.equals("2")) {
//
//					List<StudentsDTO> result = dao.selectAll();
//
//					System.out.println("=== �л� ���� ��� ===");
//					System.out.println("<�й�>\t<�̸�>\t<����>\t<����>\t<����>\t<�հ�>\t<���>");
//					for(StudentsDTO dto:result) {
//						int sum = dto.getKor()+dto.getEng()+dto.getMath();
//						String avg = String.format("%.1f", sum/3.0);
//						System.out.println(dto.getId()+"\t"+dto.getName()+"\t"+dto.getKor()
//						+"\t"+dto.getEng()+"\t"+dto.getMath()+"\t"+sum+"\t"+avg);
//					}
//
//				}else if(menu.equals("3")) {
//
//					System.out.print("������ �л��� �й� : ");
//					int id = Integer.parseInt(sc.nextLine());
//
//					boolean scanId = dao.scanId(id);
//					if(!scanId) {
//						System.out.println("�ش� �й��� �л��� ã�� �� �����ϴ�.");
//					}
//					else {
//
//						System.out.print("������ �̸�: ");
//						String name = sc.nextLine();
//						System.out.print("���� ����: ");
//						int kor = Integer.parseInt(sc.nextLine());
//						System.out.print("���� ����: ");
//						int eng = Integer.parseInt(sc.nextLine());
//						System.out.print("���� ����: ");
//						int math = Integer.parseInt(sc.nextLine());
//
//						StudentsDTO dto = new StudentsDTO(id,name,kor,eng,math);
//						int result = dao.update(dto);
//
//						if(result>0) {
//							System.out.println("���� ���� �Ϸ�");
//						}
//						else {
//							System.out.println("���� ���� ����");
//						}
//					}
//
//				}else if(menu.equals("4")) {
//
//					System.out.print("������ �л��� �й�: ");
//					int id = Integer.parseInt(sc.nextLine());
//
//					boolean scanId = dao.scanId(id);
//					if(!scanId) {
//						System.out.println("�ش� �й��� �л��� ã�� �� �����ϴ�.");
//					}
//					else {
//						int result = dao.delete(id);
//
//						if(result>0) {
//							System.out.println("���� ���� �Ϸ�");
//						}
//						else {
//							System.out.println("���� ����");
//						}
//					}
//
//				}else if(menu.equals("5")) {
//
//					while(true) {
//						System.out.println("1. �й����� �˻�");
//						System.out.println("2. �̸����� �˻�");
//						System.out.println("0. ���� �޴��� ���ư���");
//						System.out.println(">> ");
//						String scMenu = sc.nextLine();
//
//						if(scMenu.equals("1")) {
//							System.out.print("�˻��� �й�: ");
//							int scId = Integer.parseInt(sc.nextLine());
//
//							System.out.println("=== �˻� ��� ===");
//							boolean scanId = dao.scanId(scId);
//							if(!scanId) {
//								System.out.println("�˻������ �����ϴ�.");
//							}
//							else {
//								StudentsDTO dto = dao.searchById(scId);
//								
//								int sum = dto.getKor()+dto.getEng()+dto.getMath();
//								String avg = String.format("%.1f", sum/3.0);
//								
//								System.out.println("<�й�>\t<�̸�>\t<����>\t<����>\t<����>\t<�հ�>\t<���>");
//								System.out.println(dto.getId()+"\t"+dto.getName()+"\t"+dto.getKor()
//								+"\t"+dto.getEng()+"\t"+dto.getMath()+"\t"+sum+"\t"+avg);
//							}
//
//						}
//						else if(scMenu.equals("2")) {
//							System.out.print("�˻��� �̸�: ");
//							String scName = sc.nextLine();
//
//							List<StudentsDTO> result = dao.searchByName(scName);
//							
//							System.out.println("=== �˻� ��� ===");
//							if(result.size()==0) {
//								System.out.println("�˻������ �����ϴ�.");
//							}
//							else {
//								System.out.println("<�й�>\t<�̸�>\t<����>\t<����>\t<����>\t<�հ�>\t<���>");
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
//							System.out.println("���� �޴��� ���ư��ϴ�.");
//							break;
//						}
//						else {
//							System.out.println("�޴��� �ٽ� Ȯ���ϼ���.");
//						}
//					}
//
//				}else if(menu.equals("0")) {
//					System.out.println("�ý����� �����մϴ�.");
//					System.exit(0);
//				}else {
//					System.out.println("�޴��� �ٽ� Ȯ���ϼ���.");
//					continue;
//				}
//			}catch(Exception e) {
//				e.printStackTrace();
//				System.out.println("��� ���� �� ������ �߻��߽��ϴ�.");
//			}
//		}

	}

}
