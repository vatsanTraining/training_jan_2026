package login_module_07;
import org.example.demo.moduletwo.Second;

import com.example.demo.moduleone.*;
public class LoginApplication {

	public static void main(String[] args) {

		
		First obj = new First();
		
		 System.out.println(obj.moduleOne());
		 
		 Second obj2 =new Second();
		 
		 System.out.println(obj2.moduleTwo());
	}

}
