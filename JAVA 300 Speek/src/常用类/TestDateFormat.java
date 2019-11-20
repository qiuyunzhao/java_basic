package 常用类;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间对象和字符串的相互转换。
 * 
 * DateFormat是一个抽象类，一般使用它的的子类SimpleDateFormat类来实现。
 */
public class TestDateFormat {

	public static void main(String[] args) {

		// new出SimpleDateFormat对象
        DateFormat s1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat s2 = new SimpleDateFormat("yyyy年MM月dd日");
        
        // 将时间对象转换成字符串
        String daytime = s1.format(new Date());
        System.out.println(daytime);
        System.out.println(s2.format(new Date()));
        System.out.println(new SimpleDateFormat("hh:mm:ss").format(new Date()));
        
        // 将符合指定格式的字符串转成成时间对象.字符串格式需要和指定格式一致。
        Date date;
		try {
			String time = "2007年10月7日"; //要与s2格式一致 "yyyy年MM月dd日"
			date = s2.parse(time);
			System.out.println("date1: " + date);
			
	        time = "2007-10-7 20:15:30";
	        date = s1.parse(time);
	        System.out.println("date2: " + date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
		
		SimpleDateFormat s3 = new SimpleDateFormat("D");	//D表示一年中的天数
        String daytime1 = s3.format(new Date());
        System.out.println("今天是一年中的第" + daytime1 + "天");
	}

}
