package I��̬����ģʽ;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ����ӿڵ� ������
 */

public class StarHandler implements InvocationHandler {

	private Star realStar;

	public StarHandler(Star star) {
		this.realStar = star;
	}

	/**
	 * @param proxy
	 *            ������
	 * @param method
	 *            ���ڵ��õķ���
	 * @param args
	 *            ���ڵ��õķ����Ĳ���
	 * @return
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// ���̿����ڸ÷����ڲ�����
		System.out.println("************ StarHandler.invoke() **************");

		Object object = null;
		System.out.println("��������ݳ����׼������");
		
		if (method.getName().equals("sing")) {
			object = method.invoke(realStar, args);
		}

		System.out.println("��������ݳ���Ľ�������");
		return object;
	}

}
