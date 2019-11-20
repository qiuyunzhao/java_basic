package 自定义注解_2;

@MyAnnotation01(name = "小明", id = 101, hobby = { "篮球", "足球", "乒乓球" })
@MyAnnotation02({ "篮球", "足球", "乒乓球" })	//	一个参数赋值时，参数名可以省略
public class Test01 {

	public static void main(String[] args) {

	}

}
