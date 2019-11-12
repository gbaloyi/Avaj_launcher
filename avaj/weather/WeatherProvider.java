package avaj.weather;

// import	avaj.weather.*;
import	avaj.aircraft.*;
import	java.util.Random;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = null;
	private static String[] weather= { "SUN", "RAIN", "FOG", "SNOW"};

	private WeatherProvider() {
	}
	
	public static WeatherProvider	getProvider() {
		if (weatherProvider == null) {
			weatherProvider = new WeatherProvider();
		}
		return weatherProvider;
	}
	
	public String	getCurrentWeather(Coordinates coordinates) {
		Random rand = new Random();
		int rand_int = 0;
		rand_int = rand.nextInt(4);
		return (weather[rand_int]);
	}
}