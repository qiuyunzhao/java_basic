package O责任链模式;

public class Client {
	public static void main(String[] args) {
		Leader a = new Director("胡一");
		Leader b = new Manager("王二");
		Leader b2 = new ViceGeneralManager("张三");
		Leader c = new GeneralManager("李四");
		
		// 组织责任链对象的关系
		a.setNextLeader(b);
		b.setNextLeader(b2);
		b2.setNextLeader(c);
		
		// 开始请假操作
		LeaveRequest req1 = new LeaveRequest("TOM", 15, "脚踝扭伤，回家养病！");
		a.handleRequest(req1);
	}
}