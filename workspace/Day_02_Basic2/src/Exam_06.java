
public class Exam_06 {
	
	public static void main(String[] args) throws Exception{
		
		System.out.print("한 글자를 입력해주세요 : ");
		int input = System.in.read();
		//char ch = (char)input;
		
		// 아직 정해지지 않은 숫자 1개 (사용자의 입력에 따라 변화됨)
		
		// System.out.println("입력하신 문자 " + (char)input + "의 ASCII코드 10진수는 " + input + " 입니다."); or
		//System.out.println("입력하신 문자 " + ch + "의 ASCII코드 10진수는 " + input + " 입니다.");
		
		//                    위와 같은 문구를 UI 라고한다
		System.out.println("입력한 문자는 : " + (char)input);
		
		System.out.print("한 글자를 입력해주세요 : ");
		int input1 = System.in.read();
		System.out.println("입력한 문자는 : " + input1);
		
		System.out.print("한 글자를 입력해주세요 : ");
		int input2 = System.in.read();
		System.out.println("입력한 문자는 : " + input2);
		
		System.out.print("한 글자를 입력해주세요 : ");
		int input3 = System.in.read();
		System.out.println("입력한 문자는 : " + (char)input3);

	}

}
