import org.omg.CosNaming.Binding;
import org.omg.CosNaming.BindingIteratorHolder;
import org.omg.CosNaming.BindingListHolder;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.smark.corbaintro.core.util.ORBUtil;
import org.smark.corbaintro.service.corba.HelloService;
import org.smark.corbaintro.service.corba.HelloServiceHelper;

//java HelloClient -ORBInitialHost localhost -ORBInitialPort 2050
public class Client {

	public static void main(String[] args) {
		try {
			// ����һ��ORBʵ��
			ORBUtil.init(args, null);
			NamingContextExt ncRef = ORBUtil.getNamingService();
			NameComponent comps = new NameComponent("services","");
			String names[] = ORBUtil.getOrb().list_initial_services();
			 BindingListHolder bl = new BindingListHolder();
		        BindingIteratorHolder blIt= new BindingIteratorHolder();
		        ncRef.list(1000, bl, blIt);
		     Binding[] bindings = bl.value;  
		     for (int i = 0; i < bindings.length; i++) {
				System.out.println(bindings[i].binding_name[0].id);
			}  
		        
			// �������������л�ȡ�ӿ�ʵ�ֶ���
			String name = "Hello";
			HelloService helloImpl = HelloServiceHelper.narrow(ncRef
					.resolve_str(name));

			// ���ýӿڶ���ķ���
			/*System.out.println("Obtained a handle on server object: "
					+ helloImpl);
			System.out.println(helloImpl.sayHello());
			helloImpl.shutdown();*/

		} catch (Exception e) {
			System.out.println("ERROR : " + e);
			e.printStackTrace(System.out);
		}
	}

}
