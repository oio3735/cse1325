public class Customer {
	private String name;
	private String email;

	public Customer(String name, String email){
		validateEmail(email);
		this.name = name;
		this.email = email;
	}

	private void validateEmail(String email){
		if(email == null || !email.contains("@") || !email.contains(".") || email.lastIndexOf(".")) 
			throw new IllegalArgumentException("Invalid email address: " + email);
	}
	@Override
	public String toString() {
		return name + " (" + email + ")";
	}
}