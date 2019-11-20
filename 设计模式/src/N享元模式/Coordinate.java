package N享元模式;

/**
 * 外部状态UnSharedConcreteFlyWeight(不可共享部分，棋子坐标)
 */
public class Coordinate {
	private int x, y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}