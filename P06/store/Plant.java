package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


public class Plant extends Product{
	private Exposure exposure;

	public Plant(String species, int cost, Exposure exposure){
		super("Plant: " + species, cost);
		this.exposure = exposure;
	}

	public Plant(BufferedWriter bw) throws IOException{
		bw.write(exposure.name());
		bw.newLine();
	}

	public void save(BufferedReader br) throws IOException{
		super(br);
		this.exposure = br.readLine();
	}
}
