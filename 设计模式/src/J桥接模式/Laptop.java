package J桥接模式;

public class Laptop extends Computer {

	public Laptop(Brand b) {
		super(b);
	}

	@Override
	public void sale() {
		super.sale();
		System.out.println("销售笔记本");
	}

}