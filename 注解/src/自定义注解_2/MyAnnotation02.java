package �Զ���ע��_2;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Ԫע�⣬�������Զ���ע��������
@Target({ TYPE, FIELD, METHOD}) // ����ʹ�õķ�Χ
@Retention(RetentionPolicy.RUNTIME) // ����ע�����������

public @interface MyAnnotation02 {
	String[] value();	//һ������һ��ȡ��Ϊvalue
}
