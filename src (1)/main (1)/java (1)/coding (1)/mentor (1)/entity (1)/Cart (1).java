package coding.mentor.entity;

public class Cart extends ProductDetail {
	private int quantity;
	

	public Cart() {
		super();
	}

	public Cart(int quantity) {
		super();
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
