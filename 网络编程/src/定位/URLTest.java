package 定位;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL则标识了这些计算机上的资源。
 * 
 * 类 URL代表一个统一资源定位符，是指向互联网“资源”的指针。资源可以是简单的文件或目录，也可以是对更为复杂的对象的引用，例如对数据库或搜索引擎的查询。
 * 
 * URL有4部分：1.协议 2.域名/计算机 3.端口（默认80） 4.请求的资源
 * 
 * http://www.google.cn:80/webhp#aa?canhu=33
 */
public class URLTest {

	public static void main(String[] args) throws MalformedURLException {
		URL u = new URL("http://www.google.cn:80/webhp#aa?canhu=33");
		System.out.println("协议：" + u.getProtocol()); // http
		System.out.println("主机名：" + u.getHost()); // www.google.cn
		System.out.println("端口：" + u.getPort()); // 80
		System.out.println("getFile:" + u.getFile()); // 端口号后面的内容
		System.out.println("路径：" + u.getPath()); // 端口号后，参数前的内容
		System.out.println("锚点：" + u.getRef());// aa?canhu=33

		System.out.println("获取与此url关联的协议的默认端口：" + u.getDefaultPort());
		System.out.println("参数部分：" + u.getQuery());

		URL u1 = new URL("http://www.abc.com/aa/");
		URL u2 = new URL(u, "2.html"); // 相对路径构建url对象
		System.out.println(u2.toString()); // http://www.abc.com/aa/2.html
	}

}
