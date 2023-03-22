package Exams;
import costum.Student;

public class Exam_03 {

	public static void main(String[] args) {


		Student st = new Student("Jack",95,84,68);
		System.out.println("학생이름 : " + st.getName());
		System.out.println("국어점수 : " + st.getKor());
		System.out.println("영어점수 : " + st.getEng());				//인스턴스 초기값을 채울 방법은 생성자로 생성하거나 set값으로 생성가능
		System.out.println("수학점수 : " + st.getMath());
		System.out.println("과목 합계 : " +st.getSum());
		System.out.println("과목 평균 : " +st.getAvg());

		//Class : 만들고자 하는 대상의 설계도
		// 			Member Field , Member Method , Constructor
		//정보은닉 : private 접근 제한자로 정보를 은닉하는 방법.
		//getter / setter 를 만들어서 정보은닉된 데이터를 제한적으로 접근
		//this : 자기참조 변수
		//Constructor : 인스턴스를 생성히며 부여하는 초기값을 세팅하는 메서드




		//		st.setName("Jack");
		//		st.setKor(95);
		//		st.setEng(84);
		//		st.setMath(68);
		//		
		//		System.out.println("학생이름 : " + st.getName());
		//		System.out.println("국어점수 : " + st.getKor());
		//		System.out.println("영어점수 : " + st.getEng());
		//		System.out.println("수학점수 : " + st.getMath());
		//		
		//		System.out.println("과목 합계 : " +st.getSum());
		//		System.out.println("과목 평균 : " +st.getAvg());
		//		
		//		System.out.println("과목 합계 : "+ st.getKor()+st.getEng()+st.getMath());
		//		System.out.println("과목 평균 : "+ (double)(st.getKor()+st.getEng()+st.getMath())/3);
		//System.out.println("===============================");

		//	  st.setName1("Jane");
		//	  st.setKor1(100);
		//	  st.setEng1(50);
		//	  st.setMath1(95);
		//	  
		//	  
		//	  System.out.println("학생이름 : "+st.getName1());
		//	  System.out.println("국어점수 : "+st.getKor1());
		//	  System.out.println("영어점수 : "+st.getMath1());
		//	  System.out.println("수학점수 : "+st.getMath1());
		//	  
		//	  System.out.println("과목 합계 : " + st.getSum1());
		//	  System.out.println("과목 평균 : " + st.getAvg1());
		//	  
		//		
	}

}
