package 定位;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress类
 * 
 * 作用：封装计算机的IP地址和DNS(没有端口信息)。 注：DNS是 Domain Name System，域名系统。
 * 
 * 特点：类没有构造方法,只能通过静态方法得到对象：getLocalHost(),getByName(), getAllByName(), getAddress(),getHostName()。
 */

public class InetAddressTest {
	
	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
        //返回IP地址
        System.out.println(addr.getHostAddress()); 
        //输出计算机名
        System.out.println(addr.getHostName());
        System.out.println("------------------------");
        
        addr = InetAddress.getByName("www.baidu.com");
        // 返回baidu服务器的IP
        System.out.println(addr.getHostAddress());
        // 输出域名
        System.out.println(addr.getHostName());
        System.out.println("------------------------");
        
        addr = InetAddress.getByName("119.75.217.109");
        // 返回baidu服务器的IP
        System.out.println(addr.getHostAddress());
        /* 输出ip而不是域名。如果这个IP地址不存在或DNS服务器不允许进行IP地址
         * 和域名的映射，getHostName方法就直接返回这个IP地址。*/
        System.out.println(addr.getHostName());
	}

}
