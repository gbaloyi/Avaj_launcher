package avaj.aircraft;

import	avaj.weather.*;

public class jetPlane extends Aircraft implements Flyable {
	private WeatherTower _weatherTower;

	jetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);		
	}

	public	void	updateConditions() {
		String weather = this._weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN":
				this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
				if (this.coordinates.getHeight() > 100)
					this.coordinates.setHeight(100);
				WriteFile.getWriteFile().writetofile("JetPlane#" + this.name + "(" + this.id + "):Aaaaish this sun is very strong!!!");
				break;
			case "RAIN":
				this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
				WriteFile.getWriteFile().writetofile("JetPlane#" + this.name + "(" + this.id + "):The rain is very heavy and i am afraid!!!");
				break;
			case "FOG":
				this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
				WriteFile.getWriteFile().writetofile("JetPlane#" + this.name + "(" + this.id + "): Oooops the fog disturbs me to see outside!!!");
				break;
			case "SNOW":
				this.coordinates.setHeight(this.coordinates.getHeight() - 12);
				WriteFile.getWriteFile().writetofile("JetPlane#" + this.name + "(" + this.id + "): The snow is too much i am freezing up here!!!");
				break;
			default:
			WriteFile.getWriteFile().writetofile("JetPlane#" + this.name + "(" + this.id + "): I cant get hold of the weather tower!!!");
			break;
		}
		if (this.coordinates.getHeight() <= 0) {
			WriteFile.getWriteFile().writetofile("JetPlane#" + this.name + "(" + this.id + ") landing.");
			WriteFile.getWriteFile().writetofile("Tower  says: JetPlane#" + this.name + "(" + this.id + ")" + " Not registered from the weather tower.");
		}
	}

	public	void	registerTower(WeatherTower weatherTower) {
		this._weatherTower = weatherTower;
		WriteFile.getWriteFile().writetofile("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " Registered to weather tower.");
		this._weatherTower.register(this);
	}
	
}