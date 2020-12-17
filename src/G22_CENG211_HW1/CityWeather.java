package G22_CENG211_HW1;
/**
 * This is the body of the CityWeather class
 * @author Berke Can Kandemir
 *
 */
public class CityWeather {
	private City city;
	private Weather weather;
	private String date;
	/**
	 * The constructor of the class
	 * @param city The given city object 
	 * @param weather The given weather object
	 * @param date The given date value
	 */
	public CityWeather(City city, Weather weather, String date) {
		this.city = city;
		this.weather = weather;
		this.date = date;
	}
	/**
	 * This method gets the city object
	 * @return The city object
	 */
	public City getCity() {
		return city;
	}
	/**
	 * This method sets the city object
	 * @param city The given city object
	 */
	public void setCity(City city) {
		this.city = city;
	}
	/**
	 * This method gets the weather object
	 * @return The weather object
	 */
	public Weather getWeather() {
		return weather;
	}
	/**
	 * This method sets the weather object
	 * @param weather The given weather object
	 */
	public void setWeather(Weather weather) {
		this.weather = weather;
	}
	/**
	 * This method gets the date value of the object
	 * @return The date value
	 */
	public String getDate() {
		return date;
	}
	/**
	 * This method sets the date value of the object
	 * @param date The given date value
	 */
	public void setDate(String date) {
		this.date = date;
	}	
}
