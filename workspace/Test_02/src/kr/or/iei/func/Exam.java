package kr.or.iei.func;
import java.util.ArrayList;


public class Exam {

	public void exam1() {
		ArrayList<User> userList = new ArrayList<User>(); //List가 아니라 ArrayList라고 써야지

		User user1 = new User("user01", "1234", "유저1", 23, "01022478875");
		User user2 = new User("user02", "1357", "유저2", 27, "01095887774");
		User user3 = new User("user03", "2468", "유저3", 34, "01036425456");

		userList.add(user1); //put이 아니라 add란다 잘못된 메서드명
		userList.add(user2);
		userList.add(user3);


		System.out.println("아이디\t비밀번호\t이름\t나이\t전화번호");

		for(int i=0;i<userList.size();i++) { //.length가 아니라 size 메서드를 써야 한단다

			User u = userList.get(i);
			System.out.println(u.getId()+"\t"+u.getPw()+"\t"+u.getName()+"\t"+u.getAge()+"\t"+u.getPhone());
			//setId가 아니라 getId를 해야 id값이 반환된단다
		}
	}
	
}