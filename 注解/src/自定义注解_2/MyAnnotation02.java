package 自定义注解_2;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//元注解，用来对自定义注解做解释
@Target({ TYPE, FIELD, METHOD}) // 修饰使用的范围
@Retention(RetentionPolicy.RUNTIME) // 描述注解的生命周期

public @interface MyAnnotation02 {
	String[] value();	//一个参数一般取名为value
}
