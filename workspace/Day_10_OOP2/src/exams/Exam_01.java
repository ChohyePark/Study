package exams;

import custom.Movie;

//Movie Ŭ���� ����
//��ȭ ����, �帣, ����(double)
//�������� ����, getter/setter/constructor ��� �ۼ�
//custom ��Ű���� �ۼ�
public class Exam_01 {
	public static void main(String[] args) {
		
//		Movie movie1 = new Movie("�ƹ�Ÿ2","SF/�׼�",8.82);
//		Movie movie2 = new Movie("����","���",8.42);
		
//		movie1.showInfo();
//		movie2.showInfo();
//		
//		movie1.setTitle("�ƹ�Ÿ: ���� ��");
//		movie1.showInfo();
		
		//�� ������ �Ʒ��� ���� �ٲ� ���� �ִ�.
		Movie[] movies = new Movie[2];
		movies[0] = new Movie("�ƹ�Ÿ:���� ��","SF/�׼�",8.82);
		movies[1] = new Movie("����","���",8.42);
		
		//�Ʒ��� ����� ���� �����ϴ�.
		Movie[] movie = new Movie[] {
				new Movie("�ƹ�Ÿ:���� ��","SF/�׼�",8.82),
				new Movie("����","���",8.42)
		};
		
		System.out.println(movies[0]);//�ּ� ���
		System.out.println(movies[0].getTitle());
		
		movies[1].setGrade(10);
		
		for(int i=0;i<movies.length;i++) {
			System.out.println("<movie"+(i+1)+" ����>");
			System.out.println("����: "+movies[i].getTitle());
			System.out.println("�帣: "+movies[i].getGenre());
			System.out.println("����: "+movies[i].getGrade());		
		}
		
		
	} 

}
