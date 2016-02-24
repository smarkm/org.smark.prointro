package org.smark.corbaintro.service.corba;

/**
* org/smark/corbaintro/service/corba/HelloServiceHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从hello.idl
* 2016年2月24日 星期三 上午10时36分43秒 CST
*/

public final class HelloServiceHolder implements org.omg.CORBA.portable.Streamable
{
  public org.smark.corbaintro.service.corba.HelloService value = null;

  public HelloServiceHolder ()
  {
  }

  public HelloServiceHolder (org.smark.corbaintro.service.corba.HelloService initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.smark.corbaintro.service.corba.HelloServiceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.smark.corbaintro.service.corba.HelloServiceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.smark.corbaintro.service.corba.HelloServiceHelper.type ();
  }

}
