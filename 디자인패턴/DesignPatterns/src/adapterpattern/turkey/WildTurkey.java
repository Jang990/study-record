package adapterpattern.turkey;

public class WildTurkey implements Turkey {
	@Override
	public void gobble() {
		System.out.println("���");
	}
	
	@Override
	public void fly() {
		System.out.println("���� ��� �� �� �־��");
	}
}
