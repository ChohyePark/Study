
public class Exam_01 {

	public static void main(String[] args) {
		//나는 지금 heap 메모리를 사용하겠다 -> new  
		//String 경우 사용빈도가 잦아 new 생략가능
		
	
		int[] arr = new int[] {10,20,30,40,100}; // <- 배열 생성 문법 : int형 변수 4개 생성 , int[]arr; ->int 형 배열의 주소를 저장할 참조변수, 배열의 주소를 저장하고있는게 arr
									            //new int [4] ->  heap 메모리에 생성
									             //배열의 첨자(index)는 offset의 의미
//		int[] arr = new int[4];
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;
//		arr[3] = 40;
		
		
			
		for(int i= 0 ; i <arr.length ; i++) {          // arr.length 배열의 길이값
			System.out.println(arr[i]);
		}
			
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
//		System.out.println(arr[3]);
		
		
		
		
//		System.out.println(arr[1-1]);
//		System.out.println(arr[3/2]);
//		System.out.println(arr[(int)(Math.random()*3)]);
//		System.out.println(arr[Integer.parseInt(sc.nextLine())]);
		
	}

}
