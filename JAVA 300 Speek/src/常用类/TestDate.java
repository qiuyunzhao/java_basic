package ������;

import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		//ʱ���׼��1970��1��1��00:00:00
		long now = System.currentTimeMillis();	//��ǰʱ��-ʱ���׼ �����룩
		System.out.println(now);
		
		Date date1 = new Date();
        System.out.println(date1.toString());	//ת��Ϊ�ַ�������ʽ��dow mon dd hh:mm:ss zzz yyyy
        
        long i = date1.getTime();	//��ȡ������
        
        /**
         * ��ߵļ�������
         */
        Date date2 = new Date(i - 1000);
        Date date3 = new Date(i + 1000);
        
        System.out.println(date1.after(date2));//�Ƚ�����ʱ���Ⱥ�
        System.out.println(date1.before(date2));
        System.out.println(date1.after(date3));
        System.out.println(date1.before(date3));
        
        System.out.println(date1.equals(date2));
        System.out.println(date1.equals(date3));
        
        System.out.println(new Date(1000L * 60 * 60 * 24 * 365 * 39L).toString());
	}

}
