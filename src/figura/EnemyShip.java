package figura;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Interfaces.IDibujar;

public class EnemyShip implements IDibujar {
	private static final int WIDTH = 20;
	private static final int HEIGHT = 20;
	private static final int SPEED = 1;

	private int x;
	private int y;
	private boolean alive;

	public static List<EnemyShip> spawnEnemies(int rows, int columns, int spacing) {
		 List<EnemyShip> enemies = new ArrayList<>();

		    for (int row = 0; row < rows; row++) {
		        for (int col = 0; col < columns; col++) {
		            int startX = col * spacing; // Calculate x based on column and spacing
		            int startY = row * spacing; // Calculate y based on row and spacing
		            enemies.add(new EnemyShip(startX, startY));
		        }
		    }

		    return enemies;
	}

	public EnemyShip(int startX, int startY) {
		x = startX;
		y = startY;
		alive = true;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

	public void move() {
		y += SPEED;

		if (y > 600) {
			alive = false;
		}
	}

	public boolean isAlive() {
		return alive;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	////////////////////// GETTERS AND SETTERS ///////////////////////////

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

	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}

	public static int getSpeed() {
		return SPEED;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
