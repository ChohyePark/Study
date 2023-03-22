
public class Main {

	public static void main(String[] args)  {
	
		
		try {
		shopmember_dao dao = new shopmember_dao();
		
		String id = "chohye";
		ShopMember sm = dao.searchUser(id);	
		System.out.println(sm.getMemberId());
		System.out.println(sm.getAddr());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
