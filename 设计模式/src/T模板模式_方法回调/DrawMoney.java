package T模板模式_方法回调;

//可以将重写回调方法的具体实现类单独写成子类（但更多时候是写成匿名内部类）
public class DrawMoney extends BankTemplateMethod {
	
	@Override
	public void transact() {
		System.out.println("我要取款！！！");
	}
	
}