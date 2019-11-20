package N��Ԫģʽ;

/**
 * ��Ԫ�ӿ�
 */
public interface ChessFlyWeight {
	
	void setColor(String c);

	String getColor();

	void display(Coordinate c);
	
}

/**
 * ��Ԫ�� SharedConcreteFlyWeight (�ɹ����֣�������ɫ)
 */
class ConcreteChess implements ChessFlyWeight {

	private String color;

	public ConcreteChess(String color) {
		this.color = color;
	}

	@Override
	public void display(Coordinate coordinate) {
		System.out.println("������ɫ��" + color);
		System.out.println("����λ�ã�(" + coordinate.getX() + "," + coordinate.getY()+")");
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void setColor(String color) {
		this.color = color;
	}
}