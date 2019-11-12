package avaj.aircraft;

import avaj.aircraft.*;
import avaj.weather.*;

public interface Flyable {
	
	public Coordinates getCoordinates();
	public void updateConditions();
	public	void registerTower(WeatherTower weatherTower);
}