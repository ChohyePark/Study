
public class Exam_02 {

	public static void main(String[] args) {

		// int �� ���� 3ĭ ¥���� arr1 �� �ۼ���,
		// 0 : 48 , 1 : 99 , 2 : 33 �� ������ ȭ�鿡 ���

		int[] arr = new int[] {48 , 99 , 33};


		for(int i= 0; i<arr.length ; i++) {
			System.out.println(arr[i]);
		}

		//String �� ���� 2ĭ ¥���� arr2 �� �ۼ� �ϰ�
		//0 : "Hello" , 1 : "World" �� �ۼ��� ��
		// ȭ�鿡 ����غ��ô�.

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


