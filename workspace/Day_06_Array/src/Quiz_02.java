import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int stdCnt = 3;

		int[]kor= new int [stdCnt];
		int[]eng= new int [stdCnt];
		String[]names = new String [stdCnt];
		for(int i= 0; i<stdCnt; i++) {
			System.out.print((i+1)+"번째 학생 이름 : ");
			names[i]=sc.nextLine();

			System.out.print(names[i]+"학생의 국어 : ");
			kor[i] = Integer.parseInt(sc.nextLine());

			System.out.print(names[i]+"학생의 영어 : ");
			eng[i] = Integer.parseInt(sc.nextLine());
			
		
			
		}

		System.out.println("이름\t국어\t영어\t합계\t평균");
		for(int i =0; i<stdCnt ; i++) {
			System.out.println(names[i]+"\t"+kor[i]+"\t"+eng[i]+"\t"+(kor[i]+eng[i])+"\t"+(kor[i]+eng[i])/2.0);
			
			
		}
		
		
		
		
	}



}




