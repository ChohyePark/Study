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
		ad.setPrice(0);												//new �Է½� ���޸𸮿� car�ν��Ͻ��� ���� �� �ּҰ��� ad ������
																	//ad. �� �ϸ� �ν��Ͻ��� ���� �����ؼ� ��� ���
		
		System.out.println(ad.getColor());
		System.out.println(ad.getModel());
		System.out.println(ad.getPrice());
		
		//ad.getThis().getThis().getThis()  //Ư�� ��� ������ �ٽ� �ڱ��ּҰ��� �ҷ����� ��� ü�̴�
		
		
//		JFrame frame = new JFrame();
//		frame.setVisible(true);
//
//		JButton button = new JButton("ó�� ����� ���� ��ư") ;
//		frame.add(button);


		//		Robot r = new Robot();      //void = ���ϰ� �Ű� ���ʿ����

		//		for(int i = 0; i<100; i ++) {
		//			int x = (int)(Math.random()*(500-200+1)+200);
		//			int y = (int)(Math.random()*(500-200+1)+200);
		//			r.mouseMove(x,y);
		//			r.delay(100);
		//			
		//		}
	}
}
