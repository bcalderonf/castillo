package model;

public class User {
	
	int id;
	String user;
	String password;
	String firstName;
	String lastName;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//Full Constructor
	public User(int id, String user, String password, String firstName, String lastName) {
		this.id = id;
		this.user = user;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	//Empty Constructor
	public User() {
		this.user = "";
		this.password = "";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	

}
