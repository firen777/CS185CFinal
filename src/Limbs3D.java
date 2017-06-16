/**
 * 
 */

/**
 * @author albertchan
 * 3D version of Limbs
 *
 */
public abstract class Limbs3D {
	
	protected int rXY;
	protected int rXZ;
	protected int rYZ;
	protected int length;
	
	
	/**
	 * @return the rXY
	 */
	public int getrXY() {
		return rXY;
	}

	/**
	 * @return the rXZ
	 */
	public int getrXZ() {
		return rXZ;
	}

	/**
	 * @return the rYZ
	 */
	public int getrYZ() {
		return rYZ;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	
	/**set the angle of the limbs
	 * @param rXY
	 * @param rXZ
	 * @param rYZ
	 */
	public void setR(int rXY, int rXZ, int rYZ){
		this.rXY=rXY;
		this.rXZ=rXZ;
		this.rYZ=rYZ;
	}
	
	/**translate the angle of the limbs
	 * @param rXY
	 * @param rXZ
	 * @param rYZ
	 */
	public void translateR(int rXY, int rXZ, int rYZ){
		this.rXY+=rXY;
		this.rXZ+=rXZ;
		this.rYZ+=rYZ;
	}




	/**
	 * @param rXY
	 * @param rXZ
	 * @param rYZ
	 * @param length
	 */
	public Limbs3D(int rXY, int rXZ, int rYZ, int length) {
		super();
		this.rXY = rXY;
		this.rXZ = rXZ;
		this.rYZ = rYZ;
		this.length = length;
	}

	/**
	 * 
	 */
	public Limbs3D() {
		super(); 
	}

}
