package J�Ž�ģʽ;

//�Ž�ģʽ���ģ�ͨ������ά�ȣ���Ϊ�ڲ����еķ�ʽ������ļ̳й�ϵ

public class Client {
	public static void main(String[] args) {
		// ��������ıʼǱ�����
		Computer c = new Laptop(new Lenovo());
		c.sale();
		// �������۵�̨ʽ��
		Computer c2 = new Pad(new Shenzhou());
		c2.sale();
	}
}