package 数据库连接;

import java.sql.Connection;
import java.sql.DriverManager;

import MySql工具类.MySqlUtils;

public class MySqConnect {

	public static void main(String[] args) {

		Connection conn;
		long start;
		long end;
		try {
				
			// 1.加载驱动类
			Class.forName("com.mysql.jdbc.Driver");

			start = System.currentTimeMillis();

			// 2.获取数据库连接对象（注意导包：import java.sql.DriverManager）
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaspeek300", "root", "zhao17615110273");

			end = System.currentTimeMillis();
			System.out.println("建立连接耗时：" + (end - start));
			System.out.println(conn); // 查看建立连接的对象
			
			

			/**
			 * 自定义工具类实现数据库连接(并不能减少连接时间，只是把配置信息封装了)
			 */
			start = System.currentTimeMillis();
			conn = MySqlUtils.connectDatabase("MySql配置文件/mysql.ini"); // 自定义工具
			end = System.currentTimeMillis();
			System.out.println("建立连接耗时：" + (end - start));
			System.out.println(conn); // 查看建立连接的对象



		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
