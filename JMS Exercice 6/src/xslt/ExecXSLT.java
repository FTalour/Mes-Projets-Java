package xslt;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ExecXSLT {
	public static void main(String[] args) {
		TransformerFactory tFactory	= TransformerFactory.newInstance();
		Source xslSource			= new StreamSource("itransformation.xsl");
		try {
			Transformer transfo		= tFactory.newTransformer(xslSource);
			StreamSource xmlSource	= new StreamSource("sortie2.xml");
			Result outputTarget		= new StreamResult("entree2.xml");
			transfo.transform(xmlSource, outputTarget);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
