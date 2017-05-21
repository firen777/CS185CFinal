/**
 * 
 */

/**
 * @author albertchan
 * <br>AKA Inner Limbs
 *
 */
public class LimbsUpper extends Limbs {

	private Joint j;
	
	/**
	 * @param r in degrees
	 * @param l length
	 * @param j Joint for origin
	 */
	public LimbsUpper(int r, int l, Joint j) {
		super(r, l);
		
		this.j = j;
	}

	@Override
	public int getX0() {
		
		return j.getX();
	}

	@Override
	public int getY0() {
		
		return j.getY();
	}

	@Override
	public int getX1() {
		// TODO Auto-generated method stub
		return (int) (j.getX() + l*Math.cos(Math.toRadians(r)));
		
		
	}

	@Override
	public int getY1() {
		// TODO Auto-generated method stub
		return (int) (j.getY() - l*Math.sin(Math.toRadians(r)));
	}

}
