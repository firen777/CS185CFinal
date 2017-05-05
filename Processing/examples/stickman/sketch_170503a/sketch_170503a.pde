/* built with Studio Sketchpad: 
 *   http://sketchpad.cc
 * 
 * observe the evolution of this sketch: 
 *   http://studio.sketchpad.cc/sp/pad/view/ro.bcqHLVvnKdN/rev.27
 * 
 * authors: 
 *   GoToLoop
 
 * license (unless otherwise specified): 
 *   creative commons attribution-share alike 3.0 license.
 *   http://creativecommons.org/licenses/by-sa/3.0/ 
 */
 
 
 
/** 
 * Stickman (v2.03)
 * by  Dino & TfGuy44 (2013/Oct)
 * mod GoToLoop
 * 
 * forum.processing.org/two/discussion/295/
 * how-to-make-a-stickmans-armslegs-move
 *
 * studio.processingtogether.com/sp/pad/export/ro.9ozYNbweyOpjT/latest
 */
 
PImage bg;
 
void setup() {
  size(300, 300, JAVA2D);
  smooth(4);
  noLoop();
  frameRate(40);
 
  stroke(0);
  strokeWeight(3);
 
  bg = createBG();
}
 
void mouseMoved() {
  redraw();
}
 
void draw() {
  if (1/2 == 1/2.)  set(0, 0, bg);
  else              background(bg);
 
  // Right Arm
  translate(125, 85);
  rotate(map(mouseX, 0, width, -PI, PI));
  line(0, 0, -25, 75);
  resetMatrix();
 
  // Left Arm
  translate(175, 85);
  rotate(map(mouseX, 0, width, -PI, PI));
  line(0, 0, 25, 75);
  resetMatrix();
 
  // Right Leg
  translate(130, 185);
  rotate(map(mouseY, 0, height, -PI, PI));
  line(0, 0, 0, 65);
  line(0, 65, -5, 65);
  resetMatrix();
 
  // Left Leg
  translate(170, 185);
  rotate(map(mouseY, 0, height, -PI, PI));
  line(0, 0, 0, 65);
  line(0, 65, 5, 65);
}
 
PImage createBG() {
  final PGraphics pg = createGraphics(width, height, JAVA2D);
  pg.beginDraw();
  pg.smooth(4);
 
  pg.ellipseMode(CENTER);
  pg.rectMode(CENTER);
 
  pg.background(#8080F0);
  pg.stroke(0);
 
  // Body
  pg.strokeWeight(3);
  pg.rect(width>>1, 135, 50, 100);
 
  // Head
  pg.ellipse(width>>1, 60, 50, 50);
 
  // Eyes
  pg.strokeWeight(5);
  pg.point(width/2 - 10, 60);
  pg.point(width/2 + 10, 60);
 
  pg.endDraw();
  return pg.get();
}