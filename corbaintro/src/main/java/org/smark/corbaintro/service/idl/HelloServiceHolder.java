package org.smark.corbaintro.service.idl;

/**
* org/smark/corbaintro/service/idl/HelloServiceHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��hello.idl
* 2016��3��14�� ����һ ����10ʱ55��00�� CST
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
