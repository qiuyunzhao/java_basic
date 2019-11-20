package Statement及子类;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1.加载驱动类
			Class.forName("com.mysql.jdbc.Driver");

			// 2.获取数据库连接对象（注意导包：import java.sql.DriverManager）
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaspeek300", "root", "zhao17615110273");

			// 3.通过Connection对象获取Statement对象
			stmt = conn.createStatement();

			// 4.使用Statement对象执行SQL语句(存在sql注入风险)
			String sql1 = "insert into t_user(username,pwd,regTime) values ('李一',1111,now())";
			stmt.execute(sql1);

			String sql2 = "select * from t_user";
			rs = stmt.executeQuery(sql2);

			// 5.操作结果集
			while (rs.next()) {
				// System.out.println(rs.getInt(1)+"-->"+rs.getString(2)+"-->"+rs.getString(3)+"-->"+rs.getDate(4));
				System.out.println(
						rs.getObject(1) + "-->" + rs.getObject(2) + "-->" + rs.getObject(3) + "-->" + rs.getObject(4));
			}

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
