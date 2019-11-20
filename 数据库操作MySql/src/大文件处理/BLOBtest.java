package ���ļ�����;

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
 * BLOB(Binary Large Object) ���ڴ洢�����Ķ���������
 * 
 * ���ֶζ��������ݵĲ������������ķ�ʽ������
 * 
 * Mysql������ࣺ
 * 
 * -- TINYBLOB ��󳤶� 255 �ַ� (2^8-1)
 * 
 * -- BLOB ��󳤶� 65,535 �ַ� (2^16-1)
 * 
 * -- MEDIUMBLOB ��󳤶� 16,777,215 �ַ� (2^24-1)
 * 
 * -- LONGBLOB ��󳤶� 4,294,967,295(4G) �ַ� (2^32-1)
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
			// 1.����������
			Class.forName("com.mysql.jdbc.Driver");

			// 2.��ȡ���ݿ����Ӷ���ע�⵼����import java.sql.DriverManager��
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaspeek300", "root", "zhao17615110273");

			/**
			 * д��
			 */
			// // 3.ͨ��Connection�����ȡPreparedStatement����(�������ռλ��?��SQL���)
			// pstmt = conn.prepareStatement("insert into clobtest(username,headImage) values (?,?)");
			//
			// // 4.����ռλ��
			// pstmt.setString(1, "������");
			// inputStream = new BufferedInputStream(new
			// FileInputStream("D:/eclipse-workspace/File_IO/IO����Դ/����.jpg"));
			// pstmt.setBlob(2, inputStream);
			//
			// // 5.ʹ��PreparedStatement����ִ��SQL���
			// pstmt.execute(); // ִ��insert,update,delete��䷵������ļ�¼��

			/**
			 * ��ȡ
			 */
			pstmt = conn.prepareStatement("select* from clobtest where id = 69");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Blob b = rs.getBlob("headImage");
				is = b.getBinaryStream();
				outputStream = new BufferedOutputStream(new FileOutputStream("����.jpg"));

				int temp = 0;
				while ((temp = is.read()) != -1) {
					outputStream.write(temp);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 7.�ͷ���Դ
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
