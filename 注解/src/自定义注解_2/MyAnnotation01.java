package 自定义注解_2;

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

//元注解，用来对自定义注解做解释
@Target({ TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE }) // 修饰使用的范围
@Retention(RetentionPolicy.RUNTIME) // 描述注解的生命周期

public @interface MyAnnotation01 {
	String name() default "";	//参数信息   参数名：name  参数类型：String
	int id() default -1;	//可以用负数表示不存在
	String[] hobby() default {"唱歌","跳舞"};
}
