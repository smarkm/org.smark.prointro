package org.smark.corbaintro.service.idl;

/**
* org/smark/corbaintro/service/idl/HelloServiceHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从hello.idl
* 2016年3月14日 星期一 上午10时55分00秒 CST
*/

public final class HelloServiceHolder implements org.omg.CORBA.portable.Streamable
{
  public org.smark.corbaintro.service.idl.HelloService value = null;

  public HelloServiceHolder ()
  {
  }

  public HelloServiceHolder (org.smark.corbaintro.service.idl.HelloService initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.smark.corbaintro.service.idl.HelloServiceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.smark.corbaintro.service.idl.HelloServiceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.smark.corbaintro.service.idl.HelloServiceHelper.type ();
  }

}
