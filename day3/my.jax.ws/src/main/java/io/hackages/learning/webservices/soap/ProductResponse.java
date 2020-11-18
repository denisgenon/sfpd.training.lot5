package io.hackages.learning.webservices.soap;

public class ProductResponse {
	private ProductRequest productName;

	public ProductResponse(ProductRequest productName) {

		this.productName = productName;
	}

	public ProductRequest getProductName() {
		return productName;
	}

	public void setProductName(ProductRequest productName) {
		this.productName = productName;
	}
}
