package 事务;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 事务：将多步数据库操作组成逻辑执行单元，要么全部执行完成，要么全部放弃执行
 * 
 * 注意 ：
 * 
 * 2.首先关闭自动提交，然后手动提交
 */
public class TransactionTest {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1.加载驱动类
			Class.forName("com.mysql.jdbc.Driver");

			// 2.获取数据库连接对象（注意导包：import java.sql.DriverManager）
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaspeek300", "root", "zhao17615110273");

			// 3.关闭自动提交，开启事务
			conn.setAutoCommit(false);

			// 4.通过Connection对象获取Statement对象
			stmt = conn.createStatement();

			String sql1 = "";
			for (int i = 1; i <= 10; i++) {
				// 5.使用Statement对象执行SQL语句
				if(i == 8) {
					sql1 = "insert into t_user(id,username,pwd,regTime) values ('李一"+i+"',1111,now())";	//错误的语句
				}else {
					sql1 = "insert into t_user(username,pwd,regTime) values ('李一"+i+"',1111,now())";
				}
				stmt.execute(sql1);
			}
			
			// 6.提交事务(失败自动回滚)
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7.释放资源
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
