
public class CarPos {
	private int x;
    private int y;
    
    public CarPos(int x,int y) {
    	this.x = x;
    	this.y = y;
    }
    
    public CarPos() {
    	x = 3;
    	y = 0;
    }
    
	public int getX() {
		return x;
	}
	
	public void setX(int newPos) {
		x = newPos;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int newPos) {
		y = newPos;
	}
}
