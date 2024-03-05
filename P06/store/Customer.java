package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Customer {
	private String name;
	private String email;

	public Customer(String name, String email){
		int at = email.indexOf("@");
		int dot = email.indexOf(".", at+1);
		if( at < 0 || dot < 0)
			throw new IllegalArgumentException("Invalid email address" + email);
		this.name = name;
		this.email = email;
	}

	public void save(BufferedWriter bw) throws IOException{
		bw.write(name);
		bw.newLine();
		bw.write(email);
		bw.newLine();
	}

	public Customer(BufferedReader br) throws IOException{
		this.name = br.readLine();
		this.email = br.readLine();
	}

	public String getName(){
		return name;
	}
	@Override
	public String toString (){
 	return String.format("%s (%s)", name, email);
 }
}
	