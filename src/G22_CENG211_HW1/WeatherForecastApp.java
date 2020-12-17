package G22_CENG211_HW1;

/**
 * This is the main class of the program
 * It calls the necessary methods and perform the operations
 * @author Berke Can Kandemir
 */
public class WeatherForecastApp {
	
	public static void main(String[] args) {
		WeatherQuery weatherQuery = new WeatherQuery();
		weatherQuery.minFLTemperature();
		weatherQuery.highTempVar();
		weatherQuery.highAveHum();
		weatherQuery.meanHighAlt();
		weatherQuery.meanLowAlt();
		weatherQuery.RainyCities();
		weatherQuery.flyableDates();
	}

}
