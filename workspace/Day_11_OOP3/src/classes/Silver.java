package classes;

public class Silver extends Member{ //한번에 하나만 상속받을 수 있다.(C는 여러개 가능), 여러번에 걸쳐 여러개는 가능(상위, 더 상위, 더더 상위 .. 가능)

	public Silver() {}
	public Silver(int id, String name, double point) {
		super(id, name, point); //Member클래스의 생성자를 호출. 이부분이 없어도 super();가 자동으로 실행됨
	}
	
	public double getBonus() {
		return this.getPoint()*0.02;
	}// 기존의 getBonus를 덮어씌우게 된다.
}
