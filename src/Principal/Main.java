package Principal;

import javax.swing.JFrame;

import Game.GameControl;

/**
 * @author Enriquez_Jhon
 * titulo: Java Galaga impklementacion de Inversionde control
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Galaga Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		GameControl gamePanel = new GameControl();
		frame.add(gamePanel);
		frame.setVisible(true);
	}

}
