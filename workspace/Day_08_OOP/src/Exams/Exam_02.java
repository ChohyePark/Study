package Exams;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JFrame;

import costum.Car;
import costum.TV;

public class Exam_02 {

	public static void main(String[] args) throws Exception {
		
		
		TV lg = new TV();
		lg.setChannel(10);
		lg.setBrand("LG");
		lg.setPrice(10000);
		
	

		System.out.println(lg.getChannel());
		System.out.println(lg.getBrand());
		System.out.println(lg.getPrice());
		
		
		Car ad = new Car("asdasd","green",100);
		System.out.println(ad.getColor());
		System.out.println(ad.getModel());
		System.out.println(ad.getPrice());
		
		ad.setColor("grean");
		ad.setModel("dddd");
		ad.setPrice(0);												//new 입력시 힙메모리에 car인스턴스가 생성 그 주소값을 ad 에저장
																	//ad. 을 하면 인스턴스에 접근 가능해서 기능 사용
		
		System.out.println(ad.getColor());
		System.out.println(ad.getModel());
		System.out.println(ad.getPrice());
		
		//ad.getThis().getThis().getThis()  //특정 기능 수행후 다시 자기주소값을 불러오는 기법 체이닝
		
		
//		JFrame frame = new JFrame();
//		frame.setVisible(true);
//
//		JButton button = new JButton("처음 만들어 보는 버튼") ;
//		frame.add(button);


		//		Robot r = new Robot();      //void = 리턴값 신경 쓸필요없다

		//		for(int i = 0; i<100; i ++) {
		//			int x = (int)(Math.random()*(500-200+1)+200);
		//			int y = (int)(Math.random()*(500-200+1)+200);
		//			r.mouseMove(x,y);
		//			r.delay(100);
		//			
		//		}
	}
}
