/**
 * 
 */

/**
 * @author albertchan
 *
 */
public class Joint {
	private int x;
	private int y;
	
	
	
	/**
	 * @param x
	 * @param y
	 */
	public Joint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**translate x position
	 * @param x
	 */
	public void addX(int x){
		this.x += x;
	}
	
	
	/**translate y position
	 * @param y
	 */
	public void addY(int y){
		this.y += y;
	}

}
