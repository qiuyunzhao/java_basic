package E������ģʽ;

/**
 * ��ѧ��������
 * 
 * @author ��ѧ�ø�� www.sxt.cn
 *
 */
public class Car {

	private Engine engine; // ������
	private Seat seat; // ����
	private Tyre tyre; // ��̥

	public void getComponent() {
		System.out.println("��������" + engine.getName() + "---" + "���Σ�" + seat.getName() + "--" + "��̥��" + tyre.getName());
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