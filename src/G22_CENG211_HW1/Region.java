package G22_CENG211_HW1;

/**
 * This is the body of the region class
 * @author Berke Can Kandemir
 */
public class Region {
	private int id;
	private String name;
	private City[] cities;
	/**
	 * This is the constructor of the class
	 * @param id The given id value of the region
	 * @param name The given name of the region
	 * @param cities The given City object array of the region
	 */
	public Region(int id, String name, City[] cities) {
		this.id = id;
		this.name = name;
		this.cities = cities;
	}
	/**
	 * This method gets the ID number of the region
	 * @return ID The Id number of the region
	 */
	public int getId() {
		return id;
	}
	/**
	 * This method sets the ID value of the region
	 * @param id The given Id value
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Ths method gets the name of the region
	 * @return name The name of the region
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method sets the name of the region
	 * @param name The name of the region
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This method gets the city array of the region
	 * @return cities The City array of the region
	 */
	public City[] getCities() {
		return cities;
	}
	/**
	 * This method sets the city array of the region
	 * @param cities The given city array
	 */
	public void setCities(City[] cities) {
		this.cities = cities;
	}
}
