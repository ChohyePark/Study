import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int stdCnt = 3;

		int[]kor= new int [stdCnt];
		int[]eng= new int [stdCnt];
		String[]names = new String [stdCnt];
		for(int i= 0; i<stdCnt; i++) {
			System.out.print((i+1)+"��° �л� �̸� : ");
			names[i]=sc.nextLine();

			System.out.print(names[i]+"�л��� ���� : ");
			kor[i] = Integer.parseInt(sc.nextLine());

			System.out.print(names[i]+"�л��� ���� : ");
			eng[i] = Integer.parseInt(sc.nextLine());
			
		
			
		}

		System.out.println("�̸�\t����\t����\t�հ�\t���");
		for(int i =0; i<stdCnt ; i++) {
			System.out.println(names[i]+"\t"+kor[i]+"\t"+eng[i]+"\t"+(kor[i]+eng[i])+"\t"+(kor[i]+eng[i])/2.0);
			
			
		}
		
		
		
		
	}



}




