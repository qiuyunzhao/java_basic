package Q�н���ģʽ;

public interface Mediator {
	/**
	 * ������Ķ������н��н���ע��
	 * 
	 * @param dname
	 *            ��������
	 * @param d
	 *            ���Ŷ���
	 */
	void register(String dname, Department d);

	/**
	 * �н���ע�Ჿ�Ž��н���
	 * 
	 * @param dname
	 *            ��������
	 */
	void command(String dname);

}