package 常用类;

public class TestMath {

	public static void main(String[] args) {

		//取整相关操作
        System.out.println(Math.ceil(3.2));	//大于3.2的整数
        System.out.println(Math.floor(3.2));	//小于3.2的整数
        System.out.println(Math.round(3.2));	//四舍五入

        //绝对值、开方、a的b次幂等操作
        System.out.println(Math.abs(-45));
        System.out.println(Math.sqrt(64));
        System.out.println(Math.pow(5, 2));
        System.out.println(Math.pow(2, 5));
        
        //Math类中常用的常量
        System.out.println(Math.PI);
        System.out.println(Math.E);
        
        //随机数
        System.out.println(Math.random());// [0,1)
        
        //角度和弧度
        System.out.println(Math.toDegrees(Math.PI));	//弧度->角度
        System.out.println(Math.toRadians(180));	//角度->弧度
        
        //三角函数
        System.out.println(Math.sin(Math.PI/2));
        System.out.println(Math.cos(Math.PI));

	}

}
