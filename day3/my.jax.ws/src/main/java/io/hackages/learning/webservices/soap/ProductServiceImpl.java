package io.hackages.learning.webservices.soap;

import io.hackages.learning.soap.ws.server.ProductService;
import jakarta.jws.WebService;

@WebService(endpointInterface = "io.hackages.learning.soap.ws.server.ProductService")
public class ProductServiceImpl implements ProductService {

	@Override
	public ProductResponse findByName(ProductRequest productName) {
		return new ProductResponse(productName);
	}
}