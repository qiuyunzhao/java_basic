package �÷����ȡע��_3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * ��ע��������ֳɵĿ�ܣ�
 * 
 * ʹ�÷����ȡע����Ϣ��ģ��ע�⴦������
 */

public class ReadAnnotation {

	public static void main(String[] args) {

		try {
			Class clazz = Class.forName("�÷����ȡע��.SxtStudent");

			// ��ȡ�������ע��
			Annotation[] annotations = clazz.getAnnotations();
			for (Annotation a : annotations) {
				System.out.println(a);
				SxtTable st = (SxtTable) a;
				System.out.println(st.value());
			}

			// ��ȡ��ָ��ע��
			SxtTable st = (SxtTable) clazz.getAnnotation(SxtTable.class);
			System.out.println(st.value());

			// ���������Ե�ע��
			Field f = clazz.getDeclaredField("name");
			SxtField sf = f.getAnnotation(SxtField.class);
			System.out.println(sf.columnName() + " -- " + sf.type() + " -- " + sf.length());

			//��ע��ƴ��SQL���
			String sql = "select * from " + st.value() + " where " + sf.columnName() + " = 'С��'";
			System.out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
