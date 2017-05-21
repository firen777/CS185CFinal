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
	
	protected int bmp;

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
	
	
	
	public void dance(FFT fft){
		int lo = 0;
		int hi  = 0;
		int i;
		for(i = 0; i < fft.specSize()/2; i++)
		    lo += fft.getBand(i);
		
		for(i = fft.specSize()/2; i <fft.specSize(); i++)
			hi  += fft.getBand(i);
		
		translation(new int[]{lo, lo, lo, lo, lo, lo, lo, lo});
		
		System.out.println(lo + " " + hi + " " + i);
	}

}
