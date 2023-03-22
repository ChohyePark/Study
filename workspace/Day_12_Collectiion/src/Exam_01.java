//배열과 Collection의 차이
public class Exam_01 {
	public static void main(String[] args) {
		String[] arr = new String[10];
		
		arr[0]="Hello";
		arr[1]="World";
		arr[2]="Collection";
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println("==========");
		//Hello 지워보자
		arr[0] = arr[1];
		arr[1] = arr[2];
		arr[2] = null;
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println("==========");
		//중간에 Java를 끼워보자
		arr[3] = arr[2];
		arr[2] = arr[1];
		arr[1] = "Java";
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println("==========");
		
		//배열의 총 길이. 들어있는 데이터는 몇개인지 보기 까다로움
		System.out.println(arr.length);
	}
}
