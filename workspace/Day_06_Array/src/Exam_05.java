
public class Exam_05 {

	public static void main(String[] args) {

		// 24 86 13 46

		int[]nums = new int[] {99,48,27,15};

		System.out.print("���� �� : ");

		for(int i = 0; i< nums.length; i++) {
			System.out.print(nums[i] + " ");


		}
		System.out.println();
		// ------------------------- �����ڵ�( Bubble sort)  n-1  4���̸� 3�� �ݺ�
		for(int i = 0; i<nums.length-1; i++) {
			for(int j = 0; j<nums.length-1; j++) {
				if(nums[j]>nums[j+1]) {
					int tmp = nums[j];
					nums[j]= nums[j+1];
					nums[j+1]=tmp;
				}
			}
		}
		// ------------------------- �����ڵ�
		System.out.println("=======================");
		System.out.print("���� �� : ");
		for(int i =0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");

		}
	}

}