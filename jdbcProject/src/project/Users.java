package project;

public class Users {
	//필드
	private String id;
	private String pw;
	private String phone;
	
	//생성자
	public Users(String id, String pw, String phone) {
		this.id = id;
		this.pw = pw;
		this.phone = phone;
	}

	//메소드	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}// end class
