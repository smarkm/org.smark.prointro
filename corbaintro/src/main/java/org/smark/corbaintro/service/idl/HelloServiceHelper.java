package org.smark.corbaintro.service.idl;


/**
* org/smark/corbaintro/service/idl/HelloServiceHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从hello.idl
* 2016年3月14日 星期一 上午10时55分00秒 CST
*/

abstract public class HelloServiceHelper
{
  private static String  _id = "IDL:org/smark/corbaintro/service/idl/HelloService:1.0";

  public static void insert (org.omg.CORBA.Any a, org.smark.corbaintro.service.idl.HelloService that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static org.smark.corbaintro.service.idl.HelloService extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (org.smark.corbaintro.service.idl.HelloServiceHelper.id (), "HelloService");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static org.smark.corbaintro.service.idl.HelloService read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_HelloServiceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, org.smark.corbaintro.service.idl.HelloService value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static org.smark.corbaintro.service.idl.HelloService narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof org.smark.corbaintro.service.idl.HelloService)
      return (org.smark.corbaintro.service.idl.HelloService)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      org.smark.corbaintro.service.idl._HelloServiceStub stub = new org.smark.corbaintro.service.idl._HelloServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static org.smark.corbaintro.service.idl.HelloService unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof org.smark.corbaintro.service.idl.HelloService)
      return (org.smark.corbaintro.service.idl.HelloService)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      org.smark.corbaintro.service.idl._HelloServiceStub stub = new org.smark.corbaintro.service.idl._HelloServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
