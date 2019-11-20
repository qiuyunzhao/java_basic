package K组合模式;

/**
 * 何时使用： 1、您想表示对象的部分-整体层次结构（树形结构）。 2、您希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。 
 * 
 * 优点： 1、高层模块调用简单(自动递归，方法名一致)。 2、节点自由增加。
 * 
 * 缺点：在使用组合模式时，其叶子和树枝的声明都是实现类，而不是接口，违反了依赖倒置原则。
 * 
 * 使用场景：部分、整体场景，如树形菜单，文件、文件夹的管理。
 */
public class Client {
	public static void main(String[] args) {
		
		AbstractFile f2, f3, f4, f5, f6, f7;
		
		Folder f = new Folder("我的收藏");

		Folder f11 = new Folder("电影");
		f2 = new VideoFile("笑傲江湖.avi");
		f3 = new VideoFile("神雕侠侣.avi");
		f11.add(f2);
		f11.add(f3);
		f.add(f11);
		
		Folder f12 = new Folder("文件");
		f4 = new VideoFile("工资.txt");
		f5 = new VideoFile("花费.txt");
		f12.add(f4);
		f12.add(f5);
		f.add(f12);
		
		Folder f13 = new Folder("图片");
		f4 = new VideoFile("陈钰琪.txt");
		f5 = new VideoFile("祝绪丹.txt");
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