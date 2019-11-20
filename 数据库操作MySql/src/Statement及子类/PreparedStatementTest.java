package Statement������;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MySql������.MySqlUtils;

/**
 * PreparedStatement �������ݿ������  ��ֹSQLע��
 *
 */

public class PreparedStatementTest {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1.����������
			Class.forName("com.mysql.jdbc.Driver");

			// 2.��ȡ���ݿ����Ӷ���ע�⵼����import java.sql.DriverManager��
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaspeek300", "root","zhao17615110273");
			
			// 3.ͨ��Connection�����ȡPreparedStatement����(�������ռλ��?��SQL���)
			String sql1 = "insert into t_user(username,pwd,regTime) values (?,?,?)";
			pstmt = conn.prepareStatement(sql1);

			// 4.����ռλ��
			pstmt.setString(1, "������");//������1��ʼ
			pstmt.setString(2, "123");
			pstmt.setDate(3, new Date(System.currentTimeMillis()));;
			pstmt.executeUpdate();
			
			// 5.ʹ��PreparedStatement����ִ��SQL���
			//  pstmt.execute();	//�н��������true
			//	pstmt.executeUpdate();	//ִ��insert,update,delete��䷵������ļ�¼��
			rs = pstmt.executeQuery("select *  from t_user");

			// 6.���������
			while (rs.next()) {
				// System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3)+"-->"+rs.getDate(4));
				System.out.println(rs.getObject(2) + "-->" + rs.getObject(3) + "-->" + rs.getObject(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7.�ͷ���Դ
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
