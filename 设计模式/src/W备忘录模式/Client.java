package W����¼ģʽ;

public class Client {
	public static void main(String[] args) {
		
		CareTaker taker = new CareTaker();

		Originator emp = new Originator("���", 18, 1000);
		System.out.println("��1�δ洢����" + emp.getEname() + "---" + emp.getAge() + "---" + emp.getSalary());
		taker.add(emp.saveToMemento()); // ����1��
		
		emp = new Originator("���", 19, 2000);
		System.out.println("��2�δ洢����" + emp.getEname() + "---" + emp.getAge() + "---" + emp.getSalary());
		taker.add(emp.saveToMemento()); // ����2��
		
		emp = new Originator("���", 20, 3000);
		System.out.println("��3�δ洢����" + emp.getEname() + "---" + emp.getAge() + "---" + emp.getSalary());
		taker.add(emp.saveToMemento()); // ����3��

		emp.recoverFromMemento(taker.get(1)); // �ָ�������¼��3�ε�״̬
		System.out.println("�ָ���2�δ洢�Ķ���" + emp.getEname() + "---" + emp.getAge() + "---" + emp.getSalary());
		
		emp.recoverFromMemento(taker.get(0)); // �ָ�������¼��3�ε�״̬
		System.out.println("�ָ���1�δ洢�Ķ���" + emp.getEname() + "---" + emp.getAge() + "---" + emp.getSalary());
		
	}
}