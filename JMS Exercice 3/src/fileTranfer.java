import java.io.File;
import java.util.Scanner;

import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.file.GenericFileMessage;
import org.apache.camel.impl.DefaultCamelContext;

public class fileTranfer {

	public static void main(String[] args) {
		try {
			CamelContext context = new DefaultCamelContext();
			context.addRoutes(new RouteBuilder() {
				public void configure() throws Exception {
					from("file:///home/florian/temp/in")
					.process(new Processor() {
						@SuppressWarnings("unchecked")
						public void process(Exchange e) throws Exception {
							GenericFileMessage<File> fileIn =
									(GenericFileMessage<File>) e.getIn();
							System.out.println("Echange reçu : " + fileIn);
							String s = fileIn.getBody(String.class);
							System.out.println(s);
						}
					})
					.to("file:///home/florian/temp/out");
				}
			});
			context.start();
			Scanner sc = new Scanner(System.in);;
			sc.nextLine();
			sc.close();
			context.stop();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
