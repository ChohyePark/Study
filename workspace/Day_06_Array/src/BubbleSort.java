
public class BubbleSort {

	public static void main(String[] args) {

		int[]num =new int[] {15,24,35,99,86,34,13,27,46,66};{

			System.out.print("정렬 전 : " );
			for(int i= 0; i<num.length;i++ ) {
				System.out.print(num[i]+" ");
			}
			System.out.println("");
		
			for( int j = 0; j<num.length-1; j++) {
				for( int i = 0; i<num.length-1; i++) {
					if(num[i]>num[i+1]) {
						int tmp = num[i];
						num[i] = num[i+1];
						num[i+1]= tmp;
					}
				}

			}












			System.out.println("=======================");
			System.out.print("정렬 후 : ");
			for(int i= 0; i<num.length;i++ ) {
				System.out.print(num[i]+" ");


			}


		}

	}
}