package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Tool extends Product {
	public Tool(String name, int cost){
		super(name, cost);
	}
	public Tool(BufferedReader br) throws IOException{
		super(br):
	}
}