package refactoring;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Test {
	// �ܹ��� ��ȣȭ SHA ����
	// � ���ڿ��� �־ 64���� ���ڷ� �̷��� ��ȣ�� �ȴ�. �� ���ڸ� �ᵵ �� ���ڸ� �ᵵ.

	public static String getSHA256(String input){

		String toReturn = null;

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.reset();
			digest.update(input.getBytes("utf8"));
			// ���� �κ��� ���� ũ�� ������
			toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return toReturn;

	}

	public static String sha256(String msg) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256"); //�Ҿ��ϸ� SHA-512 ���. (128���� ��ȣ)
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
