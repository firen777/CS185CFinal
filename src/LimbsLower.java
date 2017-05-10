/**
 * 
 */

/**
 * @author albertchan
 *
 */
public class LimbsLower extends Limbs {
	
	private LimbsUpper limb;

	/**
	 * @param r angle, in degree
	 * @param l length
	 * @param limb Upper Limb that Lower Limb based on
	 */
	public LimbsLower(int r, int l, LimbsUpper limb) {
		super(r, l);
		this.limb = limb;
	}

	@Override
	public int getX0() {
		// TODO Auto-generated method stub
		return limb.getX1();
	}

	@Override
	public int getY0() {
		// TODO Auto-generated method stub
		return limb.getY1();
	}

	@Override
	public int getX1() {
		// TODO Auto-generated method stub
		return (int) (limb.getX1() + l*Math.cos(Math.toRadians(r)));
	}

	@Override
	public int getY1() {
		// TODO Auto-generated method stub
		return (int) (limb.getY1() - l*Math.sin(Math.toRadians(r)));
	}

}
