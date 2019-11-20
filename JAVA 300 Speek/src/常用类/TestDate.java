package 常用类;

import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		//时间基准是1970年1月1日00:00:00
		long now = System.currentTimeMillis();	//当前时间-时间基准 （毫秒）
		System.out.println(now);
		
		Date date1 = new Date();
        System.out.println(date1.toString());	//转换为字符串，格式：dow mon dd hh:mm:ss zzz yyyy
        
        long i = date1.getTime();	//获取毫秒数
        
        /**
         * 后边的几乎不用
         */
        Date date2 = new Date(i - 1000);
        Date date3 = new Date(i + 1000);
        
        System.out.println(date1.after(date2));//比较两个时间先后
        System.out.println(date1.before(date2));
        System.out.println(date1.after(date3));
        System.out.println(date1.before(date3));
        
        System.out.println(date1.equals(date2));
        System.out.println(date1.equals(date3));
        
        System.out.println(new Date(1000L * 60 * 60 * 24 * 365 * 39L).toString());
	}

}
