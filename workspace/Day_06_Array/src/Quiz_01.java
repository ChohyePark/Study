
public class Quiz_01 {

	public static void main(String[] args) {
		// int 형 변수 100개를 arr1로 생성하고,
		//1부터 100 까지 저장한 후 출력해보세요

		//char 형 변수 26개를 arr2로 생성하고,
		// 알파벳 A 부터 Z까지 저장한 후 출력해보세요



		int[] arr1 = new int[100];
		for(int i= 0; i<arr1.length; i++) {
			arr1[i] = i+1;

		}
		System.out.println(arr1[0]);
		System.out.println(arr1[99]);

		char[]arr2 = new char[26];
		for( int  i =0; i<arr2.length; i++) {
			arr2[i]=(char)(65+i);

		}
		System.out.println(arr2[0]);
		System.out.println(arr2[25]);


		int[] arr3 = new int[100];
		for(int i= 0; i<100; i++) {
			arr3[i] = 100-i;


		}
		System.out.println(arr3[0]);
		System.out.println(arr3[99]);
	}
}
