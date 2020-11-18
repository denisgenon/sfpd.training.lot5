# Day 1 : Hibernate 

## Instructions 

1. for each topic, create a new module based on one of the samples
1. Use a TDD or BDD approach to solve the challenges

## Topic : Hibernate supports Java 8 

* Add the necessary dependency to the new module `pom.xml`
```xml
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-java8</artifactId>
			<version>5.3.7.Final</version>
		</dependency>
```
* Add the following fields to the Entity
```java
LocalDate createdAt = LocalDate.of(2020, 1, 2);
LocalDateTime updatedAt = LocalDateTime.of(2020, 3, 4, 5, 6);
```

   * After an entity is created, verify the values of those properties 

* Use Streams for fetching query results
    * [Tutorial](https://thorben-janssen.com/get-query-results-stream-hibernate-5) 

## Topic : Entities Relationship workshop

Here is the subject 
1. You are part of a team responsible for the design and implementation of a company information system. 
1. The company offers Products. Each product has a name, description, regular price ... 
1. The product categories are CAT_FOOD, DOG_FOOD, BIRD_FOOD
1. The company's clients are registered with a alias and an email address ... 
1. A client's order contains at least 1 product and the purchase date 
1. For each completed order an invoice is generated 

### What is expected ? 
* Test a service (with your own dummy data) that initialize the db with :  
    * At least 3 products (1 per category)
    * At least 2 clients
* Test a service that handles clients orders
* Test a service that verifies the content of generated invoices, use Criteria
    * Article on [JPA Criteria](https://www.baeldung.com/hibernate-criteria-queries)
* After adding more dummy data, Test a service that evaluates the most purchased product    

### Bonus : Interoperability
* Switch to a PostGreSQL or Maria DB on Docker instead of H2 

## Online Resources
* [Hibernate User Guide](https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html)
* [Hibernate CRUD](https://www.baeldung.com/hibernate-save-persist-update-merge-saveorupdate)
* [JUnit 5 CRUD with Hibernate](https://www.codejava.net/testing/junit-5-tutorial-for-beginner-test-crud-for-hibernate)
