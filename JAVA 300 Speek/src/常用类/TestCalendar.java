package ������;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar {
	/**
	 * Calendar ����һ�������࣬Ϊ�����ṩ�˹������ڼ������ع��ܣ����磺�ꡢ�¡��ա�ʱ���֡����չʾ�ͼ��㡣
	 * 
	 * GregorianCalendar �� Calendar ��һ���������࣬�ṩ�������ϴ��������/����ʹ�õı�׼����ϵͳ��
	 */
	public static void main(String[] args) {
		
        Calendar calendar = new GregorianCalendar(2999, 10, 9, 22, 10, 50);
        printCalendar(calendar);
        
        setCalendar(calendar);
        printCalendar(calendar);
        
        // ���ڼ���
        calendar.add(Calendar.MONTH, -3); // �·ݼ�3
        calendar.add(Calendar.DATE, 7); // ����7��
        printCalendar(calendar);
        
     // ���������ʱ�����ת��
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
	 * ����
	 * @param calendar
	 */
	static void setCalendar(Calendar calendar) {	//�������ʹ���
		// ���ù�����Ԫ��
		calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, Calendar.APRIL); // �·�����0-11
        calendar.set(Calendar.DATE, 12);
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 5);
        calendar.set(Calendar.SECOND, 88);
	}
	
	
	/**
	 * ��ӡ���ں���
	 * @param calendar
	 */
	static void printCalendar(Calendar calendar) {
		// �õ��������Ԫ��
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;	//0~11  --> һ��~ʮ����
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int date = calendar.get(Calendar.DAY_OF_WEEK) - 1; // ���ڼ�     1~7 -->����~����
        String week = "" + ((date == 0) ? "��" : date);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        System.out.printf("%d-%d-%d, ����%s, %d:%d:%d\n", year, month, day,  
                        week, hour, minute, second);
    }
}
