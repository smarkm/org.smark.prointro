import java.util.Properties;

import org.omg.CORBA.Object;
import org.omg.CosNaming.Binding;
import org.omg.CosNaming.BindingIteratorHolder;
import org.omg.CosNaming.BindingListHolder;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.smark.corbaintro.core.util.ORBUtil;


public class OrbInfoClient {
	public static void main(String[] args) {
			// 创建一个ORB实例
			Properties props = new Properties();
	        props.put("org.omg.CORBA.ORBInitialPort", "2050");
	        props.put("org.omg.CORBA.ORBInitialHost", "192.168.1.141");
			ORBUtil.init(null, props);
			
			printRegistedName();
			
			try {
				String name ="xDRAggregationServer";
				Object s = ORBUtil.getNamingService().resolve_str(name );
			
			
			} catch (NotFound e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CannotProceed e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidName e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	public static void printRegistedName(){
		NamingContextExt ncRef = ORBUtil.getNamingService();
		String names[] = ORBUtil.getOrb().list_initial_services();
		 BindingListHolder bl = new BindingListHolder();
	        BindingIteratorHolder blIt= new BindingIteratorHolder();
	        ncRef.list(1000, bl, blIt);
	     Binding[] bindings = bl.value;  
	     for (int i = 0; i < bindings.length; i++) {
			System.out.println(bindings[i].binding_name[0].id);
		}  
	}
}
