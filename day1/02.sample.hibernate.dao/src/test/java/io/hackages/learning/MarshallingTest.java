package io.hackages.learning;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.hackages.learning.dao.ClientDao;
import io.hackages.learning.dao.OrderDao;
import io.hackages.learning.dao.OrderDetailDao;
import io.hackages.learning.dao.ProductDao;
import io.hackages.learning.model.Category;
import io.hackages.learning.model.Client;
import io.hackages.learning.model.Order;
import io.hackages.learning.model.OrderDetail;
import io.hackages.learning.model.Product;

public class MarshallingTest {

	private static OrderDao orderDao;
	private static ClientDao clientDao;
	private static ProductDao productDao;
	private static OrderDetailDao orderDetailDao;

	@BeforeAll
	public static void setup() {
		orderDao = new OrderDao();
		clientDao = new ClientDao();
		productDao = new ProductDao();
		orderDetailDao = new OrderDetailDao();
	}

	@AfterAll
	public static void tearDown() {
		System.out.println("Dao destroyed");
	}

	@Test
	public void marshallOrdersTest() {
		Client jean = new Client("Jean", "jean@jean.be");
		clientDao.saveClient(jean);

		ArrayList<Product> listOfProducts = new ArrayList<>();

		Product mercedes = new Product("Mercedes GLX", 100, Category.CAR);
		productDao.saveProduct(mercedes);

		Product bmw = new Product("BMW Serie 1", 10, Category.CAR);
		productDao.saveProduct(bmw);

		listOfProducts.add(mercedes);
		listOfProducts.add(bmw);

		OrderDetail orderDetailMercedes = new OrderDetail(mercedes, 1);
		orderDetailDao.saveOrderDetail(orderDetailMercedes);

		OrderDetail orderDetailBmw = new OrderDetail(bmw, 1);
		orderDetailDao.saveOrderDetail(orderDetailBmw);

		Order order = new Order(jean);
		orderDao.saveOrder(order);


		List<Order> orders = orderDao.getOrders();
		orders.stream().forEach(System.out::println);
	}

}
