package coding.mentor.entity;

import java.sql.Date;

public class Account {
	private int id;
	private String pronounce;
	private String firstName;
	private String lastName;
	private String preferredName;
	private String username;
	private String password;
	private String phone;
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPronounce() {
		return pronounce;
	}
	public void setPronounce(String pronounce) {
		this.pronounce = pronounce;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPreferredName() {
		return preferredName;
	}
	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Account(int id, String pronounce, String firstName, String lastName, String preferredName, String username, String email,
			String password, String phone) {
		super();
		this.id = id;
		this.pronounce = pronounce;
		this.firstName = firstName;
		this.lastName = lastName;
		this.preferredName = preferredName;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}
	public Account(String pronounce, String firstName, String lastName, String preferredName, String username,
			String password, String phone, String email) {
		super();
		this.pronounce = pronounce;
		this.firstName = firstName;
		this.lastName = lastName;
		this.preferredName = preferredName;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}
	public Account() {
		super();
	}
	
	
}