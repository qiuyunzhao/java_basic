package ����;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ���񣺽��ಽ���ݿ��������߼�ִ�е�Ԫ��Ҫôȫ��ִ����ɣ�Ҫôȫ������ִ��
 * 
 * ע�� ��
 * 
 * 2.���ȹر��Զ��ύ��Ȼ���ֶ��ύ
 */
public class TransactionTest {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1.����������
			Class.forName("com.mysql.jdbc.Driver");

			// 2.��ȡ���ݿ����Ӷ���ע�⵼����import java.sql.DriverManager��
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaspeek300", "root", "zhao17615110273");

			// 3.�ر��Զ��ύ����������
			conn.setAutoCommit(false);

			// 4.ͨ��Connection�����ȡStatement����
			stmt = conn.createStatement();

			String sql1 = "";
			for (int i = 1; i <= 10; i++) {
				// 5.ʹ��Statement����ִ��SQL���
				if(i == 8) {
					sql1 = "insert into t_user(id,username,pwd,regTime) values ('��һ"+i+"',1111,now())";	//��������
				}else {
					sql1 = "insert into t_user(username,pwd,regTime) values ('��һ"+i+"',1111,now())";
				}
				stmt.execute(sql1);
			}
			
			// 6.�ύ����(ʧ���Զ��ع�)
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7.�ͷ���Դ
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
