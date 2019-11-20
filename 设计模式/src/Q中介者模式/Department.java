package Q中介者模式;

//同事类的接口
public interface Department {
	
	void selfAction(); // 做本部门的事情

	void outAction(); // 向中介类（总经理）发出申请
	
}