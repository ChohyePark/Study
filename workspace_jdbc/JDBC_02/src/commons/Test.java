package commons;

import java.text.SimpleDateFormat;

public class Test {

	public static void main(String[] args) {
		
		
		// to_char (sysdate, 'YYYYMMDD HH:MI:SS')
		// System.currentTimeMillis() == sysdate
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss"); // 출력하는 날짜 모양을 만들 수 있다.
		
		String result = sdf.format(System.currentTimeMillis()); // String 타입 반환 
		
		System.out.println(result);
		
		
		
		
		// 날짜 M 과 시간 m 을 구분할때는 대문자, 소문자로 구분한다.
		
	
			
		
		
	}
	
	
}
