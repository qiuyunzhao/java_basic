package Lװ��ģʽ;

/**
 * 2.�������(��װ�ζ���)
 */
public class Coffee implements Drink {

	private String name = "ԭζ����";

	@Override
	public double cost() {
		return 10;
	}

	@Override
	public String info() {
		return name;
	}

}