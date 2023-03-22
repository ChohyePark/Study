
public class Quiz_00 {

	public static int minus (int num1 , int num2) {
		
	int result = num1 - num2;
	return result;
	}
	public static double divide(int num1 , int num2){
		double result = (double)num1 / num2;
		return result;
		
	}
	
	public static int bigger(int num1 , int num2){
		if(num1 >num2) {
			return num1;
			
		}else if (num1 < num2) {
			return num2;
		}else {
			return 0;
		}
	}
	
	public static String translate(String str1){
		if(str1=="»ç°ú"){
		 return "Apple";
		}else if(str1 =="µş±â") {
			return"strawberry";
		
		}else {
			return "none";
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println(minus(10,5));
		
		System.out.println(divide(17 ,3));
		
		System.out.println(bigger(3,4));
		
		System.out.println(translate("»ç°ú"));
		System.out.println(translate("µş±â"));
		System.out.println(translate("dd"));
		
		
	}
	
	

}
