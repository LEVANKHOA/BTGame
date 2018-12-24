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
public class GameDemo extends JFrame {
	private GameLoop2 gameLoop2;
	
	public GameDemo() {
		this.setSize(600, 600);
		this.setVisible(true);
		gameLoop2 = new GameLoop2(true, this);
		new Thread(gameLoop2).start();
	}
	
	public static void main(String[] args) {
		GameDemo GameDemo = new GameDemo();
	}
	
	
}