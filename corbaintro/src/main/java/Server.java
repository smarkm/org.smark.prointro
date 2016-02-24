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
			 //����һ��ORBʵ�� 
			ORBUtil.init(args, null);
	        POA rootpoa = ORBUtil.getPOA();
			
			 //�ӷ����еõ���������� 
            HelloServiceCorbaImpl helloImpl = new HelloServiceCorbaImpl();
            //helloImpl.setORB(orb); 

            //�ӷ����еõ���������� 
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl); 
            HelloService href = HelloServiceHelper.narrow(ref);
            //�õ�һ�������Ƶ������� 
           
            //�������������а�������� 
            String name = "Hello"; 
            NameComponent path[] = ORBUtil.getNamingService().to_name(name); 
            ORBUtil.getNamingService().rebind(path, href); 

            System.out.println("HelloServer ready and waiting ..."); 

            //�����̷߳��񣬵ȴ��ͻ��˵ĵ��� 
            ORBUtil.getOrb().run(); 
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
