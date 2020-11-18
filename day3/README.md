# Day 3 : JAXB

## Workshop 1

1. Sample project `00.jaxb.marshall.xsd.sample`
    1. Check the configuration 
    1. Run the using command for POJO generation : `mvn clean generate-sources`  
    1. Check the generated classes, are there differences ? 

1. Test the unmarshalling of sample file `workshop.files/customers.xml`
    * Add some Assertions
    * [Example Tutorial](https://www.javaguides.net/2018/10/jaxb-tutorial.html)
    * Compare the execution time with sample file  `workshop.files/customersLarge.xml`

1. Using the module from Day 1 Workshop as base
    * Test a service that returns the results of the query fetching all the orders purchased as an XML document 
    * [Example Tutorial](https://www.developer.com/java/data/Converting-JDBC-Result-Sets-to-XML-3329001.htm)

### Online resources 
* [API Documentation](https://javaee.github.io/jaxb-v2/doc/user-guide/release-documentation.html#users-guide)

## Workshop 2

* Import the Postman collection https://documenter.getpostman.com/view/8854915/Szf26WHn?version=latest#intro 

* Sample module  `00.jaxws.client.sample`
    1. Check the configuration 
    1. Run the using command for POJO generation : `mvn clean install`  
    1. Check the generated classes

1. Create a new module
    * Build and publish a SOAP web Service based on the data modeled from Day 1 Workshop
    * We can use static data at first (without Hibernate configured)
    * Test the WSDL url in a web browser
```java
// Publisher class 
import jakarta.xml.ws.Endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleServicePublisher {
    
    private static final Logger logger = LoggerFactory.getLogger(SampleServicePublisher.class);
    
    public static void main(String[] args) {
        Endpoint endpoint = Endpoint.create(new SampleServiceImpl());
        endpoint.publish("http://localhost:8888/ws/sample");
        
        logger.info("Sample web service ready to consume requests!");
    }
}

// Service class 

import jakarta.jws.WebService;

@WebService(endpointInterface = "io.hackages.learning.soap.ws.server.SampleService")
public class SampleServiceImpl implements SampleService {

    @Override
    public SampleObject findByName(String name) {
        return new SampleObject();
    }

}
```

### Online resources 
* [API Documentation](https://javaee.github.io/tutorial/webservices-intro002.html)
* [Jakarta XML Web Services - GitHub Pages](https://eclipse-ee4j.github.io/metro-jax-ws/2.3.3/docs/ch03.html)

## Workshop 3 : Arquillian


### Online resources 
* [Jakarta EE8 starter](https://github.com/hantsy/jakartaee8-starter)
* [Article about the starter](https://medium.com/swlh/testing-jakarta-ee-8-applications-9ca250da20e3)