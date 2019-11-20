package ��λ;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL���ʶ����Щ������ϵ���Դ��
 * 
 * �� URL����һ��ͳһ��Դ��λ������ָ����������Դ����ָ�롣��Դ�����Ǽ򵥵��ļ���Ŀ¼��Ҳ�����ǶԸ�Ϊ���ӵĶ�������ã���������ݿ����������Ĳ�ѯ��
 * 
 * URL��4���֣�1.Э�� 2.����/����� 3.�˿ڣ�Ĭ��80�� 4.�������Դ
 * 
 * http://www.google.cn:80/webhp#aa?canhu=33
 */
public class URLTest {

	public static void main(String[] args) throws MalformedURLException {
		URL u = new URL("http://www.google.cn:80/webhp#aa?canhu=33");
		System.out.println("Э�飺" + u.getProtocol()); // http
		System.out.println("��������" + u.getHost()); // www.google.cn
		System.out.println("�˿ڣ�" + u.getPort()); // 80
		System.out.println("getFile:" + u.getFile()); // �˿ںź��������
		System.out.println("·����" + u.getPath()); // �˿ںź󣬲���ǰ������
		System.out.println("ê�㣺" + u.getRef());// aa?canhu=33

		System.out.println("��ȡ���url������Э���Ĭ�϶˿ڣ�" + u.getDefaultPort());
		System.out.println("�������֣�" + u.getQuery());

		URL u1 = new URL("http://www.abc.com/aa/");
		URL u2 = new URL(u, "2.html"); // ���·������url����
		System.out.println(u2.toString()); // http://www.abc.com/aa/2.html
	}

}
