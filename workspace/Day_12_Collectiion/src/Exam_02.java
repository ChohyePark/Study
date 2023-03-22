import java.util.ArrayList;
import java.util.Scanner;
//ArrayList에서는 간단하게 가능하다.
//그리고 스스로 사이즈를 늘리므로 공간걱정이 없다
public class Exam_02 {//동적 배열
	public static void main(String[] args) {
		//generic으로 String만 담을 수 있도록 변경. 더이상 Object형이 아님
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
		
		for(String str:arr){ //( for each문 )
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
		
		//들어있는 데이터의 총 개수
		System.out.println(arr.size());
		
		System.out.println("==========");
		//형을 지정하지 않으면 모든 객체타입을 저장한다.
		//다형성 때문. ArrayList가 모든 클래스 타입의 상위클래스인 Object 타입이기 때문에 모든 타입을 변수로 받을 수 있다.
		ArrayList<String> arr2 = new ArrayList<>();
		arr2.add("Hi");
//		arr2.add(123);
//		arr2.add(3.14);
//		arr2.add(new Scanner(System.in));
//		System.out.println(arr2.get(2));
		
		//(Object 타입으로 모든 타입을 입력받을 수 있음)
		Object o = new Scanner(System.in);
		o = new ArrayList<>();
		o = 10; //Auto Boxing 된다.
		o = "Hi";
		//모든 클래스는 extends Object를 숨기고 있음. (다른 클래스를 extends하는 순간 Object는 상속할 수 없음)
		//참조연산자 .를 찍으면 어디든 Object 메서드가 뜨는 이유가 바로 이것.
	}
}
