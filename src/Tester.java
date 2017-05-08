import java.util.ArrayList;

import processing.core.PApplet;

/**
 * 
 */

/**
 * @author Albert
 *
 */
public class Tester extends PApplet{
	
	private int bodyX = 200;
	private int bodyY = 100;
	private int bodyW = 100;
	private int bodyH = 300;
	
	
	
	/**
	 * @return the bodyX
	 */
	public int getBodyX() {
		return bodyX;
	}

	/**
	 * @param bodyX the bodyX to set
	 */
	public void setBodyX(int bodyX) {
		this.bodyX = bodyX;
	}

	/**
	 * @return the bodyY
	 */
	public int getBodyY() {
		return bodyY;
	}

	/**
	 * @param bodyY the bodyY to set
	 */
	public void setBodyY(int bodyY) {
		this.bodyY = bodyY;
	}

	/**
	 * @return the bodyW
	 */
	public int getBodyW() {
		return bodyW;
	}

	/**
	 * @param bodyW the bodyW to set
	 */
	public void setBodyW(int bodyW) {
		this.bodyW = bodyW;
	}

	/**
	 * @return the bodyH
	 */
	public int getBodyH() {
		return bodyH;
	}

	/**
	 * @param bodyH the bodyH to set
	 */
	public void setBodyH(int bodyH) {
		this.bodyH = bodyH;
	}


	public class JointO {
		private int x; //positionX
		private int y; //positionY
		/**
		 * @param x positionX
		 * @param y positionY
		 */
		public JointO(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		/**
		 * @return the x
		 */
		public int getX() {
			return x;
		}
		/**
		 * @param x the x to set
		 */
		public void setX(int x) {
			this.x = x;
		}
		/**
		 * @return the y
		 */
		public int getY() {
			return y;
		}
		/**
		 * @param y the y to set
		 */
		public void setY(int y) {
			this.y = y;
		}
	}
	
	public class Limbs {
		private int r; //in Degrees
		private int l; //length of limb
		/**
		 * @return the r
		 */
		public int getR() {
			return r;
		}
		/**
		 * @param r the r to set
		 */
		public void setR(int r) {
			this.r = r;
		}
		/**
		 * @return the l
		 */
		public int getL() {
			return l;
		}
		/**
		 * @param l the l to set
		 */
		public void setL(int l) {
			this.l = l;
		}
		/**
		 * @param r angle, in degree
		 * @param l length of limbs
		 */
		public Limbs(int r, int l) {
			super();
			this.r = r;
			this.l = l;
		}
		
	}
	
	private ArrayList<Limbs> limbs = new ArrayList<Limbs>();
	private ArrayList<JointO> jointO = new ArrayList<JointO>();
	

	/* (non-Javadoc)
	 * @see processing.core.PApplet#draw()
	 */
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();
		this.background(0);
		this.fill(0xff, 0x55, 0x00);
		this.rect(bodyX,bodyY,bodyW,bodyH);
		
		
	}
	
	void drawLimbs(Limbs l){
		int x = bodyX + l.l;
	}
	

	/* (non-Javadoc)
	 * @see processing.core.PApplet#settings()
	 */
	@Override
	public void settings() {
		// TODO Auto-generated method stub
		super.settings();
		this.size(500, 500);
		{
			this.jointO.add(new JointO(200,100));
			this.jointO.add(new JointO(300,100));
			this.jointO.add(new JointO(200,400));
			this.jointO.add(new JointO(300,400));
		}
		for (int i=0; i<8; i++)
		{
			this.limbs.add(new Limbs(270, 50));
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main("Tester");

	}

}
