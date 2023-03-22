
public class Exam_02 {

	public static void main(String[] args) {



		String str = "Hello World";

		int length =str.length();
		System.out.println(length);

		char c =str.charAt(3);
		System.out.println(c);



		
		System.out.println(str.indexOf("e"));

		boolean i =str.startsWith("e");
		System.out.println(i);

		boolean end = str.endsWith("d");
		System.out.println(end);
		
		System.out.println(str.equals("Hello World"));

		System.out.println(str.contains("H"));
		String[]str1 =str.split("e");
		System.out.println(str1[0]);
		System.out.println(str1[1]);




	}

}
