package ʱ�����ʹ���;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * ���ࣺjava.util.Date
 * 
 * -���ࣺjava.sql.Date ��ʾ������
 * 
 * -���ࣺjava.sql.Time ��ʾʱ����
 * 
 * -���ࣺjava.sql.Timestamp ��ʾ������ʱ����
 */

public class PreparedStatementTest {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaspeek300", "root", "zhao17615110273");

//			String sql1 = "insert into t_user(username,pwd,regTime,data,time) values ('������',123,?,?,?)";
//			pstmt = conn.prepareStatement(sql1);
//			
//			// ���벻ͬ��ʽ������
//			pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
//			pstmt.setDate(2, new Date(System.currentTimeMillis()));
//			pstmt.setTime(3, new Time(System.currentTimeMillis()));
//			pstmt.executeUpdate();// ִ��insert,update,delete��䷵������ļ�¼��
			
			//ȡ��ָ��ʱ����ڵ�����
			String sql1 = "select * from t_user where regTime > ? and regTime < ?";
			pstmt = conn.prepareStatement(sql1);
			
			java.sql.Timestamp start = new java.sql.Timestamp(strToDate("2019-05-02 12:23:11"));
			java.sql.Timestamp end = new java.sql.Timestamp(strToDate("2019-05-10 14:47:59"));
			
			System.out.println(start + "---" +end);
			pstmt.setObject(1, start);
			pstmt.setObject(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getObject("username") + "-->" + rs.getObject("pwd") + "-->" + rs.getObject("regTime"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
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
	
	/**
	 * ���ܣ����ַ������������ת����long���͵�����
	 * @param dateSrt yyyy-MM-dd hh:mm:ss ��  yyyy-MM-dd��ʽ���ַ���ʱ��
	 * @return
	 */
	public static long strToDate(String dateSrt) {
		DateFormat format = null;
		if(dateSrt.length() == 19) {
			format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		}
		if(dateSrt.length() == 10) {
			format = new SimpleDateFormat("yyyy-MM-dd");
		}
		try {
			if(null != format) {
				return format.parse(dateSrt).getTime();
			}else {
				return 0;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
