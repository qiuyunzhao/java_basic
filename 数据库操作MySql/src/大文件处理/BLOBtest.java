package 大文件处理;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * BLOB(Binary Large Object) 用于存储大量的二进制数据
 * 
 * 大字段二进制数据的操作常常以流的方式来处理
 * 
 * Mysql中相关类：
 * 
 * -- TINYBLOB 最大长度 255 字符 (2^8-1)
 * 
 * -- BLOB 最大长度 65,535 字符 (2^16-1)
 * 
 * -- MEDIUMBLOB 最大长度 16,777,215 字符 (2^24-1)
 * 
 * -- LONGBLOB 最大长度 4,294,967,295(4G) 字符 (2^32-1)
 */
public class BLOBtest {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		BufferedInputStream inputStream = null;
		ResultSet rs = null;
		InputStream is = null;
		BufferedOutputStream outputStream = null;
		try {
			// 1.加载驱动类
			Class.forName("com.mysql.jdbc.Driver");

			// 2.获取数据库连接对象（注意导包：import java.sql.DriverManager）
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaspeek300", "root", "zhao17615110273");

			/**
			 * 写入
			 */
			// // 3.通过Connection对象获取PreparedStatement对象(传入带有占位符?的SQL语句)
			// pstmt = conn.prepareStatement("insert into clobtest(username,headImage) values (?,?)");
			//
			// // 4.设置占位符
			// pstmt.setString(1, "邱云钊");
			// inputStream = new BufferedInputStream(new
			// FileInputStream("D:/eclipse-workspace/File_IO/IO流资源/赵敏.jpg"));
			// pstmt.setBlob(2, inputStream);
			//
			// // 5.使用PreparedStatement对象执行SQL语句
			// pstmt.execute(); // 执行insert,update,delete语句返回形象的记录数

			/**
			 * 读取
			 */
			pstmt = conn.prepareStatement("select* from clobtest where id = 69");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Blob b = rs.getBlob("headImage");
				is = b.getBinaryStream();
				outputStream = new BufferedOutputStream(new FileOutputStream("赵敏.jpg"));

				int temp = 0;
				while ((temp = is.read()) != -1) {
					outputStream.write(temp);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 7.释放资源
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
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
}
