package io.hackages.learning;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.hackages.learning.dao.ClientDao;
import io.hackages.learning.dao.ProductDao;
import io.hackages.learning.model.Category;
import io.hackages.learning.model.Client;
import io.hackages.learning.model.Order;
import io.hackages.learning.model.OrderDetail;
import io.hackages.learning.model.Product;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DummyServiceTopicTest {
	private static ProductDao productDao;
	private static ClientDao clientDao;

	@BeforeAll
	public static void setup() {
		productDao = new ProductDao();
		clientDao = new ClientDao();
		System.out.println("Dao's created");
	}

	@AfterAll
	public static void tearDown() {
		System.out.println("Dao destroyed");
	}

	@Test
	@org.junit.jupiter.api.Order(1)
	public void testInitializeDB() {
		System.out.println("Running testCreate...");

		Product productBird = new Product("bird-food", 5,
										  Category.BIRD_FOOD);
		Product productCat = new Product("cat-food", 5,
										 Category.CAT_FOOD);
		Product productDog = new Product("dog-food", 5,
										 Category.DOG_FOOD);
		Integer id1 = (Integer) productDao.saveProduct(productBird);
		Integer id2 = (Integer) productDao.saveProduct(productCat);
		Integer id3 = (Integer) productDao.saveProduct(productDog);

		Assertions.assertTrue(id1 > 0);
		Assertions.assertTrue(id2 > 0);
		Assertions.assertTrue(id3 > 0);

		Client client1 = new Client("client1", "client1@yahoo.com");
		Client client2 = new Client("client2", "client2@yahoo.com");

		Integer idClient1 = (Integer) clientDao.saveClient(client1);
		Integer idClient2 = (Integer) clientDao.saveClient(client2);

		Assertions.assertTrue(idClient1 > 0);
		Assertions.assertTrue(idClient2 > 0);

		ArrayList<Product> products1 = new ArrayList<>();
		products1.add(productBird);
		products1.add(productCat);

		List<OrderDetail> orderDetails = new ArrayList<>();
		Order order1 = new Order(client1,
								 orderDetails,
								 LocalDate.now());
		orderDetails.add(new OrderDetail(order1, productBird, 2));

		/*
		Order order1 = new Order(client1,
								 products1,
								 LocalDate.now());
		*/

	}

	@Test
	@org.junit.jupiter.api.Order(2)
	public void testList() {
		System.out.println("Running testList...");

		List<Product> resultList = productDao.getProducts();

		Assertions.assertFalse(resultList.isEmpty());
		Assertions.assertEquals(resultList.size(), 3);

		Assertions.assertEquals(resultList.get(0).getName(), "bird-food");
		Assertions.assertEquals(resultList.get(0).getPrice(), 5);
		Assertions.assertEquals(resultList.get(0).getCreatedAt().getYear(), LocalDate.now().getYear());
		Assertions.assertEquals(resultList.get(0).getCategory(), Category.BIRD_FOOD);

		Assertions.assertEquals(resultList.get(1).getName(), "cat-food");
		Assertions.assertEquals(resultList.get(1).getPrice(), 5);
		Assertions.assertEquals(resultList.get(1).getCategory(), Category.CAT_FOOD);

		Assertions.assertEquals(resultList.get(2).getName(), "dog-food");
		Assertions.assertEquals(resultList.get(2).getPrice(), 5);
		Assertions.assertEquals(resultList.get(2).getCategory(), Category.DOG_FOOD);
	}

}
