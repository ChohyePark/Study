
public class Quiz_03 {

	public static void main(String[] args) {
		// 1 ~ 45 사이의 난수를 중첩되지 않게 7개를 뽑아서 출력 하세요.
		//오늘의 추천로또 만들기
		
		int num[] = new int[45];
		for(int i = 0; i<num.length; i++) {
			num[i]=i+1;
			
		}
		for(int c= 0; c<num.length; c ++) {
		int i = (int)(Math.random()*45);
		int x = (int)(Math.random()*45);
		
		int tmp = num[i];
		num[i] = num[x];
		num[x]=tmp;
		
		
		
		}
		System.out.println(num[1]);
		System.out.println(num[2]);
		System.out.println(num[3]);
		System.out.println(num[4]);
		System.out.println(num[5]);
		System.out.println(num[6]);
		System.out.println(num[7]);
		
		
	}

}
