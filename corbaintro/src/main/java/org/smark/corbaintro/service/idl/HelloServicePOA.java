package org.smark.corbaintro.service.idl;


/**
* org/smark/corbaintro/service/idl/HelloServicePOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从hello.idl
* 2016年3月14日 星期一 上午10时55分00秒 CST
*/

public abstract class HelloServicePOA extends org.omg.PortableServer.Servant
 implements org.smark.corbaintro.service.idl.HelloServiceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("sayHello", new java.lang.Integer (0));
    _methods.put ("shutdown", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // org/smark/corbaintro/service/idl/HelloService/sayHello
       {
         String $result = null;
         $result = this.sayHello ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // org/smark/corbaintro/service/idl/HelloService/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:org/smark/corbaintro/service/idl/HelloService:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public HelloService _this() 
  {
    return HelloServiceHelper.narrow(
    super._this_object());
  }

  public HelloService _this(org.omg.CORBA.ORB orb) 
  {
    return HelloServiceHelper.narrow(
    super._this_object(orb));
  }


} // class HelloServicePOA
