
public class Exam_01 {

	public static void main(String[] args) {

		//try - catch : 예외 처리 구문  예외발생시 main 밖으로 튀어나가는걸 catch가 잡음 예외발생 없을시 건너뜀
		
		try {
			int num = Integer.parseInt("123");         // parseInt 에는 숫자형 문자 , 숫자만 기입가능
			System.out.println("분석된 숫자는 : " + num); 
		}catch(Exception e) {
			//예외가 발생시 개발자가 취햐주고자 하는 행동 , 예외발생지점과 catch사이는 실행 x 9 -> 13
			System.out.println("분석하는 데이터가 숫자 형식이 아닙니다.");
		}
		
		System.out.println("프로그램 정상 종료");

	}
}
