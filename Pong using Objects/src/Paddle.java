import java.awt.Color;
import java.awt.Graphics;

public class Paddle {

 //ATTRIBUTES OR INSTANCE VARIABLES
	//instance variables do not exist unless theres an INSTANCE of a paddle object
	private int x, y; //location
	private int width, height; //size
	private Color c;
	private int vy;
	
	//constructor - named exactly after the class name
	//they define what happens when creating the object
	//the major work is initializing the state of the object
	// aka - a bunch of assignment statements to set initial values of attributes
 	public Paddle(int newX, int newY) {
 		x = newX;
		y = newY;
		width = 20;
		height = 125;
		c = Color.black;
	}
	
	public void paint(Graphics g) {
		
		//update y
		y += vy; //velocity in y affects position in the y
		
		//set the color
		g.setColor(c);
		g.fillRect(x, y, width, height);
	
	}
	
	
	public void setVelocity(int newVy) {
		vy = newVy;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}
	
	
}
