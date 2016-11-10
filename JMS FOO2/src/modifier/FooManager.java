package modifier;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.SchemaFactory;

import foo2.Foo;

public class FooManager {

	public FooManager() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JAXBContext context = null;
		Foo foo = null;
		try {
			context = JAXBContext.newInstance("foo2");
			Unmarshaller u = context.createUnmarshaller();
			
			foo = (Foo) u.unmarshal(new File("foo2.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.example.org/foo2 foo2.xsd");
			m.setSchema(
					SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema").newSchema(new File("foo2.xsd")));
			
			m.marshal(foo, System.out);
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
	}

}
