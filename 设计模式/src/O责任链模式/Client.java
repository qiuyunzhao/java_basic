package O������ģʽ;

public class Client {
	public static void main(String[] args) {
		Leader a = new Director("��һ");
		Leader b = new Manager("����");
		Leader b2 = new ViceGeneralManager("����");
		Leader c = new GeneralManager("����");
		
		// ��֯����������Ĺ�ϵ
		a.setNextLeader(b);
		b.setNextLeader(b2);
		b2.setNextLeader(c);
		
		// ��ʼ��ٲ���
		LeaveRequest req1 = new LeaveRequest("TOM", 15, "����Ť�ˣ��ؼ�������");
		a.handleRequest(req1);
	}
}