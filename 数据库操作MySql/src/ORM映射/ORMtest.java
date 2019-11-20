package ORM映射;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import MySql工具类.MySqlUtils;

/**
 * ORM(Object Relationship Mapping)
 *
 * 表结构与类对应；表中字段和类的属性对应；表中记录和对象对应
 * 
 * 让javabean的属性名和类型尽量与数据库保持一致
 * 
 * 一条记录对应一个对象。将这些查询到的对象放到容器中
 * 
 * 
 * 使用Javabean对象来封装一条记录; 使用List<Javabean>存储多条记录
 */
public class ORMtest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		Emp emp = null;
		List<Emp> list = new ArrayList<>();
		
		try {
			conn = MySqlUtils.connectDatabase("MySql配置文件/mysql.ini");
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
