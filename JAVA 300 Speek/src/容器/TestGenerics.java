package ����;

public class TestGenerics {

	public static void main(String[] args) {

		 // ����ġ�String������ʵ�ʴ�����������ͣ�
        MyCollection<String> mc = new MyCollection<>();
        mc.set("aaa", 0);
        mc.set("bbb", 1);
        String str = mc.get(1); //���˷��ͣ�ֱ�ӷ���String���ͣ�����ǿ��ת��;
        System.out.println(str);
	}

}


class MyCollection<E> {// E:��ʾ����;
    Object[] objs = new Object[5];
 
    public E get(int index) {// E:��ʾ����;
        return (E) objs[index];
    }
    public void set(E e, int index) {// E:��ʾ����;
        objs[index] = e;
    }
}