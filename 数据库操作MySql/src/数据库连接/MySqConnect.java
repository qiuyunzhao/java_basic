package ���ݿ�����;

import java.sql.Connection;
import java.sql.DriverManager;

import MySql������.MySqlUtils;

public class MySqConnect {

	public static void main(String[] args) {

		Connection conn;
		long start;
		long end;
		try {
				
			// 1.����������
			Class.forName("com.mysql.jdbc.Driver");

			start = System.currentTimeMillis();

			// 2.��ȡ���ݿ����Ӷ���ע�⵼����import java.sql.DriverManager��
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaspeek300", "root", "zhao17615110273");

			end = System.currentTimeMillis();
			System.out.println("�������Ӻ�ʱ��" + (end - start));
			System.out.println(conn); // �鿴�������ӵĶ���
			
			

			/**
			 * �Զ��幤����ʵ�����ݿ�����(�����ܼ�������ʱ�䣬ֻ�ǰ�������Ϣ��װ��)
			 */
			start = System.currentTimeMillis();
			conn = MySqlUtils.connectDatabase("MySql�����ļ�/mysql.ini"); // �Զ��幤��
			end = System.currentTimeMillis();
			System.out.println("�������Ӻ�ʱ��" + (end - start));
			System.out.println(conn); // �鿴�������ӵĶ���



		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
