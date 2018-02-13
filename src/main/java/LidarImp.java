
 public class LidarImp implements Lidar{
	private int reading;
	
	public LidarImp(int reading) {
		this.setReading(reading);
	}

	public int getReading() {
		return reading;
	}

	public void setReading(int reading) {
		this.reading = reading;
	}
}
