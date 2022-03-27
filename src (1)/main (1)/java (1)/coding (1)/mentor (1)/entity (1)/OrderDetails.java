package coding.mentor.entity;

public class OrderDetails {
	private int id;
	private int orderId;
	private int productId;
	private int quantity;
	
	public OrderDetails() {
		
	}
	
	
	public OrderDetails(int orderId, int productId, int quantity) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}

	
	public OrderDetails(int orderId, int productId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
