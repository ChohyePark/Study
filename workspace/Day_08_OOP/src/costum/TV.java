package costum;
import javax.swing.JFrame;

// Ŭ������ �� ���� ����� ���
// �������� - ���������� [ public, protected, package, private ]

// �ܺο� ���� �� �ʿ䰡 ���� ������ private ��Ű�� �ܺο��� ��밡���� ������ �޼ҵ� ����� ����� public ����� 
//Ŭ���� �������� �ǵ���� �������� Ŭ���� ����� �����ϰ� ����¹��
//Ŭ���� �����ڿ��� �������� ������ �� ����.
//������� ���Ǽ����� ������ ��ħ



public class TV {       //���赵 ũ�� �������� ������� �����ڷ����̴� 
    private String brand;
	private int price;				// int ���� ���� heap�޸𸮿� ����
	private int channel;                  
	// ���赵���� �Ӽ��� �����ϴ� ���� - ������� (Member Field)  



	//set+�ʵ�� �������е� ������ ���������ϱ����� ��ɾ�
	//get+�ʵ�� ���ο��� ���� �ܺη� �����ϱ����� ��ɾ�


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
