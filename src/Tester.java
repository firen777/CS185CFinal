import java.util.ArrayList;

//import ddf.minim.AudioMetaData;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.BeatDetect;
import ddf.minim.analysis.FFT;
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
	
	Minim minim;
	AudioPlayer player;
//	AudioMetaData meta;
	BeatDetect beat;
	FFT fft;
	
	double specLow = 0.03; // 3%
	double specMid = 0.125;  // 12.5%
	double specHi = 0.20;   // 20%
	
	double scoreLow = 0;
	double scoreMid = 0;
	double scoreHi = 0;
	
	double oldScoreLow = scoreLow;
	double oldScoreMid = scoreMid;
	double oldScoreHi = scoreHi;

	
	private RagDollDancer doll;
	
	float averageVolume = 0;
	float newVolume = 0;
	long samplesCount = 0;
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw() {
		fft.forward(player.mix);	
		for (int i=0;i<fft.specSize();i++){
			newVolume+=fft.getBand(i);
		}
		averageVolume = averageVolume* (float)(samplesCount) / (float)(samplesCount+1) + newVolume / (float)(samplesCount+1);
		samplesCount++;	
		

		beat.detect(player.mix);
		//if (beat.isOnset()) //sound energy mode
		if (beat.isHat())   //fq energy mode
			doll.onBeat(fft);
		
		doll.dance();
		
		background(0x00,0xff,0x00);
		doll.draw(this);
		newVolume=0;
	}
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void settings() {
		// TODO MannequinDoll draw method revamp
		super.settings();
		this.size(1280, 720);
		
		
		loadStickMan();
		
		//=====================Audio setup=============================//
		minim = new Minim(this);
		player = minim.loadFile("1.mp3");
		loadMusicAndPlay(1);
	}
	
	private void loadStickMan(){
		this.doll = new StickManDoll(this.width,this.height);
	}
	private void loadMannequin(){
		ArrayList<PImage> limbsIMG = new ArrayList<PImage>();
		PImage torsoIMG;
		
		//TODO-REFINE img
		for (int i=0;i<8;i++){
			limbsIMG.add(this.loadImage((i+1)+".png"));
		}
		torsoIMG = this.loadImage("torso.png");
		
		int xList[] = new int[] {49,171,74,146};
		int yList[] = new int[] {157,157,316,316};
		
		this.doll = new MannequinDoll(this.width, this.height, xList, yList, limbsIMG, torsoIMG);
	}
	
	private void loadMusicAndPlay(int name) {
		if (player.isPlaying())
			player.pause();
		player = minim.loadFile(name + ".mp3"); //"+File.separator+"
//		beat = new BeatDetect(); //sound energy mode
		beat = new BeatDetect(player.bufferSize(),player.sampleRate()); //fq energy mode

		fft = new FFT(player.bufferSize(), player.sampleRate());
		player.play();
	}
	
	@Override
	public void keyPressed() {
		switch (this.key) {
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
			loadMusicAndPlay(Character.getNumericValue(this.key));
			break;
		case 'n':
			this.loadStickMan();
			break;
		case 'm':
			this.loadMannequin();
			break;
		default:
		}
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main("Tester");

	}

}
