package Exams;
import java.util.Scanner;

import costum.TV;

public class Exam_01 {

	public static void main(String[] args) {
		//void = ���ϰ��� �Ű� ���ʿ����
//		TV samsung;           //���ǿ��� ����ȭ �� ��ü�� �����ϰ� class���赵�� �ۼ��� new �ۼ��� ������ ����     
//		new TV();      //��ü(instance)  TV(instance)�� �����Ѵ�  �� �޸𸮿� �����ǰ� new ���� �ּҰ� ���ϵ�
		
		TV samsung = new TV();
		
	//	samsung.                       // .�� ������ �ּҷ� ã�ư��ڴ�
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String str1= "Apple";
		String str2= new String("Apple");
		
		System.out.println("Apple" == "Apple");
		System.out.println("Apple" == "str1");
		System.out.println("Apple" == "str2");
		
	}

}
