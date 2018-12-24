/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author - J -
 */
public class GameLoop2 implements Runnable{
	private boolean isRunning;
        private GameDemo GameDemo;
	private List<Character> characters;
        private List<KinematicFlee> kinematicflee;
        
        public GameLoop2(boolean isRunning, GameDemo GameDemo) {
		super();
		this.isRunning = isRunning;
		this.GameDemo = GameDemo;
		
		Character c1 = new Character(new Vector2D(300, 300), 0, new Vector2D(0, 0), 0, Color.RED);
		Character c2 = new Character(new Vector2D(300, 300), 0, new Vector2D(0, 0), 0, Color.BLUE);
		
		this.characters = new ArrayList<Character>();
		this.kinematicflee = new ArrayList<KinematicFlee>();
		
		this.characters.add(c1);
		this.characters.add(c2);
		for (Character c: this.characters) {
			//this.kinematicflee = new KinematicFlee(c, 5, 1);
			this.kinematicflee.add(new KinematicFlee(c, c, 2));
		}
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public GameDemo getGameDemo() {
		return GameDemo;
	}

	public void setGameDemo(GameDemo GameDemo) {
		this.GameDemo = GameDemo;
	}

	@Override
	public void run() {
		/*for (int i=0; i<20; i++) {
			demo.getGraphics().clearRect(0,  0,  demo.getWidth(), demo.getHeight());
			int x, y;
			x = 100 + i*10;
			y = 100 + i*10;
			demo.getGraphics().drawOval(x, y, 50, 50);
			demo.getGraphics().drawLine(x, y, x + 25, y + 25);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		while (true) {
			GameDemo.getGraphics().clearRect(0,  0,  GameDemo.getWidth(), GameDemo.getHeight());
			for (Character c: this.characters) {
				c.update(this.kinematicflee.get(this.characters.indexOf(c)).generateKinematicOutput(), 2);
				c.render(this.GameDemo.getGraphics());
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
