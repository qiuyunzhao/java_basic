package J�Ž�ģʽ;

/**
 * �������͵�������Ϊһ��ά��
 */
public abstract class Computer {

	protected Brand brand;  //�Ž�ģʽ�ĺ��ľ��������ά�Ƚ��ͣ�Ȼ���������ά�ȵ�ʵ��

	public Computer(Brand b) {
		this.brand = b;
	}

	public void sale() {
		brand.sale();
	}
	
}




