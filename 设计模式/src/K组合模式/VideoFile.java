package K组合模式;

/**
 * 2）叶子（leaf）构件角色：无子节点
 */
public class VideoFile implements AbstractFile {
	
	private String name;

	public VideoFile(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println("-----视频文件：" + name + ",进行查杀！");
	}
	
}