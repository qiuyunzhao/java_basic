package ������;

public class TestMath {

	public static void main(String[] args) {

		//ȡ����ز���
        System.out.println(Math.ceil(3.2));	//����3.2������
        System.out.println(Math.floor(3.2));	//С��3.2������
        System.out.println(Math.round(3.2));	//��������

        //����ֵ��������a��b���ݵȲ���
        System.out.println(Math.abs(-45));
        System.out.println(Math.sqrt(64));
        System.out.println(Math.pow(5, 2));
        System.out.println(Math.pow(2, 5));
        
        //Math���г��õĳ���
        System.out.println(Math.PI);
        System.out.println(Math.E);
        
        //�����
        System.out.println(Math.random());// [0,1)
        
        //�ǶȺͻ���
        System.out.println(Math.toDegrees(Math.PI));	//����->�Ƕ�
        System.out.println(Math.toRadians(180));	//�Ƕ�->����
        
        //���Ǻ���
        System.out.println(Math.sin(Math.PI/2));
        System.out.println(Math.cos(Math.PI));

	}

}
