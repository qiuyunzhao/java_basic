package Fԭ��ģʽ;

public abstract class Shape implements Cloneable {		//ʵ��Cloneable

	protected String type;

	abstract void doSomething(); // �Զ��巽��

	public Shape(String type) {
		this.type = type;
	}

	public Shape() {
	}

	public String getType() {
		return type;
	}

	
	//��дobject��clone()����
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone(); // ֱ�ӵ���object�����clone()������
		return super.clone();
	}

}