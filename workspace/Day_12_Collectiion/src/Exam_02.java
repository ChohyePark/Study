import java.util.ArrayList;
import java.util.Scanner;
//ArrayList������ �����ϰ� �����ϴ�.
//�׸��� ������ ����� �ø��Ƿ� ���������� ����
public class Exam_02 {//���� �迭
	public static void main(String[] args) {
		//generic���� String�� ���� �� �ֵ��� ����. ���̻� Object���� �ƴ�
		ArrayList<String> arr = new ArrayList<>();
		
		arr.add("Hello");
		arr.add("World");
		arr.add("Collection");
		System.out.println(arr.get(2).length());
		
		
//		System.out.println(arr.get(0));
//		System.out.println(arr.get(1));
//		System.out.println(arr.get(2));
		
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
		
		for(String str:arr){ //( for each�� )
		System.out.println(str);
		}
		
		System.out.println("==========");
		
		arr.remove(0);
		
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println("==========");
		
		arr.add(1,"Java");
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		System.out.println("==========");
		
		//����ִ� �������� �� ����
		System.out.println(arr.size());
		
		System.out.println("==========");
		//���� �������� ������ ��� ��üŸ���� �����Ѵ�.
		//������ ����. ArrayList�� ��� Ŭ���� Ÿ���� ����Ŭ������ Object Ÿ���̱� ������ ��� Ÿ���� ������ ���� �� �ִ�.
		ArrayList<String> arr2 = new ArrayList<>();
		arr2.add("Hi");
//		arr2.add(123);
//		arr2.add(3.14);
//		arr2.add(new Scanner(System.in));
//		System.out.println(arr2.get(2));
		
		//(Object Ÿ������ ��� Ÿ���� �Է¹��� �� ����)
		Object o = new Scanner(System.in);
		o = new ArrayList<>();
		o = 10; //Auto Boxing �ȴ�.
		o = "Hi";
		//��� Ŭ������ extends Object�� ����� ����. (�ٸ� Ŭ������ extends�ϴ� ���� Object�� ����� �� ����)
		//���������� .�� ������ ���� Object �޼��尡 �ߴ� ������ �ٷ� �̰�.
	}
}
