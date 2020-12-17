package G22_CENG211_HW1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This is the body of the FileIo class
 * In this class, the file gets read and the objects are created
 * @author Berke Can Kandemir
 */
public class FileIO {
	/**
	 * In this part, the necessary arrays, attributes and objects are defined
	 */
	Scanner citiesFile = null;
	Scanner forecastFile = null;
	City city = null;
	Weather weather = null;
	CityWeather cityWeather = null;
	int skipper;
	CityWeather[][] weeklyForecast;
	
	City[] cities1 = null;
	Region region1 = null;
	int count1 = 0;
	
	City[] cities2 = null;
	Region region2 = null;
	int count2 = 0;
	
	City[] cities3 = null;
	Region region3 = null;
	int count3 = 0;
	
	City[] cities4 = null;
	Region region4 = null;
	int count4 = 0;
	
	City[] cities5 = null;
	Region region5 = null;
	int count5 = 0;
	
	City[] cities6 = null;
	Region region6 = null;
	int count6 = 0;
	
	City[] cities7 = null;
	Region region7 = null;
	int count7 = 0;
	
	/**
	 * This is the constructor of the class
	 * It constructs the arrays and some objects
	 */
	public FileIO() {
		weeklyForecast = new CityWeather[82][7];
		/**
		 * At first, region objects have emoty city arrys but, as the city objects are created,
		 * They are added in the necessary arrays and this arrays will be filled in region objects too because
		 * They point the same memory location
		 */
		cities1 = new City[8];
		region1 = new Region(1, "Akdeniz", cities1);
		
		cities2 = new City[14];
		region2 = new Region(2, "Doğu Anadolu", cities2);
		
		cities3 = new City[8];
		region3 = new Region(3, "Ege", cities3);
		
		cities4 = new City[9];
		region4 = new Region(4, "Güneydoğu Anadolu", cities4);
		
		cities5 = new City[13];
		region5 = new Region(5, "İç Anadolu", cities5);
		
		cities6 = new City[18];
		region6 = new Region(6, "Karadeniz", cities6);
		
		cities7 = new City[11];
		region7 = new Region(7, "Marmara", cities7);

		try {
			citiesFile = new Scanner(new File("CENG211_HW1_Cities.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("Cities file not found!");
		}
		try {
			forecastFile = new Scanner(new File("CENG211_HW1_WeeklyForecast.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("Forecast file not found!");
		}
	}
	
	/**
	 * This method is the heart of the program
	 * It reads all the data and creates all the objects that are necessary
	 * @return CityWeather[][] The necessary objects that stores weather forecast data
	 */
	public CityWeather[][] fileReader() {
		/**
		 * This part creates the city objects and add them to their arrays
		 */
		while (citiesFile.hasNextLine()) {
			String line = citiesFile.nextLine();
			String[] lineArr = line.split(",");
			int plate = Integer.parseInt(lineArr[0]);
			String name = lineArr[1];
			int regionID = Integer.parseInt(lineArr[2]);
			int altitude = Integer.parseInt(lineArr[4]);
			if (regionID == 1) {
				city = new City(plate, name, region1, altitude);
				cities1[count1] = city;
				count1++;
			} else if (regionID == 2) {
				city = new City(plate, name, region2, altitude);
				cities2[count2] = city;
				count2++;
			} else if (regionID == 3) {
				city = new City(plate, name, region3, altitude);
				cities3[count3] = city;
				count3++;
			} else if (regionID == 4) {
				city = new City(plate, name, region4, altitude);
				cities4[count4] = city;
				count4++;
			} else if (regionID == 5) {
				city = new City(plate, name, region5, altitude);
				cities5[count5] = city;
				count5++;
			} else if (regionID == 6) {
				city = new City(plate, name, region6, altitude);
				cities6[count6] = city;
				count6++;
			} else {
				city = new City(plate, name, region7, altitude);
				cities7[count7] = city;
				count7++;
			}
			
		}
		/**
		 * This part creates the weather objects and combine their cities and weather data in the CityWeather array
		 */
		while (forecastFile.hasNextLine()) {
			skipper = 0; // This is here because we don't want the program to iterate all the for loops if it is not necessary
			String line = forecastFile.nextLine();
			String[] lineArr = line.split(",");
			int plate = Integer.parseInt(lineArr[0]);
			String date = lineArr[1];
			int wind = Integer.parseInt(lineArr[2]);
			int temperature = Integer.parseInt(lineArr[3]);
			int FLtemperature = Integer.parseInt(lineArr[4]);
			int humidity = Integer.parseInt(lineArr[5]);
			int precipitation = Integer.parseInt(lineArr[6]);
			String visibility = lineArr[7];
			
			weather = new Weather(wind, temperature, FLtemperature, humidity, precipitation, visibility);
			
			if (skipper == 0) {
				for (City i : cities1) {
					if (i.getPlateNo() == plate) {
						cityWeather = new CityWeather(i, weather, date);
						skipper++;
					}
				}
			}
			
			if (skipper == 0) {
				for (City i : cities2) {
					if (i.getPlateNo() == plate) {
						cityWeather = new CityWeather(i, weather, date);
						skipper++;
					}
				}
			}
			
			if (skipper == 0) {
				for (City i : cities3) {
					if (i.getPlateNo() == plate) {
						cityWeather = new CityWeather(i, weather, date);
						skipper++;
					}
				}
			}
			
			if (skipper == 0) {
				for (City i : cities4) {
					if (i.getPlateNo() == plate) {
						cityWeather = new CityWeather(i, weather, date);
						skipper++;
					}
				}
			}
			
			if (skipper == 0) {
				for (City i : cities5) {
					if (i.getPlateNo() == plate) {
						cityWeather = new CityWeather(i, weather, date);
						skipper++;
					}
				}
			}
			
			if (skipper == 0) {
				for (City i : cities6) {
					if (i.getPlateNo() == plate) {
						cityWeather = new CityWeather(i, weather, date);
						skipper++;
					}
				}
			}
			
			if (skipper == 0) {
				for (City i : cities7) {
					if (i.getPlateNo() == plate) {
						cityWeather = new CityWeather(i, weather, date);
						skipper++;
					}
				}
			}
			
			if (date.equals("14.10.2019")) {
				weeklyForecast[plate][0] = cityWeather;
			} else if (date.equals("15.10.2019")) {
				weeklyForecast[plate][1] = cityWeather;
			} else if (date.equals("16.10.2019")) {
				weeklyForecast[plate][2] = cityWeather;
			} else if (date.equals("17.10.2019")) {
				weeklyForecast[plate][3] = cityWeather;
			} else if (date.equals("18.10.2019")) {
				weeklyForecast[plate][4] = cityWeather;
			} else if (date.equals("19.10.2019")) {
				weeklyForecast[plate][5] = cityWeather;
			} else if (date.equals("20.10.2019")) {
				weeklyForecast[plate][6] = cityWeather;
			}
		}
		
		return weeklyForecast;
	}
}
