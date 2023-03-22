package refactoring;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Test {
	// 단방향 암호화 SHA 연습
	// 어떤 문자열을 넣어도 64개의 글자로 이뤄진 암호가 된다. 한 글자를 써도 백 글자를 써도.

	public static String getSHA256(String input){

		String toReturn = null;

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.reset();
			digest.update(input.getBytes("utf8"));
			// 숫자 부분이 글자 크기 설정임
			toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return toReturn;

	}

	public static String sha256(String msg) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256"); //불안하면 SHA-512 사용. (128글자 암호)
		md.update(msg.getBytes());
		StringBuilder builder = new StringBuilder();
		for (byte b: md.digest()) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}

	public static void main(String[] args) {

		try {
			System.out.println(getSHA256("Test"));
			System.out.println(sha256("Test"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
