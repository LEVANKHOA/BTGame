/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo;
import javax.swing.JFrame;

@SuppressWarnings("serial")

/**
 *
 * @author - J -
 */
public class Demo extends JFrame {
	private GameLoop gameLoop;
	
	public Demo() {
		this.setSize(600, 600);
		this.setVisible(true);
		gameLoop = new GameLoop(true, this);
		new Thread(gameLoop).start();
	}
	
	public static void main(String[] args) {
		Demo demo = new Demo();
	}
	
	
}
