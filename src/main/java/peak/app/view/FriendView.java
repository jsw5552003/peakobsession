package peak.app.view;

public class FriendView {
	
	String userName;
	
	String firstName;
	
	String lastName;
	
	String id;

	public FriendView(String userName, String firstName, String lastName, String id) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}
	
	public FriendView(String userName)
	{
		super();
		this.userName = userName;
	}
	
	public FriendView() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
