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
			// 创建一个ORB实例
			ORBUtil.init(args, null);
			NamingContextExt ncRef = ORBUtil.getNamingService();
			NameComponent comps = new NameComponent("services","");
			String names[] = ORBUtil.getOrb().list_initial_services();
			
			// 从命名上下文中获取接口实现对象
			String name = "Hello";
			HelloService helloImpl = HelloServiceHelper.narrow(ncRef
					.resolve_str(name));

			// 调用接口对象的方法
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
