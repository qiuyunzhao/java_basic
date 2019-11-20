package N享元模式;

/**
 * 享元接口
 */
public interface ChessFlyWeight {
	
	void setColor(String c);

	String getColor();

	void display(Coordinate c);
	
}

/**
 * 享元类 SharedConcreteFlyWeight (可共享部分，棋子颜色)
 */
class ConcreteChess implements ChessFlyWeight {

	private String color;

	public ConcreteChess(String color) {
		this.color = color;
	}

	@Override
	public void display(Coordinate coordinate) {
		System.out.println("棋子颜色：" + color);
		System.out.println("棋子位置：(" + coordinate.getX() + "," + coordinate.getY()+")");
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