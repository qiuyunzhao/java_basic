package 大文件处理;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * CLOB(Charater Large Object) 用于存储大量的文本数据
 * 
 * 大字段文本数据的操作常常以流的方式来处理
 * 
 * Mysql中相关类：
 * 
 * -- TINYTEXT 最大长度 255 字符 (2^8-1)
 * 
 * -- TEXT 最大长度 65,535 字符 (2^16-1)
 * 
 * -- MEDIUMTEXT 最大长度 16,777,215 字符 (2^24-1)
 * 
 * -- LONGTEXT 最大长度 4,294,967,295(4G) 字符 (2^32-1)
 */
public class CLOBtest {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		BufferedReader bufferedReader = null;
		ResultSet rs = null;
		Reader r = null;
		try {
			// 1.加载驱动类
			Class.forName("com.mysql.jdbc.Driver");

			// 2.获取数据库连接对象（注意导包：import java.sql.DriverManager）
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaspeek300", "root", "zhao17615110273");

			/**
			 * 写入
			 */
//			// 3.通过Connection对象获取PreparedStatement对象(传入带有占位符?的SQL语句)
//			String sql1 = "insert into clobtest(username,info) values (?,?)";
//			pstmt = conn.prepareStatement(sql1);
//
//			// 4.设置占位符
//			pstmt.setString(1, "邱云钊");
//			bufferedReader = new BufferedReader(new FileReader("D:/eclipse-workspace/File_IO/IO流资源/IO_input.txt"));
//			pstmt.setClob(2, bufferedReader);
//
//			// 字符串不能直接使用可以先将字符串封装成流
//			String str = "你好，我是大连理工大学电信学部的一名研究生";
//			pstmt.setClob(2, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str.getBytes()))));
//
//			// 5.使用PreparedStatement对象执行SQL语句
//			pstmt.executeUpdate(); // 执行insert,update,delete语句返回形象的记录数

			/**
			 * 读取
			 */
			pstmt = conn.prepareStatement("select* from clobtest where id = 62");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Clob cb = rs.getClob("info");
				r = cb.getCharacterStream();
				int temp = 0;
				while ((temp = r.read()) != -1) {
					System.out.print((char) temp);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7.释放资源
			if (r != null) {
				try {
					r.close();
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

			if (bufferedReader != null) {
				try {
					bufferedReader.close();
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
