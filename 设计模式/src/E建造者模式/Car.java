package E建造者模式;

/**
 * 尚学堂牌汽车
 * 
 * @author 尚学堂高淇 www.sxt.cn
 *
 */
public class Car {

	private Engine engine; // 发动机
	private Seat seat; // 座椅
	private Tyre tyre; // 轮胎

	public void getComponent() {
		System.out.println("发动机：" + engine.getName() + "---" + "座椅：" + seat.getName() + "--" + "轮胎：" + tyre.getName());
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Tyre getTyre() {
		return tyre;
	}

	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}

}