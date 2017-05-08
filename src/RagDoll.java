import processing.core.PApplet;

/**
 * 
 */

/**
 * @author albertchan
 * RagDoll is expected to have all the necessary member for Joint, Limb 
 * or whatever components it needs
 *
 */
public interface RagDoll {
	/**draw the RagDoll
	 * @param p PApplet to be drawn on
	 */
	public void draw(PApplet p);
	/**<b>!!TO BE REVISED IF NECESSARY!!</b>
	 * <br>change the pose of the RagDoll based on the data array
	 * @param data array of data for the translation
	 */
	public void translation(int[] data);
}
