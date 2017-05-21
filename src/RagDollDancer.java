import java.util.ArrayList;
import java.util.Random;

import ddf.minim.analysis.FFT;
import processing.core.PApplet;

/**
 * 
 */

/**
 * @author albertchan
 *
 */
public abstract class RagDollDancer implements RagDoll {
	
	protected int[] newPose;
	protected int[] oldPose;
	protected int[] currentPose;
	
	protected ArrayList<LimbsLower> lbL; //Lower is Outer
	protected ArrayList<LimbsUpper> lbU; //Upper is Inner
	protected ArrayList<Joint> j0;
	
	protected int bodyX;
	protected int bodyY;
	protected int bodyW;
	protected int bodyH;

	/**
	 * 
	 */
	public RagDollDancer() {
		newPose = new int[]{270,270,270,270,270,270,270,270};
		oldPose = new int[]{270,270,270,270,270,270,270,270};
		currentPose = new int[]{270,270,270,270,270,270,270,270};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	abstract public void draw(PApplet p);

	/** {@inheritDoc}
	 *  <br>This version expect data array to be the <b>difference</b> of angle, in degree
	 *  <br>order: outer left hand, right hand, left leg, right leg;
	 *  <br>order: inner left hand, right hand, left leg, right leg.
	 */
	@Override
	public void translate(int[] data) {
		int i=0;
		while (i<data.length){
			if (i<4) {
				this.lbL.get(i).addR(data[i]);
			}
			else {
				this.lbU.get(i%4).addR(data[i]);
			}
			i++;
		}
	}
	
	/**Generate a new pose when there is a beat
	 * @param fft
	 */
	public void onBeat(FFT fft){
		float specLow = 0.03f; // 3%
		float specMid = 0.125f;  // 12.5%
		float specHi = 0.20f;   // 20%
		
//		float midpoint = 0.03f + 0.0625f;

		
		float lo = 0; //low frequency score
		float mi= 0; //mid frequency score
		float hi = 0; //high frequency score
		
		for(int i = 0; i < fft.specSize()*specLow; i++)
			lo += fft.getBand(i);
		for(int i = (int)(fft.specSize()*specLow); i < fft.specSize()*specMid; i++) 
			mi += fft.getBand(i);
		for(int i = (int)(fft.specSize()*specMid); i < fft.specSize()*specHi; i++)
			hi += fft.getBand(i);
		
		/* 
		 *  <br>order: outer left hand, right hand, left leg, right leg;
		 *  <br>order: inner left hand, right hand, left leg, right leg.
		 */
		int loI = (int)lo;
		int miI = (int)mi;
		int hiI = (int)hi;
		
		Random r = new Random();
		newPose[0] = (oldPose[0] + (r.nextInt((hiI+1)*2)-hiI)*3 +360)%360; //L out hand
		newPose[1] = (oldPose[1] - (r.nextInt((hiI+1)*2)-hiI)*3 +360)%360; //R out hand
		newPose[2] = (oldPose[2] + (r.nextInt((loI+1)*2)-loI)%60 +360)%360; //L out leg
		newPose[3] = (oldPose[3] - (r.nextInt((loI+1)*2)-loI)%60 +360)%360; //R out leg
		newPose[4] = (oldPose[4] + (r.nextInt((miI+1)*2)-miI)%120 +360)%360; //L in hand
		newPose[5] = (oldPose[5] - (r.nextInt((miI+1)*2)-miI)%120 +360)%360; //R in hand
		newPose[6] = (oldPose[6] + (r.nextInt((miI+1)*2)-miI)%60 +360)%360; //L in leg
		newPose[7] = (oldPose[7] - (r.nextInt((miI+1)*2)-miI)%60 +360)%360; //R in leg
		
//		for (int i=4; i<8; i++){
//			if (newPose[i]<180){
//				newPose[i]+=180;
//			}
//		}
		if (newPose[4]<=180) newPose[4]+=180;
		if (newPose[5]<=180) newPose[5]+=180;
//		if (newPose[6]<=120) newPose[6]+=180;
//		if (30<=newPose[7]&&newPose[7]<=180) newPose[7]= (newPose[7]+180)%360;
		
//		System.out.println("");
		
//		System.out.println(-90%360);
		//System.out.println(newPose[0]+" "+newPose[1]+" "+loI+" "+miI+" "+hiI);
	}
	
	/**dance toward the target pose
	 */
	public void dance(){
		int [] translation = new int[8];
		for (int i=0; i<8; i++){
			if (i<4) {
				currentPose[i]=lbL.get(i).getR();
			}
			else{
				currentPose[i]=lbU.get(i%4).getR();
			}
			translation[i] = (newPose[i]-currentPose[i])/4;
		}
		this.translate(translation);
		
//		for (int i: currentPose){
//			System.out.print(i+" ");
//		}
//		System.out.println("");
		
		
	}

}
