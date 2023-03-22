package costum;
import javax.swing.JFrame;

// 클래스를 더 좋게 만드는 방법
// 정보은닉 - 접근제한자 [ public, protected, package, private ]

// 외부에 노출 할 필요가 없는 정보를 private 시키고 외부에서 사용가능한 범위의 메소드 기능을 만들고 public 해줘라 
//클래스 설계자의 의도대로 안정적인 클래스 운용이 가능하게 만드는방식
//클래스 설계자에게 안정성을 제공할 수 있음.
//사용자의 편의성에도 영향을 미침



public class TV {       //설계도 크고 가변적인 사이즈라 참조자료형이다 
    private String brand;
	private int price;				// int 형임 에도 heap메모리에 저장
	private int channel;                  
	// 설계도에서 속성을 저장하는 변수 - 멤버변수 (Member Field)  



	//set+필드명 정보은닉된 변수에 값을대입하기위한 명령어
	//get+필드명 내부에서 값을 외부로 추출하기위한 명령어


	public void setChannel(int cha) {
		if(cha>0) {
			channel = cha;
		}
	}	

	public int getChannel() {return channel;}


	public void setBrand(String str) {brand = str;}
	
	public String getBrand() {return brand;}
	

	public void setPrice(int a) {price=a;}
	
	public int getPrice() {	return price;}
	

	

	void powerON() {}
	void powerOFF() {}
	//Member Method




	//**Constructor**

	//Nested Class
}
