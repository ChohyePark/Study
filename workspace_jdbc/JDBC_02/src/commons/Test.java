package commons;

import java.text.SimpleDateFormat;

public class Test {

	public static void main(String[] args) {
		
		
		// to_char (sysdate, 'YYYYMMDD HH:MI:SS')
		// System.currentTimeMillis() == sysdate
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss"); // ����ϴ� ��¥ ����� ���� �� �ִ�.
		
		String result = sdf.format(System.currentTimeMillis()); // String Ÿ�� ��ȯ 
		
		System.out.println(result);
		
		
		
		
		// ��¥ M �� �ð� m �� �����Ҷ��� �빮��, �ҹ��ڷ� �����Ѵ�.
		
	
			
		
		
	}
	
	
}
