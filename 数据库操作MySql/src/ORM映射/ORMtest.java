package ORMӳ��;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import MySql������.MySqlUtils;

/**
 * ORM(Object Relationship Mapping)
 *
 * ��ṹ�����Ӧ�������ֶκ�������Զ�Ӧ�����м�¼�Ͷ����Ӧ
 * 
 * ��javabean�������������;��������ݿⱣ��һ��
 * 
 * һ����¼��Ӧһ�����󡣽���Щ��ѯ���Ķ���ŵ�������
 * 
 * 
 * ʹ��Javabean��������װһ����¼; ʹ��List<Javabean>�洢������¼
 */
public class ORMtest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		Emp emp = null;
		List<Emp> list = new ArrayList<>();
		
		try {
			conn = MySqlUtils.connectDatabase("MySql�����ļ�/mysql.ini");
			ps = conn.prepareStatement("select * from emp where id>?");
			ps.setString(1, "0");
			rs = ps.executeQuery();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String empname = rs.getString("empname");
				double salary = rs.getDouble("salary");
				Date birthday = rs.getDate("birthday");
				Integer age = rs.getInt("age");
				Integer deptId = rs.getInt("deptId");
				
				emp = new Emp(id, empname, salary, birthday, age, deptId);
				list.add(emp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySqlUtils.close(conn, ps, rs);
		}
		
		for(Emp e : list) {
			System.out.println(e.toString());
		}

	}

}
