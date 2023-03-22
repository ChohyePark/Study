
public class Quiz_01 {
	
	
	public static int myRand(int min , int max) {
		return (int)(Math.random()*(max - min + 1) + min);		
	}

	public static void main(String[] args) {
		
	
		
		for(int i =0 ; i<10; i++) {
			System.out.print(myRand(0,9) + " \t");
			System.out.print(myRand(1,10) + " \t");
			System.out.print(myRand(20,35) + "\t");
			System.out.print(myRand(0,1) + "\t");
		}	
	}

}
