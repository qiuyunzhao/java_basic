package 常用类;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar {
	/**
	 * Calendar 类是一个抽象类，为我们提供了关于日期计算的相关功能，比如：年、月、日、时、分、秒的展示和计算。
	 * 
	 * GregorianCalendar 是 Calendar 的一个具体子类，提供了世界上大多数国家/地区使用的标准日历系统。
	 */
	public static void main(String[] args) {
		
        Calendar calendar = new GregorianCalendar(2999, 10, 9, 22, 10, 50);
        printCalendar(calendar);
        
        setCalendar(calendar);
        printCalendar(calendar);
        
        // 日期计算
        calendar.add(Calendar.MONTH, -3); // 月份减3
        calendar.add(Calendar.DATE, 7); // 增加7天
        printCalendar(calendar);
        
     // 日历对象和时间对象转化
        Date date = calendar.getTime();
        System.out.println(date.toString());
        
        GregorianCalendar calendar1 = new GregorianCalendar();
        calendar1.setTime(new Date());
        printCalendar(calendar1);
        
        long g = System.currentTimeMillis();
        calendar1.setTimeInMillis(g);
        printCalendar(calendar1);
	}

	/**
	 * 设置
	 * @param calendar
	 */
	static void setCalendar(Calendar calendar) {	//引用类型传递
		// 设置关日期元素
		calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, Calendar.APRIL); // 月份数：0-11
        calendar.set(Calendar.DATE, 12);
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 5);
        calendar.set(Calendar.SECOND, 88);
	}
	
	
	/**
	 * 打印日期函数
	 * @param calendar
	 */
	static void printCalendar(Calendar calendar) {
		// 得到相关日期元素
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;	//0~11  --> 一月~十二月
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int date = calendar.get(Calendar.DAY_OF_WEEK) - 1; // 星期几     1~7 -->周日~周六
        String week = "" + ((date == 0) ? "日" : date);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        System.out.printf("%d-%d-%d, 星期%s, %d:%d:%d\n", year, month, day,  
                        week, hour, minute, second);
    }
}
