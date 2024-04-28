package figura;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Interfaces.IDibujar;

public class Bullet implements IDibujar {
	private int x, y;
	private final int speed = 10;

	public Bullet(int startX, int startY) {
		x = startX;
		y = startY;
	}

	
	
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, 5, 5);
	}

	public void move() {
		y -= speed;
	}

	
	public int getY() {
		return y;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 5, 5);
	}
}
