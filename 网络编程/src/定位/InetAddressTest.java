package ��λ;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress��
 * 
 * ���ã���װ�������IP��ַ��DNS(û�ж˿���Ϣ)�� ע��DNS�� Domain Name System������ϵͳ��
 * 
 * �ص㣺��û�й��췽��,ֻ��ͨ����̬�����õ�����getLocalHost(),getByName(), getAllByName(), getAddress(),getHostName()��
 */

public class InetAddressTest {
	
	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
        //����IP��ַ
        System.out.println(addr.getHostAddress()); 
        //����������
        System.out.println(addr.getHostName());
        System.out.println("------------------------");
        
        addr = InetAddress.getByName("www.baidu.com");
        // ����baidu��������IP
        System.out.println(addr.getHostAddress());
        // �������
        System.out.println(addr.getHostName());
        System.out.println("------------------------");
        
        addr = InetAddress.getByName("119.75.217.109");
        // ����baidu��������IP
        System.out.println(addr.getHostAddress());
        /* ���ip������������������IP��ַ�����ڻ�DNS���������������IP��ַ
         * ��������ӳ�䣬getHostName������ֱ�ӷ������IP��ַ��*/
        System.out.println(addr.getHostName());
	}

}
