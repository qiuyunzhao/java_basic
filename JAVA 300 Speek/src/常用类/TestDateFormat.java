package ������;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ʱ�������ַ������໥ת����
 * 
 * DateFormat��һ�������࣬һ��ʹ�����ĵ�����SimpleDateFormat����ʵ�֡�
 */
public class TestDateFormat {

	public static void main(String[] args) {

		// new��SimpleDateFormat����
        DateFormat s1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat s2 = new SimpleDateFormat("yyyy��MM��dd��");
        
        // ��ʱ�����ת�����ַ���
        String daytime = s1.format(new Date());
        System.out.println(daytime);
        System.out.println(s2.format(new Date()));
        System.out.println(new SimpleDateFormat("hh:mm:ss").format(new Date()));
        
        // ������ָ����ʽ���ַ���ת�ɳ�ʱ�����.�ַ�����ʽ��Ҫ��ָ����ʽһ�¡�
        Date date;
		try {
			String time = "2007��10��7��"; //Ҫ��s2��ʽһ�� "yyyy��MM��dd��"
			date = s2.parse(time);
			System.out.println("date1: " + date);
			
	        time = "2007-10-7 20:15:30";
	        date = s1.parse(time);
	        System.out.println("date2: " + date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
		
		SimpleDateFormat s3 = new SimpleDateFormat("D");	//D��ʾһ���е�����
        String daytime1 = s3.format(new Date());
        System.out.println("������һ���еĵ�" + daytime1 + "��");
	}

}
