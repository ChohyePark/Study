
public class Exam_01 {

	public static void main(String[] args) {
		//���� ���� heap �޸𸮸� ����ϰڴ� -> new  
		//String ��� ���󵵰� ��� new ��������
		
	
		int[] arr = new int[] {10,20,30,40,100}; // <- �迭 ���� ���� : int�� ���� 4�� ���� , int[]arr; ->int �� �迭�� �ּҸ� ������ ��������, �迭�� �ּҸ� �����ϰ��ִ°� arr
									            //new int [4] ->  heap �޸𸮿� ����
									             //�迭�� ÷��(index)�� offset�� �ǹ�
//		int[] arr = new int[4];
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;
//		arr[3] = 40;
		
		
			
		for(int i= 0 ; i <arr.length ; i++) {          // arr.length �迭�� ���̰�
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
