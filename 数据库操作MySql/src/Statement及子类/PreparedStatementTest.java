package Statement及子类;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MySql工具类.MySqlUtils;

/**
 * PreparedStatement 常用数据库操作类  防止SQL注入
 *
 */

public class PreparedStatementTest {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1.加载驱动类
			Class.forName("com.mysql.jdbc.Driver");

			// 2.获取数据库连接对象（注意导包：import java.sql.DriverManager）
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaspeek300", "root","zhao17615110273");
			
			// 3.通过Connection对象获取PreparedStatement对象(传入带有占位符?的SQL语句)
			String sql1 = "insert into t_user(username,pwd,regTime) values (?,?,?)";
			pstmt = conn.prepareStatement(sql1);

			// 4.设置占位符
			pstmt.setString(1, "邱云钊");//索引从1开始
			pstmt.setString(2, "123");
			pstmt.setDate(3, new Date(System.currentTimeMillis()));;
			pstmt.executeUpdate();
			
			// 5.使用PreparedStatement对象执行SQL语句
			//  pstmt.execute();	//有结果集返回true
			//	pstmt.executeUpdate();	//执行insert,update,delete语句返回形象的记录数
			rs = pstmt.executeQuery("select *  from t_user");

			// 6.操作结果集
			while (rs.next()) {
				// System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3)+"-->"+rs.getDate(4));
				System.out.println(rs.getObject(2) + "-->" + rs.getObject(3) + "-->" + rs.getObject(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7.释放资源
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
