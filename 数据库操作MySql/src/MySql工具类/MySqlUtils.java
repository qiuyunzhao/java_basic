package MySql������;

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
	 * ���ܣ��������ݿ⣬�������ݿ�����
	 * 
	 * @param paramFile
	 *            ���ݿ������ļ�
	 * 
	 * @return ���ݿ�����ʵ��
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Connection connectDatabase(String paramFile)
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		initParam(paramFile); // �������ݿ��������Ϣ
		Class.forName(driver); // �������ݿ�������
		Connection conn = DriverManager.getConnection(url, user, password); // �������ݿ�����
		return conn;
	}

	/**
	 * ���ܣ��������ݿ��������Ϣ(����д�ɾ�̬�����)
	 * 
	 * @param paramFile
	 *            Ҫ���ص������ļ�
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void initParam(String paramFile) throws FileNotFoundException, IOException {
		Properties props = new Properties(); // �����������������ļ�
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		password = props.getProperty("password");
	}

	/**
	 * ���ܣ��ͷ���Դ
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
	 * ���ܣ��ͷ���Դ
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
