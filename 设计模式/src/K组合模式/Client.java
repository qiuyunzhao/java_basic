package K���ģʽ;

/**
 * ��ʱʹ�ã� 1�������ʾ����Ĳ���-�����νṹ�����νṹ���� 2����ϣ���û�������϶����뵥������Ĳ�ͬ���û���ͳһ��ʹ����Ͻṹ�е����ж��� 
 * 
 * �ŵ㣺 1���߲�ģ����ü�(�Զ��ݹ飬������һ��)�� 2���ڵ��������ӡ�
 * 
 * ȱ�㣺��ʹ�����ģʽʱ����Ҷ�Ӻ���֦����������ʵ���࣬�����ǽӿڣ�Υ������������ԭ��
 * 
 * ʹ�ó��������֡����峡���������β˵����ļ����ļ��еĹ���
 */
public class Client {
	public static void main(String[] args) {
		
		AbstractFile f2, f3, f4, f5, f6, f7;
		
		Folder f = new Folder("�ҵ��ղ�");

		Folder f11 = new Folder("��Ӱ");
		f2 = new VideoFile("Ц������.avi");
		f3 = new VideoFile("�������.avi");
		f11.add(f2);
		f11.add(f3);
		f.add(f11);
		
		Folder f12 = new Folder("�ļ�");
		f4 = new VideoFile("����.txt");
		f5 = new VideoFile("����.txt");
		f12.add(f4);
		f12.add(f5);
		f.add(f12);
		
		Folder f13 = new Folder("ͼƬ");
		f4 = new VideoFile("������.txt");
		f5 = new VideoFile("ף����.txt");
		f13.add(f4);
		f13.add(f5);
		f.add(f13);
		
		f2.killVirus();
		System.out.println("------------------------");
		f11.killVirus();
		System.out.println("------------------------");
		f.killVirus();
	}
}