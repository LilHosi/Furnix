package coding.mentor.dto;

import java.util.HashMap;
import java.util.List;

import coding.mentor.entity.ProductDetail;

public class CartDTO {
	private HashMap<ProductDetail, Integer> products;

	public CartDTO(HashMap<ProductDetail, Integer> products) {
		super();
		this.products = products;
	}

	public HashMap<ProductDetail, Integer> getProducts() {
		return products;
	}

	public void setProducts(HashMap<ProductDetail, Integer> products) {
		this.products = products;
	}

	
	
	
	
	
}
