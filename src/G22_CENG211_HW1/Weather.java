package G22_CENG211_HW1;

/**
 * This is the body of the Weather class
 * @author Berke Can Kandemir
 */
public class Weather {
	private int wind;
	private int temperature;
	private int FLtemperature;
	private int humidity;
	private int precipitation;
	private String visibility;
	/**
	 * The constructor of the class
	 * @param wind The given wind value
	 * @param temperature The given temperature value
	 * @param FLtemperature The given feels-like temperature value
	 * @param humidity The given humidity value
	 * @param precipitation The given precipitation value
	 * @param visibility The given visibility level
	 */
	public Weather(int wind, int temperature, int FLtemperature, int humidity, int precipitation, String visibility) {
		this.wind = wind;
		this.temperature = temperature;
		this.FLtemperature = FLtemperature;
		this.humidity = humidity;
		this.precipitation = precipitation;
		this.visibility = visibility;
	}
	/**
	 * This method gets the wind value
	 * @return wind The wind value
	 */
	public int getWind() {
		return wind;
	}
	/**
	 * This method sets the wind value
	 * @param wind The given wind value
	 */
	public void setWind(int wind) {
		this.wind = wind;
	}
	/**
	 * This method gets the temperature value
	 * @return temperature The temperature value
	 */
	public int getTemperature() {
		return temperature;
	}
	/**
	 * This method sets the temperature value
	 * @param temperature The given temperature value
	 */
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	/**
	 * This method gets the feels-like temperature value
	 * @return FLtemperature The feels-like temperature value
	 */
	public int getFLtemperature() {
		return FLtemperature;
	}
	/**
	 * This method sets the feels-like temperature value
	 * @param FLtemperature The given feels-like temperature value
	 */
	public void setFLtemperature(int FLtemperature) {
		this.FLtemperature = FLtemperature;
	}
	/**
	 * This method gets the humidity value
	 * @return humidity The humidity value
	 */
	public int getHumidity() {
		return humidity;
	}
	/**
	 * This method sets the humidity value
	 * @param humidity The given humidity value
	 */
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	/**
	 * This method gets the precipitation value
	 * @return precipitation The precipitation value
	 */
	public int getPrecipitation() {
		return precipitation;
	}
	/**
	 * This method sets the precipitation value
	 * @param precipitation The given precipitation value
	 */
	public void setPrecipitation(int precipitation) {
		this.precipitation = precipitation;
	}
	/**
	 * This method gets the visibility level
	 * @return visibility The visibility level
	 */
	public String getVisibility() {
		return visibility;
	}
	/**
	 * This method sets the visibility level
	 * @param visibility The the visibility level
	 */
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
}
