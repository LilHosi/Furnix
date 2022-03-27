package coding.mentor.entity;

public class ProductDetail {
	private long id;
	private String name;
	private String size;
	private String color;
	private String country;
	private String material;
	private String description;
	private String brand;
	private long categoryId;
	private String price;
	private byte[] image;
	private String imageCode;
	
	
	
	public ProductDetail() {
		super();
	}



	public ProductDetail(long id, String name, String size, String color, String country, String material,
			String description, String price, long categoryId, String brand) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.color = color;
		this.country = country;
		this.material = material;
		this.description = description;
		this.brand = brand;
		this.categoryId = categoryId;
		this.price = price;
	}



	public ProductDetail(long id, String name, String size, String color, String country, String material,
			String description, String brand, long categoryId, String price, byte[] image, String imageCode) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.color = color;
		this.country = country;
		this.material = material;
		this.description = description;
		this.brand = brand;
		this.categoryId = categoryId;
		this.price = price;
		this.image = image;
		this.imageCode = imageCode;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSize() {
		return size;
	}



	public void setSize(String size) {
		this.size = size;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getMaterial() {
		return material;
	}



	public void setMaterial(String material) {
		this.material = material;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}







	public long getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public byte[] getImage() {
		return image;
	}



	public void setImage(byte[] image) {
		this.image = image;
	}



	public String getImageCode() {
		return imageCode;
	}



	public void setImageCode(String imageCode) {
		imageCode = "image/" + imageCode +".jpg";
		this.imageCode = imageCode;
	}



	

	
}
