package org.smark.prointro.eclipselink.moxy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.smark.prointro.eclipselink.moxy.bean.User;

public class MOXy {

	public static void main(String[] arsg) throws JAXBException, FileNotFoundException {
		Class[] classes = new Class[1];
		classes[0] = User.class;
		JAXBContext ctx = JAXBContext.newInstance(classes);
		User user = new User("test", 12);
		Marshaller marshaller = ctx.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(user, new FileOutputStream("src/main/java/users.xml"));
	}
}
