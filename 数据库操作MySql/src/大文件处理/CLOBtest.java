package ���ļ�����;

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
 * CLOB(Charater Large Object) ���ڴ洢�������ı�����
 * 
 * ���ֶ��ı����ݵĲ������������ķ�ʽ������
 * 
 * Mysql������ࣺ
 * 
 * -- TINYTEXT ��󳤶� 255 �ַ� (2^8-1)
 * 
 * -- TEXT ��󳤶� 65,535 �ַ� (2^16-1)
 * 
 * -- MEDIUMTEXT ��󳤶� 16,777,215 �ַ� (2^24-1)
 * 
 * -- LONGTEXT ��󳤶� 4,294,967,295(4G) �ַ� (2^32-1)
 */
public class CLOBtest {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		BufferedReader bufferedReader = null;
		ResultSet rs = null;
		Reader r = null;
		try {
			// 1.����������
			Class.forName("com.mysql.jdbc.Driver");

			// 2.��ȡ���ݿ����Ӷ���ע�⵼����import java.sql.DriverManager��
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaspeek300", "root", "zhao17615110273");

			/**
			 * д��
			 */
//			// 3.ͨ��Connection�����ȡPreparedStatement����(�������ռλ��?��SQL���)
//			String sql1 = "insert into clobtest(username,info) values (?,?)";
//			pstmt = conn.prepareStatement(sql1);
//
//			// 4.����ռλ��
//			pstmt.setString(1, "������");
//			bufferedReader = new BufferedReader(new FileReader("D:/eclipse-workspace/File_IO/IO����Դ/IO_input.txt"));
//			pstmt.setClob(2, bufferedReader);
//
//			// �ַ�������ֱ��ʹ�ÿ����Ƚ��ַ�����װ����
//			String str = "��ã����Ǵ�������ѧ����ѧ����һ���о���";
//			pstmt.setClob(2, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str.getBytes()))));
//
//			// 5.ʹ��PreparedStatement����ִ��SQL���
//			pstmt.executeUpdate(); // ִ��insert,update,delete��䷵������ļ�¼��

			/**
			 * ��ȡ
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
			// 7.�ͷ���Դ
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
