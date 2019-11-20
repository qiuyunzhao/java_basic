package �ڵ���;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * java.io.File�ࣺ�����ļ���Ŀ¼�� �ڿ����У���ȡ�ļ��������ļ���ɾ���ļ����޸��ļ�������ʱ�������õ�����
 */
public class TestFile {

	public static void main(String[] args) {
		boolean flag = false;

		System.out.println(System.getProperty("user.dir"));

		File f = new File("a.txt"); // ���·����Ĭ�Ϸŵ�user.dirĿ¼����
		try {
			flag = f.createNewFile();// �����ļ�
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (flag) {
			System.out.println("�����ɹ�");
			flag = false;
		}

		System.out.println("File�Ƿ���ڣ�" + f.exists());
		System.out.println("File�Ƿ���Ŀ¼��" + f.isDirectory());
		System.out.println("File�Ƿ����ļ���" + f.isFile());
		System.out.println("File����޸�ʱ�䣺" + new Date(f.lastModified()));
		System.out.println("File�Ĵ�С��" + f.length());
		System.out.println("File���ļ�����" + f.getName());
		System.out.println("File��Ŀ¼·����" + f.getPath()); // ����ʱ�����·�����������·�����Ǿ���·�����ؾ���·��
		System.out.println("File�ľ���·����" + f.getAbsolutePath());
		System.out.println("File����һ��·����" + f.getParent()); // ����ʱ�����·�������ؿգ��Ǿ���·��������һ��Ŀ¼
		flag = f.delete();
		if (flag) {
			System.out.println("ɾ���ɹ�");
			flag = false;
		}

		System.out.println("*************Ŀ¼����***************");
		File dir = new File("D:/eclipse-workspace/File_IO/����Ŀ¼/Ŀ¼1");
		flag = dir.mkdir(); // mkdir()����·��ʱ�ϼ�·�������ڴ���ʧ��
		if (flag) {
			System.out.println("mkdir()�����ɹ�");
			flag = false;
		} else {
			System.out.println("mkdir()����ʧ��");
		}
		flag = dir.mkdirs(); // ����Ŀ¼,�ϼ�Ŀ¼�����ڻ��Զ�����
		if (flag) {
			System.out.println("mkdirs()�����ɹ�");
			flag = false;
		} else {
			System.out.println("mkdirs()����ʧ��");
		}
		dir = new File("D:/eclipse-workspace/File_IO/����Ŀ¼");
		String[] subNames = dir.list(); // ����¼�����
		System.out.print("�¼�����:");
		for (String s : subNames) {
			System.out.print(s + "\t");
		}
		System.out.println();
		
		File[] subFiles = dir.listFiles(); // ����¼�����
		System.out.print("�¼��ļ�����:");
		for (File file : subFiles) {
			System.out.print(file.getAbsolutePath() + "\t");
		}
		System.out.println();

		System.out.println("*************�����ļ�*************");
		String filePath = "d:/sxt/b.txt";
		createFile(filePath);
		System.out.println("*************ɾ���ļ�*************");
		deleteFile(filePath);
		deleteDirectory("d:/sxt");
		System.out.println("*************����Ŀ¼*************");
		String directoryName = "d:/�й�/ɽ��/�Ͳ�";
		createDirectory(directoryName);
		System.out.println("*************ɾ��Ŀ¼����Ŀ¼*******");
		deleteDirectory("d:/�й�");
	}

	/**
	 * ���������ļ������Ŀ¼�������ȴ���Ŀ¼
	 */
	public static boolean createFile(String fileName) {
		File file = new File(fileName);
		// �������
		if (file == null || file.exists()) {
			System.out.println("�ļ�" + fileName + "�Ѵ��ڣ�����ʧ��");
			return false;
		} else {
			// ����Ŀ¼���ļ�
			try {
				// ���Ŀ¼�����ڣ��ȴ���Ŀ¼
				File dir = file.getParentFile();
				if (!dir.exists()) {
					dir.mkdirs(); // ����Ŀ¼
					System.out.println("����Ŀ¼" + dir);
				}
				// �����ļ�
				boolean flagn = file.createNewFile();
				if (flagn) {
					System.out.println("�����ļ�" + fileName + "�ɹ�");
					return true;
				} else {
					System.out.println("�����ļ�" + fileName + "ʧ��");
					return false;
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("�����ļ�" + fileName + "ʧ��");
				return false;
			}
		}
	}

	/**
	 * ɾ�������ļ�
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.isFile() && file.exists()) {
			Boolean succeedDelete = file.delete();
			if (succeedDelete) {
				System.out.println("ɾ�������ļ�" + fileName + "�ɹ���");
				return true;
			} else {
				System.out.println("ɾ�������ļ�" + fileName + "ʧ�ܣ�");
				return true;
			}
		} else {
			System.out.println("ɾ�������ļ�" + fileName + "ʧ�ܣ�");
			return false;
		}
	}

	/**
	 * ����Ŀ¼�ṹ
	 */
	public static boolean createDirectory(String directoryName) {
		File file = new File(directoryName);
		// ���Ŀ¼�����ڣ��ȴ���Ŀ¼
		if (!file.exists()) {
			file.mkdirs(); // ����Ŀ¼,�ϼ�Ŀ¼�����ڻ��Զ�����
			System.out.println("����Ŀ¼" + file + "�ɹ�");
			return true;
		} else {
			System.out.println("Ŀ¼" + file + "�Ѿ�����");
			return false;
		}
	}

	/**
	 * ɾ��Ŀ¼��ɾ��Ŀ¼����������
	 */
	public static boolean deleteDirectory(String dir) {
		// ���dir�����ļ��ָ�����β���Զ�����ļ��ָ���
		if (!dir.endsWith(File.separator)) {
			dir = dir + File.separator;
		}
		File dirFile = new File(dir);
		// ���dir��Ӧ���ļ������ڣ����߲���һ��Ŀ¼�����˳�
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			System.out.println("ɾ��Ŀ¼ʧ��" + dir + "Ŀ¼�����ڣ�");
			return false;
		}
		boolean flag = true;
		// ɾ���ļ����µ������ļ�(������Ŀ¼)
		File[] files = dirFile.listFiles(); 
		for (int i = 0; i < files.length; i++) {
			// ɾ�����ļ�
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
			// ɾ����Ŀ¼
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
		}

		if (!flag) {
			System.out.println("ɾ��Ŀ¼ʧ��");
			return false;
		}

		// ɾ����ǰĿ¼
		if (dirFile.delete()) {
			System.out.println("ɾ��Ŀ¼" + dir + "�ɹ���");
			return true;
		} else {
			System.out.println("ɾ��Ŀ¼" + dir + "ʧ�ܣ�");
			return false;
		}
	}

}
