import java.util.Scanner; // Ctrl + Shift + 알파벳o 

public class Exam_07 {

	public static void main(String[] args) {
		
		// 문장을 입력받는 기능
		Scanner sc = new Scanner(System.in);
		
		System.out.println("메세지를 남겨주세요.");
		// int a = System.in.read();
		String str = sc.nextLine();
		// string 값을 받아오는 기능
		// 아직 정해지지 않은 문자열 (사용자의 입력에 따라 변화됨)
		System.out.println("<<당신이 남긴 메세지는>>");
		System.out.println(str);
		
		
	}

}
