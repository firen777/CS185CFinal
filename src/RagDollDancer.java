import processing.core.PApplet;

/**
 * 
 */

/**
 * @author albertchan
 *
 */
public abstract class RagDollDancer implements RagDoll {

	/**
	 * 
	 */
	public RagDollDancer() {
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	abstract public void draw(PApplet p);

	/**
	 * {@inheritDoc}
	 */
	@Override
	abstract public void translation(int[] data);
	
	public void dancing(){
		//TODO
	}

}
