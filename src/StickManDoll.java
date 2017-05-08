import java.util.ArrayList;

import processing.core.PApplet;

/**
 * 
 */

/**
 * @author albertchan
 *
 */
public class StickManDoll implements RagDoll {

	private ArrayList<LimbsLower> lbL;
	private ArrayList<LimbsUpper> lbU;
	private ArrayList<Joint> j0;
	
	private int bodyX;
	private int bodyY;
	private int bodyW;
	private int bodyH;
	
	private int colorR = 0xff;
	private int colorG = 0xbe;
	private int colorB = 0x89;

	/**<b>!!Refered to Mirrored image!!</b>
	 * <br>order: left hand, right hand, left leg, right leg
	 * @param lbL LowerLimbs 
	 * @param lbU UpperLimbs
	 * @param j0  Origin Joints
	 */
	public StickManDoll(ArrayList<LimbsLower> lbL, ArrayList<LimbsUpper> lbU, ArrayList<Joint> j0) {
		super();
		this.lbL = lbL;
		this.lbU = lbU;
		this.j0 = j0;
		
		this.bodyX = this.j0.get(0).getX();
		this.bodyY = this.j0.get(0).getY();
		this.bodyW = this.j0.get(3).getX()-this.bodyX;
		this.bodyH = this.j0.get(3).getY()-this.bodyY;
	}

	@Override
	public void draw(PApplet p) {
		// TODO Auto-generated method stub
		p.stroke(colorR, colorG, colorB);
		p.rect(bodyX, bodyY, bodyW, bodyH);
		for (LimbsLower l: this.lbL){
			p.line(l.getX0(), l.getY0(), l.getX1(), l.getY1());
		}
		for (LimbsUpper l: this.lbU){
			p.line(l.getX0(), l.getY0(), l.getX1(), l.getY1());
		}

	}

	/** {@inheritDoc}
	 *  <br>This version expect data array to be the <b>difference</b> of angle, in degree
	 *  <br>order: upper left hand, right hand, left leg, right leg;
	 *  <br>order: lower left hand, right hand, left leg, right leg.
	 */
	@Override
	public void translation(int[] data) {
		// TODO Auto-generated method stub
		int i=0;
		while (i<data.length){
			if (i<4) {
				this.lbL.get(i).setR(this.lbL.get(i).getR()+data[i]);
			}
			else {
				this.lbU.get(i%4).setR(this.lbU.get(i%4).getR()+data[i]);
			}
			i++;
		}

	}
	
	

}
