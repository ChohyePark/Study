
public class Exam_01 {

	public static void main(String[] args) {

		//try - catch : ���� ó�� ����  ���ܹ߻��� main ������ Ƣ����°� catch�� ���� ���ܹ߻� ������ �ǳʶ�
		
		try {
			int num = Integer.parseInt("123");         // parseInt ���� ������ ���� , ���ڸ� ���԰���
			System.out.println("�м��� ���ڴ� : " + num); 
		}catch(Exception e) {
			//���ܰ� �߻��� �����ڰ� �����ְ��� �ϴ� �ൿ , ���ܹ߻������� catch���̴� ���� x 9 -> 13
			System.out.println("�м��ϴ� �����Ͱ� ���� ������ �ƴմϴ�.");
		}
		
		System.out.println("���α׷� ���� ����");

	}
}
