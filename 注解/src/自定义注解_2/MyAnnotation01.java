package �Զ���ע��_2;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.MODULE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Ԫע�⣬�������Զ���ע��������
@Target({ TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE }) // ����ʹ�õķ�Χ
@Retention(RetentionPolicy.RUNTIME) // ����ע�����������

public @interface MyAnnotation01 {
	String name() default "";	//������Ϣ   ��������name  �������ͣ�String
	int id() default -1;	//�����ø�����ʾ������
	String[] hobby() default {"����","����"};
}
