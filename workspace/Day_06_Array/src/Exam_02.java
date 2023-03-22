
public class Exam_02 {

	public static void main(String[] args) {

		// int 형 변수 3칸 짜리를 arr1 로 작성학,
		// 0 : 48 , 1 : 99 , 2 : 33 을 저장후 화면에 출력

		int[] arr = new int[] {48 , 99 , 33};


		for(int i= 0; i<arr.length ; i++) {
			System.out.println(arr[i]);
		}

		//String 형 변수 2칸 짜리를 arr2 로 작성 하고
		//0 : "Hello" , 1 : "World" 를 작성한 후
		// 화면에 출력해봅시다.

		String[] arr2 = new String[2] ;
				arr2[0]="Hello";
				arr2[1]="World";
		for(int i = 0; i<arr2.length ; i++) {
			System.out.println(arr2[i]);
		}



		char[]arr3 = new char[] {'A','r','r','a','y'};
	
		int i = 0;
		while(i<arr3.length) {
			
			System.out.print(arr3[i]+" ");
			i++;
			
		}

	}
}


