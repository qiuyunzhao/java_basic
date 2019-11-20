package 时间类型处理;

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
 * 父类：java.util.Date
 * 
 * -子类：java.sql.Date 表示年月日
 * 
 * -子类：java.sql.Time 表示时分秒
 * 
 * -子类：java.sql.Timestamp 表示年月日时分秒
 */

public class PreparedStatementTest {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaspeek300", "root", "zhao17615110273");

//			String sql1 = "insert into t_user(username,pwd,regTime,data,time) values ('邱云钊',123,?,?,?)";
//			pstmt = conn.prepareStatement(sql1);
//			
//			// 插入不同格式的日期
//			pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
//			pstmt.setDate(2, new Date(System.currentTimeMillis()));
//			pstmt.setTime(3, new Time(System.currentTimeMillis()));
//			pstmt.executeUpdate();// 执行insert,update,delete语句返回形象的记录数
			
			//取出指定时间段内的数据
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
	 * 功能：将字符串代表的日期转换成long类型的数字
	 * @param dateSrt yyyy-MM-dd hh:mm:ss 或  yyyy-MM-dd格式的字符串时间
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
