package J桥接模式;

/**
 * 电脑类型单独划分为一个维度
 */
public abstract class Computer {

	protected Brand brand;  //桥接模式的核心就是这里，将维度降低，然后持有其他维度的实例

	public Computer(Brand b) {
		this.brand = b;
	}

	public void sale() {
		brand.sale();
	}
	
}




