package avaj.aircraft;

import	avaj.weather.*;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower _weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public	void	updateConditions() {
		String weather = this._weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
				if (this.coordinates.getHeight() > 100)
					this.coordinates.setHeight(100);
				WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "(" + this.id + "): Hmmm the day is hot!!!");
				break;
			case "RAIN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
				WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "(" + this.id + "):The rain is heavy!!!");
				break;
			case "FOG":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
				WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "(" + this.id + "): I dont like fog because i cant see!!!");
				break;
			case "SNOW":
				this.coordinates.setHeight(this.coordinates.getHeight() - 12);
				WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "(" + this.id + "):Oops i am freezing up here!!!");
			break;
			default:
			WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "(" + this.id + "): The weather tower doesnt respond!");
			break;
		}
		if (this.coordinates.getHeight() <= 0) {
			WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "(" + this.id + ") landing.");
			WriteFile.getWriteFile().writetofile("Tower  says: Helicopter#" + this.name + "(" + this.id + ")" + " Not registered from the weather tower.");
		}
	}

	public	void	registerTower(WeatherTower weatherTower) {
		this._weatherTower = weatherTower;
		WriteFile.getWriteFile().writetofile("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " Registered to the weather tower.");
		weatherTower.register(this);
	}

}