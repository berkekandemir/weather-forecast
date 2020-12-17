package G22_CENG211_HW1;
import java.util.*;
import java.lang.Math;

/**
 * This is where the background of the operations that the program does
 * @author BErke Can Kandemir
 */
public class WeatherQuery {
	FileIO fileIO = new FileIO();
	CityWeather[][] weeklyForecast = fileIO.fileReader();
	/**
	 * This method traverses the the cities and check their feels-like temperature values
	 * Then, finds the minimum feels-like temperature value
	 * Lastly, prints out the cities that have the same feels-like temperature value
	 */
	public void minFLTemperature() {
		int minFLT = 1000;
		String[] cities = new String[81];
		int index = 0;
		for (int i = 1; i < weeklyForecast.length; i++) {
			for (int j = 0; j < weeklyForecast[i].length; j++) {
				if (weeklyForecast[i][j].getWeather().getFLtemperature() <= minFLT) {
					minFLT = weeklyForecast[i][j].getWeather().getFLtemperature();
				}
			}
		}
		for (int i = 1; i < weeklyForecast.length; i++) {
			for (int j = 0; j < weeklyForecast[i].length; j++) {
				if (weeklyForecast[i][j].getWeather().getFLtemperature() == minFLT) {
					cities[index] = weeklyForecast[i][j].getCity().getName();
					index++;
				}
			}
		}
		System.out.print("1) ");
		for (int i = 0; i < cities.length; i++) {
			if ((cities[i] != null) && (cities[i + 1] != null)){
				System.out.print(cities[i] + ", ");
			} else if (cities[i] != null) {
				System.out.println(cities[i]);
			}
		}
	}
	/**
	 * This method traverses the cities and find the top three cities that have the highest temperature variation
	 * Plus, it checks whether there is any more city that has the same temperature variation level with one of the top three cities
	 */
	public void highTempVar() {
		int temporary = -1;
		int temp = 0;
		float mean;
		int counter;
		double sd1 = 0;
		double sd2;
		double sdFinal;
		int[] tempArr;
		double[] devArr = new double[81];
		String[] cityArr = new String[81];
		for (int i = 1; i < weeklyForecast.length; i++) {
			sd1 = 0;
			counter = 0;
			temp = 0;
			tempArr = new int[7];
			for (int j = 0; j < weeklyForecast[i].length; j++) {
				tempArr[counter] = weeklyForecast[i][j].getWeather().getTemperature();
				counter++;
				temporary = j;
			}
			for (int k : tempArr) {
				temp = temp + k;
			}
			mean = temp / 7;
			for (int m : tempArr) {
				sd1 = sd1 + ((m - mean)*(m - mean));
			}
			sd2 = sd1 / 6;
			sdFinal = Math.sqrt(sd2);
			boolean isFirst = true;
			for (int index = 0; index < devArr.length; index++) {
				if ((sdFinal > devArr[index]) && (isFirst == true)) {
					devArr[index] = sdFinal;
					cityArr[index] = weeklyForecast[i][temporary].getCity().getName();
					isFirst = false;
				} else if ((sdFinal < devArr[index]) && (sdFinal >= devArr[index + 1]) && (cityArr[index].equals(weeklyForecast[i][temporary].getCity().getName()))){
					devArr[index + 1] = sdFinal;
					cityArr[index + 1] = weeklyForecast[i][temporary].getCity().getName();
					
				}
			}
		}
		System.out.print("2) " + cityArr[0]);
		System.out.print(", " + cityArr[1]);
		System.out.print(", " + cityArr[2]);
		for (int i = 1; i < devArr.length; i++) {
			if ((devArr[i - 1] == devArr[i]) && (cityArr[i] != null)) {
				System.out.print(", " + cityArr[i]);
			}
		}
	}
	/**
	 * This is the most complicated method of the class
	 * It reaches the region values first, then the region's cities' humidity values
	 * Then, it adds the humidity levels for all the regions one by one
	 * and for only one time for every region.
	 * Then, it calculates the average values for all regions
	 * Lastly, it uses the private max method to find the max average and prints out the region of the value
	 */
	public void highAveHum() {
		int plate;
		int humArrCity = 0;
		int[] humDogu = new int [20];
		int[] humIc = new int [20];
		int[] humKaradeniz = new int [20];
		int[] humAkdeniz = new int [20];
		int[] humEge = new int [20];
		int[] humGuney = new int [20];
		int[] humMarmara = new int [20];
		int counter = 0;
		Region region;
		int dogu = 0;
		int ic = 0;
		int karadeniz = 0;
		int akdeniz = 0;
		int ege = 0;
		int guney = 0;
		int marmara = 0;
		for (int i = 1; i < weeklyForecast.length; i++) {
			for (int j = 0; j < weeklyForecast[i].length; j++) {
				region = weeklyForecast[i][j].getCity().getRegion();
				counter = 0;
				if ((region.getName().equals("Akdeniz")) && (akdeniz == 0)) {
					for (City city : region.getCities()) {
						plate = city.getPlateNo();
						for (int m = 0; m < weeklyForecast[plate].length; m++) {
							humArrCity = humArrCity +  weeklyForecast[plate][m].getWeather().getHumidity();
						}
						humAkdeniz[counter] = humArrCity / 7;
						humArrCity = 0;
						counter++;
						akdeniz++;
					}
				} else if ((region.getName().equals("Doğu Anadolu")) && (dogu == 0)) {
					for (City city : region.getCities()) {
						plate = city.getPlateNo();
						for (int m = 0; m < weeklyForecast[plate].length; m++) {
							humArrCity = humArrCity +  weeklyForecast[plate][m].getWeather().getHumidity();
						}
						humDogu[counter] = humArrCity / 7;
						humArrCity = 0;
						counter++;
						dogu++;
					}
				} else if ((region.getName().equals("Ege")) && (ege == 0)) {
					for (City city : region.getCities()) {
						plate = city.getPlateNo();
						for (int m = 0; m < weeklyForecast[plate].length; m++) {
							humArrCity = humArrCity +  weeklyForecast[plate][m].getWeather().getHumidity();
						}
						humEge[counter] = humArrCity / 7;
						humArrCity = 0;
						counter++;
						ege++;
					}
				} else if ((region.getName().equals("Güneydoğu Anadolu")) && (guney == 0)) {
					for (City city : region.getCities()) {
						plate = city.getPlateNo();
						for (int m = 0; m < weeklyForecast[plate].length; m++) {
							humArrCity = humArrCity +  weeklyForecast[plate][m].getWeather().getHumidity();
						}
						humGuney[counter] = humArrCity / 7;
						humArrCity = 0;
						counter++;
						guney++;
					}
				} else if ((region.getName().equals("İç Anadolu")) && (ic == 0)) {
					for (City city : region.getCities()) {
						plate = city.getPlateNo();
						for (int m = 0; m < weeklyForecast[plate].length; m++) {
							humArrCity = humArrCity +  weeklyForecast[plate][m].getWeather().getHumidity();
						}
						humIc[counter] = humArrCity / 7;
						humArrCity = 0;
						counter++;
						ic++;
					}
				} else if ((region.getName().equals("Karadeniz")) && (karadeniz == 0)) {
					for (City city : region.getCities()) {
						plate = city.getPlateNo();
						for (int m = 0; m < weeklyForecast[plate].length; m++) {
							humArrCity = humArrCity +  weeklyForecast[plate][m].getWeather().getHumidity();
						}
						humKaradeniz[counter] = humArrCity / 7;
						humArrCity = 0;
						counter++;
						karadeniz++;
					}
				} else if ((region.getName().equals("Marmara")) && (marmara == 0)) {
					for (City city : region.getCities()) {
						plate = city.getPlateNo();
						for (int m = 0; m < weeklyForecast[plate].length; m++) {
							humArrCity = humArrCity +  weeklyForecast[plate][m].getWeather().getHumidity();
						}
						humMarmara[counter] = humArrCity / 7;
						humArrCity = 0;
						counter++;
						marmara++;
					}
				}
			}
		}
		int temp = 0;
		int count = 0;
		int aveAkdeniz;
		int aveDogu;
		int aveEge;
		int aveGuney;
		int aveIc;
		int aveKaradeniz;
		int aveMarmara;
		
		for (int i : humAkdeniz) {
			if (i != 0) {
				count++;
				temp = temp + i;
			}
		}
		aveAkdeniz = temp / count;
		count = 0;
		temp = 0;
		
		for (int i : humDogu) {
			if (i != 0) {
				count++;
				temp = temp + i;
			}
		}
		aveDogu = temp / count;
		count = 0;
		temp = 0;
		
		for (int i : humEge) {
			if (i != 0) {
				count++;
				temp = temp + i;
			}
		}
		aveEge = temp / count;
		count = 0;
		temp = 0;
		
		for (int i : humGuney) {
			if (i != 0) {
				count++;
				temp = temp + i;
			}
		}
		aveGuney = temp / count;
		count = 0;
		temp = 0;
		
		for (int i : humIc) {
			if (i != 0) {
				count++;
				temp = temp + i;
			}
		}
		aveIc = temp / count;
		count = 0;
		temp = 0;
		
		for (int i : humKaradeniz) {
			if (i != 0) {
				count++;
				temp = temp + i;
			}
		}
		aveKaradeniz = temp / count;
		count = 0;
		temp = 0;
		
		for (int i : humMarmara) {
			if (i != 0) {
				count++;
				temp = temp + i;
			}
		}
		aveMarmara = temp / count;
		count = 0;
		temp = 0;
		
		int[] reg = new int[7];
		reg[0] = aveAkdeniz;
		reg[1] = aveDogu;
		reg[2] = aveEge;
		reg[3] = aveGuney;
		reg[4] = aveIc;
		reg[5] = aveKaradeniz;
		reg[6] = aveMarmara;
		
		int result = max(reg);
		System.out.println("");
		if (result == 0) {
			System.out.println("3) Akdeniz");
		} else if (result == 1) {
			System.out.println("3) Doğu Anadolu");
		} else if (result == 2) {
			System.out.println("3) Ege");
		} else if (result == 3) {
			System.out.println("3) Güneydoğu Anadolu");
		} else if (result == 4) {
			System.out.println("3) İç Anadolu");
		} else if (result == 5) {
			System.out.println("3) Karadeniz");
		} else if (result == 6) {
			System.out.println("3) Marmara");
		}
		
	}
	/**
	 * This is the helper method for finding the max value of an array
	 * @param array The given array
	 * @return result The location of the array that stores the max value 
	 */
	private static int max(int[] array) {
		int result = -1;
		if (array.length == 0) {
			return -1;
		} else {
			int max = array[0];
			for (int i = 0; i < array.length; i++) {
				if (array[i] > max) {
					max = array[i];
					result = i;
				}
			}
			return result;
		}
	}
	/**
	 * This method traverses the cities and find the city that has the maximum altitude value
	 * Then, it calculates the temperature value and then the average of them
	 */
	public void meanHighAlt() {
		String name = null;
		int counter = 0;
		float temp = 0;
		int maxAlt = 0;
		float mean = -1;
		for (int i = 1; i < weeklyForecast.length; i++) {
			for (int j = 0; j < weeklyForecast[i].length; j++) {
				if (weeklyForecast[i][j].getCity().getAltitude() >= maxAlt) {
					maxAlt = weeklyForecast[i][j].getCity().getAltitude();
				}
			}
		}
		for (int i = 1; i < weeklyForecast.length; i++) {
			for (int j = 0; j < weeklyForecast[i].length; j++) {
				if (weeklyForecast[i][j].getCity().getAltitude() == maxAlt) {
					temp = temp + weeklyForecast[i][j].getWeather().getTemperature();
					name = weeklyForecast[i][j].getCity().getName();
					counter++;
				}
			}
		}
		mean = temp / counter;
		System.out.print("4) " + name + " --> " + mean + ", ");
	}
	/**
	 * This method traverses the cities and find the city that has the minimum altitude value
	 * Then, it calculates the temperature value and then the average of them
	 */
	public void meanLowAlt() {
		String name = null;
		int counter = 0;
		float temp = 0;
		int minAlt = 2000;
		float mean = -1;
		for (int i = 1; i < weeklyForecast.length; i++) {
			for (int j = 0; j < weeklyForecast[i].length; j++) {
				if (weeklyForecast[i][j].getCity().getAltitude() <= minAlt) {
					minAlt = weeklyForecast[i][j].getCity().getAltitude();
				}
			}
		}
		for (int i = 1; i < weeklyForecast.length; i++) {
			for (int j = 0; j < weeklyForecast[i].length; j++) {
				if (weeklyForecast[i][j].getCity().getAltitude() == minAlt) {
					temp = temp + weeklyForecast[i][j].getWeather().getTemperature();
					name = weeklyForecast[i][j].getCity().getName();
					counter++;
				}
			}
		}
		mean = temp / counter;
		System.out.println(name + " --> " + mean);
	}
	/**
	 * This method traverses the cities and checks the precipitation values of them
	 * If the target precipitation value is caught, then it prints out the city
	 */
	public void RainyCities() {
		int targetPrec = 80;
		int counter;
		int nextLine = 0;
		System.out.print("5) ");
		for (int i = 1; i < weeklyForecast.length; i++) {
			counter = 0;
			for (int j = 1; j < 3; j++) {
				if ((weeklyForecast[i][j].getWeather().getPrecipitation() >= targetPrec) && (counter == 0)) {
					if (i == (weeklyForecast.length - 1) && (j == 2)) {
						System.out.print(weeklyForecast[i][j].getCity().getName());
						counter = 1;
					} else {
						System.out.print(weeklyForecast[i][j].getCity().getName() + ", ");
						counter = 1;
						nextLine++;
						if (nextLine == 8) {
							System.out.println("");
							System.out.print("   ");
							nextLine = 0;
						}
					}
				}
			}
		}
	}
	/**
	 * This method traverses the cities and checks the target cities wind values and visibility levels
	 * If they match with the target values, then it prints out the dates
	 */
	@SuppressWarnings("resource")
	public void flyableDates() {
		int targetWind = 40;
		String[] dates = new String[7];
		int index = 0;
		boolean isFirst = true;
		System.out.println("");
		Scanner keyboard = new Scanner(System.in);
		System.out.print("6) Enter the city name to see flyable dates: ");
		String name = keyboard.next();
		for (int i = 1; i < weeklyForecast.length; i++) {
			for (int j = 0; j < weeklyForecast[i].length; j++) {
				if ((weeklyForecast[i][j].getCity().getName().equals(name)) && (weeklyForecast[i][j].getWeather().getWind() <= targetWind)){
					if ((weeklyForecast[i][j].getWeather().getVisibility().equals("medium")) || (weeklyForecast[i][j].getWeather().getVisibility().equals("high"))) {
						dates[index] = weeklyForecast[i][j].getDate();
						index++;
					}
				}
			}
		}
		for (int i = 0; i < dates.length; i++) {
			if ((dates[i] != null) && (dates[i + 1] != null)){
				if (isFirst) {
					System.out.print("   " + dates[i] + ", ");
					isFirst = false;
				} else {
					System.out.print(dates[i] + ", ");
				}
			} else if (dates[i] != null) {
				System.out.println(dates[i]);
			}
		}
	}
}
