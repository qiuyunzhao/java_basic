package R����ģʽ;

import java.util.ArrayList;
import java.util.List;

//������/������
public class Invoke {
	
	 private List<Command> commandList = new ArrayList<Command>(); // ͨ������List<Command>���ɺܶ�������󣬽������������ݿ�ײ���������������ƵĽṹ��
	 
	   public void addOrder(Command command){
		   commandList.add(command);      
	   }
	 
	   public void callOrders(){
	      for (Command command : commandList) {
	    	// ҵ�񷽷� �����ڵ���������ķ���
	    	  command.execute();
	      }
	      commandList.clear();
	   }
	
}