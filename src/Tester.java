import java.io.File;
import java.util.ArrayList;

import ddf.minim.AudioMetaData;
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
	AudioMetaData meta;
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
		if (beat.isOnset()||newVolume>averageVolume){
			if (beat.isOnset())
				doll.onBeat(fft);
		}
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
		this.size(400, 600);
		ArrayList<PImage> limbsIMG = new ArrayList<PImage>();
		PImage torsoIMG;
		
		//TODO-REFINE img
		for (int i=0;i<8;i++){
			limbsIMG.add(this.loadImage((i+1)+".png"));
		}
		torsoIMG = this.loadImage("torso.png");
		
		this.doll = new StickManDoll(this.width,this.height);
//		this.doll = new MannequinDoll(lbL, lbU, j0, limbsIMG, torsoIMG);
		
		//=====================Audio setup=============================//
		minim = new Minim(this);
		player = minim.loadFile("1.mp3"); //"+File.separator+"
		meta = player.getMetaData();
		beat = new BeatDetect();
		fft = new FFT(player.bufferSize(), player.sampleRate());
		player.play();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main("Tester");

	}

}
