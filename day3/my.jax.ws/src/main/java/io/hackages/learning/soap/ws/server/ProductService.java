package io.hackages.learning.soap.ws.server;

import io.hackages.learning.webservices.soap.ProductRequest;
import io.hackages.learning.webservices.soap.ProductResponse;

public interface ProductService {
	ProductResponse findByName(ProductRequest name);
}
