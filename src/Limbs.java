/**
 * 
 */

/**
 * @author albertchan
 *
 */
public abstract class Limbs {
	protected int r;
	protected int l;
	/**
	 * @param r angle in degree
	 * @param l length
	 */
	public Limbs(int r, int l) {
		super();
		this.r = r;
		this.l = l;
	}
	
	/**Get X coordinate of the origin of the limb
	 * 
	 */
	public abstract int getX0();
	/**Get Y coordinate of the origin of the limb
	 * 
	 */
	public abstract int getY0();
	
	/**
	 * @return X coordinate of the end of the limb
	 */
	public abstract int getX1();
	
	/**
	 * @return Y coordinate of the end of the limb
	 */
	public abstract int getY1();

	/**
	 * @return the r in degree
	 */
	public int getR() {
		return r;
	}

	/**
	 * @param r the r to set, in degree
	 */
	public void setR(int r) {
		this.r = r;
	}

	/**
	 * @return the l
	 */
	public int getL() {
		return l;
	}

	/**
	 * @param l the l to set
	 */
	public void setL(int l) {
		this.l = l;
	}
	
	
}
