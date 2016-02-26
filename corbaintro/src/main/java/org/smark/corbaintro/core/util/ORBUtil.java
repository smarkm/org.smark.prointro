package org.smark.corbaintro.core.util;

import java.util.Properties;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class ORBUtil {
	private static ORB instance;
	private static NamingContextExt namingService;
	
	private ORBUtil(){
	}
	
	public static void init(String[]args, Properties props){
		/**
		 * Properties props = new Properties();
	        props.put("org.omg.CORBA.ORBInitialPort", "1050");
	        props.put("org.omg.CORBA.ORBInitialHost", "localhost");
	        ORB orb = ORB.init(args, props);
		 */
		instance =ORB.init(args, props);
	}
	
	public static ORB getOrb() {
		return instance;
	}
	
	public static POA getPOA(){
		POA rootpoa = null;
		try {
			rootpoa = POAHelper.narrow(instance.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rootpoa;
	}
	
	public static  NamingContextExt getNamingService(){
		if(namingService==null){
			return namingService();
		}
		return namingService;
	}
	
	private static NamingContextExt namingService(){
		org.omg.CORBA.Object objRef;
		 NamingContextExt ncRef = null;
		try {
			objRef = instance.resolve_initial_references("NameService");
			 // Use NamingContextExt which is part of the Interoperable 
	         // Naming Service (INS) specification. 
	         ncRef = NamingContextExtHelper.narrow(objRef); 
		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        return ncRef;
	}
}
