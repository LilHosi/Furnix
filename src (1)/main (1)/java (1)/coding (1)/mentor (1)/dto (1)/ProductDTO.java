package coding.mentor.dto;

public class ProductDTO {
	private int id;
	private String name;
	private String size;
	private String color;
	private String productCountry;
	private String materials;
	private String description;
	private float price;
	private String image;
	private int categoryId;
	private String brand;
	private String categoryName;
	private String categoryDescription;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getImage() {
		return image;
	}	
	public void setImage(String image) {
		image = "image/" + image + ".jpg";
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
		size = size.replace("/", "<br>");
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		color = color.replace("/", "<br>");
		this.color = color;
	}
	public String getProductCountry() {
		return productCountry;
	}
	public void setProductCountry(String productCountry) {
		this.productCountry = productCountry;
	}
	public String getMaterials() {
		return materials;
	}
	public void setMaterials(String materials) {
		this.materials = materials;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description= description;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public ProductDTO(int id, String name, String size, String color, String productCountry, String materials,
			String description, float price, String image, int categoryId, String brand, String categoryName,
			String categoryDescription) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.color = color;
		this.productCountry = productCountry;
		this.materials = materials;
		this.description = description;
		this.price = price;
		this.image = image;
		this.categoryId = categoryId;
		this.brand = brand;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}
	public ProductDTO() {
		super();
	}
	public ProductDTO(String categoryName, String categoryDescription) {
		super();
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}
	
	
}
