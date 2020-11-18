import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import generated.Customers;

public class App {

	public static void main(String[] args) {
		String path = "/home/genod/development/sources/trainings/sfpd.training.lot5/day3/jaxb.unmarshall/src/main/resources/customers.xml";
		String pathLarge = "/home/genod/development/sources/trainings/sfpd.training.lot5/day3/jaxb.unmarshall/src/main/resources/customersLarge.xml";

		try {
			JAXBContext context = JAXBContext.newInstance(Customers.class);
			Unmarshaller un = context.createUnmarshaller();

			long startTime = System.nanoTime();
			Customers customers = (Customers) unmarshallLargeXml(pathLarge, un);
			long endTime = System.nanoTime();
			System.out.println("Large " + (endTime - startTime) / 1000000 + "ms");

			startTime = System.nanoTime();
			customers = (Customers) unmarshallLargeXml(path, un);
			endTime = System.nanoTime();
			System.out.println("Small " + (endTime - startTime) / 1000000 + "ms");

			/*
			customers.getCustomer().stream()
					.map(Customers.Customer::getName)
					.forEach(System.out::println);
			 */

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	private static Object unmarshallLargeXml(String path, Unmarshaller un) throws JAXBException {
		return un.unmarshal(new File(path));
	}
}
