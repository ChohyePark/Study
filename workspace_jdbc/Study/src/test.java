

public class test {

	public static void main(String[] args) {


		int i = 1;
		int j = 13;
		int k = 1;
		int count = 0;

		for ( ; i <= j ; i++) {

			// 1의 자리 수 구할 때

			if (i == k) {
				System.out.println(" i == k ==>" + i);
				count++;
			}

			if (i != k) {
				if(i % 10 == k) {
					System.out.println(" i % 10 ==>" + i);
					count++;
				}
			}


			if (i / 10 == k ) {
				System.out.println("i / 10 ==>" +  i);
				count++;
			}


		}


		System.out.println(count);


	}	



}
