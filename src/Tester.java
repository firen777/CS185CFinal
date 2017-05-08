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
	
	private RagDoll doll;
	
	public int bodyX = 200;
	public int bodyY = 100;
	public int bodyW = 100;
	public int bodyH = 300;
	


	public class Joint_Deprecate {
		private int x; //positionX
		private int y; //positionY
		/**
		 * @param x positionX
		 * @param y positionY
		 */
		public Joint_Deprecate(int x, int y) {
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
	
	public class Limbs_Deprecate {
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
		public Limbs_Deprecate(int r, int l) {
			super();
			this.r = r;
			this.l = l;
		}
		
	}
	
	private ArrayList<Limbs_Deprecate> limbs = new ArrayList<Limbs_Deprecate>();
	private ArrayList<Joint_Deprecate> joint = new ArrayList<Joint_Deprecate>();
	

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
		this.stroke(0xff, 0xff, 0);
		
		
		
		
	}
	
	void drawLimbs(Limbs_Deprecate l, int x0, int y0){
		int x = (int) (x0 + l.l*(Math.cos(Math.toRadians(l.r))));
		int y = (int) (y0 - l.l*(Math.sin(Math.toRadians(l.r))));
		this.line(x0, y0, x, y);
	}
	

	/* (non-Javadoc)
	 * @see processing.core.PApplet#settings()
	 */
	@Override
	public void settings() {
		// TODO Auto-generated method stub
		super.settings();
		this.size(500, 500);
		ArrayList<LimbsLower> lbL = new ArrayList<LimbsLower>();
		ArrayList<LimbsUpper> lbU = new ArrayList<LimbsUpper>();
		ArrayList<Joint> j0 = new ArrayList<Joint> ();
		
		j0.add(new Joint(200, 100));
		j0.add(new Joint(200+100, 100));
		j0.add(new Joint(200, 100+300));
		j0.add(new Joint(200+100, 100+300));
		for (int i=0;i<4;i++) {
			lbU.add(new LimbsUpper(50, 270, j0.get(i)));
			lbL.add(new LimbsLower(50, 270, lbU.get(i)));
		}
		
		{
			this.joint.add(new Joint_Deprecate(bodyX,bodyY));
			this.joint.add(new Joint_Deprecate(bodyX+bodyW,bodyY));
			this.joint.add(new Joint_Deprecate(bodyX,bodyY+bodyH));
			this.joint.add(new Joint_Deprecate(bodyX+bodyW,bodyY+bodyH));
		}
		for (int i=0; i<8; i++)
		{
			this.limbs.add(new Limbs_Deprecate(270, 50));
			this.joint.add
			(new Joint_Deprecate((int)(joint.get(i).x + limbs.get(i).l * (Math.cos(Math.toRadians(limbs.get(i).r)))),
					(int)(joint.get(i).y - limbs.get(i).l * (Math.sin(Math.toRadians(limbs.get(i).r))))));
		}
		
		for (Joint_Deprecate j : this.joint){
			System.out.println(j.x + " " + j.y);
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main("Tester");

	}

}
