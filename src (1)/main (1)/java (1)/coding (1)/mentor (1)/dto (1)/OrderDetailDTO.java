package coding.mentor.dto;


public class OrderDetailDTO {
	private int id;
	private int orderId;
	private int productId;
	private int quantity;
	private String productName;
	private float productPrice;
	private String productImage;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public OrderDetailDTO(int id, int orderId, int productId, int quantity, String productName, float productPrice,
			String productImage) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImage = productImage;
	}
	public OrderDetailDTO() {
		super();
	}
	public OrderDetailDTO(String productName, float productPrice, String productImage) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImage = productImage;
	}
	
	
}