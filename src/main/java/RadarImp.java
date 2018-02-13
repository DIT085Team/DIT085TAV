	
public class RadarImp implements Radar {
	private int reading;
	
	public RadarImp(int reading) {
		this.setReading(reading);
	}
	
	public void setReading(int reading) {
		this.reading = reading;
	}

	public int getReading() {
		return reading;
	}
}
