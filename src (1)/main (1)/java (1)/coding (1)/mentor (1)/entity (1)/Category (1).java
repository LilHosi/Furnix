package coding.mentor.entity;

public class Category {
	private long id;
	private String name;
	private String description;
	private byte[] image;
	private String imageCode;
	
	
	
	
	public Category() {
		super();
	}
	
	
	
	public Category(long id, String name, String description, byte[] image, String imageCode) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.imageCode = imageCode;
	}



	public Category(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
		this.imageCode = imageCode;
	}
	
	
}
