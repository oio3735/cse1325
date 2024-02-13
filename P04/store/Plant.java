package store;


public class Plant extends Product{
	private Exposure exposure;

	public Plant(String species, int cost, Exposure exposure){
		super("Plant: " + species, cost);
		this.exposure = exposure;
	}
}