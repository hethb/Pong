import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements KeyListener, ActionListener{
	
	Font newFont = new Font("Serif", Font.BOLD, 100);
	//declare objects and variables that need to live and update
	//throughout the lifetime of the JFrame here
	//ClassName varName = mew ClassName();
	Ball ball = new Ball(); //creates a ball object 
	
	Boolean changeDirection = false;

	//left paddle
	Paddle leftPaddle = new Paddle(0, 0);
	
	Paddle rightPaddle = new Paddle(765, 0);
	
	
	//Boolean reachedDown = false;
	
	int P1score = 0;
	int p2score = 0;
	
 	
	/* paint is getting called roughly 60x per second */
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		 //call the paint method of the ball object
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 600);
		
		g.setColor(Color.white);
		g.drawLine(400, 0, 400, 600);
		
		//variables 
		g.setFont(newFont);
		g.setColor(Color.white);
		g.drawString(P1score+"", 100, 100);
		g.drawString(p2score+"", 600, 100);
		
		
		
		if ( ball.getX() >= 775) {
			P1score = P1score + 1;
		}
		
		if( ball.getX() <= 0) {
			p2score = p2score + 1;
		}
		
		
		ball.setColor(Color.white);
		ball.paint(g);
		
		leftPaddle.setC( Color.red );
		leftPaddle.paint(g);
		
		rightPaddle.setC( Color.blue );
		rightPaddle.paint(g);
		
		if(leftPaddle.getY()<=0) {
			leftPaddle.setY( 0 );
		}
		
		if(rightPaddle.getY()<=0) {
			rightPaddle.setY(0);
		}

		//screen size if 800x600 (w x h)
		//detect if ball is touching the top border of JFrame
		if( ball.getY() <= 0 ) {
			
			//how to change the direction of the ball in the y?
			//use setters and getter for velocity in the y direction
			ball.setVelocityY( ball.getVy()*-1 );
			changeDirection = true;
			StdAudio.playInBackground("music/fall.wav");

			
		}
		
		
		//bottom screen
		if( ball.getY() >= 550) {
			ball.setVelocityY( ball.getVy() *-1);
			changeDirection = true;
			StdAudio.playInBackground("music/fall.wav");

		}

		//left
		if( ball.getX() <= 0) {
			ball.setVelocityX( ball.getVx() *-1);
			changeDirection = true;
			StdAudio.playInBackground("music/fall.wav");

		}
		
		//right
		if( ball.getX() >= 775) {
			ball.setVelocityX( ball.getVx() *-1);
			StdAudio.playInBackground("music/fall.wav");

			changeDirection = true;

		}
		
		
	}
	
	
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		System.out.println(arg0);
		if( arg0.getKeyCode() == 32) {
			
			//the body of this if-statement only runs
			//if the condition is true
			
			//generating random #s in Java math.random
			// int randNum = (int)(Math.random()*(max-min+1))+min;
			// [-7 7]
			//x velocity
			
			
			int speedX = (int)(Math.random()*(7+7+1))- 7;
			while( speedX == 0 ) { // so velo is not 0
				speedX = (int)(Math.random()*(7+7+1))- 7;
			}
			ball.setVelocityX(speedX);
			
			// y velocity
			int speedY = (int)(Math.random()*(7+7+1))- 7;
			while( speedY == 0 ) { // so velo is not 0
				speedY = (int)(Math.random()*(7+7+1))- 7;
			}
			ball.setVelocityY(speedY);
			
			//moving the paddles through the w and s key
		}else if( arg0.getKeyCode() == 87) {//detect w
			//reachedDown = true;
			leftPaddle.setVelocity(-10);
		}else if( arg0.getKeyCode() == 83) {//detect s
			leftPaddle.setVelocity(10);

		}else if (arg0.getKeyCode() == 38){
			rightPaddle.setVelocity(-10);
			//what happens is none of the others run?
			//do nothing
		}else if( arg0.getKeyCode() == 40) {
			rightPaddle.setVelocity(10);
		}
		
		
	/*
	 * else if( arg0.getKeyCode() == 87) {//detect w
	 
		//reachedDown = true;
		leftPaddle.setVelocity(-10);
	}else if( arg0.getKeyCode() == 83) {//detect s
		leftPaddle.setVelocity(10);

	}else {
		//what happens is none of the others run?
		//do nothing
	}
	*/	
		
		while( leftPaddle.getY() > 450 ) { //&& !reachedDown
			leftPaddle.setY( 450 );
		}
		
		while( rightPaddle.getY() > 450 ) { //&& !reachedDown
			rightPaddle.setY( 450 );
		}
		//if( leftPaddle.getY() < 425) {
			//reachedDown = false;
		//}
		
		
	}
		
		

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		//if the user releases w or s they likely want to stop moving the left paddle
		
		 if( arg0.getKeyCode() == 87 || arg0.getKeyCode() == 83) {
		 
			leftPaddle.setVelocity(0);
		}
		
		//if (arg0.getKeyCode() == || arg0.getKeyCode() == ) {
			rightPaddle.setVelocity(0);
		}  
		
	
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}
	
	Timer t; //may not be required to use - hiding from use
	
	public Frame() {
		JFrame f = new JFrame("Pong");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800,600);
		f.add(this);
		f.addKeyListener(this);
		
		t = new Timer(16, this);
		t.start();
		f.setVisible(true);
		
	}
}
