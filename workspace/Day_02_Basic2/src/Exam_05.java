
public class Exam_05 {

	public static void main(String[] args) {
		
		int      a       =          10        ;
//	   (�ڷ���)  (����) (���Կ�����) (literal ��)
		
		// ���� ������ ��Ģ1. ������ �������� ���Եȴ�. (���ܾ���)
		// ���� ������ ��Ģ2. �׷��Ƿ� ������ �ݵ�� �����̾�߸� �Ѵ�. (����)
		
		// A+=B
		// int A = 10; int B = 20;
		// A = A + B; , A+=B; ������
		// A = 10 + 20;
		
		// A++; // ��ġ��
		// ++A; // ��ġ��
		
		int A = 10; int B = 20;
		System.out.println("A : " + ++A);
		System.out.println("B : " + B);
		
		System.out.println("========================================");
		
		// ���迬����
		// A == B : A ���� B ���� ����.
		// A != B : A ���� B ���� ���� �ʴ�.
		// A < B  : A ���� B ������ �۴�.
		// A > B  : A ���� B ������ ũ��.
		// A <= B : A ���� B ������ �۰ų� ����.
		// A >= B : A ���� B ������ ũ�ų� ����.
		System.out.println(A == B);
		System.out.println(A != B);
		System.out.println(A < B);
		System.out.println(A > B);
		System.out.println(A <= B);
		System.out.println(A >= B);
		
		System.out.println("========================================");
		
		// ��������
		// A && B : A �� B �Ѵ� true �϶��� true
	    //          �ϳ��� false �� false
		
		// A || B : A �� B ���� �ϳ��� true �̸� true
		//          �� �� false �� false
		
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(false && false);
		
		System.out.println("========================================");

		System.out.println(true || true);
		System.out.println(true || false);
		System.out.println(false || true);
		System.out.println(false || false);
		
		System.out.println("========================================");
		
		System.out.println(!(A == B));
	}

}
