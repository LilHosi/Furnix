package coding.mentor.entity;

public class DiscountCode {
	private int id;
	private String name;
	private int amount;
	private String expiredDate;
	
	
	
	public DiscountCode() {
		super();
	}
	public DiscountCode(int id, String name, int amount, String expiredDate) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.expiredDate = expiredDate;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}
	
	
}
