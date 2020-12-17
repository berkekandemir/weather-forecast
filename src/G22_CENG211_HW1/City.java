package G22_CENG211_HW1;

/**
 * This is the body of the city class
 * @author Berke Can Kandemir
 */
public class City {
	private int plateNo;
	private String name;
	private Region region;
	private int altitude;
	/**
	 * The constructor of the class
	 * @param plateNo The given plate number
	 * @param name The given city name
	 * @param region The given region
	 * @param altitude the given altitude
	 */
	public City(int plateNo, String name, Region region, int altitude) {
		this.plateNo = plateNo;
		this.name = name;
		this.region = region;
		this.altitude = altitude;
	}
	/**
	 * This method gets the plate number of the city object
	 * @return The integer value of plate number
	 */
	public int getPlateNo() {
		return plateNo;
	}
	/**
	 * This method sets the plate number of the city object
	 * @param plateNo The given plate number
	 */
	public void setPlateNo(int plateNo) {
		this.plateNo = plateNo;
	}
	/**
	 * This method gets the name of the object
	 * @return Name of the city
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method gets the region object of the city object
	 * @return The region object of the city
	 */
	public Region getRegion() {
		return region;
	}
	/**
	 * This method sets the region value
	 * @param region The region object
	 */
	public void setRegion(Region region) {
		this.region = region;
	}
	/**
	 * This method sets the name of the city
	 * @param name The given name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This method gets the altitude value of the city
	 * @return The integer value of the altitude
	 */
	public int getAltitude() {
		return altitude;
	}
	/**
	 * This method sets the altitude value of the object
	 * @param altitude The integer value of the altitude
	 */
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}
}
