package avaj.aircraft;

import	avaj.aircraft.*;
import	java.io.*;


public class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		String str = type.toLowerCase();
		if (str.equals("baloon")) {
			return new Baloon(name, coordinates);
		}
		else if (str.equals("jetplane")) {
			return new jetPlane(name, coordinates);
		}
		else if (str.equals("helicopter")) {
			return new Helicopter(name, coordinates);
		} else {
			return null;
		}
	}
}