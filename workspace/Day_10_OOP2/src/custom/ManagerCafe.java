package custom;

import java.util.ArrayList;

public class ManagerCafe {
	
	private ArrayList<CafeMenu> menus = new ArrayList<>();
	
	public ArrayList<CafeMenu> getMenus() {
		return menus;
	}

	public void addMenu(CafeMenu menu) {
		menus.add(menu);
	}
	
	
	

}
