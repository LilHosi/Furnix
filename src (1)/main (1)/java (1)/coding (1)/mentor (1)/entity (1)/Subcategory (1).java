package coding.mentor.entity;

public class Subcategory {
	private long id;
	private String name;
	private long categoryId;
	private String description;
	
	
	
	public Subcategory() {
		super();
	}
	public Subcategory(long id, String name, long categoryId, String description) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
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
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
