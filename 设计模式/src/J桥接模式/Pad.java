package J桥接模式;

public class Pad extends Computer {

	public Pad(Brand b) {
		super(b);
	}

	@Override
	public void sale() {
		super.sale();
		System.out.println("销售平板");
	}

}