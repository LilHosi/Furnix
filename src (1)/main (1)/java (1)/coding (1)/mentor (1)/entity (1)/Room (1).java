package coding.mentor.entity;

public class Room {
	private long id;
	private String name;
	private String imageCode;
	
	
	public Room() {
		super();
	}
	public Room(long id, String name, String imageCode) {
		super();
		this.id = id;
		this.name = name;
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
	public String getImageCode() {
		return imageCode;
	}
	public void setImageCode(String imageCode) {
		imageCode = "image/room" + imageCode +".jpg";
		this.imageCode = imageCode;
	}
	
	
	
}
