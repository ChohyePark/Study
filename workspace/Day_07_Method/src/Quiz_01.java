
public class Quiz_01 {


	public static int countchar(String str) {
		int count =0;

		for(int i =0; i<str.length() ; i ++) {
			if(str.charAt(i) == 'A') {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {

		String str = "asdsadadasdfsaAfnAkslajfhsjAkfAhsakljhsZXCDVASDAVFADCVADCscsacascsacavaaASDSVVDSVADAkjhasflkjhaasdasdwwwwiufawifluhdkjfaafjskfjasfklj";

		int count = countchar(str);
		System.out.println("¾ËÆÄºª AÀÇ °¹¼ö: " + count);





	}

}
