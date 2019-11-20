package MySql工具类;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlUtils {

	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	/**
	 * 功能：连接数据库，返回数据库连接
	 * 
	 * @param paramFile
	 *            数据库配置文件
	 * 
	 * @return 数据库连接实例
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Connection connectDatabase(String paramFile)
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		initParam(paramFile); // 加载数据库的配置信息
		Class.forName(driver); // 加载数据库驱动类
		Connection conn = DriverManager.getConnection(url, user, password); // 建立数据库连接
		return conn;
	}

	/**
	 * 功能：加载数据库的配置信息(可以写成静态代码块)
	 * 
	 * @param paramFile
	 *            要加载的配置文件
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void initParam(String paramFile) throws FileNotFoundException, IOException {
		Properties props = new Properties(); // 该类用来加载属性文件
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		password = props.getProperty("password");
	}

	/**
	 * 功能：释放资源
	 * 
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
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

	/**
	 * 功能：释放资源
	 * 
	 * @param conn
	 * @param pstmt
	 */
	public static void close(Connection conn, PreparedStatement pstmt) {
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
