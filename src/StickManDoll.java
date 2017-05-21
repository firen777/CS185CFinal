import java.util.ArrayList;

import processing.core.PApplet;

/**
 * 
 */

/**
 * @author albertchan
 *
 */
public class StickManDoll extends RagDollDancer {
	
	private int colorR = 0xff;
	private int colorG = 0xbe;
	private int colorB = 0x89;

	/**<b>!!Referred to Mirrored image!!</b>
	 * <br>order: left hand, right hand, left leg, right leg
	 * @param lbL LowerLimbs 
	 * @param lbU UpperLimbs
	 * @param j0  Origin Joints
	 * @deprecated
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
		
//		for (LimbsLower l: this.lbL){
//			System.out.println(l.getX0() + "," + l.getY0() + ":" + l.getX1() + "," + l.getY1());
//		}
	}
	
	
	/**Construct a doll in proportion of the canvas height
	 * @param w: width of canvas
	 * @param h: height of canvas
	 */
	public StickManDoll(int w, int h){
		bodyW = h/6;
		bodyH = h/3;
		bodyX = w/2 - bodyW/2;
		bodyY = h/2 - bodyH/2;
		
		j0 = new ArrayList<Joint>();
		lbU = new ArrayList<LimbsUpper>();
		lbL = new ArrayList<LimbsLower>();
		
		j0.add(new Joint(bodyX, bodyY));
		j0.add(new Joint(bodyX+bodyW, bodyY));
		j0.add(new Joint(bodyX, bodyY+bodyH));
		j0.add(new Joint(bodyX+bodyW, bodyY+bodyH));
		
		for (Joint j: j0){
			lbU.add(new LimbsUpper(270, bodyW, j));
		}
		for (LimbsUpper l: lbU){
			lbL.add(new LimbsLower(270, bodyW, l));			
		}
	}

	@Override
	public void draw(PApplet p) {
		// TODO Auto-generated method stub
		p.stroke(colorR, colorG, colorB);
		p.strokeWeight(5);
		p.rect(bodyX, bodyY, bodyW, bodyH);
		for (LimbsLower l: this.lbL){
			p.pushMatrix();
			p.translate(l.getX0(), l.getY0());
			p.rotate(PApplet.radians(-l.getR())); 
			p.line(0, 0, l.getL(), 0);
			p.popMatrix();
		}
		for (LimbsUpper l: this.lbU){
			p.pushMatrix();
			p.translate(l.getX0(), l.getY0());
			p.rotate(PApplet.radians(-l.getR())); 
			p.line(0, 0, l.getL(), 0);
			p.popMatrix();
		}

	}

	
	
	

}
