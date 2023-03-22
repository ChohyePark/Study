
public class Quiz_03 {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 20;
		System.out.println(++a == 10 && b++ == 20);
		//                              (여기는 스킵)
		//                              (shortcut)
		//                              (실행이 안됨)
		System.out.println(a + " : " + b);

	}

}
