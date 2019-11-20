package 用反射读取注解_3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * （注解解析有现成的框架）
 * 
 * 使用反射读取注解信息，模拟注解处理流程
 */

public class ReadAnnotation {

	public static void main(String[] args) {

		try {
			Class clazz = Class.forName("用反射读取注解.SxtStudent");

			// 获取类的所有注解
			Annotation[] annotations = clazz.getAnnotations();
			for (Annotation a : annotations) {
				System.out.println(a);
				SxtTable st = (SxtTable) a;
				System.out.println(st.value());
			}

			// 获取类指定注解
			SxtTable st = (SxtTable) clazz.getAnnotation(SxtTable.class);
			System.out.println(st.value());

			// 获得类的属性的注解
			Field f = clazz.getDeclaredField("name");
			SxtField sf = f.getAnnotation(SxtField.class);
			System.out.println(sf.columnName() + " -- " + sf.type() + " -- " + sf.length());

			//用注释拼接SQL语句
			String sql = "select * from " + st.value() + " where " + sf.columnName() + " = '小明'";
			System.out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
