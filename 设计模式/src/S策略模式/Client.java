package S����ģʽ;

public class Client {

	public static void main(String[] args) {

		double price = getPrice("�Ͽͻ�С����", 100);
		System.out.println("���ñ��ۣ�" + price);

		System.out.println("------------------------");

		Strategy s1 = new OldCustomerFewStrategy();
		Context ctx = new Context(s1);

		ctx.pringPrice(100);
	}

	/**
	 * �����ò���ģʽ��
	 * 
	 * ʵ�������Ƚ����ף�����һ�㿪����Ա��˼· ���磬�����ر�࣬�㷨�Ƚϸ���ʱ�������������Ĵ���ͱ�úܳ�������ά����
	 * ������������ͣ�����ҪƵ�����޸Ĵ˴��Ĵ��룡 �����Ͽ���ԭ��
	 */
	public static double getPrice(String type, double price) {
		if (type.equals("��ͨ�ͻ�С����")) {
			System.out.println("������,ԭ��");
			return price;
		} else if (type.equals("��ͨ�ͻ�������")) {
			System.out.println("�����");
			return price * 0.9;
		} else if (type.equals("�Ͽͻ�С����")) {
			System.out.println("�������");
			return price * 0.85;
		} else if (type.equals("�Ͽͻ�������")) {
			System.out.println("�����");
			return price * 0.8;
		}
		return price;
	}

}
