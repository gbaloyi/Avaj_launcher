package avaj.aircraft;

public class Coordinates {
	private	int		_longitude;
	private	int		_latitude;
	private	int		_height;

	Coordinates (int longitude, int latitude, int height) {
		setLongitude(longitude);
		setLatitude(latitude);
		setHeight(height);
	}

	public	void setLongitude(int longitude) {
		this._longitude = longitude;
	}
	
	public	void setLatitude(int latitude) {
		this._latitude = latitude;
	}
	
	public	void setHeight(int height) {
		this._height = height;
	}

	public int	getLongitude() {
		return this._latitude;
	}

	public int getLatitude() {
		return this._latitude;
	}

	public int	getHeight() {
		return this._height;
	}
}