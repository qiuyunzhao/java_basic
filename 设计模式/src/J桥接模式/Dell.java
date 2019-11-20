package J桥接模式;

public class Dell implements Brand {

	@Override
	public void sale() {
		System.out.println("销售Dell电脑");
	}

}