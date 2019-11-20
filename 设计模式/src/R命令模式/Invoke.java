package R命令模式;

import java.util.ArrayList;
import java.util.List;

//调用者/发起者
public class Invoke {
	
	 private List<Command> commandList = new ArrayList<Command>(); // 通过容器List<Command>容纳很多命令对象，进行批处理。数据库底层的事务管理就是类似的结构！
	 
	   public void addOrder(Command command){
		   commandList.add(command);      
	   }
	 
	   public void callOrders(){
	      for (Command command : commandList) {
	    	// 业务方法 ，用于调用命令类的方法
	    	  command.execute();
	      }
	      commandList.clear();
	   }
	
}