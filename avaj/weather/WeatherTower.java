package avaj.weather;

import avaj.weather.*;
import avaj.aircraft.*;

public class WeatherTower extends Tower {
	
	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}
	void	changeWeather() {
		this.conditionsChanged();
	}
}