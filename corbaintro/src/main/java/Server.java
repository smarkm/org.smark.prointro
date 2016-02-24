import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.smark.corbaintro.core.util.ORBUtil;
import org.smark.corbaintro.service.HelloServiceCorbaImpl;
import org.smark.corbaintro.service.corba.HelloService;
import org.smark.corbaintro.service.corba.HelloServiceHelper;

//java MainClass -ORBInitialPort 2050
public class Server {

	public static void main(String[]args){
		
		try {
			 //创建一个ORB实例 
			ORBUtil.init(args, null);
	        POA rootpoa = ORBUtil.getPOA();
			
			 //从服务中得到对象的引用 
            HelloServiceCorbaImpl helloImpl = new HelloServiceCorbaImpl();
            //helloImpl.setORB(orb); 

            //从服务中得到对象的引用 
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl); 
            HelloService href = HelloServiceHelper.narrow(ref);
            //得到一个根名称的上下文 
           
            //在命名上下文中绑定这个对象 
            String name = "Hello"; 
            NameComponent path[] = ORBUtil.getNamingService().to_name(name); 
            ORBUtil.getNamingService().rebind(path, href); 

            System.out.println("HelloServer ready and waiting ..."); 

            //启动线程服务，等待客户端的调用 
            ORBUtil.getOrb().run(); 
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
