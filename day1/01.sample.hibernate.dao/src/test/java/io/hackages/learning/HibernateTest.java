package io.hackages.learning;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.hackages.learning.dao.ProductDao;
import io.hackages.learning.model.Product;

@TestMethodOrder(OrderAnnotation.class)
public class HibernateTest {

	private static ProductDao productDao;

	@BeforeAll
	public static void setup() {
		productDao = new ProductDao();
		System.out.println("Dao created");
	}

	@AfterAll
	public static void tearDown() {
		System.out.println("Dao destroyed");
	}

	@Test
	@Order(1)
	public void testCreate() {
		System.out.println("Running testCreate...");

		Product product = new Product("my Phone v1", 699);

		product.setCreatedAt(LocalDate.of(2020, 1, 2));
		product.setUpdatedAt(LocalDateTime.of(2020, 3, 4, 5, 6));

		Integer id = (Integer) productDao.saveProduct(product);

		List<Product> products = productDao.getProducts();

		Assertions.assertEquals(1, products.size());

		Product expectedProduct = products.get(0);
		Assertions.assertEquals(1, expectedProduct.getCreatedAt().getMonthValue());
		Assertions.assertEquals(LocalDateTime.of(2020, 3, 4, 5, 6), expectedProduct.getUpdatedAt());
		Assertions.assertTrue(id > 0);
	}

	@Test
	@Order(2)
	public void testList() {
		System.out.println("Running testList...");

		List<Product> resultList = productDao.getProducts();

		Assertions.assertFalse(resultList.isEmpty());
		Assertions.assertEquals(resultList.size(), 1);
	}

}