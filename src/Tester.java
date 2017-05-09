import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * 
 */

/**
 * @author Albert
 *
 */
public class Tester extends PApplet{
	
	private RagDoll doll;
	private int translation[] = {1,-1,1,-1,-1,1,-1,1};
	

	/* (non-Javadoc)
	 * @see processing.core.PApplet#draw()
	 */
	@Override
	public void draw() {
		
		background(0x00,0xff,0x00);
		doll.draw(this);
		doll.translation(translation);
		
	}
	

	
	/* (non-Javadoc)
	 * @see processing.core.PApplet#settings()
	 */
	@Override
	public void settings() {
		// TODO Auto-generated method stub
		super.settings();
		this.size(600, 900);
		ArrayList<LimbsLower> lbL = new ArrayList<LimbsLower>();
		ArrayList<LimbsUpper> lbU = new ArrayList<LimbsUpper>();
		ArrayList<Joint> j0 = new ArrayList<Joint> ();
		ArrayList<PImage> limbsIMG = new ArrayList<PImage>();
		PImage torsoIMG;
		
		//TODO-REFINE img
		for (int i=0;i<8;i++){
			limbsIMG.add(this.loadImage((i+1)+".png"));
		}
		torsoIMG = this.loadImage("torso.png");
		
		//Joint Origin
		j0.add(new Joint(200, 0));
		j0.add(new Joint(200+235, 0));
		j0.add(new Joint(200, 0+350));
		j0.add(new Joint(200+235, 0+350));
		//Limbs
//		for (int i=0;i<4;i++) {
//			lbU.add(new LimbsUpper(270, 100, j0.get(i)));
//			lbL.add(new LimbsLower(270, 100, lbU.get(i)));
//		}
		
		for (int i=0;i<8;i++) {
			if (i<4) {
				lbU.add(new LimbsUpper(270, limbsIMG.get(i).width, j0.get(i)));
			} else {
				lbL.add(new LimbsLower(270, limbsIMG.get(i).width, lbU.get(i%lbU.size())));
			}
		}
		
//		this.doll = new StickManDoll(lbL, lbU, j0);
		this.doll = new MannequinDoll(lbL, lbU, j0, limbsIMG, torsoIMG);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main("Tester");

	}

}
