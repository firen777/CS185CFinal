import java.util.ArrayList;

import ddf.minim.analysis.FFT;
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
	private PImage torsoIMG;
	private int torsoIMGX;
	private int torsoIMGY;
	
	private boolean breath=false;
	private final int thershold = 10;
	private int moved = 0;


	/**<b>!!Referred to Mirrored image!!</b>
	 * <br>order: left hand, right hand, left leg, right leg
	 * @param lbL LowerLimbs 
	 * @param lbU UpperLimbs
	 * @param j0  Origin Joints
	 * @param limbsIMG images for all limbs
	 * @param torsoIMG image for the torso
	 * @deprecated
	 */
	public MannequinDoll(ArrayList<LimbsLower> lbL, ArrayList<LimbsUpper> lbU, ArrayList<Joint> j0,
			ArrayList<PImage> limbsIMG, PImage torsoIMG) {
		super();
		this.lbL = lbL;
		this.lbU = lbU;
		this.j0 = j0;
		this.limbsIMG = limbsIMG;
		this.torsoIMG = torsoIMG;
		
		int bodyW = (int) (torsoIMG.width*0.8);
		int headH = torsoIMG.height/3;
		j0.get(0).setY(headH);
		j0.get(1).setY(headH);
		j0.get(2).setY(torsoIMG.height);
		j0.get(3).setY(torsoIMG.height);
		
		j0.get(1).setX(j0.get(0).getX()+bodyW);
		j0.get(3).setX(j0.get(2).getX()+bodyW);
	}
	
	/** TODO: scale with canvas
	 *  
	 *  <br>order: inner left hand, right hand, left leg, right leg.
	 *  <br>order: outer left hand, right hand, left leg, right leg;
	 * @param w
	 * @param h
	 * @param x
	 * @param y
	 * @param limbsIMG
	 * @param torsoIMG
	 */
	public MannequinDoll(int w, int h, int[]x, int[]y, ArrayList<PImage> limbsIMG, PImage torsoIMG){
		super();
		this.limbsIMG = limbsIMG;
		this.torsoIMG = torsoIMG;
		this.j0 = new ArrayList<Joint>();
		this.lbU= new ArrayList<LimbsUpper>();
		this.lbL= new ArrayList<LimbsLower>();
		
		int x1[] = new int[4];
		int y1[] = new int[4];
		
		torsoIMGX = w/2-torsoIMG.width/2;
		torsoIMGY = h/2-torsoIMG.height/2 - 100;
		
		for (int i=0;i<4;i++)
			j0.add(new Joint(torsoIMGX+x[i], torsoIMGY+y[i]));
		for (int i=0;i<4;i++)
			lbU.add(new LimbsUpper(270, limbsIMG.get(i).width, j0.get(i)));
		for (int i=0;i<4;i++)
			lbL.add(new LimbsLower(270, limbsIMG.get(i+4).width, lbU.get(i)));
	}
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(PApplet p) {
		p.image(torsoIMG, torsoIMGX, torsoIMGY);
		
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
			p.image(limbsIMG.get(imgCounter), -20, -limbsIMG.get(imgCounter).height/2);
			p.popMatrix();
			imgCounter++;
		}
	}

	/* (non-Javadoc)
	 * @see RagDollDancer#onBeat(ddf.minim.analysis.FFT)
	 */
	@Override
	public void onBeat(FFT fft) {
		// TODO Auto-generated method stub
		super.onBeat(fft);
		this.breath = !this.breath;
	}

	/* (non-Javadoc)
	 * @see RagDollDancer#dance()
	 */
	@Override
	public void dance() {
		// TODO Auto-generated method stub
		super.dance();
		if (this.breath && moved <= this.thershold) {
			moved+=2;
			torsoIMGY+=2;
			for (Joint j: j0)
				j.addY(2);
		}
		if (!this.breath && moved >= this.thershold *-1) {
			moved-=2;
			torsoIMGY-=2;
			for (Joint j: j0)
				j.addY(-2);
		}
	}
	
	


}
