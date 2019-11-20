package F原型模式;

public abstract class Shape implements Cloneable {		//实现Cloneable

	protected String type;

	abstract void doSomething(); // 自定义方法

	public Shape(String type) {
		this.type = type;
	}

	public Shape() {
	}

	public String getType() {
		return type;
	}

	
	//重写object的clone()方法
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone(); // 直接调用object对象的clone()方法！
		return super.clone();
	}

}