package exams;

import custom.Movie;

//Movie 클래스 설계
//영화 제목, 장르, 평점(double)
//정보은닉 적용, getter/setter/constructor 모두 작성
//custom 패키지에 작성
public class Exam_01 {
	public static void main(String[] args) {
		
//		Movie movie1 = new Movie("아바타2","SF/액션",8.82);
//		Movie movie2 = new Movie("영웅","드라마",8.42);
		
//		movie1.showInfo();
//		movie2.showInfo();
//		
//		movie1.setTitle("아바타: 물의 길");
//		movie1.showInfo();
		
		//위 내용을 아래와 같이 바꿀 수도 있다.
		Movie[] movies = new Movie[2];
		movies[0] = new Movie("아바타:물의 길","SF/액션",8.82);
		movies[1] = new Movie("영웅","드라마",8.42);
		
		//아래의 방법도 물론 가능하다.
		Movie[] movie = new Movie[] {
				new Movie("아바타:물의 길","SF/액션",8.82),
				new Movie("영웅","드라마",8.42)
		};
		
		System.out.println(movies[0]);//주소 출력
		System.out.println(movies[0].getTitle());
		
		movies[1].setGrade(10);
		
		for(int i=0;i<movies.length;i++) {
			System.out.println("<movie"+(i+1)+" 정보>");
			System.out.println("제목: "+movies[i].getTitle());
			System.out.println("장르: "+movies[i].getGenre());
			System.out.println("평점: "+movies[i].getGrade());		
		}
		
		
	} 

}
