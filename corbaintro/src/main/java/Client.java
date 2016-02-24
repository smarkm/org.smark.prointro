import org.omg.CORBA.DomainManager;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
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
			
			// �������������л�ȡ�ӿ�ʵ�ֶ���
			String name = "Hello";
			HelloService helloImpl = HelloServiceHelper.narrow(ncRef
					.resolve_str(name));

			// ���ýӿڶ���ķ���
			System.out.println("Obtained a handle on server object: "
					+ helloImpl);
			System.out.println(helloImpl.sayHello());
			helloImpl.shutdown();

		} catch (Exception e) {
			System.out.println("ERROR : " + e);
			e.printStackTrace(System.out);
		}
	}

}
