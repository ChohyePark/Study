package Exams;
import costum.Student;

public class Exam_03 {

	public static void main(String[] args) {


		Student st = new Student("Jack",95,84,68);
		System.out.println("�л��̸� : " + st.getName());
		System.out.println("�������� : " + st.getKor());
		System.out.println("�������� : " + st.getEng());				//�ν��Ͻ� �ʱⰪ�� ä�� ����� �����ڷ� �����ϰų� set������ ��������
		System.out.println("�������� : " + st.getMath());
		System.out.println("���� �հ� : " +st.getSum());
		System.out.println("���� ��� : " +st.getAvg());

		//Class : ������� �ϴ� ����� ���赵
		// 			Member Field , Member Method , Constructor
		//�������� : private ���� �����ڷ� ������ �����ϴ� ���.
		//getter / setter �� ���� �������е� �����͸� ���������� ����
		//this : �ڱ����� ����
		//Constructor : �ν��Ͻ��� �������� �ο��ϴ� �ʱⰪ�� �����ϴ� �޼���




		//		st.setName("Jack");
		//		st.setKor(95);
		//		st.setEng(84);
		//		st.setMath(68);
		//		
		//		System.out.println("�л��̸� : " + st.getName());
		//		System.out.println("�������� : " + st.getKor());
		//		System.out.println("�������� : " + st.getEng());
		//		System.out.println("�������� : " + st.getMath());
		//		
		//		System.out.println("���� �հ� : " +st.getSum());
		//		System.out.println("���� ��� : " +st.getAvg());
		//		
		//		System.out.println("���� �հ� : "+ st.getKor()+st.getEng()+st.getMath());
		//		System.out.println("���� ��� : "+ (double)(st.getKor()+st.getEng()+st.getMath())/3);
		//System.out.println("===============================");

		//	  st.setName1("Jane");
		//	  st.setKor1(100);
		//	  st.setEng1(50);
		//	  st.setMath1(95);
		//	  
		//	  
		//	  System.out.println("�л��̸� : "+st.getName1());
		//	  System.out.println("�������� : "+st.getKor1());
		//	  System.out.println("�������� : "+st.getMath1());
		//	  System.out.println("�������� : "+st.getMath1());
		//	  
		//	  System.out.println("���� �հ� : " + st.getSum1());
		//	  System.out.println("���� ��� : " + st.getAvg1());
		//	  
		//		
	}

}
