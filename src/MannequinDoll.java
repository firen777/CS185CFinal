import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * 
 */

/**
 * @author albertchan
 *
 */
public class MannequinDoll extends RagDollDancer{
	
	private ArrayList<PImage> limbsIMG;
	private PImage torso;
	
	public MannequinDoll(int w, int h, ArrayList<PImage> limbsIMG, PImage torso, ArrayList<Joint> j0){
		
	}


	/**<b>!!Referred to Mirrored image!!</b>
	 * <br>order: left hand, right hand, left leg, right leg
	 * @param lbL LowerLimbs 
	 * @param lbU UpperLimbs
	 * @param j0  Origin Joints
	 * @param limbsIMG images for all limbs
	 * @param torso image for the torso
	 */
	public MannequinDoll(ArrayList<LimbsLower> lbL, ArrayList<LimbsUpper> lbU, ArrayList<Joint> j0,
			ArrayList<PImage> limbsIMG, PImage torso) {
		super();
		this.lbL = lbL;
		this.lbU = lbU;
		this.j0 = j0;
		this.limbsIMG = limbsIMG;
		this.torso = torso;
		
		int bodyW = (int) (torso.width*0.8);
		int headH = torso.height/3;
		j0.get(0).setY(headH);
		j0.get(1).setY(headH);
		j0.get(2).setY(torso.height);
		j0.get(3).setY(torso.height);
		
		j0.get(1).setX(j0.get(0).getX()+bodyW);
		j0.get(3).setX(j0.get(2).getX()+bodyW);
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(PApplet p) {
		p.image(torso, j0.get(0).getX(), 0);
		
		int imgCounter = 0;
		for (LimbsUpper l: this.lbU){
			p.pushMatrix();
			p.translate(l.getX0(), l.getY0());
			p.rotate(PApplet.radians(-l.getR())); //-l.getR() 
			p.image(limbsIMG.get(imgCounter), 0, -limbsIMG.get(imgCounter).height/2);
			p.popMatrix();
			imgCounter++;
		}
		for (LimbsLower l: this.lbL){
			p.pushMatrix();
			p.translate(l.getX0(), l.getY0());
			p.rotate(PApplet.radians(-l.getR())); 
			p.image(limbsIMG.get(imgCounter), 0, -limbsIMG.get(imgCounter).height/2);
			p.popMatrix();
			imgCounter++;
		}

	}


}
