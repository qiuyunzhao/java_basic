package S����ģʽ;

/**
 * ������ӿ�   ���µĲ���ֻ��Ҫ��Ӿ���ʵ����Ϳ��ԣ���Ĳ��ö�
 */
public interface Strategy {
	
	public double getPrice(double standardPrice);
	
}

/**
 * ʵ�ֽӿڵ�ʵ���ࣺ�¹˿�С����
 */
class NewCustomerFewStrategy implements Strategy {
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("�����ۣ�ԭ��");
		return standardPrice;
	}
}

/**
 * ʵ�ֽӿڵ�ʵ���ࣺ�¹˿ʹ�����
 */
class NewCustomerManyStrategy implements Strategy {
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("�����");
		return standardPrice * 0.9;
	}
}

/**
 * ʵ�ֽӿڵ�ʵ���ࣺ�Ϲ˿�С����
 */
class OldCustomerFewStrategy implements Strategy {
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("�������");
		return standardPrice * 0.85;
	}
}

/**
 * ʵ�ֽӿڵ�ʵ���ࣺ�Ϲ˿ʹ�����
 */
class OldCustomerManyStrategy implements Strategy {
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("�����");
		return standardPrice * 0.8;
	}
}