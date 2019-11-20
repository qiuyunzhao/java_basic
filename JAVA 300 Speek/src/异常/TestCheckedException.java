package �쳣;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestCheckedException {

	public static void main(String[] args) {

		String str = "d:/a.txt";
		try {
			throwsException(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tryCatchException(str);
	}

	/**
	 * try  catch ��ʽ�����쳣
	 * @param filePath
	 */
	public static void tryCatchException(String filePath) {
		FileReader reader = null;
		try {
			reader = new FileReader(filePath);
			char c = (char) reader.read();
			char c2 = (char) reader.read();
			System.out.println("" + c + c2);
		} catch (FileNotFoundException e) { 	//�����쳣�����ڸ����쳣ǰ��
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * throws ��ʽ�����쳣
	 * @param filePath
	 * @throws IOException 
	 */
	public static void throwsException(String filePath) throws IOException {
		FileReader in = new FileReader(filePath);
        int tem = 0;
        try {
            tem = in.read();
            while (tem != -1) {
                System.out.print((char) tem);
                tem = in.read();
            }
        } finally {
            in.close();
        }
	}
	
}
